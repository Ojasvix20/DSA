// CF -  1167c new distribution
import java.util.*;
import java.io.*;

public class NewsDistribution{
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
    
        int[] parent = new int[n+1];
        int[] size = new int[n+1];

        for(int i=0 ;i<=n;i++){
            parent[i]=i;
            size[i]=1;
        }

        for(int i=0;i<m;i++){
            st =new StringTokenizer(br.readLine());

            int t=Integer.parseInt(st.nextToken());
            if (t == 0) continue;

            int first = Integer.parseInt(st.nextToken());

            for (int j = 1; j < t; j++) {
                int friend = Integer.parseInt(st.nextToken());
                union(first, friend, parent, size);
            }

           
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            int root=find(i, parent);
            sb.append(size[root]).append(" ");
        }

        System.out.println(sb);

        
    }
    public static int find(int x, int[] parent){
        if(parent[x]==x) return x;

        return parent[x] = find(parent[x],parent);
    }

    public static void union(int a,int b, int[] parent, int[] size){
        int x = find(a, parent);
        int y = find(b, parent);

        if (x == y) return;

        if (size[x] > size[y]) {
            parent[y] = x;
            size[x] += size[y];
        } else {
            parent[x] = y;
            size[y] += size[x];
        }
        
    }
}