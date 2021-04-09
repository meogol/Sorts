package org.example.Tree.data;

import java.util.ArrayList;

public interface ITree {
    ArrayList<Integer> arr = new ArrayList<Integer>();

    public void cont(Node top);
    public void accept(Node top);

    public ArrayList<Integer> getArr();

}
