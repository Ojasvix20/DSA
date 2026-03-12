import java.util.*;
import java.io.*;

public class NumberOfMinimumsOnASegment{

    static class Node{
        long min;
        int cnt;

        Node(long min,int cnt){
            this.min=min;
            this.cnt=cnt;
        }
    }

    static Node[] seg;
    static int n;

    public static Node merge(Node a, Node b){

        if(a.min<b.min)
            return new Node(a.min,a.cnt);

        if(b.min<a.min)
            return new Node(b.min,b.cnt);

        return new Node(a.min,a.cnt+b.cnt);
    }

    public static void build(int idx,int l,int r,long[] arr){

        if(l==r){
            seg[idx]=new Node(arr[l],1);
            return;
        }

        int mid=(l+r)/2;

        build(idx*2+1,l,mid,arr);
        build(idx*2+2,mid+1,r,arr);

        seg[idx]=merge(seg[idx*2+1],seg[idx*2+2]);
    }

    public static void update(int idx,int l,int r,int pos,long val){

        if(l==r){
            seg[idx]=new Node(val,1);
            return;
        }

        int mid=(l+r)/2;

        if(pos<=mid)
            update(idx*2+1,l,mid,pos,val);
        else
            update(idx*2+2,mid+1,r,pos,val);

        seg[idx]=merge(seg[idx*2+1],seg[idx*2+2]);
    }

    public static Node query(int idx,int l,int r,int ql,int qr){

        //outside
        if(qr<l || ql>r)
            return new Node(Long.MAX_VALUE,0);

        //inside
        if(ql<=l && r<=qr)
            return seg[idx];

        //overlapping
        int mid=l+ (r-l)/2;

        Node left=query(idx*2+1,l,mid,ql,qr);
        Node right=query(idx*2+2,mid+1,r,ql,qr);

        return merge(left,right);
    }

    public static void main(String[] args)throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());

        long[] arr=new long[n];
        seg=new Node[4*n];

        st=new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++)
            arr[i]=Long.parseLong(st.nextToken());

        build(0,0,n-1,arr);

        StringBuilder sb=new StringBuilder();

        while(q-->0){

            st=new StringTokenizer(br.readLine());

            int type=Integer.parseInt(st.nextToken());

            if(type==1){

                int i=Integer.parseInt(st.nextToken());
                long v=Long.parseLong(st.nextToken());

                update(0,0,n-1,i,v);

            }else{

                int l=Integer.parseInt(st.nextToken());
                int r=Integer.parseInt(st.nextToken());

                Node ans=query(0,0,n-1,l,r-1);

                sb.append(ans.min)
                  .append(" ")
                  .append(ans.cnt)
                  .append("\n");
            }
        }

        System.out.print(sb);
    }
}