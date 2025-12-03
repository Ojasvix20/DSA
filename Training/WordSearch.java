import java.util.*;

public class WordSearch{
    public static boolean exist(char[][] board, String word,int rows, int cols) {

        // int rows = board.length;
        // int cols = board[0].length;

        // Try starting from every cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (search(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean search(char[][] board, String word, int index, int i, int j) {

        // 1. If all characters matched
        if (index == word.length()) {
            return true;
        }

        //  Boundary checks
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }

        // Character mismatch OR already visited
        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark as visited by replacing with a special char
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore 4 directions
        boolean found = search(board, word, index + 1, i + 1, j) || // down
                search(board, word, index + 1, i - 1, j) || // up
                search(board, word, index + 1, i, j + 1) || // right
                search(board, word, index + 1, i, j - 1); // left

        // Backtrack (undo the visit)
        board[i][j] = temp;

        return found;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of rows");
        int rows = sc.nextInt();
        System.out.print("Enter no. of cols");
        int cols = sc.nextInt();
        char[][] board= new char[rows][cols];

        System.out.println("Enter column wise chars:");

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                board[i][j]=sc.nextLine().charAt(0);
            }
        }

        System.out.print("Enter the word to find: ");
        String word = sc.nextLine();

        exist(board, word, rows, cols);
    }
}