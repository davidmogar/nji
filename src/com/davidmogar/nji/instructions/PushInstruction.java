package com.davidmogar.nji.instructions;

import com.davidmogar.nji.Context;
import com.davidmogar.nji.instructions.Instruction;

public class PushInstruction implements Instruction {

    private char suffix;
    private float value;

    public PushInstruction() {
        this(Character.MIN_VALUE, Float.MIN_VALUE);
    }

    public PushInstruction(char suffix, float value) {
        this.suffix = suffix;
        this.value = value;
    }

    @Override
    public void execute(Context context) {
        switch (suffix) {
            case 'b':
                context.stackPointer -= 1;
                context.stack.setByte((byte) value, context.stackPointer);
                break;
            case 'i':
                context.stackPointer -= 2;
                context.stack.setInteger((int) value, context.stackPointer);
                break;
            case 'f':
                context.stackPointer -= 4;
                context.stack.setFloat(value, context.stackPointer);
                break;
            case Character.MIN_VALUE: // BP
                context.stackPointer -= 2;
                context.stack.setInteger(context.basePointer, context.stackPointer);
                break;
        }

        context.instructionPointer++;
    }

}
