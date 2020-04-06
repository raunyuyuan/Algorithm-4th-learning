package chapter1_Fundamentals.Bags_Queues_Stacks;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class QueueClient {
    public static void main(String args[]) {
        String name = "algs4-data/tinyT.txt";
        In in = new In(name);
        Queue<Integer> q = new Queue<Integer>();
        while (!in.isEmpty()) {
            q.enqueue(in.readInt());
        }
        int N = q.size();
        for (int i = 0; i < N; i++) {
            StdOut.print(q.dequeue() + "\n");
        }
    }
}
