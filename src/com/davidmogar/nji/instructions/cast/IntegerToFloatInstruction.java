package com.davidmogar.nji.instructions.cast;

import com.davidmogar.nji.Context;
import com.davidmogar.nji.instructions.Instruction;

public class IntegerToFloatInstruction implements Instruction {

    @Override
    public void execute(Context context) {
        int value = context.stack.getInteger(context.stackPointer);
        context.stackPointer -= 2;
        context.stack.setFloat(value, context.stackPointer);
        context.instructionPointer++;
    }

}
