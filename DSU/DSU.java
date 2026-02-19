import java.util.*;
public class DSU{
    public static void main(String[] args){
        int n=7;
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.fill(rank,0);

        union(1, 2, parent, rank);
        union(2, 3, parent, rank);
        union(4, 5, parent, rank);

        System.out.println(find(3, parent)); 
        System.out.println(find(5, parent)); 

    }
    public static void union(int x, int y, int[] parent, int[] rank){

        int x_parent = find(x, parent);
        int y_parent = find(y, parent);

        if(x_parent==y_parent){
            return;
        }else if(rank[x_parent]> rank[y_parent]){
            parent[y_parent] = x_parent;
        }else if(rank[y_parent]> rank[x_parent]){
            parent[x_parent] = y_parent;
        }else{
            parent[x_parent] = y_parent;
            rank[y_parent]+=1;
        }
    }
    public static int find(int i, int[] parent){

        if(i==parent[i]){
            return i;
        }

        return parent[i] = find(parent[i], parent);
    }
}