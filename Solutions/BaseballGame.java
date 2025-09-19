import java.util.*;

class BaseballGame {
    public int calPoints(String[] operations) {
        ArrayList<Integer> arr = new ArrayList<>();

        for (String op : operations) {
            switch (op) {
                case "+":
                    int n = arr.size();
                    arr.add(arr.get(n - 1) + arr.get(n - 2));
                    break;

                case "C":
                    arr.remove(arr.size() - 1);
                    break;

                case "D":
                    arr.add(arr.get(arr.size() - 1) * 2);
                    break;

                default:
                    // it's a number
                    arr.add(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for (int x : arr) {
            sum += x;
        }

        return sum;
    }
}
