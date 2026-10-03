class Solution {
    private class Island {
        int i, j;
        
        public Island(int i, int j) { this.i = i; this.j = j; }

        public List<Integer> asList() {
            return List.of(i, j);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            Island that = (Island)obj;
            return this.i == that.i && this.j == that.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;

        Set<Island> pacific = new HashSet<>();

        Queue<Island> adjacents = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            Island island = new Island(i, 0);
            pacific.add(island);
            adjacents.offer(island);
        }
        for (int j = 1; j < n; j++) {
            Island island = new Island(0, j);
            pacific.add(island);
            adjacents.offer(island);
        }

        final int[] dirY = {1, 0, -1, 0};
        final int[] dirX = {0, 1, 0, -1};

        while (!adjacents.isEmpty()) {
            Island cur = adjacents.poll();
            for (int k = 0; k < 4; k++) {
                Island adj = new Island(cur.i + dirY[k], cur.j + dirX[k]);
                if (
                    adj.i >= 0 && adj.i < m && adj.j >= 0 && adj.j < n 
                    && heights[adj.i][adj.j] >= heights[cur.i][cur.j] 
                    && !pacific.contains(adj)
                ) {
                    pacific.add(adj);
                    adjacents.offer(adj);
                }
            }
        }

        Set<Island> atlantic = new HashSet<>();
        for (int i = m-1; i >= 0; i--) {
            Island island = new Island(i, n-1);
            atlantic.add(island);
            adjacents.offer(island);
        }
        for (int j = n-2; j >= 0; j--) {
            Island island = new Island(m-1, j);
            atlantic.add(island);
            adjacents.offer(island);
        }

        while (!adjacents.isEmpty()) {
            Island cur = adjacents.poll();
            for (int k = 0; k < 4; k++) {
                Island adj = new Island(cur.i + dirY[k], cur.j + dirX[k]);
                if (
                    adj.i >= 0 && adj.i < m && adj.j >= 0 && adj.j < n 
                    && heights[adj.i][adj.j] >= heights[cur.i][cur.j] 
                    && !atlantic.contains(adj)
                ) {
                    atlantic.add(adj);
                    adjacents.offer(adj);
                }
            }
        }

        return pacific.stream().filter(atlantic::contains).map(Island::asList).toList();
    }
}
