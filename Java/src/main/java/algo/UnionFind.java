package algo;

/**
 * UnionFind
 */
public class UnionFind {
    private int[] id;
    private int[] size;

    public UnionFind(int n) {
        id = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    public int root(int n) {
        int r = id[n];
        while (r != id[r]) r = id[r];
        return r;
    }

    public boolean isConnected(int p, int q) {
        return p == q || root(p) == root(q);
    }

    public void connect(int p, int q) {
        int rp = root(p);
        int rq = root(q);
        if (size[rp] >= size[rq]) {
            id[q] = rp;
            size[rp] += size[rq];
        } else {
            id[p] = rq;
            size[rq] += size[rp];
        }
    }
}