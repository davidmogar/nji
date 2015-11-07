#!/bin/bash
cd $(dirname $0)
java -cp jflex/JFlex.jar JFlex.Main -d ../src/com/davidmogar/nji/lexicon ../src/com/davidmogar/nji/lexicon/lexicon.flex
./byaccj/yacc.macosx -J -v -Jpackage=com.davidmogar.nji.syntactic -Jsemantic=Object ../src/com/davidmogar/nji/syntactic/syntactic.y
mv Parser.java ../src/com/davidmogar/nji/syntactic
mv y.output byaccj