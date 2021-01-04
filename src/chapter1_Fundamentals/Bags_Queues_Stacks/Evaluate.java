package chapter1_Fundamentals.Bags_Queues_Stacks;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// Dijkstra的双栈算数表达式运算求值算法
public class Evaluate {

    public static void caluate(Stack<String> ops, Stack<Double> vals) {
        while (!ops.isEmpty()) {
            String op = ops.pop();
            double v = vals.pop();
            if (op.equals("+")) v = vals.pop() + v;
            else if (op.equals("-")) v = vals.pop() - v;
            else if (op.equals("*")) v = vals.pop() * v;
            else if (op.equals("/")) v = vals.pop() / v;
            else if (op.equals("sqrt")) v = Math.sqrt(v);
            vals.push(v);
        }

    }

    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        String s = "";
        while (!StdIn.isEmpty()) {
            s = StdIn.readString();
            if      (s.equals("("))   ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) caluate(ops, vals);
            else {
                String prevOpe = "";
                if (!ops.isEmpty()) prevOpe = ops.pop();
                if (prevOpe.equals("*") || prevOpe.equals("/") || prevOpe.equals("sqrt")) {
                    vals.push(Double.parseDouble(s) * vals.pop());
                } else {
                    vals.push(Double.parseDouble(s));
                    ops.push(prevOpe);
                }
            }
        }
        if (!s.equals(")")) caluate(ops, vals);
        StdOut.println(vals.pop());
    }
}
