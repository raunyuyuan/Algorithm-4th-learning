package chapter1_Fundamentals.DataAbstraction;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import org.jetbrains.annotations.NotNull;

public class TestVisualAccumulator {
    public static void main(@NotNull String[] args) {
        int T = Integer.parseInt(args[0]);
        VisualAccumulator a = new VisualAccumulator(T, 1.0);
        for (int t = 0; t < T; t++) {
            a.addDateValue(StdRandom.uniform());
        }
        StdOut.println(a);
    }
}
