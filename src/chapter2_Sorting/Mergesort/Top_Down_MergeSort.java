package chapter2_Sorting.Mergesort;

import edu.princeton.cs.algs4.StdOut;

public class Top_Down_MergeSort extends InPlaceMerge{

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid); // 左区间
        sort(a, mid + 1, hi); // 右区间
        merge(a, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        initAux(a.length);
        sort(a, 0, a.length - 1);
    }

    public static void main(String args[]) {
        String[] a = new String[5];
        a[0] = "G";
        a[1] = "B";
        a[2] = "A";
        a[3] = "K";
        a[4] = "A";
        sort(a);
        for (String s : a) {
            StdOut.print(s);
        }
    }
}
