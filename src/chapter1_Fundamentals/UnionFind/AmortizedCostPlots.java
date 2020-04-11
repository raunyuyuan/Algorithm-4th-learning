package chapter1_Fundamentals.UnionFind;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class AmortizedCostPlots {

    private int cost; // 当前处理的项目访问数组的次数。
    private int total; // 到目前位置访问数组的次数。
    private int count; // 处理个数

    public AmortizedCostPlots(int trials, double max) {
        StdDraw.setXscale(0, trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(.005);
    }

    public void increaseCost() {
        cost++;
        total++;
    }

    public void drawPoint() {
        count++;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(count, cost);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(count, total/count);
        cost = 0;
    }

    public static void main(String[] args) {
    }
}
