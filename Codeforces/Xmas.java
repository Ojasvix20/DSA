import java.util.*;

public class Xmas {
    static class Elf {
        int idx;
        long a;
        Elf(int idx, long a) {
            this.idx = idx;
            this.a = a;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            Elf[] elves = new Elf[n];
            for (int i = 0; i < n; i++) {
                elves[i] = new Elf(i + 1, sc.nextLong());
            }

            if (m == n || m > (n + 1) / 2) {
                System.out.println(-1);
                continue;
            }

            Arrays.sort(elves, Comparator.comparingLong(e -> e.a));

            List<int[]> ops = new ArrayList<>();

            if (m == 0) {
                // kill all
                for (int i = 0; i + 1 < n; i += 2) {
                    ops.add(new int[]{elves[i + 1].idx, elves[i].idx});
                }
            } else {
                // strongest survives
                Elf strongest = elves[n - 1];

                for (int i = 0; i < m - 1; i++) {
                    ops.add(new int[]{elves[i].idx, strongest.idx});
                }
            }

            System.out.println(ops.size());
            for (int[] op : ops) {
                System.out.println(op[0] + " " + op[1]);
            }
        }
    }
}
