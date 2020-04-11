package chapter1_Fundamentals.UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class WeightedQuickUnionUF {
    // 主要将小树链接到大树，减少树的深度，减少find根节点的复杂度
    private int[] id; // 父链接数组（触点索引）
    private int[] sz; // 各个根节点对应的分量的大小
    private int count; // 连通分量的 数量
    private AmortizedCostPlots visual = new AmortizedCostPlots(900, 300); // 均摊成本图像

    public WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
        sz = new int[N];
        for (int i = 0; i < N; i++) sz[i] = 1;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        visual.increaseCost();
        while (p != id[p]) {
            visual.increaseCost();
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) {
            visual.drawPoint();
            return;
        }

        if (sz[i] < sz[j]) {
            id[i] = j; sz[j] += sz[i];
        } else {
            id[j] = i; sz[i] += sz[j];
        }
        visual.increaseCost();
        visual.increaseCost();
        visual.increaseCost();
        visual.increaseCost();
        visual.increaseCost();
        visual.drawPoint();
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
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
