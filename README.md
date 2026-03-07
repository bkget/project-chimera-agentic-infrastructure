# Project Chimera: Agentic Infrastructure

Architect a Factory that builds Autonomous Influencers.

## Architectural Vision

This project implements the **FastRender Swarm Pattern**, a multi-agent architecture designed for scalable, concurrent task execution in agentic systems. The pattern consists of three core components:

- **Planner**: Generates and decomposes high-level goals into executable tasks, ensuring strategic planning and task distribution.
- **Worker**: Executes tasks produced by the planner, handling the computational workload with high concurrency.
- **Judge**: Evaluates the results from workers, providing quality assurance and feedback loops to refine outputs.

### Why Java 21?
Java 21 (LTS) was chosen as the runtime for this agentic infrastructure due to its advanced concurrency features, particularly **Virtual Threads** (`Executors.newVirtualThreadPerTaskExecutor()`). Virtual threads enable efficient handling of I/O-bound operations without the overhead of traditional thread pools, while maintaining compatibility with existing Java ecosystems. Combined with immutable data structures (Java Records), this ensures thread-safe, scalable agent interactions essential for swarm-based systems.

## How to Run

### Prerequisites
- Java 21 JDK installed
- Maven 3.8+

### Build the Project
```bash
cd project-chimera-infrastructure
mvn clean install
```

### Run Individual Services
```bash
# Planner
java -jar planner/target/planner-1.0-SNAPSHOT.jar

# Worker
java -jar worker/target/worker-1.0-SNAPSHOT.jar

# Judge
java -jar judge/target/judge-1.0-SNAPSHOT.jar
```

### Run Tests
```bash
mvn test
```

## Project Structure
- `project-chimera-infrastructure/`: Maven multi-module project
  - `planner/`: Planning service module
  - `worker/`: Execution service module
  - `judge/`: Evaluation service module
- `research/`: Architectural research and strategy documents
- `specs/`: Functional and technical specifications
- `skills/`: Custom agent skills and configurations
