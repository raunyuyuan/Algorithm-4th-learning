package chapter2_Sorting.Elementary_Sorts;

public class ShellSort extends SortCommon{
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3 * h + 1; // 1， 4， 13, 40, 121
        while (h >= 1) {
            for (int i = h; i < N; i++) { // 进行h 间的两个较远量交换，实现较远距离的插入排序（数据提前有序）。
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, i, j);
                }
            }
            h = h / 3;
        }
    }
}
// 假如有N = 14位数
// int[] a = 17389127381294
// h = 13 i = 13  i < N成立
// j = i = 13 <= h = 13 成立 且 a[j = 13] < a[j - h =  0] 即是 4 < 1不成立 循环因为j-= h结束;

// 因为 i++ = 14 不小于N = 14 则退出第二层循环 此时 h = h / 3 = 13 / 3 = 4;
// i = h = 4 < N 成立 j= i = 4 ; 4 >= 4 且 a[4] < a[0] 即 9 < 1不成立; j = 0;

// i+ 1 = 5; j = i = 5; j >= 4 成立 a[5] < a[1]; 不成立；j = 5 - 4 = 1 j >= 4不成立 退出

// i + 1= 6; j = i = 6; j >= 4 成立 a[6] < a[2]; 不成立 j = 6 - 4 = 2 j >= 4 不成立 退出

// ...i = 8; j = i = 8; j >= 4 成立 a[8] < a[4]; 不成立 j = 8 - 4 = 4 j >= 4 成立 则不退出 4 与 0再次比较（为何这里4要和0再次比较呢？？？ // 因为8和4比较过了一次 如果交换了位置 4就不是原来的数值就要再次和0进行比较）

// 9 的时候 5要和 1再次比较
