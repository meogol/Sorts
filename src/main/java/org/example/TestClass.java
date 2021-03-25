package org.example;

import org.example.Sort.*;
import org.example.test.Test;

public class TestClass {
    public static void main(String[] args) {
        ShakerSortMethod s = new ShakerSortMethod();
        Test t = new Test(100);
        t.printArray();
        System.out.println();
        System.out.println();
        System.out.println();

        t.StartSort(10, new QuickSortMethod());

        t.printArray();
    }
}
