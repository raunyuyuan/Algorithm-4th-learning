package chapter2_Sorting.PriorityQueues;

public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void swim(int k) {
        while (k > 1) {
            int root = k / 2;
            if (less(root, k)) {
                exch(root, k);
                k = k / 2;
            } else {
                break;
            }
        }
    }

    private void sink(int k) {
        while(k * 2 < N) {
            // 如果分左右节点 会走很多逻辑，但是一次找到最大的就比较方便
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            // 和其中最大的元素做交换
            exch(k, j);
            k = j;
        }
    }
}
