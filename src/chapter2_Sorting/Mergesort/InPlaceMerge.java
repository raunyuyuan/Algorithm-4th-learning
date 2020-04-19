package chapter2_Sorting.Mergesort;

public class InPlaceMerge {

    private static Comparable[] aux;
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void initAux(int len) {
        aux = new Comparable[len];
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        // 将a[lo, mid] 和 a[mid+1, hi] 归并
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) { // 复制数组 lo ～ hi
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++]; // 左区间走访完毕
            else if (j > hi) a[k] = aux[i++]; // 右区间走访完毕
            else if (less(a[j], a[i])) a[k] = aux[j++]; // 右区间小于左区间
            else a[k] = aux[i++]; // 右区间大于左区间
        }

    }
}
