package com.davidmogar.nji.instructions.cast;

import com.davidmogar.nji.Context;
import com.davidmogar.nji.instructions.Instruction;

public class IntegerToByteInstruction implements Instruction {

    @Override
    public void execute(Context context) {
        int value = context.stack.getInteger(context.stackPointer);
        context.stackPointer += 1;
        context.stack.setByte((byte) value, context.stackPointer);
        context.instructionPointer++;
    }
    
}
