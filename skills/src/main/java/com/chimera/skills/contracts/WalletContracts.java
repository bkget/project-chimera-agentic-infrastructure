package com.chimera.skills.contracts;

import java.math.BigDecimal;

/**
 * Immutable record for balance information.
 */
public record BalanceInfo(
    String address,
    BigDecimal balance,
    String currency
) {}

/**
 * Immutable record for transaction request details.
 */
public record TransactionRequest(
    String toAddress,
    BigDecimal amount,
    String currency,
    String memo
) {}

/**
 * Immutable record for signed transaction result.
 */
public record SignedTransaction(
    String transactionId,
    String signature,
    String status
) {}