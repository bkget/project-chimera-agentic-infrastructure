# Project Chimera Master Control

.PHONY: setup test lint clean docker-test spec-check db-check

# Setup: Initialize the environment by building all modules without running tests
setup:
	mvn clean install -DskipTests

# Test: Run the full test suite across all modules
test:
	mvn test

# Lint: Run checkstyle to check code style and standards
lint:
	mvn checkstyle:check

# Clean: Clean all build artifacts
clean:
	mvn clean

# Docker test: Build and run tests in Docker container
docker-test:
	docker build -t chimera-governor .
	docker run --rm chimera-governor

# Spec check: Validate that specs are implemented in code
spec-check:
	python3 scripts/spec_check.py

# DB check: Verify schema.sql contains mandatory correlation_id column
db-check:
	@grep -q "correlation_id" src/main/resources/db/schema.sql && echo "✓ correlation_id found in agent_logs table" || (echo "✗ correlation_id missing from schema.sql" && exit 1)

# The Master Switch for CI/CD
all: setup lint test spec-check db-check