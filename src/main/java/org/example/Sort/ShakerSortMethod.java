package org.example.Sort;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ShakerSortMethod implements Consumer {
    public void sort(int[] array) {
        int left = 0; // левая граница
        int right = array.length - 1; // правая граница

        do
        {
            //Сдвигаем к концу массива "тяжелые элементы"
            for (int i = left; i < right; i++)
            {
                if(array[i] > array[i+1])
                {
                    array[i] ^= array[i+1];
                    array[i+1] ^= array[i];
                    array[i] ^= array[i+1];
                }
            }
            right--; // уменьшаем правую границу
            //Сдвигаем к началу массива "легкие элементы"
            for (int i = right; i > left ; i--)
            {
                if(array[i] < array[i-1])
                {
                    array[i] ^= array[i-1];
                    array[i-1] ^= array[i];
                    array[i] ^= array[i-1];
                }
            }
            left++; // увеличиваем левую границу
        } while (left <= right);
    }



    @Override
    public void accept(Object o) {
        if(o.getClass() != int[].class)
            return;

        sort((int[]) o);
    }
}
