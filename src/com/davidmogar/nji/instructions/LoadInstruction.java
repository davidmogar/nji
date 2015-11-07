package com.davidmogar.nji.instructions;

import com.davidmogar.nji.Context;

public class LoadInstruction implements Instruction {

    private char suffix;

    public LoadInstruction(char suffix) {
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
