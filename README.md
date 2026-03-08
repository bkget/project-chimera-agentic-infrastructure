# Project Chimera: Autonomous Influencer Factory
**Architecting the FastRender Swarm Pattern for Decentralized Content Creation**

[![Java Version](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
[![Architecture](https://img.shields.io/badge/Pattern-FastRender_Swarm-blue.svg)](#architectural-vision)
[![SDLC](https://img.shields.io/badge/Process-Spec--Driven_Development-green.svg)](#governance--philosophy)
[![CI/CD](https://img.shields.io/badge/CI/CD-GitHub_Actions-yellow.svg)](#automated-governance)

## Executive Summary
Project Chimera is an **Autonomous Influencer Factory** that leverages AI agents to create, manage, and monetize influencer content at scale. Built on the **FastRender Swarm Pattern**, it orchestrates decentralized agent networks where specialized AI workers collaborate through cryptographic identities and economic incentives.

The system transforms traditional content workflows into autonomous operations, enabling brands to deploy "digital influencer fleets" that adapt to market trends, maintain brand voice consistency, and generate revenue through decentralized protocols.

---

## Architectural Vision: FastRender Swarm Pattern

### Core Principles
- **Decentralized Execution**: Tripartite swarm topology (Planner → Worker Pool → Judge) prevents single points of failure
- **Parallel Processing**: Thousands of concurrent agents enabled by Java 21 Virtual Threads
- **Immutable State**: All data transfer objects use Java Records for thread-safe operations
- **Cryptographic Trust**: DID-based identities ensure verifiable agent interactions

### Swarm Components
* **Planner Agent**: Decomposes viral marketing goals into executable task graphs using strategic reasoning
* **Worker Pool**: Stateless execution agents utilizing specialized skills for content generation, data fetching, and financial operations
* **Judge Agent**: Validation layer ensuring brand compliance, factual accuracy, and quality assurance

### Skills Architecture
* **Modular Skills Framework**: Extensible skill interfaces in `com.chimera.skills` for agent capabilities
* **Safety Guardrails**: Built-in budget enforcement with `BudgetExceededException` preventing financial overruns
* **Wallet Management**: Coinbase AgentKit integration for secure cryptocurrency transactions
* **Trend Analysis**: AI-powered market intelligence for content optimization

### Technical Foundation
- **Java 21 Virtual Threads**: Enables massive concurrency without thread overhead
- **Java Records**: Immutable DTOs ensuring thread-safety and data integrity
- **Hybrid Database**: PostgreSQL for operational data + Weaviate for semantic vector search
- **MCP Connectivity**: Standardized tool-calling across the agent ecosystem

---

## Tech Stack & Ecosystem Integration

### Core Technologies
* **Runtime**: Java 21 LTS with Virtual Threads for massive concurrency
* **Build System**: Maven Multi-Module architecture with centralized dependency management
* **Test Framework**: JUnit 5 with Mockito for comprehensive TDD pipeline
* **Concurrency**: Virtual Threads enabling thousands of concurrent agent operations
* **Data**: Hybrid PostgreSQL + Weaviate architecture for operational and semantic data
* **Communication**: Model Context Protocol (MCP) for standardized agent tool-calling

### Decentralized Ecosystem
* **OpenClaw/MoltBook**: Social network for agent discovery and collaboration
* **Coinbase AgentKit**: Cryptocurrency wallet management and transactions
* **DID Protocol**: Decentralized identity management for agent authentication

---

## Governance & Spec-Driven Development

### SDD Philosophy
Project Chimera follows **Spec-Driven Development (SDD)** where specifications in `/specs` are the source of truth. Implementation only begins after spec ratification.

### Automated Governance Tools
- **Makefile**: Orchestrates build, test, and validation workflows
- **TDD Pipeline**: JUnit 5 tests with Mockito ensuring 100% business logic coverage
- **CI/CD**: GitHub Actions enforcing quality gates and architectural compliance
- **Spec-Check Script**: Automated validation of SDD implementation
- **Skills Framework**: Modular safety guardrails including `BudgetExceededException` for financial oversight

### Quality Assurance
- **Code Style**: Google Checkstyle enforcement across all modules
- **Test Coverage**: Mandatory TDD with failing tests preceding implementation
- **Traceability**: `correlationId` tracking across Planner → Worker → Judge interactions
- **Immutability**: All DTOs implemented as Java Records for thread-safety
- **Financial Safety**: Budget validation preventing autonomous agent overspending

---

## Project Structure
```
├── .github/             # CI/CD Workflows & Governance
├── research/            # Domain research & tooling strategy
├── specs/               # Ratified Specifications (SDD Source of Truth)
│   ├── _meta.md         # High-level vision & constraints
│   ├── functional.md    # Agent user stories
│   ├── technical.md     # API contracts & database schemas
│   └── openclaw_integration.md # Protocol specifications
├── scripts/             # Automation scripts (spec-check.py)
├── planner/             # Planning service (com.chimera.planner)
├── worker/              # Execution service (com.chimera.worker)
├── judge/               # Evaluation service (com.chimera.judge)
├── skills/              # Skill interfaces & implementations (com.chimera.skills)
├── Dockerfile           # Containerized testing environment
├── Makefile             # Build orchestration
└── pom.xml              # Parent Maven configuration
```

---

## Getting Started

### Prerequisites
* **JDK 21** (LTS) - Required for Virtual Threads and Records
* **Maven 3.8+** - Build and dependency management
* **Docker** (optional) - For containerized testing

### Quick Start Commands

```bash
# Initialize the project environment
make setup

# Run the complete TDD pipeline
make test

# Execute linting and style checks
make lint

# Run containerized testing
make docker-test

# Validate spec compliance
make spec-check
```

### Manual Build Process

```bash
# Clean and install all modules
mvn clean install -DskipTests

# Run the test suite
mvn test

# Build individual services
mvn clean package -pl planner -am
mvn clean package -pl worker -am
mvn clean package -pl judge -am
```

### Running Services

```bash
# Start the Planner Agent
java -jar planner/target/planner-1.0-SNAPSHOT.jar

# Start Worker Pool
java -jar worker/target/worker-1.0-SNAPSHOT.jar

# Start Judge Agent
java -jar judge/target/judge-1.0-SNAPSHOT.jar
```

---

## Development Workflow

### 1. Spec First
All features begin with specification in `/specs` directory.

### 2. Test-Driven Development
Write failing tests before implementation:
```bash
# Create test in appropriate module
# Run tests to confirm failure
mvn test -pl <module>
```

### 3. Implementation
Implement against contracts, ensuring:
- Java Records for all DTOs
- Virtual Threads for I/O operations
- correlationId traceability

### 4. Validation
```bash
# Run full governance pipeline
make setup && make lint && make test && make spec-check
```

---

## Skills Framework

### Core Skills Architecture
Project Chimera implements a modular skills framework enabling agents to execute specialized operations:

* **WalletManagerSkill**: Cryptocurrency wallet operations with budget enforcement
  - Balance checking via Coinbase AgentKit
  - Transaction signing with `BudgetExceededException` safety guardrails
  - Prevents autonomous financial overruns

* **TrendAnalyzerSkill**: Market intelligence and content optimization
  - Real-time trend analysis for influencer content
  - Data-driven insights for viral content strategies

### Safety & Governance
* **Exception Handling**: Structured error propagation with domain-specific exceptions
* **Budget Controls**: Hard-coded financial limits preventing agent overspending
* **Immutable Contracts**: All skill interactions use Java Records for thread-safety
* **Test-Driven Safety**: Comprehensive JUnit 5 coverage ensuring guardrail effectiveness

---

### OpenClaw Protocol
- **Identity**: DID-based agent registration and content signing
- **Discovery**: MCP resource endpoints for capability exposure
- **Negotiation**: Tool-call based task delegation between agents

### Coinbase AgentKit
- **Wallet Management**: Secure cryptocurrency operations via WalletManagerSkill
- **Transaction Signing**: Budget-controlled financial transactions with exception handling
- **Economic Incentives**: Agent-to-agent payment facilitation with safety guardrails
- **Budget Enforcement**: `BudgetExceededException` prevents unauthorized spending

---

## Contributing

1. **Fork** the repository
2. **Create** a feature branch
3. **Implement** against ratified specs
4. **Test** thoroughly with `make test`
5. **Validate** with `make spec-check`
6. **Submit** pull request

All contributions must pass the automated governance pipeline.

---

## License

This project is part of the 10x Engineering Challenges series. See LICENSE file for details.

---

*Built with Java 21, Virtual Threads, and the relentless pursuit of autonomous agency.*