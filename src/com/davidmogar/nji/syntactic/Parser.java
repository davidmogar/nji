//### This file created by BYACC 1.8(/Java extension  1.15)
//### Java capabilities added 7 Jan 97, Bob Jamison
//### Updated : 27 Nov 97  -- Bob Jamison, Joe Nieten
//###           01 Jan 98  -- Bob Jamison -- fixed generic semantic constructor
//###           01 Jun 99  -- Bob Jamison -- added Runnable support
//###           06 Aug 00  -- Bob Jamison -- made state variables class-global
//###           03 Jan 01  -- Bob Jamison -- improved flags, tracing
//###           16 May 01  -- Bob Jamison -- added custom stack sizing
//###           04 Mar 02  -- Yuval Oren  -- improved java performance, added options
//###           14 Mar 02  -- Tomas Hurka -- -d support, static initializer workaround
//### Please send bug reports to tom@hukatronic.cz
//### static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";



package com.davidmogar.nji.syntactic;



//#line 2 "../src/com/davidmogar/nji/syntactic/syntactic.y"

import com.davidmogar.nji.lexicon.Lexicon;
import com.davidmogar.nji.instructions.*;
import com.davidmogar.nji.instructions.arithmetic.*;
import com.davidmogar.nji.instructions.cast.*;
import com.davidmogar.nji.instructions.comparison.*;
import com.davidmogar.nji.instructions.io.*;
import com.davidmogar.nji.instructions.jump.*;

import java.util.*;

//#line 29 "Parser.java"




public class Parser
{

boolean yydebug;        //do I want debug output?
int yynerrs;            //number of errors so far
int yyerrflag;          //was there an error?
int yychar;             //the current working character

//########## MESSAGES ##########
//###############################################################
// method: debug
//###############################################################
void debug(String msg)
{
  if (yydebug)
    System.out.println(msg);
}

//########## STATE STACK ##########
final static int YYSTACKSIZE = 500;  //maximum stack size
int statestk[] = new int[YYSTACKSIZE]; //state stack
int stateptr;
int stateptrmax;                     //highest index of stackptr
int statemax;                        //state when highest index reached
//###############################################################
// methods: state stack push,pop,drop,peek
//###############################################################
final void state_push(int state)
{
  try {
		stateptr++;
		statestk[stateptr]=state;
	 }
	 catch (ArrayIndexOutOfBoundsException e) {
     int oldsize = statestk.length;
     int newsize = oldsize * 2;
     int[] newstack = new int[newsize];
     System.arraycopy(statestk,0,newstack,0,oldsize);
     statestk = newstack;
     statestk[stateptr]=state;
  }
}
final int state_pop()
{
  return statestk[stateptr--];
}
final void state_drop(int cnt)
{
  stateptr -= cnt; 
}
final int state_peek(int relative)
{
  return statestk[stateptr-relative];
}
//###############################################################
// method: init_stacks : allocate and prepare stacks
//###############################################################
final boolean init_stacks()
{
  stateptr = -1;
  val_init();
  return true;
}
//###############################################################
// method: dump_stacks : show n levels of the stacks
//###############################################################
void dump_stacks(int count)
{
int i;
  System.out.println("=index==state====value=     s:"+stateptr+"  v:"+valptr);
  for (i=0;i<count;i++)
    System.out.println(" "+i+"    "+statestk[i]+"      "+valstk[i]);
  System.out.println("======================");
}


//########## SEMANTIC VALUES ##########
//## **user defined:Object
String   yytext;//user variable to return contextual strings
Object yyval; //used to return semantic vals from action routines
Object yylval;//the 'lval' (result) I got from yylex()
Object valstk[] = new Object[YYSTACKSIZE];
int valptr;
//###############################################################
// methods: value stack push,pop,drop,peek.
//###############################################################
final void val_init()
{
  yyval=new Object();
  yylval=new Object();
  valptr=-1;
}
final void val_push(Object val)
{
  try {
    valptr++;
    valstk[valptr]=val;
  }
  catch (ArrayIndexOutOfBoundsException e) {
    int oldsize = valstk.length;
    int newsize = oldsize*2;
    Object[] newstack = new Object[newsize];
    System.arraycopy(valstk,0,newstack,0,oldsize);
    valstk = newstack;
    valstk[valptr]=val;
  }
}
final Object val_pop()
{
  return valstk[valptr--];
}
final void val_drop(int cnt)
{
  valptr -= cnt;
}
final Object val_peek(int relative)
{
  return valstk[valptr-relative];
}
final Object dup_yyval(Object val)
{
  return val;
}
//#### end semantic value section ####
public final static short BP=257;
public final static short INTEGER=258;
public final static short FLOAT=259;
public final static short STRING=260;
public final static short TAG=261;
public final static short PUSH=262;
public final static short PUSHA=263;
public final static short PUSHB=264;
public final static short PUSHI=265;
public final static short PUSHF=266;
public final static short LOAD=267;
public final static short LOADB=268;
public final static short LOADI=269;
public final static short LOADF=270;
public final static short STORE=271;
public final static short STOREB=272;
public final static short STOREI=273;
public final static short STOREF=274;
public final static short ADD=275;
public final static short ADDB=276;
public final static short ADDI=277;
public final static short ADDF=278;
public final static short DIV=279;
public final static short DIVB=280;
public final static short DIVI=281;
public final static short DIVF=282;
public final static short MOD=283;
public final static short MODB=284;
public final static short MODI=285;
public final static short MODF=286;
public final static short MUL=287;
public final static short MULB=288;
public final static short MULI=289;
public final static short MULF=290;
public final static short SUB=291;
public final static short SUBB=292;
public final static short SUBI=293;
public final static short SUBF=294;
public final static short IN=295;
public final static short INB=296;
public final static short INI=297;
public final static short INF=298;
public final static short OUT=299;
public final static short OUTB=300;
public final static short OUTI=301;
public final static short OUTF=302;
public final static short CALL=303;
public final static short ENTER=304;
public final static short HALT=305;
public final static short RET=306;
public final static short B2I=307;
public final static short I2B=308;
public final static short I2F=309;
public final static short F2I=310;
public final static short EQ=311;
public final static short EQB=312;
public final static short EQI=313;
public final static short EQF=314;
public final static short GE=315;
public final static short GEB=316;
public final static short GEI=317;
public final static short GEF=318;
public final static short GT=319;
public final static short GTB=320;
public final static short GTI=321;
public final static short GTF=322;
public final static short LE=323;
public final static short LEB=324;
public final static short LEI=325;
public final static short LEF=326;
public final static short LT=327;
public final static short LTB=328;
public final static short LTI=329;
public final static short LTF=330;
public final static short NE=331;
public final static short NEB=332;
public final static short NEI=333;
public final static short NEF=334;
public final static short AND=335;
public final static short ANDB=336;
public final static short ANDI=337;
public final static short ANDF=338;
public final static short NOT=339;
public final static short NOTB=340;
public final static short NOTI=341;
public final static short NOTF=342;
public final static short OR=343;
public final static short ORB=344;
public final static short ORI=345;
public final static short ORF=346;
public final static short JMP=347;
public final static short JNZ=348;
public final static short JZ=349;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    1,    1,    2,    2,    2,    2,    2,    2,    2,
    2,    2,    2,    2,    2,    2,    2,    3,    3,    3,
    3,    3,    3,    3,    3,    3,    3,    3,    3,    3,
    3,    3,    3,    3,    3,    3,    3,    4,    4,    4,
    4,    5,    5,    5,    5,    5,    5,    5,    5,    5,
    5,    5,    5,    5,    5,    5,    5,    5,    5,    5,
    5,    5,    5,    5,    5,    6,    6,    6,    6,    6,
    6,    6,    6,    7,    7,    7,    8,    8,    8,    8,
    9,    9,    9,   10,   10,   10,   10,   10,   10,   11,
   11,   11,   11,
};
final static short yylen[] = {                            2,
    1,    1,    2,    1,    1,    1,    1,    1,    1,    1,
    1,    1,    2,    2,    1,    4,    1,    1,    1,    1,
    1,    1,    1,    1,    1,    1,    1,    1,    1,    1,
    1,    1,    1,    1,    1,    1,    1,    1,    1,    1,
    1,    1,    1,    1,    1,    1,    1,    1,    1,    1,
    1,    1,    1,    1,    1,    1,    1,    1,    1,    1,
    1,    1,    1,    1,    1,    1,    1,    1,    1,    1,
    1,    1,    1,    2,    2,    2,    1,    1,    1,    1,
    1,    1,    1,    2,    2,    2,    2,    2,    2,    1,
    1,    1,    1,
};
final static short yydefred[] = {                         0,
   17,    0,    0,    0,    0,    0,   77,   78,   79,   80,
   90,   91,   92,   93,   18,   19,   20,   21,   22,   23,
   24,   25,   26,   27,   28,   29,   30,   31,   32,   33,
   34,   35,   36,   37,   66,   67,   68,   69,   70,   71,
   72,   73,    0,    0,   15,    0,   38,   39,   40,   41,
   42,   43,   44,   45,   46,   47,   48,   49,   50,   51,
   52,   53,   54,   55,   56,   57,   58,   59,   60,   61,
   62,   63,   64,   65,   81,   82,   83,    0,    0,    0,
    0,    0,    2,    4,    5,    6,    7,    8,    9,   10,
   11,   12,   84,   85,   86,   87,   88,   89,   13,   14,
    0,   74,   75,   76,    3,    0,   16,
};
final static short yydgoto[] = {                         81,
   82,   83,   84,   85,   86,   87,   88,   89,   90,   91,
   92,
};
final static short yysindex[] = {                      -261,
    0, -182, -181, -179, -178, -176,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0, -180, -174,    0, -173,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0, -172, -171, -170,
    0, -261,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
 -166,    0,    0,    0,    0, -165,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   94,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
    0,   13,    0,    0,    0,    0,    0,    0,    0,    0,
    0,
};
final static int YYTABLESIZE=95;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                          1,
    2,    3,    4,    5,    6,    7,    8,    9,   10,   11,
   12,   13,   14,   15,   16,   17,   18,   19,   20,   21,
   22,   23,   24,   25,   26,   27,   28,   29,   30,   31,
   32,   33,   34,   35,   36,   37,   38,   39,   40,   41,
   42,   43,   44,   45,   46,   47,   48,   49,   50,   51,
   52,   53,   54,   55,   56,   57,   58,   59,   60,   61,
   62,   63,   64,   65,   66,   67,   68,   69,   70,   71,
   72,   73,   74,   75,   93,   94,   95,   76,   96,   97,
   99,   77,   98,  100,  101,   78,   79,   80,  102,  103,
  104,  106,  107,    1,  105,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                        261,
  262,  263,  264,  265,  266,  267,  268,  269,  270,  271,
  272,  273,  274,  275,  276,  277,  278,  279,  280,  281,
  282,  283,  284,  285,  286,  287,  288,  289,  290,  291,
  292,  293,  294,  295,  296,  297,  298,  299,  300,  301,
  302,  303,  304,  305,  306,  307,  308,  309,  310,  311,
  312,  313,  314,  315,  316,  317,  318,  319,  320,  321,
  322,  323,  324,  325,  326,  327,  328,  329,  330,  331,
  332,  333,  334,  335,  257,  258,  258,  339,  258,  258,
  261,  343,  259,  258,  258,  347,  348,  349,  261,  261,
  261,  258,  258,    0,   82,
};
}
final static short YYFINAL=81;
final static short YYMAXTOKEN=349;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,"BP","INTEGER","FLOAT","STRING","TAG","PUSH","PUSHA","PUSHB",
"PUSHI","PUSHF","LOAD","LOADB","LOADI","LOADF","STORE","STOREB","STOREI",
"STOREF","ADD","ADDB","ADDI","ADDF","DIV","DIVB","DIVI","DIVF","MOD","MODB",
"MODI","MODF","MUL","MULB","MULI","MULF","SUB","SUBB","SUBI","SUBF","IN","INB",
"INI","INF","OUT","OUTB","OUTI","OUTF","CALL","ENTER","HALT","RET","B2I","I2B",
"I2F","F2I","EQ","EQB","EQI","EQF","GE","GEB","GEI","GEF","GT","GTB","GTI",
"GTF","LE","LEB","LEI","LEF","LT","LTB","LTI","LTF","NE","NEB","NEI","NEF",
"AND","ANDB","ANDI","ANDF","NOT","NOTB","NOTI","NOTF","OR","ORB","ORI","ORF",
"JMP","JNZ","JZ",
};
final static String yyrule[] = {
"$accept : program",
"program : instructions",
"instructions : instruction",
"instructions : instructions instruction",
"instruction : arithmetic",
"instruction : cast",
"instruction : comparison",
"instruction : inout",
"instruction : jump",
"instruction : load",
"instruction : logic",
"instruction : push",
"instruction : store",
"instruction : CALL TAG",
"instruction : ENTER INTEGER",
"instruction : HALT",
"instruction : RET INTEGER INTEGER INTEGER",
"instruction : TAG",
"arithmetic : ADD",
"arithmetic : ADDB",
"arithmetic : ADDI",
"arithmetic : ADDF",
"arithmetic : DIV",
"arithmetic : DIVB",
"arithmetic : DIVI",
"arithmetic : DIVF",
"arithmetic : MOD",
"arithmetic : MODB",
"arithmetic : MODI",
"arithmetic : MODF",
"arithmetic : MUL",
"arithmetic : MULB",
"arithmetic : MULI",
"arithmetic : MULF",
"arithmetic : SUB",
"arithmetic : SUBB",
"arithmetic : SUBI",
"arithmetic : SUBF",
"cast : B2I",
"cast : I2B",
"cast : I2F",
"cast : F2I",
"comparison : EQ",
"comparison : EQB",
"comparison : EQI",
"comparison : EQF",
"comparison : GE",
"comparison : GEB",
"comparison : GEI",
"comparison : GEF",
"comparison : GT",
"comparison : GTB",
"comparison : GTI",
"comparison : GTF",
"comparison : LE",
"comparison : LEB",
"comparison : LEI",
"comparison : LEF",
"comparison : LT",
"comparison : LTB",
"comparison : LTI",
"comparison : LTF",
"comparison : NE",
"comparison : NEB",
"comparison : NEI",
"comparison : NEF",
"inout : IN",
"inout : INB",
"inout : INI",
"inout : INF",
"inout : OUT",
"inout : OUTB",
"inout : OUTI",
"inout : OUTF",
"jump : JMP TAG",
"jump : JNZ TAG",
"jump : JZ TAG",
"load : LOAD",
"load : LOADB",
"load : LOADI",
"load : LOADF",
"logic : AND",
"logic : NOT",
"logic : OR",
"push : PUSH BP",
"push : PUSH INTEGER",
"push : PUSHA INTEGER",
"push : PUSHB INTEGER",
"push : PUSHI INTEGER",
"push : PUSHF FLOAT",
"store : STORE",
"store : STOREB",
"store : STOREI",
"store : STOREF",
};

//#line 153 "../src/com/davidmogar/nji/syntactic/syntactic.y"

private Lexicon lexicon;

public List<Instruction> instructions;

public void yyerror(String error) {
 System.err.println(error + lexicon.getLine());
}

public int yylex() {
    int token = 0;

    try {
        token = lexicon.yylex();
        yylval = lexicon.matchedValue;
    } catch(Throwable e) {
System.err.println(e.getMessage() + lexicon.getLine() + " " + lexicon.matchedValue + "#");
    }

    return token;
}

public Parser(Lexicon lexicon) {
    this.lexicon = lexicon;
}
//#line 448 "Parser.java"
//###############################################################
// method: yylexdebug : check lexer state
//###############################################################
void yylexdebug(int state,int ch)
{
String s=null;
  if (ch < 0) ch=0;
  if (ch <= YYMAXTOKEN) //check index bounds
     s = yyname[ch];    //now get it
  if (s==null)
    s = "illegal-symbol";
  debug("state "+state+", reading "+ch+" ("+s+")");
}





//The following are now global, to aid in error reporting
int yyn;       //next next thing to do
int yym;       //
int yystate;   //current parsing state from state table
String yys;    //current token string


//###############################################################
// method: yyparse : parse input and execute indicated items
//###############################################################
int yyparse()
{
boolean doaction;
  init_stacks();
  yynerrs = 0;
  yyerrflag = 0;
  yychar = -1;          //impossible char forces a read
  yystate=0;            //initial state
  state_push(yystate);  //save it
  val_push(yylval);     //save empty value
  while (true) //until parsing is done, either correctly, or w/error
    {
    doaction=true;
    if (yydebug) debug("loop"); 
    //#### NEXT ACTION (from reduction table)
    for (yyn=yydefred[yystate];yyn==0;yyn=yydefred[yystate])
      {
      if (yydebug) debug("yyn:"+yyn+"  state:"+yystate+"  yychar:"+yychar);
      if (yychar < 0)      //we want a char?
        {
        yychar = yylex();  //get next token
        if (yydebug) debug(" next yychar:"+yychar);
        //#### ERROR CHECK ####
        if (yychar < 0)    //it it didn't work/error
          {
          yychar = 0;      //change it to default string (no -1!)
          if (yydebug)
            yylexdebug(yystate,yychar);
          }
        }//yychar<0
      yyn = yysindex[yystate];  //get amount to shift by (shift index)
      if ((yyn != 0) && (yyn += yychar) >= 0 &&
          yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
        if (yydebug)
          debug("state "+yystate+", shifting to state "+yytable[yyn]);
        //#### NEXT STATE ####
        yystate = yytable[yyn];//we are in a new state
        state_push(yystate);   //save it
        val_push(yylval);      //push our lval as the input for next rule
        yychar = -1;           //since we have 'eaten' a token, say we need another
        if (yyerrflag > 0)     //have we recovered an error?
           --yyerrflag;        //give ourselves credit
        doaction=false;        //but don't process yet
        break;   //quit the yyn=0 loop
        }

    yyn = yyrindex[yystate];  //reduce
    if ((yyn !=0 ) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
      {   //we reduced!
      if (yydebug) debug("reduce");
      yyn = yytable[yyn];
      doaction=true; //get ready to execute
      break;         //drop down to actions
      }
    else //ERROR RECOVERY
      {
      if (yyerrflag==0)
        {
        yyerror("syntax error");
        yynerrs++;
        }
      if (yyerrflag < 3) //low error count?
        {
        yyerrflag = 3;
        while (true)   //do until break
          {
          if (stateptr<0)   //check for under & overflow here
            {
            yyerror("stack underflow. aborting...");  //note lower case 's'
            return 1;
            }
          yyn = yysindex[state_peek(0)];
          if ((yyn != 0) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
            if (yydebug)
              debug("state "+state_peek(0)+", error recovery shifting to state "+yytable[yyn]+" ");
            yystate = yytable[yyn];
            state_push(yystate);
            val_push(yylval);
            doaction=false;
            break;
            }
          else
            {
            if (yydebug)
              debug("error recovery discarding state "+state_peek(0)+" ");
            if (stateptr<0)   //check for under & overflow here
              {
              yyerror("Stack underflow. aborting...");  //capital 'S'
              return 1;
              }
            state_pop();
            val_pop();
            }
          }
        }
      else            //discard this token
        {
        if (yychar == 0)
          return 1; //yyabort
        if (yydebug)
          {
          yys = null;
          if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
          if (yys == null) yys = "illegal-symbol";
          debug("state "+yystate+", error recovery discards token "+yychar+" ("+yys+")");
          }
        yychar = -1;  //read another
        }
      }//end error recovery
    }//yyn=0 loop
    if (!doaction)   //any reason not to proceed?
      continue;      //skip action
    yym = yylen[yyn];          //get count of terminals on rhs
    if (yydebug)
      debug("state "+yystate+", reducing "+yym+" by rule "+yyn+" ("+yyrule[yyn]+")");
    if (yym>0)                 //if count of rhs not 'nil'
      yyval = val_peek(yym-1); //get current semantic value
    yyval = dup_yyval(yyval); //duplicate yyval if ParserVal is used as semantic value
    switch(yyn)
      {
//########## USER-SUPPLIED ACTIONS ##########
case 1:
//#line 28 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ instructions = (List<Instruction>) val_peek(0); }
break;
case 2:
//#line 30 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{
                        List<Instruction> instructions = new ArrayList<>();
                        instructions.add((Instruction) val_peek(0));
                        yyval = instructions;
                    }
break;
case 3:
//#line 35 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{
                        List<Instruction> instructions = (List<Instruction>) val_peek(1);
                        instructions.add((Instruction) val_peek(0));
                        yyval = instructions;
                    }
break;
case 4:
//#line 42 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = val_peek(0); }
break;
case 5:
//#line 43 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = val_peek(0); }
break;
case 6:
//#line 44 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = val_peek(0); }
break;
case 7:
//#line 45 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = val_peek(0); }
break;
case 8:
//#line 46 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = val_peek(0); }
break;
case 9:
//#line 47 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = val_peek(0); }
break;
case 10:
//#line 48 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = val_peek(0); }
break;
case 11:
//#line 49 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = val_peek(0); }
break;
case 12:
//#line 50 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = val_peek(0); }
break;
case 13:
//#line 51 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new CallInstruction((String) val_peek(0)); }
break;
case 14:
//#line 52 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new EnterInstruction((int) val_peek(0)); }
break;
case 15:
//#line 53 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new HaltInstruction(); }
break;
case 16:
//#line 54 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new RetInstruction((int) val_peek(2), (int) val_peek(1), (int) val_peek(0)); }
break;
case 17:
//#line 55 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new TagInstruction((String) val_peek(0)); }
break;
case 18:
//#line 58 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new AddInstruction('i'); }
break;
case 19:
//#line 59 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new AddInstruction('b'); }
break;
case 20:
//#line 60 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new AddInstruction('i'); }
break;
case 21:
//#line 61 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new AddInstruction('f'); }
break;
case 22:
//#line 62 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new DivInstruction('i'); }
break;
case 23:
//#line 63 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new DivInstruction('b'); }
break;
case 24:
//#line 64 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new DivInstruction('i'); }
break;
case 25:
//#line 65 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new DivInstruction('f'); }
break;
case 26:
//#line 66 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new ModInstruction('i'); }
break;
case 27:
//#line 67 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new ModInstruction('b'); }
break;
case 28:
//#line 68 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new ModInstruction('i'); }
break;
case 29:
//#line 69 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new ModInstruction('f'); }
break;
case 30:
//#line 70 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new MulInstruction('i'); }
break;
case 31:
//#line 71 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new MulInstruction('b'); }
break;
case 32:
//#line 72 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new MulInstruction('i'); }
break;
case 33:
//#line 73 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new MulInstruction('f'); }
break;
case 34:
//#line 74 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new MulInstruction('i'); }
break;
case 35:
//#line 75 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new MulInstruction('b'); }
break;
case 36:
//#line 76 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new MulInstruction('i'); }
break;
case 37:
//#line 77 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new MulInstruction('f'); }
break;
case 38:
//#line 80 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new ByteToIntegerInstruction(); }
break;
case 39:
//#line 81 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new IntegerToByteInstruction(); }
break;
case 40:
//#line 82 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new IntegerToFloatInstruction(); }
break;
case 41:
//#line 83 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new FloatToIntegerInstruction(); }
break;
case 42:
//#line 86 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new EqualsInstruction('i'); }
break;
case 43:
//#line 87 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new EqualsInstruction('b'); }
break;
case 44:
//#line 88 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new EqualsInstruction('i'); }
break;
case 45:
//#line 89 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new EqualsInstruction('f'); }
break;
case 46:
//#line 90 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new GreaterEqualsInstruction('i'); }
break;
case 47:
//#line 91 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new GreaterEqualsInstruction('b'); }
break;
case 48:
//#line 92 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new GreaterEqualsInstruction('i'); }
break;
case 49:
//#line 93 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new GreaterEqualsInstruction('f'); }
break;
case 50:
//#line 94 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new GreaterThanInstruction('i'); }
break;
case 51:
//#line 95 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new GreaterThanInstruction('b'); }
break;
case 52:
//#line 96 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new GreaterThanInstruction('i'); }
break;
case 53:
//#line 97 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new GreaterThanInstruction('f'); }
break;
case 54:
//#line 98 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new LowerEqualsInstruction('i'); }
break;
case 55:
//#line 99 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new LowerEqualsInstruction('b'); }
break;
case 56:
//#line 100 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new LowerEqualsInstruction('i'); }
break;
case 57:
//#line 101 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new LowerEqualsInstruction('f'); }
break;
case 58:
//#line 102 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new LowerThanInstruction('i'); }
break;
case 59:
//#line 103 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new LowerThanInstruction('b'); }
break;
case 60:
//#line 104 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new LowerThanInstruction('i'); }
break;
case 61:
//#line 105 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new LowerThanInstruction('f'); }
break;
case 62:
//#line 106 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new NotEqualsInstruction('i'); }
break;
case 63:
//#line 107 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new NotEqualsInstruction('b'); }
break;
case 64:
//#line 108 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new NotEqualsInstruction('i'); }
break;
case 65:
//#line 109 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new NotEqualsInstruction('f'); }
break;
case 66:
//#line 112 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new InInstruction('i'); }
break;
case 67:
//#line 113 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new InInstruction('b'); }
break;
case 68:
//#line 114 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new InInstruction('i'); }
break;
case 69:
//#line 115 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new InInstruction('f'); }
break;
case 70:
//#line 116 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new OutInstruction('i'); }
break;
case 71:
//#line 117 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new OutInstruction('b'); }
break;
case 72:
//#line 118 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new OutInstruction('i'); }
break;
case 73:
//#line 119 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new OutInstruction('f'); }
break;
case 74:
//#line 122 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new JumpInstruction((String) val_peek(0)); }
break;
case 75:
//#line 123 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new NonZeroJumpInstruction((String) val_peek(0)); }
break;
case 76:
//#line 124 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new ZeroJumpInstruction((String) val_peek(0)); }
break;
case 77:
//#line 127 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new LoadInstruction('i'); }
break;
case 78:
//#line 128 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new LoadInstruction('b'); }
break;
case 79:
//#line 129 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new LoadInstruction('i'); }
break;
case 80:
//#line 130 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new LoadInstruction('f'); }
break;
case 81:
//#line 133 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new LogicInstruction(LogicInstruction.Operation.AND); }
break;
case 82:
//#line 134 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new LogicInstruction(LogicInstruction.Operation.NOT); }
break;
case 83:
//#line 135 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new LogicInstruction(LogicInstruction.Operation.OR); }
break;
case 84:
//#line 138 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new PushInstruction(); }
break;
case 85:
//#line 139 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new PushInstruction('i', (int) val_peek(0)); }
break;
case 86:
//#line 140 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new PushInstruction('i', (int) val_peek(0)); }
break;
case 87:
//#line 141 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new PushInstruction('b', (int) val_peek(0)); }
break;
case 88:
//#line 142 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new PushInstruction('i', (int) val_peek(0)); }
break;
case 89:
//#line 143 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new PushInstruction('f', (float) val_peek(0)); }
break;
case 90:
//#line 146 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new StoreInstruction('i'); }
break;
case 91:
//#line 147 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new StoreInstruction('b'); }
break;
case 92:
//#line 148 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new StoreInstruction('i'); }
break;
case 93:
//#line 149 "../src/com/davidmogar/nji/syntactic/syntactic.y"
{ yyval = new StoreInstruction('f'); }
break;
//#line 977 "Parser.java"
//########## END OF USER-SUPPLIED ACTIONS ##########
    }//switch
    //#### Now let's reduce... ####
    if (yydebug) debug("reduce");
    state_drop(yym);             //we just reduced yylen states
    yystate = state_peek(0);     //get new state
    val_drop(yym);               //corresponding value drop
    yym = yylhs[yyn];            //select next TERMINAL(on lhs)
    if (yystate == 0 && yym == 0)//done? 'rest' state and at first TERMINAL
      {
      if (yydebug) debug("After reduction, shifting from state 0 to state "+YYFINAL+"");
      yystate = YYFINAL;         //explicitly say we're done
      state_push(YYFINAL);       //and save it
      val_push(yyval);           //also save the semantic value of parsing
      if (yychar < 0)            //we want another character?
        {
        yychar = yylex();        //get next character
        if (yychar<0) yychar=0;  //clean, if necessary
        if (yydebug)
          yylexdebug(yystate,yychar);
        }
      if (yychar == 0)          //Good exit (if lex returns 0 ;-)
         break;                 //quit the loop--all DONE
      }//if yystate
    else                        //else not done yet
      {                         //get next state and push, for next yydefred[]
      yyn = yygindex[yym];      //find out where to go
      if ((yyn != 0) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn]; //get new state
      else
        yystate = yydgoto[yym]; //else go to new defred
      if (yydebug) debug("after reduction, shifting from state "+state_peek(0)+" to state "+yystate+"");
      state_push(yystate);     //going again, so push state & val...
      val_push(yyval);         //for next action
      }
    }//main loop
  return 0;//yyaccept!!
}
//## end of method parse() ######################################



//## run() --- for Thread #######################################
/**
 * A default run method, used for operating this parser
 * object in the background.  It is intended for extending Thread
 * or implementing Runnable.  Turn off with -Jnorun .
 */
public void run()
{
  yyparse();
}
//## end of method run() ########################################



//## Constructors ###############################################
/**
 * Default constructor.  Turn off with -Jnoconstruct .

 */
public Parser()
{
  //nothing to do
}


/**
 * Create a parser, setting the debug to true or false.
 * @param debugMe true for debugging, false for no debug.
 */
public Parser(boolean debugMe)
{
  yydebug=debugMe;
}
//###############################################################



}
//################### END OF CLASS ##############################
