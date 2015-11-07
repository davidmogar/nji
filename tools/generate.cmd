cls
cd %~dp0
java -cp jflex\JFlex.jar JFlex.Main -d ..\src\com\davidmogar\nji\lexicon ..\src\com\davidmogar\nji\lexicon\lexicon.flex
pause
byaccj\yacc.exe -J -v -Jpackage=com.davidmogar.nji.syntactic -Jsemantic=Object "../src/com/davidmogar/nji/syntactic/syntactic.y"
move Parser.java ../src/com/davidmogar/nji/syntactic
move y.output byaccj
pause