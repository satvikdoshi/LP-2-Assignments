
import java.util.*;
public class Main {
    public static void branchAndBound(int n, char[][] board){

        boolean[] cols = new boolean[n];
        boolean[] ndiag = new boolean[2*n-1];
        boolean[] rdiag = new boolean[2*n-1];

        solve(board, 0, cols, ndiag, rdiag);
    }

    public static void solve(char[][] board,int row, boolean[] cols, boolean[] ndiag, boolean[] rdiag){

        if(row == board.length){
            for(char[] ch : board){
                System.out.println(Arrays.toString(ch));
            }
            System.out.println();
            return;
        }
        for(int col=0;col<board[0].length;col++){
            if(!cols[col] && !ndiag[row + col] && !rdiag[row - col + board[0].length - 1]){
                board[row][col] = 'Q';
                cols[col] = true;
                ndiag[row + col] = true;
                rdiag[row - col + board.length - 1] = true;
                solve(board, row + 1, cols, ndiag, rdiag);
                board[row][col] = '.';
                cols[col] = false;
                ndiag[row + col] = false;
                rdiag[row - col + board.length - 1] = false;

            }
        }
    }


    static boolean validate(char[][] board, int row, int col) {
        int duprow = row;
        int dupcol = col;

        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') return false;
            col--;
            row++;
        }
        return true;
    }

    static void backtracking(int col, char[][] board) {
        if (col == board.length) {
            for(char[] ch : board){
                System.out.println(Arrays.toString(ch));
            }
            System.out.println();
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (validate(board, row, col)) {
                board[row][col] = 'Q';
                backtracking(col + 1, board);
                board[row][col] = '.';
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Enter the size of the board: ");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][]board = new char[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                board[i][j] = '.';
            }
        }
        // Branch and Bound
        System.out.println("\n------Branch and Bound-----");
        branchAndBound(N,board);

        // BackTracking
        System.out.println("\n-------BackTracking------");
        backtracking(0,board);

    }
}