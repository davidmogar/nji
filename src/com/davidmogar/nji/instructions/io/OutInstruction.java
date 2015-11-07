package com.davidmogar.nji.instructions.io;

import com.davidmogar.nji.Context;
import com.davidmogar.nji.instructions.Instruction;

public class OutInstruction implements Instruction {

    private char suffix;

    public OutInstruction(char suffix) {
        this.suffix = suffix;
    }

    @Override
    public void execute(Context context) {
        switch (suffix) {
            case 'b':
                System.out.print((char) context.stack.getByte(context.stackPointer));
                context.stackPointer++;
                break;
            case 'i':
                System.out.print(context.stack.getInteger(context.stackPointer));
                context.stackPointer += 2;
                break;
            case 'f':
                System.out.print(context.stack.getFloat(context.stackPointer));
                context.stackPointer += 4;
                break;
        }

        context.instructionPointer++;
    }

}
