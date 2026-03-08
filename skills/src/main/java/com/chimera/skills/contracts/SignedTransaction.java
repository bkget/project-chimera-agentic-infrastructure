package com.chimera.skills.contracts;

/**
 * Immutable record for signed transaction result.
 */
public record SignedTransaction(
    String transactionId,
    String signature,
    String status
) {}