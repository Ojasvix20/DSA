import java.util.*;

class Matrix01 {
    static int n, m;

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public int[][] updateMatrix(int[][] mat) {
        n = mat.length;
        m = mat[0].length;

        int[][] ans = new int[n][m];
        for (int[] row : ans) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        // BFS
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (isValid(nr, nc) && ans[nr][nc] == -1) {
                    ans[nr][nc] = ans[r][c] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return ans;
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }
}
