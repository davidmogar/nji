package com.davidmogar.nji.instructions;

import com.davidmogar.nji.Context;

public class CallInstruction implements Instruction {

    private String tag;
    
    public CallInstruction(String tag) {
        this.tag = tag;
    }

    @Override
    public void execute(Context context) {

        /* Save next instruction pointer */
        context.stackPointer -= 2;
        context.stack.setInteger(context.instructionPointer + 1, context.stackPointer);

        /* Save previous base pointer */
        context.stackPointer -= 2;
        context.stack.setInteger(context.basePointer, context.stackPointer);

        /* Update instruction and stack pointer */
        context.basePointer = context.stackPointer;
        context.instructionPointer = context.tags.get(tag);
    }

}
