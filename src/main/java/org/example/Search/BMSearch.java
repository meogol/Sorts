package org.example.Search;

import java.util.ArrayList;

public class BMSearch implements ISearch {
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

        char[] pattern = findStr.toCharArray();
        char[] text = str.toCharArray();

        int patternSize = pattern.length;
        int textSize = text.length;

        for (int i = 0, j = 0; i < textSize; i++)

            while ((i + patternSize) <= textSize) {
                j = patternSize - 1;
                while (text[i + j] == pattern[j]) {
                    j--;
                    if (j < 0) {
                        foundPositions.add(i);
                        break;

                    }
                }

                if(j>patternSize)
                    break;
                else
                    i++;
            }
    }
}
