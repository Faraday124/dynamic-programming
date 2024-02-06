package com.dp;

import java.util.HashMap;

public class MoneyChange {

    public static void main(String[] args) {
        MoneyChange moneyChange = new MoneyChange();
        System.out.println(moneyChange.change(950));
    }

    public int change(int m) {
        return change(m, new HashMap<>());
    }

    private int change(int m, HashMap<Integer, Integer> memo) {
        if (m == 0) {
            return 0;
        }
        if (m < 0) {
            return -1;
        }

        if (memo.containsKey(m)) {
            return memo.get(m);
        }

        int[] coins = {1, 3, 4};

        int count = -1;
        for (int c : coins) {
            int subAmount = m - c;
            int subCoins = change(subAmount, memo);
            if (subCoins != -1) {
                int numCoins = subCoins + 1;
                if (numCoins < count || count == -1) {
                    count = numCoins;
                }
            }
        }
        memo.put(m, count);
        return count;

    }
}
