class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        Queue<int[]> rottens = new LinkedList<>();

        int freshCount = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1)
                    freshCount++;
                else if (grid[i][j] == 2)
                    rottens.offer(new int[] {i, j});
        
        if (freshCount == 0 && rottens.size() == 0)
            return 0;

        final int[] dirY = new int[] {1, 0, -1, 0};
        final int[] dirX = new int[] {0, 1, 0, -1};

        int seconds = -1;
        while (!rottens.isEmpty()) {
            int sz = rottens.size();
            for (int s = 0; s < sz; s++) {
                int[] top = rottens.poll();
                int i = top[0], j = top[1];

                for (int k = 0; k < 4; k++) {
                    int y = i + dirY[k];
                    int x = j + dirX[k];

                    if (y >= 0 && y < m && x >= 0 && x < n && grid[y][x] == 1) {
                        grid[y][x] = 2;
                        freshCount--;
                        rottens.offer(new int[] {y, x});
                    }
                }
            }
            seconds++;
        }

        return freshCount == 0 ? seconds : -1;
    }
}
