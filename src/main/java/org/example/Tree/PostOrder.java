package org.example.Tree;

import org.example.Tree.data.ITree;
import org.example.Tree.data.Node;

import java.util.ArrayList;

public class PostOrder implements ITree {
    @Override
    public void cont(Node top) {
        if (top == null) return;
        cont(top.getLeft());
        cont(top.getRight());
        arr.add(top.getValue());

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
