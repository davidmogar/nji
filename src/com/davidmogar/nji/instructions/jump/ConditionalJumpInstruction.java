package com.davidmogar.nji.instructions.jump;

import com.davidmogar.nji.Context;
import com.davidmogar.nji.instructions.Instruction;

public class ConditionalJumpInstruction implements Instruction {

    public enum Operation {
        JNZ, JZ
    }

    public Operation operation;

    public ConditionalJumpInstruction(Operation operation) {
        this.operation = operation;
    }

    @Override
    public void execute(Context context) {
        switch (operation) {
            case JNZ:
                break;
            case JZ:
                break;
        }
    }
    
}
