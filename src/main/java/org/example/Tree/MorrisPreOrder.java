package org.example.Tree;

import org.example.Tree.data.ITree;
import org.example.Tree.data.Node;

import java.util.ArrayList;

public class MorrisPreOrder implements ITree {

    @Override
    public void cont(Node top) {
        if(top == null)return;
        Node cur = top;
        Node mostRight = null;

        while(cur != null){
            mostRight = cur.getLeft();
            if(mostRight != null){

                while(mostRight.getRight() != null && mostRight.getRight() != cur){
                    mostRight = mostRight.getRight();
                }

                if(mostRight.getRight() == null){
                    mostRight.setRight(cur);
                    arr.add(cur.getValue());
                    cur = cur.getLeft();
                    continue;
                }else {
                    mostRight.setRight(null);
                }
            }else {    // Если у узла нет левого поддерева, это равносильно тому, что он только один раз заходит на этот узел, печатает напрямую, а затем идет вправо
                arr.add(cur.getValue());
            }
            cur = cur.getRight();
        }
        System.out.println();
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
