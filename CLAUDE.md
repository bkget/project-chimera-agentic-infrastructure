# CLAUDE.md - Prime Directive for Project Chimera

## Project Context
Project Chimera: An Autonomous Influencer Factory.

## The First Rule
NEVER generate code without first reading and validating against the files in /specs.

## Tech Stack Constraints
- Java 21+ only.
- Mandatory use of Java Records for all DTOs.
- Virtual Threads for I/O.

## Testing Protocol
No logic is 'Done' until a corresponding JUnit 5 test exists in /src/test.

## Traceability
Explain your architectural plan in 2 sentences before writing any code blocks.