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
Directives = ("#line" | "#source").*
Integer = -?{Digit}+
Float = ({Integer}\.{Digit}+ | {Integer})
Letter = [a-z]
String = \"~\"
Tag = {Letter}({Letter} | {Digit})*


%%

/* Remove comments, breaklines, whitespaces, tabulations and end of files. */
"," | ":" | {Comment} | {BreakLine} | {Directives} | [ \t\f] {}

"bp"		{ matchedValue = yytext(); return Parser.BP; }
{Integer}	{ matchedValue = Integer.parseInt(yytext()); return Parser.INTEGER; }
{Float}		{ matchedValue = Float.parseFloat(yytext()); return Parser.FLOAT; }
{String}	{ matchedValue = Float.parseFloat(yytext()); return Parser.STRING; }

"pusha"		{ matchedValue = yytext(); return Parser.PUSHA; }
"pushb"		{ matchedValue = yytext(); return Parser.PUSHB; }
"pushi"		{ matchedValue = yytext(); return Parser.PUSHI; }
"pushf"		{ matchedValue = yytext(); return Parser.PUSHF; }
"push"		{ matchedValue = yytext(); return Parser.PUSH; }

"loadb"		{ matchedValue = yytext(); return Parser.LOADB; }
"loadi"		{ matchedValue = yytext(); return Parser.LOADI; }
"loadf"		{ matchedValue = yytext(); return Parser.LOADF; }
"load"		{ matchedValue = yytext(); return Parser.LOAD; }
"storeb"	{ matchedValue = yytext(); return Parser.STOREB; }
"storei"	{ matchedValue = yytext(); return Parser.STOREI; }
"storef"	{ matchedValue = yytext(); return Parser.STOREF; }
"store"		{ matchedValue = yytext(); return Parser.STORE; }

"addb"		{ matchedValue = yytext(); return Parser.ADDB; }
"addi"		{ matchedValue = yytext(); return Parser.ADDI; }
"addf"		{ matchedValue = yytext(); return Parser.ADDF; }
"add"		{ matchedValue = yytext(); return Parser.ADD; }
"divb"		{ matchedValue = yytext(); return Parser.DIVB; }
"divi"		{ matchedValue = yytext(); return Parser.DIVI; }
"divf"		{ matchedValue = yytext(); return Parser.DIVF; }
"div"		{ matchedValue = yytext(); return Parser.DIV; }
"modb"		{ matchedValue = yytext(); return Parser.MODB; }
"modi"		{ matchedValue = yytext(); return Parser.MODI; }
"modf"		{ matchedValue = yytext(); return Parser.MODF; }
"mod"		{ matchedValue = yytext(); return Parser.MOD; }
"mulb"		{ matchedValue = yytext(); return Parser.MULB; }
"muli"		{ matchedValue = yytext(); return Parser.MULI; }
"mulf"		{ matchedValue = yytext(); return Parser.MULF; }
"mul"		{ matchedValue = yytext(); return Parser.MUL; }
"subb"		{ matchedValue = yytext(); return Parser.SUBB; }
"subi"		{ matchedValue = yytext(); return Parser.SUBI; }
"subf"		{ matchedValue = yytext(); return Parser.SUBF; }
"sub"		{ matchedValue = yytext(); return Parser.SUB; }

"inb"		{ matchedValue = yytext(); return Parser.INB; }
"ini"		{ matchedValue = yytext(); return Parser.INI; }
"inf"		{ matchedValue = yytext(); return Parser.INF; }
"in"		{ matchedValue = yytext(); return Parser.IN; }
"outb"		{ matchedValue = yytext(); return Parser.OUTB; }
"outi"		{ matchedValue = yytext(); return Parser.OUTI; }
"outf"		{ matchedValue = yytext(); return Parser.OUTF; }
"out"		{ matchedValue = yytext(); return Parser.OUT; }

"call"		{ matchedValue = yytext(); return Parser.CALL; }
"enter"		{ matchedValue = yytext(); return Parser.ENTER; }
"halt"		{ matchedValue = yytext(); return Parser.HALT; }
"ret"		{ matchedValue = yytext(); return Parser.RET; }

"b2i"		{ matchedValue = yytext(); return Parser.B2I; }
"i2b"		{ matchedValue = yytext(); return Parser.I2B; }
"i2f"		{ matchedValue = yytext(); return Parser.I2F; }
"f2i"		{ matchedValue = yytext(); return Parser.F2I; }

"eqb"		{ matchedValue = yytext(); return Parser.EQB; }
"eqi"		{ matchedValue = yytext(); return Parser.EQI; }
"eqf"		{ matchedValue = yytext(); return Parser.EQF; }
"eq"		{ matchedValue = yytext(); return Parser.EQ; }
"geb"		{ matchedValue = yytext(); return Parser.GEB; }
"gei"		{ matchedValue = yytext(); return Parser.GEI; }
"gef"		{ matchedValue = yytext(); return Parser.GEF; }
"ge"		{ matchedValue = yytext(); return Parser.GE; }
"gtb"		{ matchedValue = yytext(); return Parser.GTB; }
"gti"		{ matchedValue = yytext(); return Parser.GTI; }
"gtf"		{ matchedValue = yytext(); return Parser.GTF; }
"gt"		{ matchedValue = yytext(); return Parser.GT; }
"leb"		{ matchedValue = yytext(); return Parser.LEB; }
"lei"		{ matchedValue = yytext(); return Parser.LEI; }
"lef"		{ matchedValue = yytext(); return Parser.LEF; }
"le"		{ matchedValue = yytext(); return Parser.LE; }
"ltb"		{ matchedValue = yytext(); return Parser.LTB; }
"lti"		{ matchedValue = yytext(); return Parser.LTI; }
"ltf"		{ matchedValue = yytext(); return Parser.LTF; }
"lt"		{ matchedValue = yytext(); return Parser.LT; }
"ntb"		{ matchedValue = yytext(); return Parser.NEB; }
"nti"		{ matchedValue = yytext(); return Parser.NEI; }
"ntf"		{ matchedValue = yytext(); return Parser.NEF; }
"nt"		{ matchedValue = yytext(); return Parser.NE; }

"andb"		{ matchedValue = yytext(); return Parser.ANDB; }
"andi"		{ matchedValue = yytext(); return Parser.ANDI; }
"andf"		{ matchedValue = yytext(); return Parser.ANDF; }
"and"		{ matchedValue = yytext(); return Parser.AND; }
"notb"		{ matchedValue = yytext(); return Parser.NOTB; }
"noti"		{ matchedValue = yytext(); return Parser.NOTI; }
"notf"		{ matchedValue = yytext(); return Parser.NOTF; }
"not"		{ matchedValue = yytext(); return Parser.NOT; }
"orb"		{ matchedValue = yytext(); return Parser.ORB; }
"ori"		{ matchedValue = yytext(); return Parser.ORI; }
"orf"		{ matchedValue = yytext(); return Parser.ORF; }
"or"		{ matchedValue = yytext(); return Parser.OR; }

"jmp"		{ matchedValue = yytext(); return Parser.JMP; }
"jnz"		{ matchedValue = yytext(); return Parser.JNZ; }
"jz"		{ matchedValue = yytext(); return Parser.JZ; }

{Tag}		{ matchedValue = yytext(); return Parser.TAG; }

.			{ System.out.println("Character \'" + yycharat(0) + "' unknown."); }