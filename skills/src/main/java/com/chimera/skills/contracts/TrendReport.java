package com.chimera.skills.contracts;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Immutable record representing trend analysis results.
 */
public record TrendReport(
    String keyword,
    double trendScore,
    Map<String, Long> engagementMetrics,
    LocalDateTime timestamp
) {}