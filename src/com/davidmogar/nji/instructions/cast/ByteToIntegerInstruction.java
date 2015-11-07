package com.davidmogar.nji.instructions.cast;

import com.davidmogar.nji.Context;
import com.davidmogar.nji.instructions.Instruction;

public class ByteToIntegerInstruction implements Instruction {

    @Override
    public void execute(Context context) {
        byte value = context.stack.getByte(context.stackPointer);
        context.stackPointer -= 1;
        context.stack.setInteger(value, context.stackPointer);
        context.instructionPointer++;
    }

}
