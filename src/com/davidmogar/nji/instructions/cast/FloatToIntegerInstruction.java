package com.davidmogar.nji.instructions.cast;

import com.davidmogar.nji.Context;
import com.davidmogar.nji.instructions.Instruction;

public class FloatToIntegerInstruction implements Instruction {

    @Override
    public void execute(Context context) {
        float value = context.stack.getFloat(context.stackPointer);
        context.stackPointer += 2;
        context.stack.setInteger((int) value, context.stackPointer);
        context.instructionPointer++;
    }
    
}
