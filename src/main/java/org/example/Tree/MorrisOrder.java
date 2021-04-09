package org.example.Tree;

import org.example.Tree.data.ITree;
import org.example.Tree.data.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MorrisOrder implements ITree {

    @Override
    public void cont(Node top) {
        if(top == null)return;
        Node cur = top;
        Node mostRight = null;// Самый правый узел на левом поддереве

        while(cur != null){
            mostRight = cur.getLeft();   // Первый левый узел cur
            if(mostRight != null){  // Если левое поддерево не пустое

                while(mostRight.getRight() != null && mostRight.getRight()
                        != cur){ // Находим самый правый узел Есть два случая
                    mostRight = mostRight.getRight();
                }

                if(mostRight.getRight() == null){ // Первый раз, когда я пришел в этот узел, чтобы встретить первый из второго по величине
                    mostRight.setRight(cur);
                    cur = cur.getLeft();
                    arr.add(cur.getValue());
                    continue; // cur = cur.left напрямую заканчивают все
                }else { // Второй раз, когда я пришел к этому узлу, удовлетворить второй по величине
                    mostRight.setRight(null);
                }
            }
            cur = cur.getRight();  // Левое поддерево, включающее оба случая, пусто и пришло на этот узел во второй раз
        }
    }

    @Override
    public void accept(Node top) {
        cont(top);
    }

    @Override
    public ArrayList<Integer> getArr() {
        return arr;
    }
}
