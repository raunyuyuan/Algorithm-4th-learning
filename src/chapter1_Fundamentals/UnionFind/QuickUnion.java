package chapter1_Fundamentals.UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class QuickUnion {
    private int[] id; // 分量id，分量指将向量分成几个方向的和，这个方向上的向量就是分量
    private  int count; // 联通数量
    private AmortizedCostPlots visual = new AmortizedCostPlots(900, 300); // 均摊成本图像

    public QuickUnion(int N) {
        count = N;
        id = new int[N];
        while (N > 0) {
            N--;
            id[N] = N;
        }
    }

    public int find(int a) {
        visual.increaseCost();
        while (a != id[a]) {
            visual.increaseCost();
            a = id[a];
        };
        return a;
    }

    public void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) {
            visual.drawPoint();
            return;
        }
        id[aRoot] = bRoot;
        visual.increaseCost();
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
        QuickUnion uf = new QuickUnion(N);
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
