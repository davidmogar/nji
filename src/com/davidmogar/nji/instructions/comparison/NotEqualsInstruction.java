package com.davidmogar.nji.instructions.comparison;

import com.davidmogar.nji.Context;
import com.davidmogar.nji.instructions.Instruction;

public class NotEqualsInstruction implements Instruction {

    private char suffix;

    public NotEqualsInstruction(char suffix) {
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
