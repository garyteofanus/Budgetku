package com.budgetku.budgetstate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NormalBudgetStateTest {

    private final NormalBudgetState mockNormalBudgetState = new NormalBudgetState();

    @Test
    public void NormalBudgetStateGetSummaryShouldReturnNormalBudgetStateSummary() {
        assertEquals("Current budget value is normal!",
            mockNormalBudgetState.getSummary());
    }
}
