package com.kawasin73;

/**
 * Created by kawasin73 on 2018/06/03.
 */
public class MaxHeap {
    public static void main(String[] args) {
        MaxHeap h = new MaxHeap(4);

        int[] data = {9, 10, 3, 4, 12, 1};
        for (int d : data) {
            h.add(d);
            h.print();
        }
        for (int i = 0; i < data.length; i++) {
            System.out.println(h.peek());
            System.out.println(h.poll());
            h.print();
        }
    }

    private int[] heap;

    public MaxHeap(int initial) {
        this.heap = new int[initial + 1];
        this.heap[0] = 0;
    }

    public MaxHeap() {
        this(16);
    }

    public void add(int value) {
        if (this.heap[0] + 1 > this.heap.length - 1) {
            this.resize();
        }
        this.heap[0]++;
        this.heap[this.heap[0]] = value;
        int cur = this.heap[0];
        while (cur > 1) {
            int parent = cur / 2;
            if (this.heap[parent] < this.heap[cur]) {
                swap(parent, cur);
                cur = parent;
            } else {
                return;
            }
        }
    }

    private void swap(int i, int j) {
        int tmp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = tmp;
    }

    private void resize() {
        int cap = this.heap.length - 1;
        int[] next = new int[cap*2+1];
        for (int i = 0; i <= this.heap[0]; i++) {
            next[i] = this.heap[i];
        }
        this.heap = next;
    }

    public int size() {
        return this.heap[0];
    }

    public int poll() {
        if (this.heap[0] <= 0) {
            return 0;
        }
        int result = this.heap[1];
        int size = this.heap[0];
        this.heap[1] = this.heap[size];
        int cur = 1;
        while (true) {
            int max = cur;
            int left = cur * 2;
            if (left >= size) {
                break;
            }
            if (this.heap[left] > this.heap[max]) {
                max = left;
            }
            int right = left + 1;
            if (right < size && this.heap[right] > this.heap[max]) {
                max = right;
            }
            if (max != cur) {
                swap(cur, max);
                cur = max;
            } else {
                break;
            }
        }
        this.heap[0]--;
        return result;
    }

    public int peek() {
        if (this.heap[0] <= 0) {
            return 0;
        }
        return this.heap[1];
    }

    public void print() {
        System.out.print("[ ");
        for (int i = 0; i <= this.heap[0]; i++) {
            System.out.print(String.valueOf(this.heap[i]) + ", ");
        }
        System.out.println("]");
    }
}
