package com.kawasin73;

/**
 * Created by kawasin73 on 2018/06/03.
 */
public class UnionFind {
    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        int[][] data = {
                {1, 4, 5},
                {2, 3},
                {5, 7},
                {8, 0, 4}
        };

        for (int i = 0; i < data.length; i++) {
            int[] array = data[i];
            for (int j = 1; j < array.length; j++) {
                uf.union(array[0], array[j]);
            }
        }

        System.out.print("[ ");
        for (int i = 0; i < 10; i++) {
            System.out.print(uf.find(i));
            System.out.print(", ");
        }
        System.out.println("]");
    }

    private int[] data;

    public UnionFind(int size) {
        data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = i;
        }
    }

    public int find(int i) {
        if (data[i] == i) {
            return i;
        }
        data[i] = find(data[i]);
        return data[i];
    }

    public boolean same(int i, int j) {
        return find(i) == find(j);
    }

    public void union(int i, int j) {
        i = find(i);
        j = find(j);
        if (i == j) {
            return;
        }
        data[i] = j;
    }
}
