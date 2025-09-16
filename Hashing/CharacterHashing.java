
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class CharacterHashing {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);

        String s = sc.nextLine();

        // precompute
        int hash[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)-'a'] += 1;
        }

        int q = sc.nextInt();

        while (q > 0) {
            char c = sc.next().charAt(0); 
            System.out.println(hash[c-'a']);
            q--;
        }
        sc.close();
    }
}
