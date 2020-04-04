package chapter1_Fundamentals.DataAbstraction;

import edu.princeton.cs.algs4.StdOut;

public class Counter {

    private final String name;

    private int count;

    public Counter(String id) {
        name = id;
    }

    public void increment() {
        count++;
    }
    public int tally() {
        return count;
    }

    @Override
    public String toString() {
        return count + " " + name;
    }

    public static void main(String args[]) {
        Counter a = new Counter("123");
        a.increment();
        StdOut.println(a.tally());
        StdOut.println(a.toString());
    }
}
