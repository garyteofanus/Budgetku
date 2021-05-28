package com.budgetku.budgetstate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ExpiredBudgetStateTest {
    
    private final ExpiredBudgetState mockExpiredBudgetState = new ExpiredBudgetState();

    @Test
    public void ExpiredBudgetStateGetSummaryShouldReturnExpiredBudgetStateSummary() {
        assertEquals("This budget has expired!",
            mockExpiredBudgetState.getSummary());
    }
}
