package org.example.Sort;

import java.util.function.Consumer;

public class QuickSortMethod implements Consumer {

    public void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i ++) {
            int minIndex = min(array, i, n - 1);
            swap(array, i, minIndex);
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static int min(int[] array, int begin, int end) {
        int minVal = array[begin];
        int minIndex = begin;
        for (int i = begin + 1; i <= end; i++) {
            if (array[i] < minVal) {
                minVal = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }



    @Override
    public void accept(Object o) {
        if(o.getClass() != int[].class)
            return;

        sort((int[]) o);
    }
}
