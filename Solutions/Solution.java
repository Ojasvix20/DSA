import java.util.Arrays;

public class Solution {

    static int missingNum(int arr[]) {
        // code here
        if (arr.length == 1) {
            return (arr[0] + 1);
        }
        Arrays.sort(arr);
        if(arr[0]!=1){
            return 1;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] != (arr[i] + 1)) {
                return (arr[i] + 1);
            }
        }
        return arr[arr.length - 1] + 1;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 3 };
        System.out.println(missingNum(nums));
    }
}
