/**
 * Created by qijiawen on 8/6/17.
 */

/**
 * Time: O(MN). Space: O(MN). M is the rows, N is the cols.
 */
public class IslandCountDFS {

    public static int getNumberOfIslands(int[][] binaryMatrix) {
        // base case
        if (binaryMatrix == null || binaryMatrix.length == 0 || binaryMatrix[0].length == 0) return 0;

        int result = 0;
        int m = binaryMatrix.length;
        int n = binaryMatrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (binaryMatrix[i][j] == 1) {
                    dfs(binaryMatrix, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private static void dfs(int[][] binaryMatrix, int i, int j) {
        int m = binaryMatrix.length;
        int n = binaryMatrix[0].length;

        // outbound
        if (i < 0 || i >= m || j < 0 || j >= n) return;

        // mark as visited and go through 4 directions
        if (binaryMatrix[i][j] == 1) {
            binaryMatrix[i][j] = -1; // -1 means visited
            dfs(binaryMatrix, i - 1, j);
            dfs(binaryMatrix, i + 1, j);
            dfs(binaryMatrix, i, j - 1);
            dfs(binaryMatrix, i, j + 1);
        }
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
