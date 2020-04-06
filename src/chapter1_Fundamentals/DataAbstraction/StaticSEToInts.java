package chapter1_Fundamentals.DataAbstraction;
import chapter1_Fundamentals.Basic.BinarySearch;

import java.util.Arrays;

public class StaticSEToInts {
    private int[] a;
    public StaticSEToInts(int[] keys) {
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++) {
            a[i] = keys[i];
        }
        Arrays.sort(a);
    }

    private boolean contains(int key) {
        return BinarySearch.indexOf(a, key) != -1;
    }

}
