%{

import com.davidmogar.nji.lexicon.Lexicon;

%}

%token BP INTEGER FLOAT STRING TAG
%token LINE SOURCE
%token PUSH PUSHA PUSHB PUSHI PUSHF
%token LOAD STORE
%token ADD DIV MOD MUL SUB
%token IN OUT
%token CALL ENTER HALT RET
%token B2I I2B I2F F2I
%token EQ GE GT LE LT NE
%token AND NOT OR
%token JMP JZ JNZ

%%

instructions:   instruction
                | instructions instruction
                ;

instruction:    PUSH;

%%

private Lexicon lexicon;

public void yyerror(String error) {

}

public int yylex() {
    int token = 0;

    try {
        token = lexicon.yylex();
        yylval = lexicon.matchedValue;
    } catch(Throwable e) {

    }

    return token;
}

public Parser(Lexicon lexicon) {
    this.lexicon = lexicon;
}