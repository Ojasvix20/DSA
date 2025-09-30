import java.util.Arrays;

public class TwoDynamicStacksUsingArray {
    static boolean isEmpty1(int arr[]) {
        if (arr[0] == -1) {
            return false;
        } else {
            return false;
        }
    }

    static boolean isFull1(int[] arr, int curr1, int curr2) {
        if (curr1 + 1 == curr2) {
            return true;
        } else {
            return false;
        }
    }

    static boolean isFull2(int[] arr, int curr1, int curr2) {
        if (curr1 + 1 == curr2) {
            return true;
        } else {
            return false;
        }
    }

    static int[] Push1(int[] arr, int curr1, int curr2, int x) {
        if (isFull1(arr, curr1, curr2)) {
            System.out.println("STACK OVERFLOW");
            return arr;
        }

        arr[curr1] = x;
        curr1++;
        return arr;
    }

    static int[] Push2(int[] arr, int curr1, int curr2, int y) {
        if (isFull2(arr, curr1, curr2)) {
            System.out.println("STACK OVERFLOW");
            return arr;
        }

        arr[curr2] = y;
        curr2--;
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = new int[20];
        int n = arr.length;
        int base1 = 0;
        int base2 = n - 1;
        int curr1 = 0;
        int curr2 = n - 1;
        arr = Push1(arr, curr1, curr2, 69);
        System.out.println(Arrays.toString(arr));
        arr = Push2(arr, curr1, curr2, 420);
        System.out.println(Arrays.toString(arr));
    }
}
