import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qijiawen on 8/6/17.
 */
public class IslandCountBFS {

    public static int getNumberOfIslands(int[][] binaryMatrix) {
        if (binaryMatrix == null || binaryMatrix.length == 0 || binaryMatrix[0].length == 0) return 0;

        int m = binaryMatrix.length;
        int n = binaryMatrix[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (binaryMatrix[i][j] == 1) {
                    markIsland(binaryMatrix, m, n, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private static void markIsland(int[][] binaryMatrix, int m, int n, int i, int j) {
        Queue<int[]> queue = new LinkedList<>(); // store the index in queue
        queue.add(new int[] {i, j});
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            int r = cur[0];
            int c = cur[1];
            if (binaryMatrix[r][c] == 1) {
                binaryMatrix[r][c] = -1; // mark as visited
                addIfValid(queue, m, n, r - 1, c);
                addIfValid(queue, m, n, r + 1, c);
                addIfValid(queue, m, n, r, c - 1);
                addIfValid(queue, m, n, r, c + 1);
            }
        }
    }

    private static void addIfValid(Queue<int[]> queue, int m, int n, int r, int c) {
        if (r >= 0 && r < m && c >= 0 && c < n) queue.add(new int[] {r, c});
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