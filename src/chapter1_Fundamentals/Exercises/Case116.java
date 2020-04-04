package chapter1_Fundamentals.Exercises;

import edu.princeton.cs.algs4.StdOut;
// 斐波那契数列动态规划算法
// 这里非常不好理解的地方就是从0开始打印，将g计算回0，再次打印1将g计算回1，g保存上一个数，f都是下一个f
public class Case116 {
    public static void main(String[] args) {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            StdOut.println(f);
            f = f + g; // 这里的f每次都是下一个f
            g = f - g;
        }
    }

}
