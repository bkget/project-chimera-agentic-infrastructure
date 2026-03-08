# Skills Directory - Input/Output Contracts

This directory contains the skill interfaces that define the contracts for critical agent capabilities in Project Chimera. Each skill represents an "Empty Slot" for implementation, ensuring modularity and testability.

## Skill Contracts

### 1. Trend Analyzer Skill
**Purpose**: Analyzes social media trends for a given keyword to inform content generation strategies.

**Interface**: `com.chimera.skills.TrendAnalyzerSkill`

**Input**: 
- `keyword` (String): The search term to analyze trends for

**Output**: 
- `TrendReport` (Record in `com.chimera.skills.contracts`): Contains trend analysis data including:
  - `keyword` (String): The analyzed keyword
  - `trendScore` (double): Numerical score indicating trend strength (0.0 to 1.0)
  - `engagementMetrics` (Map<String, Long>): Key metrics like views, likes, shares
  - `timestamp` (LocalDateTime): When the analysis was performed

### 2. Wallet Manager Skill
**Purpose**: Manages cryptocurrency wallet operations using Coinbase AgentKit for agent-to-agent transactions and financial autonomy.

**Interface**: `com.chimera.skills.WalletManagerSkill`

**Operations**:
- **Check Balance**: 
  - Input: `walletAddress` (String)
  - Output: `BalanceInfo` (Record in `com.chimera.skills.contracts`) with `address` (String), `balance` (BigDecimal), `currency` (String)

- **Sign Transaction**:
  - Input: `TransactionRequest` (Record in `com.chimera.skills.contracts`) with `toAddress` (String), `amount` (BigDecimal), `currency` (String), `memo` (String)
  - Output: `SignedTransaction` (Record in `com.chimera.skills.contracts`) with `transactionId` (String), `signature` (String), `status` (String)

## Implementation Notes
- All skills must be implemented as Java interfaces first, then concrete classes.
- Use Java Records for all DTOs to ensure immutability.
- Implementations should leverage Virtual Threads for I/O operations.
- Each skill must have corresponding JUnit 5 tests in `/src/test`.
- Skills should integrate with MCP for external tool calling where appropriate.