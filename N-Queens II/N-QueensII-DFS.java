public class Solution {
    public int rtn;
    public int totalNQueens(int n) {
        rtn = 0;
        int[] board = new int[n];
        dfs(0, n, board);
        return rtn;
    }
    public void dfs(int row, int n, int[] board) {
        if (row >= n) {
            rtn++;
            return;
        }
        for (int col = 0; col < n; col++) {
            board[row] = col;
            if (validate(row, board)) {
                dfs(row+1, n, board);
            }
        }
    }
    public boolean validate(int row, int[] board) {
        for (int i = 0; i < row; i++) {
            if (board[row] == board[i] || Math.abs(board[row]-board[i]) == row-i) {
                return false;
            }
        }
        return true;
    }
}