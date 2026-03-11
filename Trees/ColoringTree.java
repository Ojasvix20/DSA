// https://codeforces.com/problemset/problem/902/B

import java.io.*;
import java.util.*;

public class ColoringTree {

    static int count=0;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n= Integer.parseInt(st.nextToken());

        List<List<Integer>> tree = new ArrayList<>();
        
        
        for(int i=0;i<=n;i++){
            tree.add(new ArrayList<>());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=2;i<=n;i++){
            int parent = Integer.parseInt(st.nextToken());
            tree.get(parent).add(i);
        }
        
        int[] colorReq= new int[n+1];
        st= new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            colorReq[i]= Integer.parseInt(st.nextToken());
        }

        dfs(1,0,tree, colorReq);

        System.out.println(count);
    }
    public static void dfs(int node, int parentColor, List<List<Integer>> tree, int[] colorReq){
        if(colorReq[node]!=parentColor){
            count++;
        }
        for(int child : tree.get(node)){
            dfs(child, colorReq[node], tree, colorReq);
        }
    }
}
