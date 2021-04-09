package org.example.Tree;

import org.example.Tree.data.ITree;
import org.example.Tree.data.Node;

import java.util.ArrayList;

public class PreOrder implements ITree {
    @Override
    public void cont(Node top) {
        if (top == null) {
            return;
        }
        arr.add(top.getValue());
        // Затем обходим левое поддерево
        cont(top.getLeft());

        // В конце обходим правое поддерево
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
