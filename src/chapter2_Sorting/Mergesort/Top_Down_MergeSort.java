package chapter2_Sorting.Mergesort;

public class Top_Down_MergeSort extends InPlaceMerge{

    public void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid); // 左区间
        sort(a, mid + 1, hi); // 右区间
        merge(a, lo, mid, hi);
    }

    public void sort(Comparable[] a) {
        initAux(a.length);
        sort(a, 0, a.length - 1);
    }


}
