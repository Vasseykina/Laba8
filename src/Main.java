
import org.suai.Laba8.ParallelMatrixProduct;
import org.suai.Laba8.UsualMatrix;


public class Main {
    static public void main(String[] args) {
        long time2 = System.currentTimeMillis();
        ParallelMatrixProduct p = new ParallelMatrixProduct(7);
        UsualMatrix a = new UsualMatrix(700, 700);
        UsualMatrix b = new UsualMatrix(700, 700);
        for (int i = 0; i < 700; i++) {
            for (int j = 0; j < 700; j++) {
                a.setElement(i, j, 1);
                b.setElement(j, i, 1);
            }
        }
        UsualMatrix res = p.productParallel(a, b);
        //System.out.println(res);
        long t = System.currentTimeMillis();
        time2 = t - time2;
        System.out.println("parallel product:" + time2 + "\n");
        long time1 = System.currentTimeMillis();
        UsualMatrix c = new UsualMatrix(700, 700);
        UsualMatrix d = new UsualMatrix(700, 700);
        for (int i = 0; i < 700; i++) {
            for (int j = 0; j < 700; j++) {
                c.setElement(i, j, 1);
                d.setElement(j, i, 1);
            }
        }
        c.product(d);
        long s = System.currentTimeMillis();
        time1 = s - time1;
        System.out.println("usual product:" + time1 + "\n");
    }
}
