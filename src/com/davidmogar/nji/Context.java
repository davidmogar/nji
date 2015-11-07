package com.davidmogar.nji;

import java.util.HashMap;
import java.util.Map;

public class Context {

    private static final short STACK_SIZE = 2 * 1024; // 2Kb

    private Map<String, Byte> tags;
    private Stack stack;

    private short basePointer;
    private short instructionPointer;
    private short stackPointer;

    public Context() {
        tags = new HashMap<>();
        stack = new Stack(STACK_SIZE);

        basePointer = STACK_SIZE - 1;
        stackPointer = basePointer;
    }

}
