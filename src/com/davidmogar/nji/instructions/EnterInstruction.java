package com.davidmogar.nji.instructions;

import com.davidmogar.nji.Context;

public class EnterInstruction implements Instruction {

    private int size;
    
    public EnterInstruction(int size) {
        this.size = size;
    }

    @Override
    public void execute(Context context) {

    }

}
