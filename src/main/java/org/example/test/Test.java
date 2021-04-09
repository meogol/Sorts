package org.example.test;

import org.example.Search.ISearch;
import org.example.Tree.data.ITree;
import org.example.Tree.data.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class Test {
    int[] array;
    String str;
    List<Long> timeRes = new ArrayList<>();

    Test(){
        array = new int[100];
    }
    public Test(int size){
        array = new int[100];
        initArray();
    }

    public int[] getArray() {
        return array;
    }

    public List<Long> getTimeRes() {
        return timeRes;
    }

    public void printTimeRes() {
        for (int ii : array) System.out.print(ii + " ");
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

    public void startSort(int repeat, Consumer<int[]> sort){
        for(int i=0; i<repeat; i++){
            initArray();

            long start = System.currentTimeMillis();
            sort.accept(array);
            long finish = System.currentTimeMillis();

            timeRes.add(finish-start);
        }
    }

    private String createStr(int size){
        Random r = new Random();
        String eng = "abcdefghijklmnopqrstuvwxyz";

        var str = "";
        for(int i=0; i<size; i++){
            char c = eng.charAt(r.nextInt(eng.length()));

            str += c;
        }

        return  str;
    }

    public void startSearch(int repeat, ISearch search){


        for(int i=0; i<repeat; i++){
            str = createStr(array.length);
            String findStr = str.substring(60,63);

            long start = System.currentTimeMillis();
            search.accept(str, findStr);
            long finish = System.currentTimeMillis();

            timeRes.add(finish-start);
        }
    }

    public Node createTree(){
        var rand = new Random();
        var head = new Node(rand.nextInt());
        createNode(head, 0);

        return head;

    }

    private void createNode(Node node, int count){
        var rand = new Random();

        switch (rand.nextInt(3)) {
            case 0:{
                node.setLeft(new Node(rand.nextInt()));
                count++;
                if(count< array.length)
                    createNode(node.getLeft(), count);
            }
            case 1:{
                node.setRight(new Node(rand.nextInt()));
                count++;
                if(count< array.length)
                    createNode(node.getRight(), count);

            }
            case 2:{
                node.setRight(new Node(rand.nextInt()));
                node.setLeft(new Node(rand.nextInt()));
                count++;

                if(count< array.length) {
                    createNode(node.getLeft(), count);
                    createNode(node.getRight(), count);
                }

            }
        }
    }

    public void startOrder(int repeat, ITree search){
        for(int i=0; i<repeat; i++){
            var testData = createTree();

            long start = System.currentTimeMillis();
            search.accept(testData);
            long finish = System.currentTimeMillis();

            timeRes.add(finish-start);

            for (var a: search.getArr()) System.out.println(a + " ");
        }
    }

}
