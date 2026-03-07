package com.example.worker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkerApp {
    public static void main(String[] args) {
        try (ExecutorService exec = Executors.newVirtualThreadPerTaskExecutor()) {
            exec.submit(() -> System.out.println("Worker responding on " + Thread.currentThread()));
        }
    }
}
