package com.chimera.planner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Simple entry point demonstrating virtual thread executor for planner.
 */
public class PlannerApp {
    public static void main(String[] args) {
        try (ExecutorService exec = Executors.newVirtualThreadPerTaskExecutor()) {
            exec.submit(() -> System.out.println("Planner running on " + Thread.currentThread()));
        }
    }
}