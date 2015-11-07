package com.davidmogar.nji.instructions.arithmetic;

import com.davidmogar.nji.Context;
import com.davidmogar.nji.instructions.Instruction;

public class AddInstruction implements Instruction {

    private char suffix;

    public AddInstruction(char suffix) {
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
