public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> hs = new HashSet<Character>();
        for (int row = 0; row < 9; row++) {
            hs.clear();
            for (int col = 0; col < 9; col++) {
                if (hs.contains(board[row][col])) {
                    return false;
                } else {
                    if (board[row][col] != '.') {
                        hs.add(board[row][col]);
                    }
                }
            }
        }
        for (int col = 0; col < 9; col++) {
            hs.clear();
            for (int row = 0; row < 9; row++) {
                if (hs.contains(board[row][col])) {
                    return false;
                } else {
                    if (board[row][col] != '.') {
                        hs.add(board[row][col]);
                    }
                }
            }
        }
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                hs.clear();
                int row_threshold = i + 2;
                int col_threshold = j + 2;
                for (int row = i; row <= row_threshold; row++) {
                    for (int col = j; col <= col_threshold; col++) {
                        if (hs.contains(board[row][col])) {
                            return false;
                        } else {
                            if (board[row][col] != '.') {
                                hs.add(board[row][col]);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}