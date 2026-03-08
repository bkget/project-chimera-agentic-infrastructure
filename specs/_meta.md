# Project Chimera: Decentralized Influencer Factory

## High-Level Vision

Project Chimera is envisioned as a decentralized Influencer Factory, leveraging autonomous AI agents to create, manage, and monetize influencer content at scale. By integrating with the OpenClaw ecosystem and MoltBook, Chimera enables agents to operate as independent entities with verifiable identities, forming a social network of specialized AI influencers that collaborate on tasks while maintaining cryptographic security and non-custodial control.

## Primary Constraints

1. **Java 21**: All components must be built using Java 21 (LTS) to leverage modern features like Virtual Threads for efficient concurrency in the swarm pattern.

2. **FastRender Swarm Pattern**: The architecture follows a Hierarchical Swarm pattern with Planner, Worker Pool, and Judge components, utilizing Java 21 Virtual Threads for parallel execution and stateless, ephemeral workers.

3. **Model Context Protocol (MCP)**: MCP serves as the mandatory connectivity layer for agent-to-agent communication, resource discovery, and tool-calling standardization across the OpenClaw network.

## Key Principles

- **Immutable Agent State**: All agent state must be immutable to ensure thread-safety, predictability, and ease of debugging in a concurrent environment. Use Java Records for all data transfer objects and state representations.