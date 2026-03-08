-- Project Chimera Database Schema
-- Implements the ERD from technical.md specifications
-- PostgreSQL compatible

-- Influencer Profiles: Store brand voice and metadata
CREATE TABLE influencer_profiles (
    profile_id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    brand_voice_spec TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Video Metadata: Track generated content
CREATE TABLE video_metadata (
    video_id VARCHAR(255) PRIMARY KEY,
    profile_id VARCHAR(255) NOT NULL,
    title VARCHAR(255),
    hashtags TEXT[], -- PostgreSQL array for multiple hashtags
    engagement_score FLOAT,
    published_at TIMESTAMP,
    FOREIGN KEY (profile_id) REFERENCES influencer_profiles(profile_id)
);

-- Agent Logs: Crucial for traceability, linking actions to correlationId
CREATE TABLE agent_logs (
    log_id VARCHAR(255) PRIMARY KEY,
    video_id VARCHAR(255),
    agent_type VARCHAR(50),
    action VARCHAR(255),
    details JSONB, -- PostgreSQL JSONB for flexible details
    logged_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    correlation_id VARCHAR(255) NOT NULL, -- Mandatory for Orchestrator-level auditability
    FOREIGN KEY (video_id) REFERENCES video_metadata(video_id)
);

-- Indexes for performance and traceability
CREATE INDEX idx_agent_logs_correlation_id ON agent_logs(correlation_id);
CREATE INDEX idx_video_metadata_profile_id ON video_metadata(profile_id);
CREATE INDEX idx_agent_logs_video_id ON agent_logs(video_id);