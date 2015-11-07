package com.davidmogar.nji.instructions;

import com.davidmogar.nji.Context;

public class PushInstruction implements Instruction {

    private char suffix;
    private float value;

    public PushInstruction() {
        this(Character.MIN_VALUE, Float.MIN_VALUE);
    }

    public PushInstruction(char suffix, float value) {
        this.suffix = suffix;
        this.value = value;
    }

    @Override
    public void execute(Context context) {
        switch (suffix) {
            case 'a':
                break;
            case 'b':
                break;
            case 'i':
                break;
            case 'f':
                break;
            case Character.MIN_VALUE: // BP
                break;
        }
    }

}
