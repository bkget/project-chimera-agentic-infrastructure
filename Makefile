# Makefile for Project Chimera

.PHONY: setup test lint clean

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