# CLAUDE.md - Architectural Rules for Project Chimera

## Core Principles

### Business Logic Triggering
All business logic MUST be triggered by an interface defined in the `contracts` package of each module (planner, worker, judge). This ensures modularity and adherence to the FastRender Swarm Pattern.

### Immutability Enforcement
Immutability is non-negotiable:
- No `@Data` annotations or setters allowed.
- Use only Java Records for all DTOs and message objects.
- Records provide thread-safe, immutable state by design.

### Concurrency Policy
- **I/O Operations**: Must use Virtual Threads (`Executors.newVirtualThreadPerTaskExecutor()`) for efficient handling of blocking I/O.
- **Compute-Heavy Tasks**: Must use the standard `ForkJoinPool` for parallel computation to leverage multi-core CPUs effectively.

## Implementation Guidelines
- Always reference this file before making changes.
- Ensure all new code aligns with these rules to maintain architectural integrity.
- For any deviations, consult the project lead or update this document accordingly.