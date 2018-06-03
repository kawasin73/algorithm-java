package com.kawasin73;

/**
 * Created by kawasin73 on 2018/06/03.
 */
// Range Minimum Query
// URL: https://www.slideshare.net/iwiwi/ss-3578491
public class RMQBucket {
    public static void main(String[] args) {
        int[] data = {13, 43, 65, 87, 72, 35, 22, 17, 10, 34, 11, 99, 11, 46, 35, 34, 13, 10};
        RMQBucket rmq = new RMQBucket(data);

        System.out.print("1, 8 : ");
        System.out.println(rmq.min(1, 8));
        System.out.print("3, 5 : ");
        System.out.println(rmq.min(3, 5));
        System.out.print("0, 10 : ");
        System.out.println(rmq.min(0, 10));
        System.out.print("0, 16 : ");
        System.out.println(rmq.min(0, 16));
        System.out.print("10, 16 : ");
        System.out.println(rmq.min(10, 16));

        System.out.println("changed");
        rmq.change(6, 9);
        System.out.print("1, 7 : ");
        System.out.println(rmq.min(1, 7));
        System.out.print("0, 7 : ");
        System.out.println(rmq.min(0, 7));
        System.out.print("0, 5 : ");
        System.out.println(rmq.min(0, 5));
    }

    private int[] data;
    private int[] buckets;
    private int size;

    public RMQBucket(int[] data) {
        this.data = data;
        size = (int) Math.sqrt(data.length);
        buckets = new int[data.length / size + 1];

        int b = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < data.length; i++) {
            if (data[i] < min) {
                min = data[i];
            }
            if (i + 1 % size == 0) {
                buckets[b] = min;
                b++;
                min = Integer.MAX_VALUE;
            }
        }
    }

    public int min(int i, int j) {
        int min = data[i];
        for (; i % size != 0 && i <= j; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }
        int b = i / size;
        for (; i - j > size; i += size) {
            if (buckets[b] < min) {
                min = buckets[b];
            }
            b++;
        }
        for (; i <= j; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }

        return min;
    }

    public void change(int i, int v) {
        data[i] = v;
        int b = i % size;
        int end = i + size;
        if (end > data.length - 1) {
            end = data.length - 1;
        }
        int min = v;
        for (int j = i; j < end; j++) {
            if (data[j] < min) {
                min = data[j];
            }
        }
        buckets[b] = min;
    }
}
