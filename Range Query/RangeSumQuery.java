import java.util.*;
import java.io.*;

public class RangeSumQuery{
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        
        int n=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        long[] preCal= new long[n];

        st= new StringTokenizer(br.readLine());
        for(int i=0 ; i<n; i++){
            arr[i]= Long.parseLong(st.nextToken());
            preCal[i]=(i==0) ? arr[i] : preCal[i-1]+arr[i];
        }



        StringBuilder sb = new StringBuilder();
        while(q-->0){
            st= new StringTokenizer(br.readLine());
            int ql= Integer.parseInt(st.nextToken());
            int qr= Integer.parseInt(st.nextToken());

            ql--;qr--;

            long ans = (ql == 0) ? preCal[qr] : preCal[qr] - preCal[ql - 1];
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}