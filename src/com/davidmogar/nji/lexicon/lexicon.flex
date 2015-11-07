package com.davidmogar.nji.lexicon;

import com.davidmogar.nji.syntactic.Parser;

%%

%byaccj
%line
%column
%class Lexicon
%public
%unicode

%{

public Object matchedValue; // Semantic value of the token returned.

/**
 * Return token's column.
 */
public int getColumn() {
	return yycolumn + 1;
}

/**
 * Return token's line.
 */
public int getLine() {
	return yyline + 1;
}

%}

Comment = "'".*
BreakLine = \n | \r | \r\n | \n\r
Digit = [0-9]
Integer = -?{Digit}+
Float = {Integer}\.{Digit}+
String = \"~\"
Tag = [a-z]+

%%

/* Remove comments, breaklines, whitespaces, tabulations and end of files. */
":" | {Comment} | {BreakLine} | [ \t\f] {}

"bp"		{ matchedValue = yytext(); return Parser.BP; }
{Integer}	{ matchedValue = yytext(); return Parser.INTEGER; }
{Float}		{ matchedValue = yytext(); return Parser.FLOAT; }
{String}	{ matchedValue = yytext(); return Parser.STRING; }

"line"		{ matchedValue = yytext(); return Parser.LINE; }
"source"	{ matchedValue = yytext(); return Parser.SOURCE; }

"push"		{ matchedValue = yytext(); return Parser.PUSH; }
"pusha"		{ matchedValue = yytext(); return Parser.PUSHA; }
"pushb"		{ matchedValue = yytext(); return Parser.PUSHB; }
"pushi"		{ matchedValue = yytext(); return Parser.PUSHI; }
"pushf"		{ matchedValue = yytext(); return Parser.PUSHF; }

"load"		{ matchedValue = yytext(); return Parser.LOAD; }
"store"		{ matchedValue = yytext(); return Parser.STORE; }

"addi"		{ matchedValue = yytext(); return Parser.ADD; }
"divi"		{ matchedValue = yytext(); return Parser.DIV; }
"modi"		{ matchedValue = yytext(); return Parser.MOD; }
"muli"		{ matchedValue = yytext(); return Parser.MUL; }
"subi"		{ matchedValue = yytext(); return Parser.SUB; }

"in"		{ matchedValue = yytext(); return Parser.IN; }
"out"		{ matchedValue = yytext(); return Parser.OUT; }

"call"		{ matchedValue = yytext(); return Parser.CALL; }
"enter"		{ matchedValue = yytext(); return Parser.ENTER; }
"halt"		{ matchedValue = yytext(); return Parser.HALT; }
"ret"		{ matchedValue = yytext(); return Parser.RET; }

"b2i"		{ matchedValue = yytext(); return Parser.B2I; }
"i2b"		{ matchedValue = yytext(); return Parser.I2B; }
"i2f"		{ matchedValue = yytext(); return Parser.I2F; }
"f2i"		{ matchedValue = yytext(); return Parser.F2I; }

"eq"		{ matchedValue = yytext(); return Parser.EQ; }
"ge"		{ matchedValue = yytext(); return Parser.GE; }
"gt"		{ matchedValue = yytext(); return Parser.GT; }
"le"		{ matchedValue = yytext(); return Parser.LE; }
"lt"		{ matchedValue = yytext(); return Parser.LT; }
"nt"		{ matchedValue = yytext(); return Parser.NE; }

"and"		{ matchedValue = yytext(); return Parser.AND; }
"not"		{ matchedValue = yytext(); return Parser.NOT; }
"or"		{ matchedValue = yytext(); return Parser.OR; }

"jmp"		{ matchedValue = yytext(); return Parser.JMP; }
"jz"		{ matchedValue = yytext(); return Parser.JZ; }
"jnz"		{ matchedValue = yytext(); return Parser.JNZ; }

{Tag}		{ matchedValue = yytext(); return Parser.TAG; }

.			{}