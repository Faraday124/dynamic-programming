package com.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MoneyChangeTest {

    @Test
    public void shouldReturnCorrectValue() {

        MoneyChange moneyChange = new MoneyChange();

        Assertions.assertEquals(1, moneyChange.change(1));
        Assertions.assertEquals(1, moneyChange.change(4));
        Assertions.assertEquals(2, moneyChange.change(6));
        Assertions.assertEquals(238, moneyChange.change(950));
        Assertions.assertEquals(237, moneyChange.change(948));
    }

}