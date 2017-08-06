/**
 * Created by qijiawen on 8/6/17.
 */

// Union Find
class UF {

    public int count = 0;
    public int[] id  = null;

    public UF(int m, int n, int[][] matrix) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) count++;
            }
        }
        id = new int[m*n];
        for (int i = 0; i < m * n; i++) {
            id[i] = i;
        }
    }

    public int find(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot != qRoot) {
            id[pRoot] = qRoot;
            count--;
        }
    }
}

public class IslandCountUF {

    public static int getNumberOfIslands(int[][] binaryMatrix) {
        if (binaryMatrix == null || binaryMatrix.length == 0 || binaryMatrix[0].length == 0) return 0;

        int m = binaryMatrix.length;
        int n = binaryMatrix[0].length;
        UF uf = new UF(m, n, binaryMatrix);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (binaryMatrix[i][j] == 1) {
                    int p = i * n + j;
                    // only need to go right and down
                    if (i < m - 1 && binaryMatrix[i + 1][j] == 1) uf.union(p, p + n); // down
                    if (j < n - 1 && binaryMatrix[i][j + 1] == 1) uf.union(p, p + 1); // right
                }
            }
        }
        return uf.count;
    }

    public static void main(String[] args) {
        int[][] binaryMatrix = {
                {0, 1, 0, 1, 0},
                {0, 0, 1, 1, 1},
                {1, 0, 0, 1, 0},
                {0, 1, 1, 0, 0},
                {1, 0, 1, 0, 1}};
        System.out.println(getNumberOfIslands(binaryMatrix));
    }
}

