function MaxPQ() {

    const queue = [null]
    let N = 0

    function exch(a, b) {
        const temp = queue[b]
        queue[b] = queue[a]
        queue[a] = temp
    }

    function swim(k) {
        while (k > 1) {
            let root = k / 2;
            if (root < k) {
                exch(root, k);
                k = k / 2;
            } else {
                break;
            }
        }
    }

    function insert(v) {
        queue.push(v)
        N++
        swim(N)
    }

    function init(arr) {
        arr.forEach(item => {
            insert(item)
        })
    }

    function sink(k) {

        while (k * 2 < N) {
            let child = k * 2
            if (queue[child] < queue[child + 1]) child += 1
            if (queue[k] < queue[child]) {
                exch(k, child)
                k = child
            } else {
                break
            }
        }
    }

    function delMax() {
        let max = pq[1];
        exch(1, N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }


    return {
        insert,
        delMax,
        init
    }
}
