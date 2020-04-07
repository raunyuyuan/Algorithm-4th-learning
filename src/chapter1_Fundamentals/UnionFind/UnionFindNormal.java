package chapter1_Fundamentals.UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UnionFindNormal {
    private int[] id; // 分量id，分量指将向量分成几个方向的和，这个方向上的向量就是分量
    private  int count; // 联通数量

    public UnionFindNormal(int N) {
        count = N;
        id = new int[N];
        while (N > 0) {
            N--;
            id[N] = N;
        }
    }

    public int find(int a) {
        return id[a];
    }

    public void union(int a, int b) {
        int aID = find(a);
        int bID = find(b);
        if (aID == bID) return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == aID) {
                id[i] = bID;
            }
        }
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
        UnionFindNormal uf = new UnionFindNormal(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}
