package com.kawasin73;

/**
 * Created by kawasin73 on 2018/06/02.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] data = {9, 10, 3, 4};
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
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        int curleft = left;
        int curright = right;
        int pivot = array[(left + right) / 2];

        while (curleft <= curright) {
            while (array[curleft] < pivot) {
                curleft++;
            }
            while (array[curright] > pivot) {
                curright--;
            }
            if (curleft <= curright) {
                swap(array, curleft, curright);
                curleft++;
                curright--;
            }
        }

        print(array);
        if (curright > left) {
            quickSort(array, left, curright);
        }
        if (curleft < right) {
            quickSort(array, curleft, right);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
