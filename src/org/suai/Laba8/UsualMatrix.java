package org.suai.Laba8;


public class UsualMatrix implements Comparable<UsualMatrix> {
    protected int[][] data;
    protected int rows = 0;
    protected int cols = 0;

    public UsualMatrix(int row1, int column1) {
        data = new int[row1][column1];
        rows = row1;
        cols = column1;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                data[i][j] = 0;
    }

    public UsualMatrix sum(UsualMatrix a) {
        if (rows == a.getRows() && cols == a.getCols()) {
            UsualMatrix res = new UsualMatrix(rows, cols);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int tmp = a.getElement(i, j) + this.getElement(i, j);
                    res.setElement(i, j, tmp);
                }
            }
            return res;
        }
        return null;
    }

    public UsualMatrix product(UsualMatrix a) {
        if (cols == a.getRows()) {
            UsualMatrix res = new UsualMatrix(rows, a.getCols());
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < a.getCols(); j++) {
                    res.setElement(i, j, 0);
                    for (int k = 0; k < cols; k++) {
                        res.setElement(i, j, res.getElement(i, j) + (this.getElement(i, k) * a.getElement(k, j)));
                    }
                }
            }
            return res;
        }
        return null;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void setElement(int row1, int column1, int value) {
        data[row1][column1] = value;
    }

    public int getElement(int row1, int column1) {
        return data[row1][column1];
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                res.append(" ").append(getElement(i, j));
            res.append("\n");
        }
        return res.toString();
    }

    public boolean equals(Object obj) {
        boolean res = false;
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof UsualMatrix))
            return false;
        UsualMatrix a = (UsualMatrix) obj;
        if (rows != a.getRows() || cols != a.getCols())
            return false;
        int flag = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (this.getElement(i, j) != a.getElement(i, j))
                    flag++;
            }
        }
        if (flag == 0)
            res = true;
        return res;
    }

    @Override
    public int compareTo(UsualMatrix o2) {
        int sum1 = 0;
        for (int i = 0; i < this.getRows(); i++)
            for (int j = 0; j < this.getCols(); j++)
                sum1 += this.getElement(i, j);
        int sum2 = 0;
        for (int i = 0; i < o2.getRows(); i++)
            for (int j = 0; j < o2.getCols(); j++)
                sum2 += o2.getElement(i, j);
        if (sum1 == sum2)
            return 0;
        if (sum1 > sum2)
            return 1;
        return -1;
    }
}

