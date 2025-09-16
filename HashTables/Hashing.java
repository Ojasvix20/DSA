// Hashing using Hashmap

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Hashing {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("input.txt");
        Scanner sc = new Scanner(file);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                int currentCount = map.get(arr[i]);
                map.put(arr[i], currentCount + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        int q= sc.nextInt();

        while (q>0) {
            System.out.println(map.get(sc.nextInt()));
            q--;
        }

        sc.close();
    }
}