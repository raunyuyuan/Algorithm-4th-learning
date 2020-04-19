package chapter2_Sorting.Mergesort;

public class Down_Top_MergeSort extends InPlaceMerge{
    public static void sort(Comparable[] a) {
        int N = a.length;
        initAux(N);
        for (int sz = 1; sz < N; sz = sz + sz) { // sz为左右子数组的大小
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                int mid = lo + sz -1;
                int hi = Math.min(lo+sz+sz-1, N-1);
                merge(a, lo, mid, hi);
            }
        }
    }

}
