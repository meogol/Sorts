package org.example;

import org.example.Search.*;
import org.example.Sort.*;
import org.example.Tree.InOrder;
import org.example.Tree.MorrisOrder;
import org.example.Tree.PostOrder;
import org.example.test.Test;

public class TestClass {
    public static void main(String[] args) {
        testOrder();
    }

    private static void testSort(){
        ShakerSortMethod s = new ShakerSortMethod();
        Test t = new Test(10000);
        //t.printArray();
        System.out.println();
        System.out.println();
        System.out.println();

        t.startSort(10, new QuickSortMethod());

       // t.printArray();
        System.out.println();
        var a = t.getTimeRes();
        System.out.println(a);
    }

    private static void testSearch(){
        Test t = new Test(1000);
        System.out.println();
        System.out.println();
        System.out.println();

        var a =new BMHSearch();
        t.startSearch(10, a);
        for(var ii:a.getFoundPositions()) System.out.println(ii+" ");

    }

    private static void testOrder(){
        Test t = new Test(200);
        System.out.println();
        System.out.println();
        System.out.println();

        var a =new MorrisOrder();
        t.startOrder(1, a);

    }
}
