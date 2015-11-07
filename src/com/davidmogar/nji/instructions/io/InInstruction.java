package com.davidmogar.nji.instructions.io;

import com.davidmogar.nji.Context;
import com.davidmogar.nji.instructions.Instruction;

public class InInstruction implements Instruction {

    private char suffix;

    public InInstruction(char suffix) {
        this.suffix = suffix;
    }

    @Override
    public void execute(Context context) {
        switch (suffix) {
            case 'b':
                break;
            case 'i':
                break;
            case 'f':
                break;
        }
    }

}
