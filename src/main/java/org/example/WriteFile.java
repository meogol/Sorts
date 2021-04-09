package org.example;

import org.example.Sort.*;
import org.example.test.Test;

import java.io.*;

public class WriteFile {
    static Test test = new Test(1000);

    public static void main(String[] args) {

        test.startSort(1000, new CombSortMethod());
        writeFile("CombSortMethod");

        test.startSort(1000, new InsertionSortMethod());
        writeFile("InsertionSortMethod");

        test.startSort(1000, new QuickSortMethod());
        writeFile("QuickSortMethod");

        test.startSort(1000, new ShakerSortMethod());
        writeFile("ShakerSortMethod");

        test.startSort(1000, new ShellSortMethod());
        writeFile("ShellSortMethod");


    }

    private static void writeFile(String name){
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
