%{

import com.davidmogar.nji.lexicon.Lexicon;
import com.davidmogar.nji.instructions.*;
import com.davidmogar.nji.instructions.arithmetic.*;
import com.davidmogar.nji.instructions.cast.*;
import com.davidmogar.nji.instructions.comparison.*;
import com.davidmogar.nji.instructions.io.*;
import com.davidmogar.nji.instructions.jump.*;

import java.util.*;

%}

%token BP INTEGER FLOAT STRING TAG
%token PUSH PUSHA PUSHB PUSHI PUSHF
%token LOAD LOADB LOADI LOADF STORE STOREB STOREI STOREF
%token ADD ADDB ADDI ADDF DIV DIVB DIVI DIVF MOD MODB MODI MODF MUL MULB MULI MULF SUB SUBB SUBI SUBF
%token IN INB INI INF OUT OUTB OUTI OUTF
%token CALL ENTER HALT RET
%token B2I I2B I2F F2I
%token EQ EQB EQI EQF GE GEB GEI GEF GT GTB GTI GTF LE LEB LEI LEF LT LTB LTI LTF NE NEB NEI NEF
%token AND ANDB ANDI ANDF NOT NOTB NOTI NOTF OR ORB ORI ORF
%token JMP JNZ JZ

%%

program:        instructions { instructions = (List<Instruction>) $1; } ;

instructions:   instruction {
                        List<Instruction> instructions = new ArrayList<>();
                        instructions.add((Instruction) $1);
                        $$ = instructions;
                    }
                | instructions instruction {
                        List<Instruction> instructions = (List<Instruction>) $1;
                        instructions.add((Instruction) $2);
                        $$ = instructions;
                    }
                ;

instruction:    arithmetic { $$ = $1; }
                | cast { $$ = $1; }
                | comparison { $$ = $1; }
                | inout { $$ = $1; }
                | jump { $$ = $1; }
                | load { $$ = $1; }
                | logic { $$ = $1; }
                | push { $$ = $1; }
                | store { $$ = $1; }
                | CALL TAG  { $$ = new CallInstruction((String) $2); }
                | ENTER INTEGER { $$ = new EnterInstruction((int) $2); }
                | HALT { $$ = new HaltInstruction(); }
                | RET INTEGER INTEGER INTEGER { $$ = new RetInstruction((int) $2, (int) $3, (int) $4); }
                | TAG { $$ = new TagInstruction((String) $1); }
                ;

arithmetic:     ADD { $$ = new AddInstruction('i'); }
                | ADDB { $$ = new AddInstruction('b'); }
                | ADDI { $$ = new AddInstruction('i'); }
                | ADDF { $$ = new AddInstruction('f'); }
                | DIV { $$ = new DivInstruction('i'); }
                | DIVB { $$ = new DivInstruction('b'); }
                | DIVI { $$ = new DivInstruction('i'); }
                | DIVF { $$ = new DivInstruction('f'); }
                | MOD { $$ = new ModInstruction('i'); }
                | MODB { $$ = new ModInstruction('b'); }
                | MODI { $$ = new ModInstruction('i'); }
                | MODF { $$ = new ModInstruction('f'); }
                | MUL { $$ = new MulInstruction('i'); }
                | MULB { $$ = new MulInstruction('b'); }
                | MULI { $$ = new MulInstruction('i'); }
                | MULF { $$ = new MulInstruction('f'); }
                | SUB { $$ = new MulInstruction('i'); }
                | SUBB { $$ = new MulInstruction('b'); }
                | SUBI { $$ = new MulInstruction('i'); }
                | SUBF { $$ = new MulInstruction('f'); }
                ;

cast:           B2I { $$ = new ByteToIntegerInstruction(); }
                | I2B { $$ = new IntegerToByteInstruction(); }
                | I2F { $$ = new IntegerToFloatInstruction(); }
                | F2I { $$ = new FloatToIntegerInstruction(); }
                ;

comparison:     EQ { $$ = new EqualsInstruction('i'); }
                | EQB { $$ = new EqualsInstruction('b'); }
                | EQI { $$ = new EqualsInstruction('i'); }
                | EQF { $$ = new EqualsInstruction('f'); }
                | GE { $$ = new GreaterEqualsInstruction('i'); }
                | GEB { $$ = new GreaterEqualsInstruction('b'); }
                | GEI { $$ = new GreaterEqualsInstruction('i'); }
                | GEF { $$ = new GreaterEqualsInstruction('f'); }
                | GT { $$ = new GreaterThanInstruction('i'); }
                | GTB { $$ = new GreaterThanInstruction('b'); }
                | GTI { $$ = new GreaterThanInstruction('i'); }
                | GTF { $$ = new GreaterThanInstruction('f'); }
                | LE { $$ = new LowerEqualsInstruction('i'); }
                | LEB { $$ = new LowerEqualsInstruction('b'); }
                | LEI { $$ = new LowerEqualsInstruction('i'); }
                | LEF { $$ = new LowerEqualsInstruction('f'); }
                | LT { $$ = new LowerThanInstruction('i'); }
                | LTB { $$ = new LowerThanInstruction('b'); }
                | LTI { $$ = new LowerThanInstruction('i'); }
                | LTF { $$ = new LowerThanInstruction('f'); }
                | NE { $$ = new NotEqualsInstruction('i'); }
                | NEB { $$ = new NotEqualsInstruction('b'); }
                | NEI { $$ = new NotEqualsInstruction('i'); }
                | NEF { $$ = new NotEqualsInstruction('f'); }
                ;

inout:          IN { $$ = new InInstruction('i'); }
                | INB { $$ = new InInstruction('b'); }
                | INI { $$ = new InInstruction('i'); }
                | INF { $$ = new InInstruction('f'); }
                | OUT { $$ = new OutInstruction('i'); }
                | OUTB { $$ = new OutInstruction('b'); }
                | OUTI { $$ = new OutInstruction('i'); }
                | OUTF { $$ = new OutInstruction('f'); }
                ;

jump:           JMP TAG { $$ = new JumpInstruction((String) $2); }
                | JNZ TAG { $$ = new NonZeroJumpInstruction((String) $2); }
                | JZ TAG { $$ = new ZeroJumpInstruction((String) $2); }
                ;

load:          LOAD { $$ = new LoadInstruction('i'); }
                | LOADB { $$ = new LoadInstruction('b'); }
                | LOADI { $$ = new LoadInstruction('i'); }
                | LOADF { $$ = new LoadInstruction('f'); }
                ;

logic:          AND { $$ = new LogicInstruction(LogicInstruction.Operation.AND); }
                | NOT { $$ = new LogicInstruction(LogicInstruction.Operation.NOT); }
                | OR { $$ = new LogicInstruction(LogicInstruction.Operation.OR); }
                ;

push:           PUSH BP { $$ = new PushInstruction(); }
                | PUSH INTEGER { $$ = new PushInstruction('i', (int) $2); }
                | PUSHA INTEGER { $$ = new PushInstruction('a', (int) $2); }
                | PUSHB INTEGER { $$ = new PushInstruction('b', (int) $2); }
                | PUSHI INTEGER { $$ = new PushInstruction('i', (int) $2); }
                | PUSHF FLOAT { $$ = new PushInstruction('f', (float) $2); }
                ;

store:          STORE { $$ = new StoreInstruction('i'); }
                | STOREB { $$ = new StoreInstruction('b'); }
                | STOREI { $$ = new StoreInstruction('i'); }
                | STOREF { $$ = new StoreInstruction('f'); }
                ;

%%

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