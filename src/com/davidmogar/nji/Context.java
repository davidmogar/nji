package com.davidmogar.nji;

import java.util.HashMap;
import java.util.Map;

public class Context {

    private static final short STACK_SIZE = 1 * 1024; // 2Kb

    public Map<String, Short> tags;
    public Stack stack;

    public int basePointer;
    public int instructionPointer;
    public int stackPointer;

    public Context() {
        tags = new HashMap<>();
        stack = new Stack(STACK_SIZE);

        basePointer = STACK_SIZE;
        instructionPointer = 0;
        stackPointer = basePointer;
    }

}
