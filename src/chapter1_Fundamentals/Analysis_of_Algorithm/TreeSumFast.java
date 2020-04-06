package chapter1_Fundamentals.Analysis_of_Algorithm;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class TreeSumFast {

    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        StdOut.printf("The data Length is %d \n", N);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (BinarySearch.indexOf(a, -a[i] - a[j]) > j) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(@NotNull String[] args) {
        In i = new In(args[0]);
        int[] a = i.readAllInts();
        Stopwatch timer = new Stopwatch();
        int Counter = count(a);
        StdOut.printf("Consume time is %.2f \n", timer.elapsedTime());
        StdOut.println(Counter);
    }

}
