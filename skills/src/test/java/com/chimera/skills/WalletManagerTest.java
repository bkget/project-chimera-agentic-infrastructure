package com.chimera.skills;

import com.chimera.skills.contracts.BalanceInfo;
import com.chimera.skills.contracts.TransactionRequest;
import com.chimera.skills.exceptions.BudgetExceededException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class WalletManagerTest {

    @Test
    public void shouldThrowExceptionWhenBudgetExceeded() {
        // USE THE REAL IMPLEMENTATION, NOT A MOCK
        WalletManagerSkill walletManager = new WalletManagerSkill() {
            @Override
            public BalanceInfo checkBalance(String address) { return null; }
        };

        TransactionRequest highAmountRequest = new TransactionRequest(
            "recipientAddress",
            new BigDecimal("150000"), // 150k is over the 100k limit in the code
            "USD",
            "Test transaction"
        );

        // This will FAIL if you comment out the check in the actual class
        assertThrows(BudgetExceededException.class, () -> {
            walletManager.signTransaction(highAmountRequest);
        });
    }
}