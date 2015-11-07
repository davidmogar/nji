package com.davidmogar.nji.instructions;

import com.davidmogar.nji.Context;

public class TagInstruction implements Instruction {

    private String name;

    public TagInstruction(String name) {
        this.name = name;
    }

    @Override
    public void execute(Context context) {

    }
}
