class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;
        int minutes = 0;

        // Step 1: Put all rotten oranges in queue
        // and count fresh oranges
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // Directions: up, down, left, right
        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        // Step 2: BFS
        while (!queue.isEmpty() && fresh > 0) {

            int size = queue.size();

            // Process all oranges belonging to this minute
            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];

                // Check 4 directions
                for (int[] dir : directions) {

                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // Check boundaries and fresh orange
                    if (newRow >= 0 && newRow < grid.length &&
                        newCol >= 0 && newCol < grid[0].length &&
                        grid[newRow][newCol] == 1) {

                        // Make it rotten
                        grid[newRow][newCol] = 2;

                        // One less fresh orange
                        fresh--;

                        // Add newly rotten orange to queue
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }

            // One minute has passed
            minutes++;
        }

        // If fresh oranges are still left, impossible
        if (fresh > 0) {
            return -1;
        }

        return minutes;
    }
}