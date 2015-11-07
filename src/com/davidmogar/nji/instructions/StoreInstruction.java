package com.davidmogar.nji.instructions;

import com.davidmogar.nji.Context;

public class StoreInstruction implements Instruction {

    private char suffix;

    public StoreInstruction(char suffix) {
        this.suffix = suffix;
    }

    @Override
    public void execute(Context context) {
        int address;

        switch (suffix) {
            case 'b':
                byte b = context.stack.getByte(context.stackPointer);
                context.stackPointer += 1;
                address = context.stack.getInteger(context.stackPointer);
                context.stackPointer += 2;
                context.stack.setByte(b, address);
                break;
            case 'i':
                int i = context.stack.getInteger(context.stackPointer);
                context.stackPointer += 2;
                address = context.stack.getInteger(context.stackPointer);
                context.stackPointer += 2;
                context.stack.setInteger(i, address);
                break;
            case 'f':
                float f = context.stack.getFloat(context.stackPointer);
                context.stackPointer += 4;
                address = context.stack.getInteger(context.stackPointer);
                context.stackPointer += 2;
                context.stack.setFloat(f, address);
                break;
        }

        context.instructionPointer++;
    }

}
