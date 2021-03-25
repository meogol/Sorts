package org.example.Sort;

import java.util.function.Consumer;

<<<<<<< refs/remotes/origin/GUISorts
public class CombSortMethod implements Consumer {
=======
public class CombSortMethod implements Consumer, SortInterface {
>>>>>>> Add sort code

    public void sort(int[] array) {
        int step = (int) (array.length / 1.247);
        int swapCount = 1;
        for (; step > 1 || swapCount > 0;) {
            swapCount = 0;
            for (int i = 0; i + step < array.length; i++) {
                if (array[i] > array[i + step]) {
                    int temp = array[i];
                    array[i] = array[i + step];
                    array[i + step] = temp;
                    swapCount++;
                }
            }
            if (step > 1) {
                step = (int) (step / 1.247);
            }
        }
    }


    @Override
    public void accept(Object o) {
        if(o.getClass() != int[].class)
            return;

        sort((int[]) o);
    }
}
