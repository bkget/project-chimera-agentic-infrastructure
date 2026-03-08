package com.chimera.skills;

import com.chimera.skills.contracts.BalanceInfo;
import com.chimera.skills.contracts.SignedTransaction;
import com.chimera.skills.contracts.TransactionRequest;
import com.chimera.skills.exceptions.BudgetExceededException;

import java.math.BigDecimal;

/**
 * Skill interface for managing cryptocurrency wallet operations using Coinbase AgentKit.
 * Enables agents to perform financial transactions autonomously.
 */
public abstract class WalletManagerSkill {

    /**
     * Checks the balance of the specified wallet address.
     * @param walletAddress the address to check
     * @return BalanceInfo containing balance details
     */
    public abstract BalanceInfo checkBalance(String walletAddress);

    /**
     * Signs a transaction request.
     * @param request the transaction details to sign
     * @return SignedTransaction with signature and status
     * @throws BudgetExceededException if the transaction amount exceeds available budget
     */
    public SignedTransaction signTransaction(TransactionRequest request) {
        // Default implementation with budget check
        BigDecimal budgetLimit = new BigDecimal("100000"); // Example budget limit
        if (request.amount().compareTo(budgetLimit) > 0) {
            throw new BudgetExceededException("Transaction amount " + request.amount() + " exceeds budget limit of " + budgetLimit);
        }
        // Simulate signing
        return new SignedTransaction("tx" + System.currentTimeMillis(), "signature", "signed");
    }
}