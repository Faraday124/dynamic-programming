package com.dp;

import java.util.HashMap;
import java.util.List;

public class MaxPaths {

    public static void main(String[] args) {

        List<List<Integer>> grid = List.of(
                List.of(1, 3, 12),
                List.of(5, 6, 2)
        );

        System.out.println(new MaxPaths().maxPaths(grid));
    }

    public int maxPaths(List<List<Integer>> grid) {
        return maxPaths(0, 0, grid, new HashMap<>());
    }

    private int maxPaths(int row, int column, List<List<Integer>> grid, HashMap<List<Integer>, Integer> memo) {
        if (row == grid.size() || column == grid.get(0).size()) {
            return Integer.MIN_VALUE;
        }
        if (row == grid.size() - 1 && column == grid.get(0).size() - 1) {
            return grid.get(row).get(column);
        }

        List<Integer> position = List.of(row, column);
        if (memo.containsKey(position)) {
            return memo.get(position);
        }

        int result = grid.get(row).get(column) + Math.max(maxPaths(row + 1, column, grid, memo), maxPaths(row, column + 1, grid, memo));

        memo.put(position, result);
        
        return result;
    }
}
