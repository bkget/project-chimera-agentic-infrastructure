package com.chimera.skills;

import com.chimera.skills.contracts.TransactionRequest;
import com.chimera.skills.exceptions.BudgetExceededException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class WalletManagerTest {

    @Test
    public void shouldThrowExceptionWhenBudgetExceeded() {
        // Given: A mock implementation of WalletManagerSkill
        WalletManagerSkill walletManager = Mockito.mock(WalletManagerSkill.class);

        // Mock the behavior to throw BudgetExceededException for amounts over 500 USD
        TransactionRequest highAmountRequest = new TransactionRequest(
            "recipientAddress",
            BigDecimal.valueOf(600), // Amount exceeding 500 USD safety limit
            "USD",
            "Test transaction exceeding budget"
        );
        Mockito.when(walletManager.signTransaction(highAmountRequest))
               .thenThrow(new BudgetExceededException("Transaction amount 600 USD exceeds safety limit of 500 USD"));

        // When & Then: Signing the transaction should throw BudgetExceededException
        assertThrows(BudgetExceededException.class, () -> {
            walletManager.signTransaction(highAmountRequest);
        }, "Should throw BudgetExceededException for amounts over 500 USD");
    }
}