# Project Chimera Master Control

.PHONY: setup test lint clean docker-test spec-check

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

# The Master Switch for CI/CD
all: setup lint test spec-check