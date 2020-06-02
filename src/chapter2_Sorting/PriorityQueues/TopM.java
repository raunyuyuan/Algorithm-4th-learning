package chapter2_Sorting.PriorityQueues;

import edu.princeton.cs.algs4.*;

public class TopM {
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        MinPQ<Transaction> pq = new MinPQ<Transaction>(M + 1);
        while (StdIn.hasNextLine()) {
            pq.insert(new Transaction(StdIn.readLine()));
            if (pq.size() > M) {
                Transaction a = pq.delMin(); // 到顶了删除最小的元素
                StdOut.println(a + "\n");
            }
        }
        Stack<Transaction> stack = new Stack<Transaction>();
        while (!pq.isEmpty()) stack.push(pq.delMin());
        for (Transaction t: stack) StdOut.println(t);
    }

}
