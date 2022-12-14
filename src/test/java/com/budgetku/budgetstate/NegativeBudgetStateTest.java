package com.budgetku.budgetstate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.budgetku.core.state.NegativeBudgetState;
import org.junit.jupiter.api.Test;

public class NegativeBudgetStateTest {

    private final NegativeBudgetState mockNegativeBudgetState = new NegativeBudgetState();

    @Test
    public void NegativeBudgetStateGetSummaryShouldReturnNegativeBudgetStateSummary() {
        assertEquals("On Limit!",
            mockNegativeBudgetState.getSummary());
    }
}
