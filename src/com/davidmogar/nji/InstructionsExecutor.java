package com.davidmogar.nji;

import com.davidmogar.nji.instructions.Instruction;
import com.davidmogar.nji.instructions.TagInstruction;

import java.util.Iterator;
import java.util.List;

public class InstructionsExecutor {

    private Context context;
    private List<Instruction> instructions;

    public InstructionsExecutor(List<Instruction> instructions) {
        this.instructions = instructions;

        context = new Context();
        prepareContext();
    }

    public void execute() {
        while (context.instructionPointer < instructions.size()) {
            instructions.get(context.instructionPointer).execute(context);
        }
    }

    private void prepareContext() {
        Iterator<Instruction> iterator = instructions.iterator();

        short i = 0;
        while(iterator.hasNext()) {
            Instruction instruction = iterator.next();
            if (instruction instanceof TagInstruction) {
                String tag = ((TagInstruction) instruction).getName();
                context.tags.put(tag, i);
                iterator.remove();
            } else {
                i++;
            }
        }
    }

}
