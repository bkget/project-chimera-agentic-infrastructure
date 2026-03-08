package com.chimera.skills.exceptions;

/**
 * Runtime exception thrown when a skill operation exceeds its allocated budget,
 * particularly for Coinbase AgentKit operations. This is an unchecked exception
 * to allow flexible error handling in agent workflows.
 */
public class BudgetExceededException extends RuntimeException {

    /**
     * Constructs a new BudgetExceededException with the specified detail message.
     * @param message the detail message
     */
    public BudgetExceededException(String message) {
        super(message);
    }

    /**
     * Constructs a new BudgetExceededException with the specified detail message and cause.
     * @param message the detail message
     * @param cause the cause of this exception
     */
    public BudgetExceededException(String message, Throwable cause) {
        super(message, cause);
    }
}