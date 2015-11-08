package com.davidmogar.nji.instructions.arithmetic;

import com.davidmogar.nji.Context;
import com.davidmogar.nji.instructions.Instruction;

public class AddInstruction implements Instruction {

    private char suffix;

    public AddInstruction(char suffix) {
        this.suffix = suffix;
    }

    @Override
    public void execute(Context context) {
        switch (suffix) {
            case 'b':
                byte b1 = context.stack.getByte(context.stackPointer);
                context.stackPointer++;
                byte b2 = context.stack.getByte(context.stackPointer);
                context.stack.setByte((byte) (b2 + b1), context.stackPointer);
                break;
            case 'i':
                int i1 = context.stack.getInteger(context.stackPointer);
                context.stackPointer += 2;
                int i2 = context.stack.getInteger(context.stackPointer);
                context.stack.setInteger(i2 + i1, context.stackPointer);
                break;
            case 'f':
                float f1 = context.stack.getFloat(context.stackPointer);
                context.stackPointer += 4;
                float f2 = context.stack.getFloat(context.stackPointer);
                context.stack.setFloat(f2 + f1, context.stackPointer);
                break;
        }

        context.instructionPointer++;
    }

}
