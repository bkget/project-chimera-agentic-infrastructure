# Multi-Agent System (FastRender Swarm Pattern)

This Maven multi-module project targets **Java 21** and uses virtual threads for concurrency. It provides three services:

- **planner** – generates tasks and plans
- **worker** – executes tasks produced by the planner
- **judge** – evaluates results from workers

Each module includes a `contracts` package defining interfaces and immutable message records.

## Build & Run

```bash
# from the project root
target/java21
mvn clean install

# run a specific service
java -jar planner/target/planner-1.0-SNAPSHOT.jar
``` 

All modules share common dependency management (Jackson and JUnit 5) defined in the parent POM.

## Notes

- Compiler configured with `<release>21</release>` and preview features enabled.
- DTOs use Java `record` for thread-safe immutable state.
