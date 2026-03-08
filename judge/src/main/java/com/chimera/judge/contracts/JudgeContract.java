package com.chimera.judge.contracts;

/**
 * Contract for judge that evaluates results from workers.
 */
public interface JudgeContract {
    /**
     * Evaluate output from a worker and return a verdict.
     * @param output data produced by worker
     * @return true if acceptable, false otherwise
     */
    boolean evaluate(String output);
}