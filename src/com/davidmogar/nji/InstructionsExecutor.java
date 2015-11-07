package com.davidmogar.nji;

import com.davidmogar.nji.instructions.Instruction;

import java.util.List;

public class InstructionsExecutor {

    private Context context;
    private List<Instruction> instructions;

    public InstructionsExecutor(List<Instruction> instructions) {
        this.instructions = instructions;

        context = new Context();
    }

    public void execute() {
        while (context.instructionPointer < instructions.size()) {
            instructions.get(context.instructionPointer).execute(context);
        }
    }

}
