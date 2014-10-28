// reference: http://www.lifeincode.net/programming/leetcode-word-search-java/


public class Solution {
    boolean[][] visited;
    int boardHeight, boardWidth;
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return true;
        }
        boardHeight = board.length;
        boardWidth = board[0].length;
        visited = new boolean[boardHeight][boardWidth];
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int pos, int i, int j) {
        if (pos == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= boardHeight || j >= boardWidth) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        if (word.charAt(pos) != board[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean result = dfs(board, word, pos+1, i-1, j) ||
                         dfs(board, word, pos+1, i+1, j) ||
                         dfs(board, word, pos+1, i, j-1) ||
                         dfs(board, word, pos+1, i, j+1);
        visited[i][j] = false;
        return result;
    }
}