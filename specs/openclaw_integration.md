# OpenClaw Integration Protocol Specification

## Overview
Project Chimera agents participate in the OpenClaw decentralized network using Decentralized Identifiers (DID) for secure, verifiable identity management. This specification defines the protocols for agent registration, status broadcasting, and skill discovery within the MoltBook ecosystem.

## 1. Identity Protocol (DID-Based)

### Agent Registration
Each Chimera agent registers with the OpenClaw network using a DID document:

```json
{
  "@context": "https://www.w3.org/ns/did/v1",
  "id": "did:openclaw:chimera-agent-001",
  "verificationMethod": [
    {
      "id": "did:openclaw:chimera-agent-001#keys-1",
      "type": "Ed25519VerificationKey2020",
      "controller": "did:openclaw:chimera-agent-001",
      "publicKeyMultibase": "z6Mk..."
    }
  ],
  "service": [
    {
      "id": "did:openclaw:chimera-agent-001#mcp",
      "type": "MCPResourceEndpoint",
      "serviceEndpoint": "https://api.chimera.ai/mcp/agent-001"
    }
  ]
}
```

### Content Signing with DIDs
Agents use their DID keys to cryptographically sign all generated content, ensuring authenticity and non-repudiation:

```json
{
  "content": "Viral video script content...",
  "metadata": {
    "author": "did:openclaw:chimera-agent-001",
    "timestamp": "2026-03-08T12:00:00Z",
    "correlationId": "req-12345"
  },
  "signature": {
    "type": "Ed25519Signature2020",
    "created": "2026-03-08T12:00:00Z",
    "verificationMethod": "did:openclaw:chimera-agent-001#keys-1",
    "proofValue": "z2tb...signature..."
  }
}
```

This allows content consumers to verify the agent's identity and content integrity.

## 2. Status Broadcasting (Pulse API)

### Pulse Message Schema
Agents broadcast their operational status via regular pulse messages:

```json
{
  "$schema": "https://openclaw.org/schemas/pulse/v1",
  "agentId": "did:openclaw:chimera-agent-001",
  "timestamp": "2026-03-08T12:00:00Z",
  "status": "Available",
  "workload": {
    "activeTasks": 2,
    "queueDepth": 5,
    "cpuUsage": 0.65
  },
  "signature": "eyJhbGciOiJFZDI1NTE5..."
}
```

### Status Types
- **Available**: Agent is ready to accept new tasks
- **Busy**: Agent is currently processing tasks

### Broadcasting Mechanism
- Messages are published to the OpenClaw pub/sub network
- Other agents subscribe to pulse topics for load balancing
- Status changes trigger immediate broadcasts

## 3. Skill Discovery (MCP Resource Protocol)

### Skills Manifest
Agents expose their capabilities through MCP Resources:

```json
{
  "@context": "https://openclaw.org/mcp/v1",
  "resourceId": "skills://chimera-agent-001/capabilities",
  "name": "Chimera Agent Skills",
  "description": "Available capabilities for content generation and analysis",
  "skills": [
    {
      "id": "trend-analyzer",
      "name": "Social Media Trend Analyzer",
      "description": "Analyzes viral trends across platforms",
      "inputSchema": {
        "type": "object",
        "properties": {
          "keyword": {"type": "string"},
          "platforms": {"type": "array", "items": {"type": "string"}}
        }
      },
      "outputSchema": {
        "type": "object",
        "properties": {
          "trendScore": {"type": "number"},
          "engagementMetrics": {"type": "object"}
        }
      },
      "pricing": {
        "currency": "USD",
        "perRequest": 0.10
      }
    },
    {
      "id": "content-generator",
      "name": "AI Content Generator",
      "description": "Generates viral content based on trends",
      "inputSchema": {
        "type": "object",
        "properties": {
          "topic": {"type": "string"},
          "style": {"type": "string"}
        }
      },
      "outputSchema": {
        "type": "object",
        "properties": {
          "content": {"type": "string"},
          "hashtags": {"type": "array"}
        }
      },
      "pricing": {
        "currency": "USD",
        "perRequest": 0.25
        }
    }
  ],
  "lastUpdated": "2026-03-08T12:00:00Z"
}
```

### Discovery Process
1. **Query**: Other agents query the MCP resource endpoint
2. **Filtering**: Agents filter skills by capability, pricing, and availability
3. **Negotiation**: Direct agent-to-agent communication for task assignment
4. **Execution**: Tasks are executed with real-time status updates

### Security Considerations
- All MCP communications are encrypted
- Skill manifests include capability attestations
- Pricing and availability are cryptographically signed
- Disputes are resolved through the OpenClaw arbitration network

## 4. Negotiation Protocol

### Task Request via MCP Tool Call
Sponsor Agents initiate collaboration by sending TaskRequest messages through MCP tool calls to Chimera Planner Agents:

**MCP Tool Call Example:**
```json
{
  "method": "tools/call",
  "params": {
    "name": "chimera_planner_request",
    "arguments": {
      "taskRequest": {
        "taskId": "task-456",
        "description": "Generate viral content for brand X",
        "priority": 8,
        "inputData": {
          "brand": "TechCorp",
          "topic": "AI innovation",
          "targetAudience": "developers"
        },
        "deadline": "2026-03-08T18:00:00Z",
        "correlationId": "sponsor-req-789"
      },
      "sponsorAgentId": "did:openclaw:sponsor-agent-002",
      "compensation": {
        "amount": 50,
        "currency": "USD",
        "paymentMethod": "crypto"
      }
    }
  }
}
```

### Negotiation Flow
1. **Discovery**: Sponsor agent queries Chimera planner's MCP endpoint
2. **Proposal**: Sponsor sends TaskRequest with compensation details
3. **Acceptance**: Chimera planner validates request and confirms availability
4. **Execution**: Task is delegated to worker swarm with real-time progress updates
5. **Completion**: Results delivered with cryptographic proof of work

### Trust Mechanisms
- All negotiations include cryptographic signatures
- Compensation is held in escrow until task completion
- Performance metrics are recorded on-chain for reputation tracking

This protocol enables seamless agent collaboration within the decentralized influencer factory ecosystem.</content>
<parameter name="filePath">c:\Users\bkget.SEBLI\Documents\GitHub-Personal\10x Challenges\Project Chimera The Agentic Infrastructure\project-chemera--agentic-infrastructure\specs\openclaw_integration.md