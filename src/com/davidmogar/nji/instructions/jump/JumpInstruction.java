package com.davidmogar.nji.instructions.jump;

import com.davidmogar.nji.Context;
import com.davidmogar.nji.instructions.Instruction;

public class JumpInstruction implements Instruction {

    public String tag;

    public JumpInstruction(String tag) {
        this.tag = tag;
    }

    @Override
    public void execute(Context context) {
        context.instructionPointer = context.tags.get(tag);
    }

}
