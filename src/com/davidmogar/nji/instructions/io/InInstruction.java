package com.davidmogar.nji.instructions.io;

import com.davidmogar.nji.Context;
import com.davidmogar.nji.instructions.Instruction;

import java.util.Scanner;

public class InInstruction implements Instruction {

    private Scanner scanner;
    private char suffix;

    public InInstruction(char suffix) {
        this.suffix = suffix;

        scanner = new Scanner(System.in);
    }

    @Override
    public void execute(Context context) {
        switch (suffix) {
            case 'b':
                System.out.println("Enter a character:");
                while (!scanner.hasNext()) {
                    System.out.println("Not a valid integer. Try again.");
                    scanner.next();
                }
                char c = scanner.next().charAt(0);
                context.stackPointer -= 1;
                context.stack.setByte((byte) c, context.stackPointer);
                break;
            case 'i':
                System.out.println("Enter an integer:");
                while (!scanner.hasNextInt()) {
                    System.out.println("Not a valid integer. Try again.");
                    scanner.next();
                }
                int i = scanner.nextInt();
                context.stackPointer -= 2;
                context.stack.setInteger(i, context.stackPointer);
                break;
            case 'f':
                System.out.println("Enter a float:");
                while (!scanner.hasNextFloat()) {
                    System.out.println("Not a valid float. Try again.");
                    scanner.next();
                }
                float f = scanner.nextFloat();
                context.stackPointer -= 4;
                context.stack.setFloat(f, context.stackPointer);
                break;
        }

        context.instructionPointer++;
    }

}
