import java.util.*;
import java.io.*;

public class MinimumRangeQuery{
    
    static long[] arr, seg;
    static int n;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        int q= Integer.parseInt(st.nextToken());

        arr= new long[n];
        seg= new long[4*n];

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i]= Long.parseLong(st.nextToken());
        }
        buildSt(0,0,n-1);

        StringBuilder sb = new StringBuilder();
        while(q-->0){

            st= new StringTokenizer(br.readLine());
            int type= Integer.parseInt(st.nextToken());
            if(type==1){
                int idx= Integer.parseInt(st.nextToken());
                int nv= Integer.parseInt(st.nextToken());
                update(0,0,n-1,idx,nv);
            }else{

                int ql= Integer.parseInt(st.nextToken());
                int qr= Integer.parseInt(st.nextToken());
                ql--; qr--;
                long minVal= (query(ql, qr, 0, 0, n-1));
                int minFreq=0;
                for(int i=ql; i<qr; i++){
                    if(arr[i]==minVal) minFreq++;
                }            
                sb.append(minVal).append(" ").append(minFreq).append("\n");
            }
        }
        System.out.print(sb);
    }

    // building the Segment tree
    public static void buildSt (int idx, int left, int right){
        if(left==right){
            seg[idx]=arr[left];
            return;
        }

        int mid = left+ (right-left)/2;
        int leftChild= idx*2+1;
        int rightChild= idx*2+2;

        buildSt(leftChild, left, mid);
        buildSt(rightChild, mid+1, right);

        seg[idx] = Math.min(seg[leftChild], seg[rightChild]);
    }

    public static long query(int ql, int qr, int idx, int l, int r){

        // No overlap --  completely outsider
        if(qr < l || ql > r){
            return Integer.MAX_VALUE;
        }

        // Complete overlap -- completely inside
        if(ql <= l && r <= qr){
            return seg[idx];
        }

        // Partial overlap
        int mid = l + (r-l)/2;

        long leftMin = query(ql, qr, idx*2+1, l, mid);
        long rightMin = query(ql, qr, idx*2+2, mid+1, r);

        return Math.min(leftMin, rightMin);
    }
    public static void update(int idx, int l, int r, int i, int nv){
        if(l==r && r==i){
            seg[idx]=nv;
            arr[i]=nv;
            return;
        }
        int mid= l+ (r-l)/2;

        if( i>=l && i<=mid){
            update(2*idx+1, l,mid,i,nv);
        }else{
            update(2*idx+2, mid+1, r, i,nv);
        }

        seg[idx]= seg[2*idx+1] + seg[2*idx+2];
    }
}
