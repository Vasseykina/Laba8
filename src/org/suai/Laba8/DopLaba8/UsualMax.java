package org.suai.Laba8.DopLaba8;

import java.util.ArrayList;
import java.util.List;

public class UsualMax {
    public static int findMaxUsual(String[] lines) {
        List numbers = new ArrayList();
        int size = lines.length;
        int[] results = new int[size];
        int max = Integer.MIN_VALUE;

        for (int i = size - 1; i >= 0; i--) {
            int fi = i;

            List<Integer> num = new ArrayList<>();
            int currentMax = Integer.MIN_VALUE;

            for (String s : lines[fi].split("\\s")) {
                num.add(Integer.parseInt(s));
            }
            for (int n : num) {
                if (n > currentMax) {
                    currentMax = n;
                }
            }
            results[fi] = currentMax;
        }
        for (int n : results) {
            if (n > max) {
                max = n;
            }
        }

        return max;
    }

}