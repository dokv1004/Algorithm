class Solution {
    public int[][] grid;
    public int[][] visited;
    public int m, n;
    public int[] dr = {-1, 1, 0, 0};
    public int[] dc = {0, 0, -1, 1};

    public int orangesRotting(int[][] grid) {
        this.grid = grid;
        this.m = grid.length; // 세로
        this.n = grid[0].length; // 가로
        this.visited = new int[m][n];
        int freshCount = 0;
        int depth = 0;

        Queue<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[] {r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            for (int i = 0; i < 4; i++) {
                int nextRow = row + dr[i];
                int nextCol = col + dc[i];

                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                    continue;
                } else if (grid[nextRow][nextCol] == 1) {
                    depth = visited[row][col] + 1;
                    visited[nextRow][nextCol] = depth;
                    grid[nextRow][nextCol] = 2;
                    queue.offer(new int[] {nextRow, nextCol});
                    freshCount--;
                }
            }
        }
        
        if (freshCount == 0) {
            return depth;
        } else {
            return -1;
        }
    }
}
