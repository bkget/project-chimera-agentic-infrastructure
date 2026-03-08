package com.chimera.worker;

import com.chimera.skills.WalletManagerSkill;
import com.chimera.skills.contracts.BalanceInfo;
import com.chimera.skills.contracts.SignedTransaction;
import com.chimera.skills.contracts.TransactionRequest;
import com.chimera.skills.exceptions.BudgetExceededException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WorkerAppTest {
    @Test
    void sanity() {
        assertTrue(true);
    }

    @Test
    void testWalletManagerSkillThrowsBudgetExceededException() {
        // Implementation using default signTransaction with budget check
        WalletManagerSkill skill = new WalletManagerSkill() {
            @Override
            public BalanceInfo checkBalance(String walletAddress) {
                return new BalanceInfo("address", new BigDecimal("100000"), "USD");
            }
            // signTransaction inherited with budget validation
        };

        TransactionRequest request = new TransactionRequest("toAddress", new BigDecimal("1000000"), "USD", "large transaction");
        // This should now pass as the default implementation throws BudgetExceededException
        assertThrows(BudgetExceededException.class, () -> skill.signTransaction(request));
    }
}