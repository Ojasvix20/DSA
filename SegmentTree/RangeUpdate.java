import java.util.*;
public class RangeUpdate{

    static int[] arr, seg,  lazy;

    public static void build(int idx, int l, int r){
        if(l==r){

            seg[idx]= arr[l];
            return;
        }
        int mid = l+ (r-l)/2;
        build(2*idx+1, l,mid);
        build(2*idx+2, mid+1,r);
        seg[idx]= seg[2*idx+1] + seg[2*idx+2];
    }

    public static void rangeUpdate(int idx, int l, int r, int rl, int rr, int nv){
        //first finish pending task
        if(lazy[idx]!=0){
            seg[idx]+= (r-l+1)*lazy[idx];

            if(l!=r){
                //do pending task for children
                lazy[2*idx+1]+=lazy[idx];
                lazy[2*idx+2]+=lazy[idx];
            }
            lazy[idx]=0;
        }

        //completely outside:
        if(l>rr || r<rl) return;

        //if completely inside:
        if(rl<=l && r<=rr){
            seg[idx]+=(r-l+1)*nv;
            if(l!=r){
                lazy[2*idx+1]+=nv;
                lazy[2*idx+2]+=nv;
            }
            return;
        }

        //if partial overlapping:
        int mid = l +(r-l)/2;
        rangeUpdate(2*idx+1, l,mid,rl,rr,nv);
        rangeUpdate(2*idx+2, mid+1,r,rl,rr,nv);

        seg[idx]= seg[2*idx+1] + seg[2*idx+2];
        
    }

    public static int query(int idx, int l, int r, int ql, int qr){
        //first finish pending task
        if(lazy[idx]!=0){
            seg[idx]+= (r-l+1)*lazy[idx];

            if(l!=r){
                //do pending task for children
                lazy[2*idx+1]+=lazy[idx];
                lazy[2*idx+2]+=lazy[idx];
            }
            lazy[idx]=0;
        }

        //completely outside:
        if(l>qr || r<ql) return 0;

        //if completely inside:
        if(ql<=l && r<=qr){        
            return seg[idx];
        }

        int mid = l+(r-l)/2;  
        int left= query(2*idx+1, l, mid, ql, qr);
        int right= query(2*idx+2, mid+1,r, ql, qr);

        return left+right;

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        arr= new int[n];
        seg= new int[n*4];
        lazy= new int[n*4];
        int q= sc.nextInt();
        for(int i=0; i<n; i++) arr[i]=sc.nextInt();

        build(0,0,n-1);

        // System.out.println(Arrays.toString(seg));

        while(q-->0){
            //1 l r = rangequery
            //2 l r v = range update

            int a= sc.nextInt();
            if(a==1){
                int ql = sc.nextInt();
                int qr = sc.nextInt();
                System.out.println(query(0,0,n-1,ql,qr));

            }else{
                int rl = sc.nextInt();
                int rr = sc.nextInt();
                int nv = sc.nextInt();
                rangeUpdate(0,0,n-1, rl,rr,nv );
            }
        }
        //print the final arrays
        System.out.println(Arrays.toString(seg));
        System.out.println(Arrays.toString(lazy));
        
        //print the updated elements
        
        for(int i=0;i<n;i++){
            System.out.print(query(0,0,n-1,i,i)+" ");
        }
        System.out.println();
        
    }
}