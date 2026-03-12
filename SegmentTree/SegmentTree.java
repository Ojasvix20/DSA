import java.util.*;

class SegmentTree{
    static int[] arr, seg;
    static int n;

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

        seg[idx] = seg[leftChild]+ seg[rightChild];

    }

    // range sum query
    public static int query(int ql, int qr, int idx, int l, int r){

        if(r<ql || qr<l){
            //comppletely outside
            return 0;
        }
        if(ql<=l && r<=qr){
            // completely inside
            return seg[idx];
        }
        int mid= l + (r-l)/2;
        int left= query(ql,qr, 2*idx+1,l,mid);
        int right = query(ql,qr, 2*idx+2, mid+1, r);
        return left+ right;
    }
    
    //update value:
    public static void update(int idx, int l, int r, int i, int nv){
        if(l==r==i){
            seg[idx]=nv;
            arr[i]=nv;
            return;
        }
        int mid= l+ (r-l)/2;

        if( i>=l && i<=mid){
            update(2*idx+1, l,m,i,nv);
        }else{
            update(2*idx+2, m+1, r, i,nv);
        }

        seg[idx]= seg[2*idx+1] + seg[2*idx+2];
    }

    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        n= sc.nextInt();
        arr = new int[n];
        seg = new int[4*n];
        for(int i=0; i<n; i++){
            arr[i]= sc.nextInt();
        }
        buildSt(0,0,n-1);
        // System.out.println("Contents of Segment Tree: ");
        // for (int i = 0; i <= 2 * n; i++) {
        //     System.out.print(seg[i] + " ");
        // }

        // System.out.println();

        // System.out.println(query(1,1,0,0,n-1));

        StringBuilder sb = new StringBuilder();
        while(q-->0){
            st= new StringTokenizer(br.readLine());
            int type= Integer.parseInt(st.nextToken());

            if(type==1){
                //update
                int index= Integer.parseInt(st.nextToken());
                int nv= Integer.parseInt(st.nextToken());
                index--;
                long diff = nv - arr[index];
                arr[index] = nv;
                for (int i = index; i < n; i++) {
                    seg[i] += diff;
                }

            }else{
                // sum in range
                int ql= Integer.parseInt(st.nextToken());
                int qr= Integer.parseInt(st.nextToken());
                ql--;qr--;
                long ans = (ql == 0) ? seg[qr] : seg[qr] - seg[ql - 1];
                sb.append(ans).append("\n");
            }
        }
        System.out.print(sb);
    }
}