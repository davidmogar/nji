package com.davidmogar.nji.instructions;

import com.davidmogar.nji.Context;

public class RetInstruction implements Instruction {

    private int returnOffset;
    private int localVariablesOffset;
    private int parametersOffset;

    public RetInstruction(int returnOffset, int localVariablesOffset, int parametersOffset) {
        this.returnOffset = returnOffset;
        this.localVariablesOffset = localVariablesOffset;
        this.parametersOffset = parametersOffset;
    }

    @Override
    public void execute(Context context) {
        float value = readReturnedValue(context);

        context.stackPointer += returnOffset + localVariablesOffset + parametersOffset;
        context.basePointer = context.stack.getInteger(context.stackPointer);
        context.stackPointer += 2;
        context.instructionPointer = context.stack.getInteger(context.stackPointer);
        context.stackPointer += 2 - returnOffset;

        writeReturnedValue(value, context);
    }

    private float readReturnedValue(Context context) {
        float value = 0;

        switch (returnOffset) {
            case 1:
                value = context.stack.getByte(context.stackPointer);
                break;
            case 2:
                value = context.stack.getInteger(context.stackPointer);
                break;
            case 3:
                value = context.stack.getFloat(context.stackPointer);
                break;
        }

        return value;
    }

    private void writeReturnedValue(float value, Context context) {
        switch (returnOffset) {
            case 1:
                context.stack.setByte((byte) value, context.stackPointer);
                break;
            case 2:
                context.stack.setInteger((int) value, context.stackPointer);
                break;
            case 3:
                context.stack.setFloat(value, context.stackPointer);
                break;
        }
    }

}
