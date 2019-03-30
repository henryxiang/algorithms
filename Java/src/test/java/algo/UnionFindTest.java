package algo;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnionFindTest {
    private UnionFind uf;

    @Test
    public void testNotConnected() {
        int n = 5;
        uf = new UnionFind(n);
        for (int i = 0; i < n - 1; i++) {
            assertFalse(uf.isConnected(i, i + 1));
        }
    }

    @Test
    public void testSelfConnection() {
        int n = 5;
        uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            assertTrue(uf.isConnected(i, i));
        }
    }

    @Test
    public void testInterConnection() {
        int n = 5;
        uf = new UnionFind(n);
        uf.connect(1, 2);
        uf.connect(2, 3);
        uf.connect(3, 4);
        assertTrue(uf.isConnected(1, 4));
        assertTrue(uf.isConnected(1, 3));
        assertTrue(uf.isConnected(2, 4));
        for (int i = 1; i < n; i++) {
            assertFalse(uf.isConnected(0, i));
        }
    }
}