package com.budgetku.budgetstate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NegativeBudgetStateTest {

    private final NegativeBudgetState mockNegativeBudgetState = new NegativeBudgetState();

    @Test
    public void NegativeBudgetStateGetSummaryShouldReturnNegativeBudgetStateSummary() {
        assertEquals("This budget has negative amount of money!!",
            mockNegativeBudgetState.getSummary());
    }
}
