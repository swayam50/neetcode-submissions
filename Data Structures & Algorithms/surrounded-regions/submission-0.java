class Solution {
    private static final int[] dirY = new int[] {1, 0, -1, 0};
    private static final int[] dirX = new int[] {0, 1, 0, -1};

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++)
            if (board[i][0] == 'O')
                markRegion(i, 0, m, n, board);

        for (int j = 1; j < n; j++)
            if (board[0][j] == 'O')
                markRegion(0, j, m, n, board);
        
        for (int i = 1; i < m; i++)
            if (board[i][n - 1] == 'O')
                markRegion(i, n - 1, m, n, board);

        for (int j = 1; j < n; j++)
            if (board[m - 1][j] == 'O')
                markRegion(m - 1, j, m, n, board);

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '5')
                    board[i][j] = 'O';
    }

    private void markRegion(int i, int j, int m, int n, char[][] board) {
        board[i][j] = '5';

        for (int k = 0; k < 4; k++) {
            int y = i + dirY[k];
            int x = j + dirX[k];

            if (y >= 0 && y < m && x >= 0 && x < n && board[y][x] == 'O')
                markRegion(y, x, m, n, board);
        }
    }
}
