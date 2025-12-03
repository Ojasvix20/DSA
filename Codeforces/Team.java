    import java.util.*;

    public class Team{
        public static void main(String args[]){
            System.out.println(Number());
        }
        private static int Number(){
            Scanner sc = new Scanner(System.in);
            int n=sc.nextInt();
            int solved=0;
            
            while(n-->0){
                int noOfOne = 0;
                int a=sc.nextInt();
                if(a==1) noOfOne++;
                int b=sc.nextInt();
                if(b==1) noOfOne++;
                int c=sc.nextInt();
                if(c==1) noOfOne++;

                if(noOfOne>=2) solved++;
            }

            return solved;
        }
    }