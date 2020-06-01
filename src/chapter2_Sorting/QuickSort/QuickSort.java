package chapter2_Sorting.QuickSort;

public class QuickSort {
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while(true) {
            while(less(a[++i], v)) if (i == hi) break;
            while(less(a[--j], v)) ;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
}
