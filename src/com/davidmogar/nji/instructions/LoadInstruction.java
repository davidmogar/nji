package com.davidmogar.nji.instructions;

import com.davidmogar.nji.Context;

public class LoadInstruction implements Instruction {

    private char suffix;

    public LoadInstruction(char suffix) {
        this.suffix = suffix;
    }

    @Override
    public void execute(Context context) {
        int address = context.stack.getInteger(context.stackPointer);
        context.stackPointer += 2;

        switch (suffix) {
            case 'b':
                byte b = context.stack.getByte(address);
                context.stackPointer -= 1;
                context.stack.setByte(b, context.stackPointer);
                break;
            case 'i':
                int i = context.stack.getInteger(address);
                context.stackPointer -= 2;
                context.stack.setInteger(i, context.stackPointer);
                break;
            case 'f':
                float f = context.stack.getFloat(address);
                context.stackPointer -= 4;
                context.stack.setFloat(f, context.stackPointer);
                break;
        }

        context.instructionPointer++;
    }

}
