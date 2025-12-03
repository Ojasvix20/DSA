// https://codeforces.com/problemset/problem/228/A

import java.util.*;
public class HorseShoe{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<Integer> map = new HashMap<>();
        for(int i =0 ; i<4;i++){
            int a = sc.nextInt();
            map.put(a,getOrDefault(a,0)+1);

            
        }

    }
}