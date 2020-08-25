package com.company;

import com.sun.tools.javac.util.Pair;

// https://www.techiedelight.com/count-the-number-of-islands/
public class IslandProblem {

    public void run() {
        int[][] matrix = {
                { 1, 0, 1, 0, 0, 0, 1, 1, 1, 1 },
                { 0, 0, 1, 0, 1, 0, 1, 0, 0, 0 },
                { 1, 1, 1, 1, 0, 0, 1, 0, 0, 0 },
                { 1, 0, 0, 1, 0, 1, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 0, 0, 0, 1, 1, 1 },
                { 0, 1, 0, 1, 0, 0, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 1, 1, 1, 0 },
                { 1, 0, 1, 0, 1, 0, 0, 1, 0, 0 },
                { 1, 1, 1, 1, 0, 0, 0, 1, 1, 1 }
        };
        int result = islandProblem(matrix);
        System.out.println(result);
    }

    private int islandProblem(int[][] matrix) {
        // land is an area of connected 1
        // to find the area we do bfs until surrounded water
        // for that we keep processed array similar size as given
        int RL = matrix.length;
        int CL = matrix[0].length;
        int[][] processed = new int[RL][CL];
        // set processed matrix cells as 0
        for (int row=0; row<RL; row++) {
            for (int column = 0; column < CL; column++) {
                processed[row][column] = 0;
            }
        }
        int result = 0;
        for (int row=0; row<RL; row++) {
            for (int column=0; column<CL; column++) {
                // start with the node where it is a land and not proessed before
                if (matrix[row][column] == 1 && processed[row][column] == 0) {
                    bfs(row, column, processed, matrix);
                    result++;
                }
            }
        }
        return result;
    }

    // possible positions in coordinates around cell
    // x - 1, y + 1
    // x, y + 1
    // x + 1, y + 1
    // x - 1, y
    // x, y - skip
    // x + 1, y
    // x - 1, y - 1
    // x, y - 1
    // x + 1, y - 1
    int[] rows = {-1, 0, 1, -1, 1, -1, 0, 1};
    int[] columns = {1, 1, 1, 0, 0, 0, -1, -1, -1};

    private void bfs(int row, int column, int[][] processed, int[][] matrix) {
        java.util.Queue<com.sun.tools.javac.util.Pair<Integer, Integer>> queue = new java.util.ArrayDeque<>();
        queue.add(Pair.of(row, column));

        // mark node as processed
        processed[row][column] = 1;

        while (!queue.isEmpty()) {
            Integer x = queue.peek().fst;
            Integer y = queue.peek().snd;
            queue.poll();

            for (int i=0; i<rows.length; i++) {
                // check all surrounding areas for the cell
                // push to queue, when not water
                if (isLand(x + rows[i], y + columns[i], processed, matrix)) {
                    processed[x + rows[i]][y + columns[i]] = 1;
                    queue.add(Pair.of(x + rows[i], y + columns[i]));
                }
            }
        }
    }

    private boolean isLand(int row, int column, int[][] processed, int[][] matrix) {
        return row >= 0 && row < processed.length &&
                column >= 0 && column < processed[0].length &&
                matrix[row][column] == 1 && processed[row][column] == 0;
    }
}
