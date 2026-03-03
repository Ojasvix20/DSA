// CSES- Road construction

import java.util.*;
import java.io.*;

public class RoadConstruction{
    static int components, maxSize;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        int[] parent= new int[n+1];
        int[] size= new int[n+1];
        for(int i=0; i<=n; i++){
            parent[i]=i;
            size[i]=1;
        }
        components=n;
        maxSize=1;

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<m; i++){
            st=new StringTokenizer(br.readLine());
            int u= Integer.parseInt(st.nextToken());
            int v= Integer.parseInt(st.nextToken());

            int pu = find(u, parent);
            int pv = find(v, parent);
            if(pu!=pv){
                union(pu,pv,parent, size);
            }
            sb.append(components).append(" ").append(maxSize).append("\n");
        }
        System.out.println(sb);
    }
    public static int find(int x, int[] parent){
        if(parent[x]==x) return x;

        return parent[x] = find(parent[x],parent);
    }

    public static void union(int x,int y, int[] parent, int[] size){
        if(size[x]>size[y]){
            size[x]+=size[y];
            parent[y]=x;
            maxSize=Math.max(size[x], maxSize);
        }else{
            size[y]+=size[x];
            parent[x]=y;
            maxSize=Math.max(size[y], maxSize);
        }
        components--;
        
    }
}