import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] result = new int[m][n];
        boolean[][] vis = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();

        // Step 1: Push all 0s into queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }

        // Directions (Up, Down, Left, Right)
        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // Step 2: BFS
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            for (int[] d : dir) {
                int nr = row + d[0];
                int nc = col + d[1];

                // Correct boundary + visited check
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !vis[nr][nc]) {
                    result[nr][nc] = result[row][col] + 1;
                    vis[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        return result;
    }
}