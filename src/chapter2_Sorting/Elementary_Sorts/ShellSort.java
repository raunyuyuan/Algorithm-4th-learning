package chapter2_Sorting.Elementary_Sorts;

public class ShellSort extends SortCommon{
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3 * h + 1; // 1， 4， 13, 40, 121
        while (h >= 1) {
            for (int i = h; i < N; i++) { // 进行h ~ N  和 (0 ～ N - h)之间的插入排序
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, i, j);
                }
            }
            h = h / 3;
        }
    }
}
