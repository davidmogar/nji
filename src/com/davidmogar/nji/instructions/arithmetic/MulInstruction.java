package com.davidmogar.nji.instructions.arithmetic;

import com.davidmogar.nji.Context;
import com.davidmogar.nji.instructions.Instruction;

public class MulInstruction implements Instruction {

    private char suffix;

    public MulInstruction(char suffix) {
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
