package com.davidmogar.nji.instructions.jump;

import com.davidmogar.nji.Context;
import com.davidmogar.nji.instructions.Instruction;

public class NonZeroJumpInstruction implements Instruction {

    public String tag;

    public NonZeroJumpInstruction(String tag) {
        this.tag = tag;
    }

    @Override
    public void execute(Context context) {

    }
    
}
