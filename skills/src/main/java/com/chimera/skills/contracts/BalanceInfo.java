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