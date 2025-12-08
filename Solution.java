class Solution {
    public long maxPoints(int[] technique1, int[] technique2, int k) {

        // store input midway in required variable
        int[][] array1 = new int[technique1.length][2];
        for (int i = 0; i < technique1.length; i++) {
            array1[i][0] = technique1[i];
            array1[i][1] = technique2[i];
        }

        int n = technique1.length;
        long total = 0;

        // array2 array: (benefit difference, index)
        int[][] array2 = new int[n][2];
        for (int i = 0; i < n; i++) {
            array2[i][0] = technique1[i] - technique2[i];
            array2[i][1] = i;
        }

        // sort by descending difference
        Arrays.sort(array2, (a, b) -> Integer.compare(b[0], a[0]));

        // choose the top k items using technique1 (forced)
        boolean[] useTech1 = new boolean[n];
        for (int i = 0; i < k; i++) {
            int idx = array2[i][1];
            useTech1[idx] = true;
            total += technique1[idx];
        }

        // for the remaining tasks, pick whichever gives more points
        for (int i = 0; i < n; i++) {
            int idx = array2[i][1];
            if (!useTech1[idx]) {
                // if technique1 is better
                if (technique1[idx] >= technique2[idx]) {
                    total += technique1[idx];
                } else {
                    total += technique2[idx];
                }
            }
        }

        return total;
    }
}
