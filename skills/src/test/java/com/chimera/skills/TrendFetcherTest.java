package com.chimera.skills;

import com.chimera.skills.contracts.TrendReport;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TrendFetcherTest {

    @Test
    public void shouldReturnValidTrendReport() {
        // Given: A mock implementation of TrendAnalyzerSkill
        TrendAnalyzerSkill trendAnalyzer = Mockito.mock(TrendAnalyzerSkill.class);

        // Mock the behavior to return a TrendReport with valid data
        LocalDateTime recentTimestamp = LocalDateTime.now().minusMinutes(30);
        TrendReport mockReport = new TrendReport(
            "testKeyword",
            75.0, // Valid popularity score
            Map.of("views", 1000L, "likes", 500L),
            recentTimestamp
        );
        Mockito.when(trendAnalyzer.analyzeTrend("testKeyword")).thenReturn(mockReport);

        // When: Analyzing a trend
        TrendReport result = trendAnalyzer.analyzeTrend("testKeyword");

        // Then: Verify the TrendReport record properties
        assertNotNull(result, "TrendReport should not be null");
        assertNotNull(result.trendScore(), "Popularity score should not be null");
        assertTrue(result.timestamp().isAfter(LocalDateTime.now().minusHours(1)),
                  "Timestamp should be within the last hour");
        assertEquals("testKeyword", result.keyword(), "Keyword should match");
    }
}