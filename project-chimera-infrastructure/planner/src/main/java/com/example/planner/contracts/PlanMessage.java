package com.example.planner.contracts;

/**
 * Immutable message recorded by the planner.
 */
public record PlanMessage(String correlationId, String taskId, String description) {}
