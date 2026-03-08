package com.chimera.judge.contracts;

/**
 * Immutable record representing evaluation request.
 */
public record JudgeMessage(String correlationId, String taskId, String result) {}
