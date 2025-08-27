public class Check_power_2 {
    public static boolean power_2(int n){

        // a number is power of 2 if it has only bit=1... so we can check by logical and of n and n-1 and compare it with 0
        return (n & (n-1)) ==0;
    }
    public static void main (String args[]){
        System.out.print("16 is power of 2? : ");
        System.out.println(power_2(16));
        System.out.print("20 is power of 2? : ");
        System.out.println(power_2(20));
        System.out.print("256 is power of 2? : ");
        System.out.println(power_2(256));
        System.out.print("8 is power of 2? : ");
        System.out.println(power_2(8));
        
    }
}
