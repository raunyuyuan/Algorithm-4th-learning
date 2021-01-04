package chapter1_Fundamentals.Bags_Queues_Stacks;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// 反转 reserve command + d to send EOF（end of file ）
public class StackClient {
    public static void main(String[] args) {
        Stack<Integer> stack;
        stack = new Stack<Integer>();
        while (!StdIn.isEmpty()) {
            stack.push(StdIn.readInt());
        }
        for (Integer integer : stack) {
            StdOut.println(integer);
        }
    }
}
