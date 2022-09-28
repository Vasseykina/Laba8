package org.suai.Laba8;

public class ParallelMatrixProduct {
    private int NumberOfString = 0;

    private UsualMatrix left;
    private UsualMatrix right;
    private UsualMatrix res;
    private Threads[] threads;

    public class Threads extends Thread {
        private int NumberOfString = 0;
        public Threads(int number) {
            NumberOfString = number;
        }

        public void run() {
            for(int i = 0; i < right.getCols(); i++) {
                int value = 0;
                for(int j = 0; j < left.getCols(); ++j) {
                    value += left.getElement(NumberOfString,j) * right.getElement(j, i);
                    res.setElement(NumberOfString, i, value);
                }

            }
        }
    }

    public ParallelMatrixProduct (int N) {
        NumberOfString = N;
        threads = new Threads[N];
    }

    public UsualMatrix productParallel(UsualMatrix left1, UsualMatrix right1) {
        left = left1;
        right = right1;
        res = new UsualMatrix(left.getRows(), right.getCols());
        int k = 0;
        for(int i = 0; i < left.getRows(); i++) {
            threads[k] = new Threads(i);
            threads[k].start();
            k++;
            if (k >= NumberOfString)
                k = k - NumberOfString;

        }
        for(int i = 0; i < threads.length; ++i) {
            if(threads[i] != null) {
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return res;
    }
}