public class Solution {
    public List<String[]> solveNQueens(int n) {
        List<String[]> rtn = new ArrayList<String[]>();
        int[] board = new int[n];
        dfs(0, n, board, rtn);
        return rtn;
    }
    public void dfs(int row, int n, int[] board, List<String[]> rtn) {
        if (row >= n) {
            generateBoard(board, n, rtn);
            return;
        }
        for (int col = 0; col < n; col++) {
            board[row] = col;
            if (validate(row, board)) {
                dfs(row+1, n, board, rtn);
            }
        }
    }
    public boolean validate(int row, int[] board) {
        for (int i =  0; i < row; i++) {
            if (board[i] == board[row] || Math.abs(board[row] - board[i]) == row-i) {
                return false;
            }
        }
        return true;
    }
    
    public void generateBoard(int[] board, int n, List<String[]> rtn) {
        String[] inStr = new String[n];
        for (int i = 0; i < n; i++) {
            char[] aRow = new char[n];
            Arrays.fill(aRow, '.');
            aRow[board[i]] = 'Q';
            inStr[i] = String.copyValueOf(aRow);
        }
        rtn.add(inStr);
    }
}