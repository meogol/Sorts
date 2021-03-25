package org.example;

import org.example.Sort.*;
import org.example.test.Test;

public class TestClass {
    public static void main(String[] args) {
        ShakerSortMethod s = new ShakerSortMethod();
        Test t = new Test(10000);
        //t.printArray();
        System.out.println();
        System.out.println();
        System.out.println();

        t.StartSort(100, new InsertionSortMethod());

       // t.printArray();
        System.out.println();
        var a = t.getTimeRes();
        System.out.println(a);
    }
}
