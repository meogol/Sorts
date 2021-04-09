package org.example.Tree;

import org.example.Tree.data.ITree;
import org.example.Tree.data.Node;

import java.util.ArrayList;

public class InOrder implements ITree {
    @Override
    public void cont(Node top) {
        if (top == null) return;
        cont(top.getLeft());
        arr.add(top.getValue());
        cont(top.getRight());
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
