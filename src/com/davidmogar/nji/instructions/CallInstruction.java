package com.davidmogar.nji.instructions;

import com.davidmogar.nji.Context;

public class CallInstruction implements Instruction {

    private String tag;
    
    public CallInstruction(String tag) {
        this.tag = tag;
    }

    @Override
    public void execute(Context context) {

    }

}
