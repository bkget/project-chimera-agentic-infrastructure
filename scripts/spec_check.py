#!/usr/bin/env python3
"""
Spec Compliance Checker for Project Chimera

This script validates that specifications defined in specs/technical.md
are implemented in the source code under src/.
"""

import os
import sys
import re
from pathlib import Path

def extract_requirements(spec_file):
    """Extract key requirements from the technical spec file."""
    requirements = []

    try:
        with open(spec_file, 'r', encoding='utf-8') as f:
            content = f.read()

        # Look for key architectural requirements
        # These are patterns that indicate mandatory implementation features
        patterns = [
            r'record\s+(\w+)',  # Java Records
            r'Virtual Threads',  # Concurrency model
            r'correlationId',    # Traceability
            r'Java Records',     # Immutability
            r'Executors\.newVirtualThreadPerTaskExecutor',  # Virtual threads
        ]

        for pattern in patterns:
            matches = re.findall(pattern, content, re.IGNORECASE)
            if matches:
                # For records, extract the record names
                if 'record' in pattern.lower():
                    requirements.extend([f"record {match}" for match in matches])
                else:
                    requirements.extend(matches)

        # Remove duplicates while preserving order
        seen = set()
        requirements = [x for x in requirements if not (x in seen or seen.add(x))]

    except FileNotFoundError:
        print(f"Error: Spec file {spec_file} not found")
        sys.exit(1)
    except Exception as e:
        print(f"Error reading spec file: {e}")
        sys.exit(1)

    return requirements

def check_dto_immutability(src_dir):
    """Check that all DTOs are defined as Java Records."""
    violations = []

    # Find all Java files in src
    java_files = list(Path(src_dir).rglob("*.java"))

    for java_file in java_files:
        try:
            with open(java_file, 'r', encoding='utf-8') as f:
                content = f.read()

            # Look for class definitions that might be DTOs
            # Check if they use 'record' keyword
            class_matches = re.findall(r'\bclass\s+(\w+)', content)
            record_matches = re.findall(r'\brecord\s+(\w+)', content)

            for class_name in class_matches:
                # Skip if it's a record
                if class_name not in record_matches:
                    # Check if it looks like a DTO (has getters/setters or is simple)
                    # For now, flag any non-record class as potential violation
                    if not any(keyword in content for keyword in ['@Entity', '@Service', '@Controller']):
                        violations.append(f"Non-record class '{class_name}' in {java_file.name} - consider using Java Record for immutability")

        except Exception as e:
            print(f"Warning: Could not read {java_file}: {e}")

    return violations

def check_correlation_id_usage(src_dir):
    """Check for correlationId usage in API handlers."""
    violations = []

    # Find all Java files in src
    java_files = list(Path(src_dir).rglob("*.java"))

    correlation_id_found = False
    for java_file in java_files:
        try:
            with open(java_file, 'r', encoding='utf-8') as f:
                content = f.read()

            if 'correlationId' in content:
                correlation_id_found = True
                break

        except Exception as e:
            print(f"Warning: Could not read {java_file}: {e}")

    if not correlation_id_found:
        violations.append("correlationId not found in any source file - traceability requirement not implemented")

    return violations

def search_in_source(src_dir, requirements):
    """Search for requirements in source code files."""
    missing = []

    # Find all Java files in src
    java_files = list(Path(src_dir).rglob("*.java"))

    if not java_files:
        print(f"Warning: No Java files found in {src_dir}")
        return requirements  # All missing if no files

    # Read all source content
    source_content = ""
    for java_file in java_files:
        try:
            with open(java_file, 'r', encoding='utf-8') as f:
                source_content += f.read() + "\n"
        except Exception as e:
            print(f"Warning: Could not read {java_file}: {e}")

    # Check each requirement
    for req in requirements:
        if req.lower() not in source_content.lower():
            missing.append(req)

    return missing

def main():
    """Main validation function."""
    # Paths
    script_dir = Path(__file__).parent
    project_root = script_dir.parent
    spec_file = project_root / "specs" / "technical.md"
    src_dir = project_root / "src"

    print("🔍 Project Chimera Spec Compliance Checker")
    print("=" * 50)

    all_violations = []

    # 1. Extract and check spec requirements
    requirements = extract_requirements(spec_file)
    print(f"📋 Found {len(requirements)} requirements in spec:")
    for req in requirements:
        print(f"  • {req}")

    if requirements:
        missing = search_in_source(src_dir, requirements)
        if missing:
            all_violations.extend([f"Missing requirement: {req}" for req in missing])

    # 2. Check DTO immutability
    print("\n🔎 Checking DTO immutability...")
    dto_violations = check_dto_immutability(src_dir)
    if dto_violations:
        all_violations.extend(dto_violations)

    # 3. Check correlationId usage
    print("🔎 Checking correlationId traceability...")
    correlation_violations = check_correlation_id_usage(src_dir)
    if correlation_violations:
        all_violations.extend(correlation_violations)

    # Report results
    if all_violations:
        print(f"\n❌ FAILED: {len(all_violations)} violations found:")
        for violation in all_violations:
            print(f"  ✗ {violation}")
        print("\n💡 Fix violations to pass spec compliance")
        sys.exit(1)
    else:
        print("\n✅ SUCCESS: All spec requirements are implemented!")
        sys.exit(0)

if __name__ == "__main__":
    main()