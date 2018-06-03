package com.kawasin73;

/**
 * Created by kawasin73 on 2018/06/03.
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] data = {9, 10, 3, 4, 1, 2, 13, 10};
        sort(data);
        print(data);
    }

    private static void print(int[] array) {
        System.out.print("[ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(String.valueOf(array[i]) + ", ");
        }
        System.out.println("]");
    }

    public static void sort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        heapSort(array);
    }

    private static void heapSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            upRotate(array, i);
        }
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            downRotate(array, i);
        }
    }

    private static void upRotate(int[] array, int i) {
        while (i > 0) {
            int p = parent(i);
            if (array[i] > array[p]) {
                swap(array, p, i);
                i = p;
            } else {
                break;
            }
        }
    }

    private static void downRotate(int[] array, int size) {
        int cur = 0;
        while (true) {
            int max = cur;
            int left = left(cur);
            if (left >= size) {
                break;
            } else if (array[left] > array[max]) {
                max = left;
            }
            int right = right(cur);
            if (right < size && array[right] > array[max]) {
                max = right;
            }
            if (max == cur) {
                break;
            }
            swap(array, max, cur);
            cur = max;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static int parent(int i) {
        return (i + 1) / 2 - 1;
    }

    private static int left(int i) {
        return (i + 1) * 2 - 1;
    }

    private static int right(int i) {
        return (i + 1) * 2;
    }
}
