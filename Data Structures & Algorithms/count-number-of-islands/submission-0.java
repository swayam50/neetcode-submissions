class Solution {
    private static final int[] dirY = new int[] {1, 0, -1, 0};
    private static final int[] dirX = new int[] {0, 1, 0, -1};

    public int numIslands(char[][] grid) {

        int islandCount = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == '1') {
                    traverseIsland(i, j, grid);
                    islandCount++;
                }

        return islandCount;
    }

    private void traverseIsland(int i, int j, char[][] grid) {
        grid[i][j] = '2';

        for (int k = 0; k < 4; k++) {
            int y = i + dirY[k];
            int x = j + dirX[k];

            if (y >= 0 && y < grid.length && x >= 0 && x < grid[0].length && grid[y][x] == '1')
                traverseIsland(y, x, grid);
        }
    }
}
