package com.chimera.skills;

import com.chimera.skills.contracts.BalanceInfo;
import com.chimera.skills.contracts.SignedTransaction;
import com.chimera.skills.contracts.TransactionRequest;

/**
 * Skill interface for managing cryptocurrency wallet operations using Coinbase AgentKit.
 * Enables agents to perform financial transactions autonomously.
 */
public interface WalletManagerSkill {

    /**
     * Checks the balance of the specified wallet address.
     * @param walletAddress the address to check
     * @return BalanceInfo containing balance details
     */
    BalanceInfo checkBalance(String walletAddress);

    /**
     * Signs a transaction request.
     * @param request the transaction details to sign
     * @return SignedTransaction with signature and status
     * @throws RuntimeException if the transaction amount exceeds available budget
     */
    SignedTransaction signTransaction(TransactionRequest request);
}