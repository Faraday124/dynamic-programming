package com.dp;

import java.util.HashMap;
import java.util.List;

public class CountPaths {


    public static void main(String[] args) {

        List<List<String>> grid = List.of(
                List.of("", "", "X"),
                List.of("", "", ""),
                List.of("", "", "")
        );

        System.out.println(new CountPaths().countPaths(grid));

    }

    public int countPaths(List<List<String>> grid) {
        return countPaths(0, 0, grid, new HashMap<>());
    }

    private int countPaths(int row, int column, List<List<String>> grid, HashMap<List<Integer>, Integer> memo) {
        if (row == grid.size() || column == grid.get(0).size()) {
            return 0;
        }
        if (row == grid.size() - 1 && column == grid.get(0).size() - 1) {
            return 1;
        }

        if (grid.get(row).get(column).equals("X")) {
            return 0;
        }

        List<Integer> position = List.of(row, column);
        if(memo.containsKey(position)){
            return memo.get(position);
        }

        int result = countPaths(row + 1, column, grid, memo) + countPaths(row, column + 1, grid, memo);

        memo.put(position, result);

        return result;
    }
}
