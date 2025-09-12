
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class NumberHashing {

    public static void main(String[] args) throws FileNotFoundException {

        //Number Hashing
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);
        int n = sc.nextInt();

        int hash[] = new int[10000000];

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // precompute
        for (int i = 0; i < n; i++) {
            hash[arr[i]] += 1;
        }

        int q = sc.nextInt();
        while (q > 0) {
            int number = sc.nextInt();
            System.out.println(hash[number]);
            q--;
        }

    }
}
