package com.davidmogar.nji.instructions;

import com.davidmogar.nji.Context;

public class LogicInstruction implements Instruction {

    public enum Operation {
        AND, NOT, OR
    }

    public Operation operation;

    public LogicInstruction(Operation operation) {
        this.operation = operation;
    }

    @Override
    public void execute(Context context) {
        switch (operation) {
            case AND:
                break;
            case OR:
                break;
            case NOT:
                break;
        }
    }

}
