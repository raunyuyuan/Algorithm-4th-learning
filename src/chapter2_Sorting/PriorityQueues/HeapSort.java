package chapter2_Sorting.PriorityQueues;

import edu.princeton.cs.algs4.StdOut;

public class HeapSort{

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i-1];
        a[i-1] = a[j-1];
        a[j-1] = temp;
    }

    /***************************************************************************
     * Helper functions for comparisons and swaps.
     * Indices are "off-by-one" to support 1-based indexing.
     ***************************************************************************/
    private static boolean less(Comparable[] a, int i, int j) {
        return a[i-1].compareTo(a[j-1]) < 0;
    }

    private static void sink(Comparable[] a, int k, int N) {
        while(k * 2 < N) {
            // 如果分左右节点 会走很多逻辑，但是一次找到最大的就比较方便
            int j = 2 * k;
            if (j < N && less(a, j, j + 1)) j++;
            if (!less(a, k, j)) break;
            // 和其中最大的元素做交换
            exch(a, k, j);
            k = j;
        }
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }
        while (N > 1) {
            // 把当前N表示最小元素挪上去，不停在原堆当中归位该元素
            exch(a, 1, N--);
            sink(a, 1, N);
        }

    }

    public static void main(String[] args) {
        Comparable[] a = {43,123,512,542,123,3453,35241,4325,131,131,1,2,3,21,423};
        HeapSort.sort(a);
        for (Comparable comparable : a) {
            StdOut.println(comparable);
        }
    }
}
