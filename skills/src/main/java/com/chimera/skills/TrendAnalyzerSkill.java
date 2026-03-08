package com.chimera.skills;

import com.chimera.skills.contracts.TrendReport;

/**
 * Skill interface for analyzing social media trends.
 * Implementation should use MCP tools to fetch real-time data.
 */
public interface TrendAnalyzerSkill {

    /**
     * Analyzes trends for the given keyword.
     * @param keyword the search term to analyze
     * @return TrendReport containing analysis results
     */
    TrendReport analyzeTrend(String keyword);
}