# Functional Specifications: User Stories

## Planner Agent

- As a Planner Agent, I need to decompose a viral trend into a 3-step content strategy so that the Worker swarm can execute atomic tasks efficiently.
- As a Planner Agent, I need to analyze campaign goals and break them down into parallelizable subtasks to optimize the FastRender Swarm execution.
- As a Planner Agent, I need to prioritize tasks based on urgency and dependencies to ensure timely content delivery.
- As a Planner Agent, I need to integrate with MCP Resources to discover available Worker capabilities before task assignment.

## Worker Agent

- As a Worker Agent, I need to use MCP tools to fetch real-time engagement data from Twitter so that content can be tailored to current trends.
- As a Worker Agent, I need to generate video scripts using AI models while maintaining brand voice consistency.
- As a Worker Agent, I need to execute tasks in parallel using Java 21 Virtual Threads to handle high-velocity content production.
- As a Worker Agent, I need to remain stateless and ephemeral, relying on immutable state passed via JSON messages.

## Judge Agent

- As a Judge Agent, I need to validate content against the Brand Voice Spec before it is published to prevent misalignment with brand guidelines.
- As a Judge Agent, I need to assign confidence scores to generated content to determine if Human-in-the-Loop (HITL) review is required.
- As a Judge Agent, I need to route low-confidence content back to the Planner for re-queuing and improvement.
- As a Judge Agent, I need to log validation results to PostgreSQL for operational auditing and continuous learning.