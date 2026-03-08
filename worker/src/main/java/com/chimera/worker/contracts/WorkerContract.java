package com.chimera.worker.contracts;

/**
 * Interface defining tasks that a worker can execute.
 */
public interface WorkerContract {
    /**
     * Process an incoming plan message.
     * @param plan plan data to execute
     */
    void executePlan(String plan);
}