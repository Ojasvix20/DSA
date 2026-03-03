class Main{

public static void main(String[] args){

    // int to binary
    //divide by 2 until remainder =1.. reverse all the remainders found

    int x=10;
    StringBuilder ans = new StringBuilder();
    while(x>0){
        int rem = x%2;
        x/=2;
        ans.append(rem);
    }
    ans.reverse();
    System.out.println(ans);

    //or simply get binary string


    //binary to int
    
    String binaryNo = "1101";
    int decimal=0;
    int poww=0;
    for(int i=binaryNo.length()-1; i>=0; i--){
        int num = binaryNo.charAt(i)-'0';
        decimal = decimal + (int)(num*Math.pow(2,poww));
        poww++;
    } 
    System.out.println(decimal);
        
        //simpler method:
    System.out.println(Integer.parseInt("11011", 2));   // binary → decimal
    System.out.println(Integer.toBinaryString(15));     // decimal → binary
    }
}