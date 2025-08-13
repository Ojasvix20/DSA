public class Fast_Exponentiation {
    
    //for calculation a^n we use a*a*a... n times which means O(n)time complexity
    //however this time complexity can be reduced to O(log n) by using binary methods

    public static int fastExpo(int a, int n) {
        int ans=1;
        while (n>0) {
            if((n&1)!=0){   //check LSB
                ans=ans*a;
            }
            a=a*a;
            n=n>>1;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(fastExpo(5, 2));
    }
}
