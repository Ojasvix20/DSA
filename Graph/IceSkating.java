// Q 217A IceSkating - codeforces

import java.util.*;
public class IceSkating{
    static int n;
    static int[] x, y;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        x = new int[n];
        y = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                components++;
            }
        }

        // Minimum snow drifts to add = no. of connected components - 1
        System.out.println(components - 1);
    }

    static void dfs(int u) {
        visited[u] = true;

        for (int v = 0; v < n; v++) {
            if (!visited[v] && (x[u] == x[v] || y[u] == y[v])) {
                dfs(v);
            }
        }
    }

}