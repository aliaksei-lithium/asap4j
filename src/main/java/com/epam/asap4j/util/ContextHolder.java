package com.epam.asap4j.util;

import java.util.Stack;

/**
 * Thread-local holder for execution context. Supports internal stack for
 * CONTEXTS, meaning that nested actions are also supported.
 *
 * @author Ivan_Zauharodneu
 * @version 1.0
 */
public final class ContextHolder {

    /**
     * Constructor.
     */
    private ContextHolder() {
    }

    /**
     * Thread context.
     */
    private static final ThreadLocal<Stack<ExecutionContext>> CONTEXTS = new ThreadLocal<Stack<ExecutionContext>>() {

        @Override
        protected Stack<ExecutionContext> initialValue() {
            return new Stack<ExecutionContext>();
        }
    };

    /**
     * Get execution context.
     *
     * @return current {@link ExecutionContext}.
     */
    public static ExecutionContext getContext() {
        return CONTEXTS.get().peek();
    }

    /**
     * Pushes {@link ExecutionContext} on the stack.
     *
     * @param context context to push.
     */
    public static void setContext(ExecutionContext context) {
        CONTEXTS.get().push(context);
    }

    /**
     * Pops {@link ExecutionContext} from the stack.
     */
    public static void unsetContext() {
        CONTEXTS.get().pop();
    }
}
