import java.util.*;

class Solution {

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        // Store litter ID at each cell
        int[][] litterId = new int[m][n];

        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }

        int startRow = 0;
        int startCol = 0;
        int litterCount = 0;

        // Find S and assign IDs to L
        for (int r = 0; r < m; r++) {

            for (int c = 0; c < n; c++) {

                char ch = classroom[r].charAt(c);

                if (ch == 'S') {
                    startRow = r;
                    startCol = c;
                }

                else if (ch == 'L') {
                    litterId[r][c] = litterCount;
                    litterCount++;
                }
            }
        }

        // No litter to collect
        if (litterCount == 0) {
            return 0;
        }

        int totalMasks = 1 << litterCount;

        /*
         * visited[row][col][remainingEnergy][mask]
         *
         * mask:
         * 1 = litter not collected
         * 0 = litter collected
         */
        boolean[][][][] visited =
            new boolean[m][n][energy + 1][totalMasks];

        /*
         * State:
         * [row, col, remainingEnergy, mask]
         */
        Queue<int[]> queue = new LinkedList<>();

        int initialMask = (1 << litterCount) - 1;

        queue.offer(new int[]{
            startRow,
            startCol,
            energy,
            initialMask
        });

        visited[startRow][startCol][energy][initialMask] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int moves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            // Process one BFS level
            for (int q = 0; q < size; q++) {

                int[] state = queue.poll();

                int r = state[0];
                int c = state[1];
                int currentEnergy = state[2];
                int mask = state[3];

                // All litter collected
                if (mask == 0) {
                    return moves;
                }

                // No energy left
                if (currentEnergy == 0) {
                    continue;
                }

                // Try 4 directions
                for (int d = 0; d < 4; d++) {

                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    // Outside grid
                    if (nr < 0 || nr >= m ||
                        nc < 0 || nc >= n) {
                        continue;
                    }

                    // Obstacle
                    if (classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }

                    // Energy after moving
                    int nextEnergy = currentEnergy - 1;

                    // Reset energy if destination is R
                    if (classroom[nr].charAt(nc) == 'R') {
                        nextEnergy = energy;
                    }

                    // Update litter mask
                    int nextMask = mask;

                    if (classroom[nr].charAt(nc) == 'L') {

                        int id = litterId[nr][nc];

                        nextMask =
                            nextMask & ~(1 << id);
                    }

                    // Avoid repeated states
                    if (!visited[nr][nc][nextEnergy][nextMask]) {

                        visited[nr][nc][nextEnergy][nextMask] = true;

                        queue.offer(new int[]{
                            nr,
                            nc,
                            nextEnergy,
                            nextMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}