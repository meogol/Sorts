package org.example.Tree;

import org.example.Tree.data.ITree;
import org.example.Tree.data.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder implements ITree {

    @Override
    public void cont(Node top) {
        Queue<Node> queue=new LinkedList<> ();
        do{
            arr.add(top.getValue());

            if (top.getLeft()!=null) queue.add(top.getLeft());
            if (top.getRight()!=null) queue.add(top.getRight());
            if (!queue.isEmpty()) top=queue.poll();
        }while (!queue.isEmpty());
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
