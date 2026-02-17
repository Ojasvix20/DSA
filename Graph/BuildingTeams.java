import java.io.*;
import java.util.*;

public class BuildingTeams {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] team = new int[n + 1];
        Arrays.fill(team, -1);

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if (team[i] != -1) continue;

            team[i] = 1;
            q.add(i);

            while (!q.isEmpty()) {
                int node = q.poll();

                for (int nbr : adj.get(node)) {
                    if (team[nbr] == -1) {
                        team[nbr] = (team[node] == 1) ? 2 : 1;
                        q.add(nbr);
                    } else if (team[nbr] == team[node]) {
                        System.out.println("IMPOSSIBLE");
                        return;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(team[i]).append(" ");
        }
        System.out.println(sb);
    }
}
