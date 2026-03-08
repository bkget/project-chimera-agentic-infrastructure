package com.chimera.planner.contracts;

/**
 * Contract interface for the planner component of the FastRender swarm.
 */
public interface PlannerContract {
    /**
     * Initiates planning given a goal description.
     * @param goal description of what needs to be planned
     */
    void planTask(String goal);
}