package UnionFind;

import java.util.Random;

public class Main {

    private static double testUF(UF uf, int m){

        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();


        for(int i = 0 ; i < m ; i ++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        for(int i = 0 ; i < m ; i ++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int size = 100000000;
        int m = 100000000;

        // UnionFindOriginal uf1 = new UnionFindOriginal(size);
        // System.out.println("UnionFindOriginal : " + testUF(uf1, m) + " s");

        // UnionFindTree uf2 = new UnionFindTree(size);
        // System.out.println("UnionFindTree : " + testUF(uf2, m) + " s");

        UnionFindOptimizeHeight uf3 = new UnionFindOptimizeHeight(size);
        System.out.println("UnionFindOptimizeHeight : " + testUF(uf3, m) + " s");

        UnionFindOptimizeRank uf4 = new UnionFindOptimizeRank(size);
        System.out.println("UnionFindOptimizeRank : " + testUF(uf4, m) + " s");
    }
}
