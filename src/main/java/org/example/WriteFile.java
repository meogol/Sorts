package org.example;

import org.example.Search.*;
import org.example.Sort.*;
import org.example.Tree.*;
import org.example.test.Test;

import java.io.*;

public class WriteFile {

    public static void main(String[] args) {

    testSort();
    testSearch();
    testTree();


    }

    private static void testSort(){
        Test test = new Test(1000);

        test.startSort(1000, new CombSortMethod());
        writeFile("CombSortMethod",test);

        test.startSort(1000, new InsertionSortMethod());
        writeFile("InsertionSortMethod",test);

        test.startSort(1000, new QuickSortMethod());
        writeFile("QuickSortMethod",test);

        test.startSort(1000, new ShakerSortMethod());
        writeFile("ShakerSortMethod",test);

        test.startSort(1000, new ShellSortMethod());
        writeFile("ShellSortMethod",test);
    }

    private static void testSearch(){
        Test test = new Test(200000);

        test.startSearch(10000, new BMHSearch());
        writeFile("BMHSearch",test);

        test.startSearch(1000, new BMSearch());
        writeFile("BMSearch",test);

        test.startSearch(1000, new KMPSearch());
        writeFile("KMPSearch",test);

        test.startSearch(1000, new LineSearch());
        writeFile("LineSearch",test);

        test.startSearch(1000, new RKSearch());
        writeFile("RKSearch",test);
    }

    private static void testTree(){
        Test test = new Test(100);

        test.startOrder(10000, new InOrder());
        writeFile("InOrder",test);

        test.startOrder(10000, new PostOrder());
        writeFile("PostOrder",test);

        test.startOrder(10000, new LevelOrder());
        writeFile("LevelOrder",test);

        test.startOrder(10000, new MorrisOrder());
        writeFile("MorrisOrder",test);

        test.startOrder(10000, new MorrisPreOrder());
        writeFile("MorrisPreOrder",test);

        test.startOrder(10000, new PreOrder());
        writeFile("PreOrder",test);
    }

    private static void writeFile(String name, Test test){
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(name+".txt")))) {
            for (long l: test.getTimeRes()
                 ) {
                writer.write( String.valueOf(l));
                writer.write(System.lineSeparator());

            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
