package org.example.Search;

import java.util.ArrayList;

public class KMPSearch implements ISearch {
    ArrayList<Integer> foundPositions;

    @Override
    public void accept(String o, String o1) {
        search((String) o, (String) o1);
    }

    public ArrayList<Integer> getFoundPositions() {
        return foundPositions;
    }

    public static int[] pfl(char[] text)
    {
        int[] pfl = new int[text.length];
        pfl[0] = 0;

        for (int i = 1; i < text.length; ++i)
        {
            int k = pfl[i - 1];
            while (text[k] != text[i] && k > 0)
            {
                k = pfl[k - 1];
            }
            if (text[k] == text[i])
            {
                pfl[i] = k + 1;
            }
            else
            {
                pfl[i] = 0;
            }
        }

        return pfl;
    }

    @Override
    public void search(String str, String findStr) {
        foundPositions = new ArrayList<>();

        char[] pattern = findStr.toCharArray();
        char[] text = str.toCharArray();

        int[] pfl = pfl(pattern);
        int k = 0;

        for (int i = 0; i < text.length; ++i)
        {
            while (pattern[k] != text[i] && k > 0)
            {
                k = pfl[k - 1];
            }
            if (pattern[k] == text[i])
            {
                k = k + 1;
                if (k == pattern.length)
                {
                    foundPositions.add(i + 1 - k);
                    k = pfl[k - 1];
                }
            }
            else
            {
                k = 0;
            }
        }
    }

}
