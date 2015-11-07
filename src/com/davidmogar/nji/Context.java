package com.davidmogar.nji;

import java.util.HashMap;
import java.util.Map;

public class Context {

    private static final short STACK_SIZE = 2 * 1024; // 2Kb

    public Map<String, Byte> tags;
    public Stack stack;

    public short basePointer;
    public short instructionPointer;
    public short stackPointer;

    public Context() {
        tags = new HashMap<>();
        stack = new Stack(STACK_SIZE);

        basePointer = STACK_SIZE - 1;
        stackPointer = basePointer;
    }

}
