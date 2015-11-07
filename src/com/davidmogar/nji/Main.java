package com.davidmogar.nji;

import com.davidmogar.nji.lexicon.Lexicon;
import com.davidmogar.nji.syntactic.Parser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Input file expected.");
            System.exit(0);
        }

        File inputFile = null;
        FileReader fileReader = null;
        try {
            inputFile = new File(args[0]);
            fileReader = new FileReader(inputFile);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }

        Lexicon lexicon = new Lexicon(fileReader);
        Parser parser = new Parser(lexicon);
        parser.run();

        InstructionsExecutor instructionsExecutor = new InstructionsExecutor(parser.instructions);
        instructionsExecutor.execute();
    }
}
