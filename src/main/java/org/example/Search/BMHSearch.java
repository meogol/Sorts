package org.example.Search;

import java.util.ArrayList;

public class BMHSearch implements ISearch {
    ArrayList<Integer> foundPositions;

    @Override
    public void accept(String o, String o1) {
        search((String) o, (String) o1);
    }

    public ArrayList<Integer> getFoundPositions() {
        return foundPositions;
    }

    @Override
    public void search(String str, String findStr) {
        foundPositions = new ArrayList<>();

        int shift[] = new int[256];
        char[] pattern = findStr.toCharArray();
        char[] text = str.toCharArray();


        for (int k = 0; k < 256; k++) {
            shift[k] = pattern.length;
        }

        for (int k = 0; k < pattern.length - 1; k++){
            shift[pattern[k]] = pattern.length - 1 - k;
        }

        for (int i = 0, j = 0; i < text.length; i++)

        while ((i + pattern.length) <= text.length) {
            j = pattern.length - 1;

            while (text[i + j] == pattern[j]) {
                j -= 1;
                if (j < 0) {
                    foundPositions.add(i);
                    break;

                }
            }

            i = i + shift[text[i + pattern.length - 1]];
        }
    }

}
