package com.davidmogar.nji;

import java.util.HashMap;
import java.util.Map;

public class Context {

    private static final int STACK_SIZE = 2 * 1024; // 2Kb

    private Map<String, Byte> tags;
    private Stack stack;

    private byte basePointer;
    private byte instructionPointer;
    private byte stackPointer;

    public Context() {
        tags = new HashMap<>();
        stack = new Stack(STACK_SIZE);
    }

}
