package chapter1_Fundamentals.Analysis_of_Algorithm;

import chapter1_Fundamentals.Basic.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class TwoSumFast {
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
//        StdOut.print("The data length is" + N);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (BinarySearch.indexOf(a, -a[i]) > i) {
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(@NotNull String args[]) {
        In in = new In(args[0]);
        Stopwatch Timer = new Stopwatch();
        int Count = count(in.readAllInts());
        StdOut.println(Count);
    }
}
