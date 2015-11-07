package com.davidmogar.nji.instructions;

import com.davidmogar.nji.Context;

public class LogicInstruction implements Instruction {

    public enum Operation {
        AND, NOT, OR
    }

    public Operation operation;

    public LogicInstruction(Operation operation) {
        this.operation = operation;
    }

    @Override
    public void execute(Context context) {
        int value1, value2;

        switch (operation) {
            case AND:
                value1 = context.stack.getInteger(context.stackPointer);
                context.stackPointer += 2;
                value2 = context.stack.getInteger(context.stackPointer);
                context.stack.setInteger((value1 == value2)? 1 : 0, context.stackPointer);
                break;
            case OR:
                value1 = context.stack.getInteger(context.stackPointer);
                context.stackPointer += 2;
                value2 = context.stack.getInteger(context.stackPointer);
                context.stack.setInteger((value1 == 1 || value2 == 1)? 1 : 0, context.stackPointer);
                break;
            case NOT:
                value1 = context.stack.getInteger(context.stackPointer);
                context.stack.setInteger((value1 == 1)? 0 : 1, context.stackPointer);
                break;
        }

        context.instructionPointer++;
    }

}
