package com.davidmogar.nji.instructions;

import com.davidmogar.nji.Context;

public class RetInstruction implements Instruction {

    private int returnOffset;
    private int localVariablesOffset;
    private int parametersOffset;

    public RetInstruction(int returnOffset, int localVariablesOffset, int parametersOffset) {
        this.returnOffset = returnOffset;
        this.localVariablesOffset = localVariablesOffset;
        this.parametersOffset = parametersOffset;
    }

    @Override
    public void execute(Context context) {
        context.stackPointer += returnOffset + localVariablesOffset + parametersOffset;
        context.basePointer = context.stack.getInteger(context.stackPointer);
        context.stackPointer += 2;
        context.instructionPointer = context.stack.getInteger(context.stackPointer);
        context.stackPointer += 2;
    }

}
