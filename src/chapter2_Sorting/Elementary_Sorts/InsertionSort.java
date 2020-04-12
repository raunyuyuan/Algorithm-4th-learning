package chapter2_Sorting.Elementary_Sorts;

public class InsertionSort extends SortCommon {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, i, j);
            }
        }
    }
}
