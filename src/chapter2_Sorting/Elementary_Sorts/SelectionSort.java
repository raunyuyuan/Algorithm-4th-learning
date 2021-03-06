package chapter2_Sorting.Elementary_Sorts;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// 5，5，2时选择排序是不稳定的
public class SelectionSort extends SortCommon{

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            // 每次归位最小的元素
            exch(a, i, min);
        }
    }



    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
