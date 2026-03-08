package com.chimera.skills.contracts;

import java.math.BigDecimal;

/**
 * Immutable record for transaction request details.
 */
public record TransactionRequest(
    String toAddress,
    BigDecimal amount,
    String currency,
    String memo
) {}