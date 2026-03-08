package com.example.worker.contracts;

/**
 * Message sent to a worker.
 */
public record WorkerMessage(String correlationId, String planId, String payload) {}
