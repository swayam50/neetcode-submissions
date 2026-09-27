class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9], cols = new boolean[9][9], boxs = new boolean[9][9];

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;

                int num = board[i][j] - '0' - 1;
                int row = i, col = j, box = (i / 3) + 3 * (j / 3);

                if (rows[row][num] || cols[col][num] || boxs[box][num])
                    return false;
                rows[row][num] = cols[col][num] = boxs[box][num] = true;
            }

        return true;
    }
}
