// CSES - Building roads:
//first look for components
// if (components > 1) -> we need more roads
//no. of roads to be built = components - 1;

/* one approach is to do using bfs visited array.... ans = no of bfs calls due to diconnected components but this is naive */

// do using dsu
// find opn -  return the parents
// unions opn - takes 2 nodes and combines them into 1... by adding a link
// 1,2 : make connection 1--->2
//but if parent are same, no need to make more link

import java.util.*;
import java.io.*;

public class BuildingRoads{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];
        for(int i=1; i<parent.length; i++) parent[i]= i;

        while(m-->0){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            union(x,y, parent, rank);

        }

        List<Integer> comp = new ArrayList<>();
        for(int i=1 ;i<parent.length; i++){
            if(find(i,parent)==i) comp.add(i);
        }

        System.out.println(comp.size()-1);

        for(int i=1 ;i<comp.size(); i++){
            System.out.println(comp.get(i-1)+ " " + comp.get(i));
        }
    }

    public static void union(int x, int y, int[] parent , int[] rank){
        int parent_x = find(x, parent);
        int parent_y = find(y, parent);

        if(parent_x==parent_y){
            return;
        }else{
            if(rank[parent_x]> rank[parent_y]){
                parent[parent_y] = parent_x;
            }
            else if(rank[parent_y]> rank[parent_x]){
                parent[parent_x] = parent_y;
            }else{
                parent[parent_x] = parent_y;
                rank[parent_y]+=1;
            }
        }

    }

    public static int find(int i, int[] parent){
        if(parent[i]==i) return i;

        return parent[i]= find(parent[i], parent);
    }
}