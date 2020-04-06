package chapter1_Fundamentals.Analysis_of_Algorithm;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class TwoSum {
    public static int count(int[] a) {
        int N = a.length;
        StdOut.printf("The data length is %d \n", N);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (a[i] + a[j] == 0) cnt++;
            }
        }
        return cnt;
    }

    public static void main(@NotNull String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        Stopwatch timer = new Stopwatch();
        int Count = count(a);
        StdOut.printf("Consume time is %.2f \n", timer.elapsedTime());
        StdOut.println(Count);
    }
}
