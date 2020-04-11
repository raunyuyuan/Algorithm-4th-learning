package chapter1_Fundamentals.UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class QuickFind {
    private int[] id; // 分量id，分量指将向量分成几个方向的和，这个方向上的向量就是分量
    private int count; // 联通数量
    private AmortizedCostPlots visual = new AmortizedCostPlots(900, 1300); // 均摊成本图像

    public QuickFind(int N) {
        count = N;
        id = new int[N];
        while (N > 0) {
            N--;
            id[N] = N;
        }
    }

    public int find(int a) {
        visual.increaseCost();
        return id[a];
    }

    public void union(int a, int b) {
        int aID = find(a);
        int bID = find(b);
        if (aID == bID) {
            visual.drawPoint();
            return;
        }
        for (int i = 0; i < id.length; i++) {
            visual.increaseCost();
            if (id[i] == aID) {
                visual.increaseCost();
                id[i] = bID;
            }
        }
        visual.drawPoint();
        count--;
    }

    public int count() {
        return count;
    }


    public boolean connected(int a, int b) {
        return find(a) == find(b);
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickFind uf = new QuickFind(N);
        Stopwatch timer = new Stopwatch();
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.printf("Consume time is %.2f \n", timer.elapsedTime());
        StdOut.println(uf.count() + " components");
    }
}
