package org.suai.Laba8.DopLaba8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Parallel {
    public static int findMaxParallel(String[] lines) throws InterruptedException {

        List numbers = new ArrayList();
        int size = lines.length;
        int[] results = new int[size];
        int max = Integer.MIN_VALUE;

        List<Thread> threads = new LinkedList<>();
        for (int i = size - 1; i >= 0; i--) {
            int fi = i;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {

                    List<Integer> num = new ArrayList<>();
                    int currentMax = Integer.MIN_VALUE;

                    for (String s : lines[fi].split("\\s")) {
                        num.add(Integer.parseInt(s));
                    }
                    for (int n : num) {
                        try {
                            Thread.sleep(1);
                            if (n > currentMax) {
                                currentMax = n;
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    results[fi] = currentMax;
                }
            });
            t.start();
            threads.add(t);
        }
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        for (int n : results) {
            if (n > max) {
                max = n;
            }
        }

        return max;
    }
}