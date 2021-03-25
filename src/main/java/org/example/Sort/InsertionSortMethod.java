package org.example.Sort;

import java.util.function.Consumer;

public class InsertionSortMethod implements Consumer {
    public void sort(int[] array) {
        int in, out, temp;

        for (out = 1; out < array.length; out++) { // начинаем со второго элемента
            temp = array[out];                     // запоминаем его во временной переменной
            in = out;                              // переменная для внутреннего цикла
            while (in > 0 && array[in - 1] > temp) {// сравниваем до тех пор пока не достигли 1 или    меньшего элемента
                array[in] = array[in - 1];          // сдвигаем массив вправо
                --in;                               // перемещаем указатель далее влево
            }
            array[in] = temp;                       // вставляем элемент в нужную позицию
        }
    }



    @Override
    public void accept(Object o) {
        if(o.getClass() != int[].class)
            return;

        sort((int[]) o);
    }
}
