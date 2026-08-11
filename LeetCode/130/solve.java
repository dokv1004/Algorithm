class Solution {
    char[][] board;
    int m, n;

    public void solve(char[][] board) {
        this.board = board;
        m = board.length;
        n = board[0].length;

        for (int r = 0; r < m; r++) {
            dfs(r, 0);
            dfs(r, n-1);
        }

        for (int c = 0; c < n; c++) {
            dfs(0, c);
            dfs(m-1, c);
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'S') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    public void dfs(int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 'O') {
            return;
        }

        board[r][c] = 'S';

        dfs(r-1, c);
        dfs(r+1, c);
        dfs(r, c-1);
        dfs(r, c+1);
    }
}
