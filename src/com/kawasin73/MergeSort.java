package com.kawasin73;

/**
 * Created by kawasin73 on 2018/06/02.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] data = {9, 10, 3, 4, 1};
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
        int[] tmp = new int[array.length];
        mergeSort(array, tmp, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] tmp, int left, int right) {
        if ((right - left) == 1) {
            if (array[left] > array[right]) {
                tmp[left] = array[left];
                array[left] = array[right];
                array[right] = tmp[left];
            }
            return;
        }
        int middle = (left + right) / 2;
        if (middle > left) {
            mergeSort(array, tmp, left, middle);
        }
        if (middle + 1 < right) {
            mergeSort(array, tmp, middle + 1, right);
        }

        // merge
        int curT = left, curL = left, curR = middle + 1;
        while (curL <= middle || curR <= right) {
            if (curL > middle) {
                // write right part
                for (; curR <= right; curR++) {
                    tmp[curT] = array[curR];
                    curT++;
                }
            } else if (curR > right) {
                // write left part
                for (; curL <= middle; curL++) {
                    tmp[curT] = array[curL];
                    curT++;
                }
            } else {
                if (array[curL] <= array[curR]) {
                    tmp[curT] = array[curL];
                    curT++;
                    curL++;
                } else {
                    tmp[curT] = array[curR];
                    curT++;
                    curR++;
                }
            }
        }
        for (curT = left; curT <= right; curT++) {
            array[curT] = tmp[curT];
        }
    }
}
