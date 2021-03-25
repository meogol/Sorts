package org.example.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Test {
    int[] array;
    List<Long> timeRes = new ArrayList<>();

    public Test(){
        array = new int[100];
    }
    public Test(int size){
        array = new int[size];
        initArray();
    }

    public int[] getArray() {
        return array;
    }

    public List<Long> getTimeRes() {
        return timeRes;
    }

    public void printArray(){
        for (int ii : array) System.out.print(ii + " ");
    }

    private void initArray(){
        Random rand = new Random();

        for(int i = 0; i< array.length; i++){
            array[i]= rand.nextInt();
        }
    }

    public void StartSort(int repeat, Consumer<int[]> sort){
        for(int i=0; i<repeat; i++){
            initArray();

            long start = System.currentTimeMillis();
            sort.accept(array);
            long finish = System.currentTimeMillis();

            timeRes.add(finish-start);
        }
    }



}
