package com.davidmogar.nji.instructions.jump;

import com.davidmogar.nji.Context;
import com.davidmogar.nji.instructions.Instruction;

public class ZeroJumpInstruction implements Instruction {

    public String tag;

    public ZeroJumpInstruction(String tag) {
        this.tag = tag;
    }

    @Override
    public void execute(Context context) {

    }
    
}
