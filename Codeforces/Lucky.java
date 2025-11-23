// https://codeforces.com/problemset/problem/1676/A

import java.util.*;
public class Lucky{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int sumLeft=0;
        int sumRight=0;

        while(n-- >0){
            String s = sc.next();

            int len = s.length();
            
            sumLeft = s.charAt(0) - '0' + s.charAt(1) - '0' + s.charAt(2) - '0';
            
            sumRight = s.charAt(len-1) - '0' + s.charAt(len-2) - '0' + s.charAt(len-3) - '0';

            if(sumLeft==sumRight){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
        
    }
}