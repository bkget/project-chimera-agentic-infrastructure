# Project Chimera: The Agentic Infrastructure Factory 
**Architecting a Scalable Foundation for Autonomous Influencer Networks**

[![Java Version](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
[![Architecture](https://img.shields.io/badge/Pattern-FastRender_Swarm-blue.svg)](#architectural-vision)
[![SDLC](https://img.shields.io/badge/Process-Spec--Driven_Development-green.svg)](#governance--philosophy)

## Executive Summary
Project Chimera represents a paradigm shift from automated content scheduling to **Autonomous Agentic Agency**. This repository implements the core infrastructure for a "Factory" capable of managing a fleet of digital influencers. By leveraging **Java 21 Virtual Threads**, the **Model Context Protocol (MCP)**, and the **FastRender Swarm Pattern**, we have established a strictly-typed engineering environment where Intent (Specs) is the source of truth.

---

## Architectural Vision: The FastRender Swarm
Unlike fragile sequential chains, Chimera utilizes a decentralized, tripartite swarm topology designed for massive parallel execution and hallucination mitigation.



### Core Components
* **The Planner (Strategist):** Decomposes high-level influencer goals (e.g., "Increase engagement on Tech-Twitter") into atomic, executable tasks using LLM-driven reasoning.
* **The Worker Pool (Executioner):** A fleet of stateless, ephemeral agents that execute tasks—from trend analysis to content generation—via MCP-standardized tools.
* **The Judge (Governor):** A mandatory validation layer that critiques worker output against brand-voice specs and factual accuracy before any data is committed.

### Why Java 21 & Virtual Threads?
For an infrastructure managing thousands of concurrent agents, traditional thread-per-request models fail due to stack memory overhead. We utilize **Project Loom (Virtual Threads)** to allow:
1.  **Massive Concurrency:** Scaling to 1,000+ concurrent worker sub-processes on standard hardware.
2.  **Synchronous Clarity:** Writing simple, blocking I/O code that performs with the efficiency of complex asynchronous frameworks.
3.  **Immutable State:** Leveraging **Java Records** for all DTOs, ensuring thread-safe state management for Optimistic Concurrency Control (OCC).

---

## Tech Stack & Integration
* **Runtime:** Java 21 (LTS)
* **Build System:** Maven (Multi-Module)
* **Orchestration:** FastRender Swarm Pattern
* **Connectivity:** Model Context Protocol (MCP) for universal tool-calling
* **Identity & Commerce:** Coinbase AgentKit & OpenClaw Protocol integration for agentic economic agency.
* **Data Strategy:** Hybrid approach using **PostgreSQL** (Operational State) and **Weaviate** (Vector Memory).

---

## Governance & Philosophy
This project follows **Spec-Driven Development (SDD)**. No implementation code is committed until the Specification is ratified in the `specs/` directory.



### Traceability
Every interaction within the swarm is tagged with a `correlationId`. This ensures 100% auditability, allowing us to trace a specific social media post back to the original Planner intent and the specific Judge validation.

---

## Project Structure
```text
├── .github/             # CI/CD Workflows & Governance
├── research/            # Domain research (OpenClaw, a16z stack, SRS analysis)
├── specs/               # Ratified Specifications (The Source of Truth)
│   ├── _meta.md         # High-level vision & constraints
│   ├── functional.md    # Agent user stories
│   └── technical.md     # API Contracts & ERDs
├── planner/             # Planning service (Java 21)
├── worker/              # Execution service (Java 21)
├── judge/               # Evaluation service (Java 21)
└── pom.xml              # Parent Maven configuration
```
---

## Getting Started

### Prerequisites
To maintain the "Orchestrator" environment standards, ensure the following are installed:
* **JDK 21** (LTS) - *Mandatory for Virtual Threads and Record support.*
* **Maven 3.8+** - *Primary build and dependency management tool.*
* **Tenx MCP Sense** - *Required for real-time architectural traceability and feedback.*

### Build & Test
Execute the following commands from the root directory (`project-chimera-infrastructure`) to validate the environment and contract integrity:

```bash
# Clean previous builds and install all modules to the local repository
mvn clean install

# Execute the Test-Driven Development (TDD) suite
mvn test
```
---

### Running Services
Each module is a standalone service that communicates via the shared contract layer:

```bash
# Start the Strategic Planner
java -jar planner/target/planner-1.0-SNAPSHOT.jar

# Start the Execution Worker Pool
java -jar worker/target/worker-1.0-SNAPSHOT.jar

# Start the Governance Judge
java -jar judge/target/judge-1.0-SNAPSHOT.jar
```
---

### Project Verification
After starting the services, verify the Tenx MCP logs to ensure the connection is active. A successful initialization will show as a "Handshake" event in your MCP analysis dashboard, confirming your Day 2 environment is ready for implementation logic.