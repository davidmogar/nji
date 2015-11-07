/* The following code was generated by JFlex 1.4.1 on 11/7/15 11:35 PM */

package com.davidmogar.nji.lexicon;

import com.davidmogar.nji.syntactic.Parser;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.1
 * on 11/7/15 11:35 PM from the specification file
 * <tt>../src/com/davidmogar/nji/lexicon/lexicon.flex</tt>
 */
public class Lexicon {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\23\1\2\1\0\1\23\1\3\22\0\1\23\1\0\1\22"+
    "\1\5\3\0\1\1\4\0\1\23\1\17\1\20\1\0\2\4\1\35"+
    "\7\4\1\23\46\0\1\27\1\24\1\16\1\31\1\11\1\30\1\37"+
    "\1\26\1\7\1\40\1\21\1\6\1\34\1\10\1\13\1\25\1\36"+
    "\1\15\1\12\1\32\1\14\1\33\3\21\1\41\uff85\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\3\2\1\3\1\1\11\4\2\1\1\2"+
    "\11\4\3\0\1\5\1\4\1\6\1\7\2\4\1\10"+
    "\1\4\1\11\3\4\1\12\2\4\1\0\1\13\1\14"+
    "\11\4\1\15\1\16\2\4\1\17\1\20\2\0\1\21"+
    "\1\22\1\23\1\4\1\24\1\25\1\26\1\27\1\30"+
    "\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\4"+
    "\1\40\1\41\1\42\1\43\1\4\1\44\1\45\1\46"+
    "\1\47\1\50\1\4\1\51\2\4\1\52\1\53\1\54"+
    "\1\55\1\56\1\57\1\60\1\61\1\62\1\63\1\64"+
    "\1\65\1\66\1\67\2\0\1\70\1\71\1\72\1\73"+
    "\1\4\1\74\1\75\1\76\1\4\1\77\1\100\1\101"+
    "\1\102\1\103\1\104\1\105\1\106\1\107\1\110\1\111"+
    "\1\112\1\113\1\114\1\115\1\116\1\117\1\120\1\121"+
    "\1\122\1\123\1\0\1\124\1\125\1\126\1\127\1\130"+
    "\1\131\1\132\1\133\1\134\1\135\1\136\1\137";

  private static int [] zzUnpackAction() {
    int [] result = new int[156];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\42\0\104\0\146\0\210\0\252\0\314\0\356"+
    "\0\u0110\0\u0132\0\u0154\0\u0176\0\u0198\0\u01ba\0\u01dc\0\u01fe"+
    "\0\u0220\0\u0242\0\42\0\u0264\0\u0286\0\u02a8\0\u02ca\0\u02ec"+
    "\0\u030e\0\u0330\0\u0352\0\u0374\0\u0396\0\u03b8\0\u03da\0\u03fc"+
    "\0\u041e\0\u0440\0\u0462\0\u0484\0\u04a6\0\u04c8\0\u04ea\0\u050c"+
    "\0\u052e\0\u0550\0\u0572\0\u0594\0\u05b6\0\u05d8\0\u0242\0\42"+
    "\0\u01ba\0\u05fa\0\u061c\0\u063e\0\u0660\0\u0682\0\u06a4\0\u06c6"+
    "\0\u06e8\0\u070a\0\u072c\0\u074e\0\u0770\0\u0792\0\u01ba\0\u0396"+
    "\0\u07b4\0\u07d6\0\u01ba\0\u01ba\0\u01ba\0\u07f8\0\u01ba\0\u01ba"+
    "\0\u01ba\0\u01ba\0\u01ba\0\u01ba\0\u01ba\0\u01ba\0\u081a\0\u01ba"+
    "\0\u01ba\0\u01ba\0\u083c\0\u01ba\0\u01ba\0\u01ba\0\u085e\0\u0880"+
    "\0\u08a2\0\u01ba\0\u01ba\0\u01ba\0\u01ba\0\u08c4\0\u01ba\0\u08e6"+
    "\0\u0908\0\u092a\0\u094c\0\u01ba\0\u096e\0\u0990\0\u09b2\0\u01ba"+
    "\0\u01ba\0\u01ba\0\u01ba\0\u01ba\0\u01ba\0\u01ba\0\u01ba\0\u09d4"+
    "\0\u09f6\0\u0a18\0\u01ba\0\u01ba\0\u01ba\0\u0a3a\0\u01ba\0\u01ba"+
    "\0\u01ba\0\u0a5c\0\u01ba\0\u01ba\0\u01ba\0\u01ba\0\u0a7e\0\u01ba"+
    "\0\u01ba\0\u01ba\0\u01ba\0\u01ba\0\u01ba\0\u01ba\0\u01ba\0\u01ba"+
    "\0\u01ba\0\u01ba\0\u01ba\0\u01ba\0\u01ba\0\u01ba\0\u01ba\0\u0aa0"+
    "\0\u01ba\0\u01ba\0\u01ba\0\u01ba\0\u0ac2\0\u01ba\0\u01ba\0\u01ba"+
    "\0\u01ba\0\u01ba\0\u01ba\0\u01ba";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[156];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21"+
    "\1\2\1\16\1\22\1\23\1\24\1\25\1\26\1\27"+
    "\1\30\1\31\2\16\1\32\1\6\1\16\1\33\1\34"+
    "\1\16\42\0\2\3\1\0\37\3\3\0\1\23\40\0"+
    "\1\23\43\0\1\6\13\0\1\35\14\0\1\6\12\0"+
    "\1\36\3\0\1\37\33\0\1\16\1\0\3\16\1\40"+
    "\1\16\1\41\3\16\2\0\1\16\2\0\6\16\1\42"+
    "\7\16\4\0\1\16\1\0\2\16\1\43\6\16\2\0"+
    "\1\16\2\0\11\16\1\44\4\16\4\0\1\16\1\0"+
    "\5\16\1\45\3\16\2\0\1\16\2\0\6\16\1\46"+
    "\7\16\4\0\1\16\1\0\2\16\1\47\6\16\2\0"+
    "\1\16\2\0\12\16\1\50\3\16\4\0\1\16\1\0"+
    "\6\16\1\51\2\16\2\0\1\16\2\0\6\16\1\52"+
    "\7\16\4\0\1\16\1\0\6\16\1\53\1\54\1\16"+
    "\2\0\1\16\2\0\16\16\4\0\1\16\1\0\11\16"+
    "\2\0\1\16\2\0\16\16\4\0\1\16\1\0\3\16"+
    "\1\55\5\16\2\0\1\16\2\0\16\16\4\0\1\16"+
    "\1\0\11\16\2\0\1\16\2\0\3\16\1\56\12\16"+
    "\4\0\1\6\30\0\1\6\4\0\22\57\1\60\17\57"+
    "\4\0\1\16\1\0\11\16\2\0\1\16\2\0\1\16"+
    "\1\61\7\16\1\62\4\16\4\0\1\16\1\0\6\16"+
    "\1\63\2\16\2\0\1\16\2\0\16\16\4\0\1\16"+
    "\1\0\11\16\2\0\1\16\2\0\3\16\1\64\12\16"+
    "\4\0\1\16\1\0\2\16\1\65\6\16\2\0\1\16"+
    "\2\0\5\16\1\66\10\16\4\0\1\16\1\0\11\16"+
    "\2\0\1\16\2\0\11\16\1\67\4\16\4\0\1\16"+
    "\1\0\1\16\1\70\7\16\2\0\1\16\2\0\16\16"+
    "\4\0\1\16\1\0\5\16\1\71\1\72\2\16\2\0"+
    "\1\16\2\0\16\16\4\0\1\16\1\0\3\16\1\73"+
    "\5\16\2\0\1\16\2\0\6\16\1\74\7\16\4\0"+
    "\1\16\1\0\2\16\1\75\6\16\2\0\1\16\2\0"+
    "\10\16\1\76\4\16\1\77\4\0\1\100\30\0\1\100"+
    "\13\0\1\101\45\0\1\102\32\0\1\16\1\0\1\16"+
    "\1\103\7\16\2\0\1\16\2\0\1\104\3\16\1\105"+
    "\11\16\4\0\1\16\1\0\11\16\2\0\1\16\2\0"+
    "\3\16\1\106\12\16\4\0\1\16\1\0\1\16\1\107"+
    "\7\16\2\0\1\16\2\0\1\110\3\16\1\111\11\16"+
    "\4\0\1\16\1\0\1\16\1\112\7\16\2\0\1\16"+
    "\2\0\1\113\3\16\1\114\11\16\4\0\1\16\1\0"+
    "\11\16\2\0\1\16\2\0\1\115\3\16\1\116\11\16"+
    "\4\0\1\16\1\0\11\16\2\0\1\16\2\0\6\16"+
    "\1\117\7\16\4\0\1\16\1\0\1\16\1\120\7\16"+
    "\2\0\1\16\2\0\1\121\3\16\1\122\11\16\4\0"+
    "\1\16\1\0\11\16\2\0\1\16\2\0\6\16\1\123"+
    "\7\16\4\0\1\16\1\0\1\16\1\124\7\16\2\0"+
    "\1\16\2\0\1\125\3\16\1\126\11\16\4\0\1\16"+
    "\1\0\11\16\2\0\1\16\2\0\1\127\15\16\4\0"+
    "\1\16\1\0\5\16\1\130\3\16\2\0\1\16\2\0"+
    "\16\16\4\0\1\16\1\0\11\16\2\0\1\16\2\0"+
    "\6\16\1\131\7\16\4\0\1\16\1\0\1\16\1\132"+
    "\7\16\2\0\1\16\2\0\1\133\3\16\1\134\11\16"+
    "\4\0\1\16\1\0\11\16\2\0\1\16\2\0\6\16"+
    "\1\135\7\16\4\0\1\16\1\0\1\136\10\16\2\0"+
    "\1\16\2\0\16\16\4\0\1\16\1\0\1\16\1\137"+
    "\7\16\2\0\1\16\2\0\16\16\4\0\1\16\1\0"+
    "\4\16\1\140\4\16\2\0\1\16\2\0\16\16\4\0"+
    "\1\16\1\0\1\141\10\16\2\0\1\16\2\0\16\16"+
    "\4\0\1\16\1\0\11\16\2\0\1\16\2\0\5\16"+
    "\1\142\10\16\4\0\1\16\1\0\11\16\2\0\1\16"+
    "\2\0\5\16\1\143\10\16\4\0\1\16\1\0\1\16"+
    "\1\144\7\16\2\0\1\16\2\0\16\16\4\0\1\16"+
    "\1\0\11\16\2\0\1\16\2\0\7\16\1\145\6\16"+
    "\4\0\1\16\1\0\11\16\2\0\1\16\2\0\5\16"+
    "\1\146\10\16\4\0\1\16\1\0\1\147\10\16\2\0"+
    "\1\16\2\0\16\16\4\0\1\16\1\0\1\16\1\150"+
    "\7\16\2\0\1\16\2\0\1\151\3\16\1\152\11\16"+
    "\4\0\1\16\1\0\1\16\1\153\7\16\2\0\1\16"+
    "\2\0\1\154\3\16\1\155\11\16\4\0\1\16\1\0"+
    "\11\16\2\0\1\16\2\0\15\16\1\156\4\0\1\16"+
    "\1\0\11\16\2\0\1\16\2\0\1\16\1\157\14\16"+
    "\10\0\1\160\45\0\1\161\31\0\1\16\1\0\11\16"+
    "\2\0\1\16\2\0\5\16\1\162\10\16\4\0\1\16"+
    "\1\0\1\16\1\163\7\16\2\0\1\16\2\0\1\164"+
    "\3\16\1\165\11\16\4\0\1\16\1\0\3\16\1\166"+
    "\5\16\2\0\1\16\2\0\16\16\4\0\1\16\1\0"+
    "\1\16\1\167\7\16\2\0\1\16\2\0\1\170\3\16"+
    "\1\171\11\16\4\0\1\16\1\0\7\16\1\172\1\16"+
    "\2\0\1\16\2\0\16\16\4\0\1\16\1\0\1\16"+
    "\1\173\7\16\2\0\1\16\2\0\1\174\3\16\1\175"+
    "\11\16\4\0\1\16\1\0\1\176\10\16\2\0\1\16"+
    "\2\0\16\16\4\0\1\16\1\0\11\16\2\0\1\16"+
    "\2\0\2\16\1\177\13\16\4\0\1\16\1\0\11\16"+
    "\2\0\1\16\2\0\6\16\1\200\7\16\4\0\1\16"+
    "\1\0\1\16\1\201\7\16\2\0\1\16\2\0\1\202"+
    "\3\16\1\203\11\16\4\0\1\16\1\0\1\16\1\204"+
    "\7\16\2\0\1\16\2\0\1\205\3\16\1\206\11\16"+
    "\4\0\1\16\1\0\1\16\1\207\7\16\2\0\1\16"+
    "\2\0\1\210\3\16\1\211\11\16\4\0\1\16\1\0"+
    "\1\16\1\212\7\16\2\0\1\16\2\0\1\213\3\16"+
    "\1\214\11\16\4\0\1\16\1\0\1\16\1\215\7\16"+
    "\2\0\1\16\2\0\1\216\3\16\1\217\11\16\11\0"+
    "\1\3\45\0\1\220\30\0\1\16\1\0\1\16\1\221"+
    "\7\16\2\0\1\16\2\0\1\222\3\16\1\223\11\16"+
    "\4\0\1\16\1\0\7\16\1\224\1\16\2\0\1\16"+
    "\2\0\16\16\4\0\1\16\1\0\3\16\1\225\5\16"+
    "\2\0\1\16\2\0\16\16\4\0\1\16\1\0\1\16"+
    "\1\226\7\16\2\0\1\16\2\0\1\227\2\16\1\230"+
    "\1\231\11\16\16\0\1\160\27\0\1\16\1\0\1\16"+
    "\1\232\7\16\2\0\1\16\2\0\1\233\3\16\1\234"+
    "\11\16";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2788];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\20\1\1\11\11\1\3\0\17\1\1\0"+
    "\1\11\20\1\2\0\55\1\2\0\36\1\1\0\14\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[156];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */

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



  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexicon(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public Lexicon(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 96) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzPushbackPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead < 0) {
      return true;
    }
    else {
      zzEndRead+= numRead;
      return false;
    }
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = zzPushbackPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public int yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = zzLexicalState;


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 34: 
          { matchedValue = yytext(); return Parser.EQF;
          }
        case 96: break;
        case 12: 
          { matchedValue = yytext(); return Parser.BP;
          }
        case 97: break;
        case 16: 
          { matchedValue = Float.parseFloat(yytext()); return Parser.FLOAT;
          }
        case 98: break;
        case 28: 
          { matchedValue = yytext(); return Parser.NOT;
          }
        case 99: break;
        case 6: 
          { matchedValue = yytext(); return Parser.LT;
          }
        case 100: break;
        case 17: 
          { matchedValue = yytext(); return Parser.LEI;
          }
        case 101: break;
        case 27: 
          { matchedValue = yytext(); return Parser.I2F;
          }
        case 102: break;
        case 49: 
          { matchedValue = yytext(); return Parser.GEB;
          }
        case 103: break;
        case 22: 
          { matchedValue = yytext(); return Parser.LTF;
          }
        case 104: break;
        case 81: 
          { matchedValue = yytext(); return Parser.MULI;
          }
        case 105: break;
        case 7: 
          { matchedValue = yytext(); return Parser.IN;
          }
        case 106: break;
        case 47: 
          { matchedValue = yytext(); return Parser.MUL;
          }
        case 107: break;
        case 15: 
          { matchedValue = yytext(); return Parser.JZ;
          }
        case 108: break;
        case 29: 
          { matchedValue = yytext(); return Parser.NEI;
          }
        case 109: break;
        case 88: 
          { matchedValue = yytext(); return Parser.STORE;
          }
        case 110: break;
        case 75: 
          { matchedValue = yytext(); return Parser.DIVI;
          }
        case 111: break;
        case 72: 
          { matchedValue = yytext(); return Parser.ADDI;
          }
        case 112: break;
        case 14: 
          { matchedValue = yytext(); return Parser.GT;
          }
        case 113: break;
        case 78: 
          { matchedValue = yytext(); return Parser.MODI;
          }
        case 114: break;
        case 25: 
          { matchedValue = yytext(); return Parser.INF;
          }
        case 115: break;
        case 18: 
          { matchedValue = yytext(); return Parser.LEB;
          }
        case 116: break;
        case 39: 
          { matchedValue = yytext(); return Parser.ORF;
          }
        case 117: break;
        case 82: 
          { matchedValue = yytext(); return Parser.MULB;
          }
        case 118: break;
        case 30: 
          { matchedValue = yytext(); return Parser.NEB;
          }
        case 119: break;
        case 10: 
          { matchedValue = yytext(); return Parser.OR;
          }
        case 120: break;
        case 89: 
          { matchedValue = yytext(); return Parser.PUSHI;
          }
        case 121: break;
        case 60: 
          { matchedValue = yytext(); return Parser.SUBI;
          }
        case 122: break;
        case 56: 
          { matchedValue = yytext(); return Parser.LOAD;
          }
        case 123: break;
        case 76: 
          { matchedValue = yytext(); return Parser.DIVB;
          }
        case 124: break;
        case 73: 
          { matchedValue = yytext(); return Parser.ADDB;
          }
        case 125: break;
        case 42: 
          { matchedValue = yytext(); return Parser.AND;
          }
        case 126: break;
        case 79: 
          { matchedValue = yytext(); return Parser.MODB;
          }
        case 127: break;
        case 8: 
          { matchedValue = yytext(); return Parser.NE;
          }
        case 128: break;
        case 41: 
          { matchedValue = yytext(); return Parser.B2I;
          }
        case 129: break;
        case 90: 
          { matchedValue = yytext(); return Parser.PUSHB;
          }
        case 130: break;
        case 61: 
          { matchedValue = yytext(); return Parser.SUBB;
          }
        case 131: break;
        case 50: 
          { matchedValue = yytext(); return Parser.GEF;
          }
        case 132: break;
        case 69: 
          { matchedValue = yytext(); return Parser.ANDI;
          }
        case 133: break;
        case 84: 
          { matchedValue = yytext(); return Parser.LOADI;
          }
        case 134: break;
        case 40: 
          { matchedValue = yytext(); return Parser.RET;
          }
        case 135: break;
        case 93: 
          { matchedValue = yytext(); return Parser.STOREI;
          }
        case 136: break;
        case 5: 
          { matchedValue = yytext(); return Parser.LE;
          }
        case 137: break;
        case 51: 
          { matchedValue = yytext(); return Parser.GTI;
          }
        case 138: break;
        case 63: 
          { matchedValue = yytext(); return Parser.OUTI;
          }
        case 139: break;
        case 67: 
          { matchedValue = yytext(); return Parser.PUSH;
          }
        case 140: break;
        case 57: 
          { matchedValue = yytext(); return Parser.NOTI;
          }
        case 141: break;
        case 32: 
          { matchedValue = yytext(); return Parser.EQI;
          }
        case 142: break;
        case 44: 
          { matchedValue = yytext(); return Parser.F2I;
          }
        case 143: break;
        case 1: 
          { System.out.println("Character \'" + yycharat(0) + "' unknown.");
          }
        case 144: break;
        case 19: 
          { matchedValue = yytext(); return Parser.LEF;
          }
        case 145: break;
        case 70: 
          { matchedValue = yytext(); return Parser.ANDB;
          }
        case 146: break;
        case 85: 
          { matchedValue = yytext(); return Parser.LOADB;
          }
        case 147: break;
        case 91: 
          { matchedValue = yytext(); return Parser.PUSHA;
          }
        case 148: break;
        case 83: 
          { matchedValue = yytext(); return Parser.MULF;
          }
        case 149: break;
        case 46: 
          { matchedValue = yytext(); return Parser.MOD;
          }
        case 150: break;
        case 20: 
          { matchedValue = yytext(); return Parser.LTI;
          }
        case 151: break;
        case 94: 
          { matchedValue = yytext(); return Parser.STOREB;
          }
        case 152: break;
        case 52: 
          { matchedValue = yytext(); return Parser.GTB;
          }
        case 153: break;
        case 31: 
          { matchedValue = yytext(); return Parser.NEF;
          }
        case 154: break;
        case 64: 
          { matchedValue = yytext(); return Parser.OUTB;
          }
        case 155: break;
        case 45: 
          { matchedValue = yytext(); return Parser.DIV;
          }
        case 156: break;
        case 43: 
          { matchedValue = yytext(); return Parser.ADD;
          }
        case 157: break;
        case 13: 
          { matchedValue = yytext(); return Parser.GE;
          }
        case 158: break;
        case 55: 
          { matchedValue = yytext(); return Parser.JMP;
          }
        case 159: break;
        case 58: 
          { matchedValue = yytext(); return Parser.NOTB;
          }
        case 160: break;
        case 87: 
          { matchedValue = yytext(); return Parser.ENTER;
          }
        case 161: break;
        case 33: 
          { matchedValue = yytext(); return Parser.EQB;
          }
        case 162: break;
        case 77: 
          { matchedValue = yytext(); return Parser.DIVF;
          }
        case 163: break;
        case 74: 
          { matchedValue = yytext(); return Parser.ADDF;
          }
        case 164: break;
        case 80: 
          { matchedValue = yytext(); return Parser.MODF;
          }
        case 165: break;
        case 23: 
          { matchedValue = yytext(); return Parser.INI;
          }
        case 166: break;
        case 26: 
          { matchedValue = yytext(); return Parser.I2B;
          }
        case 167: break;
        case 4: 
          { matchedValue = yytext(); return Parser.TAG;
          }
        case 168: break;
        case 21: 
          { matchedValue = yytext(); return Parser.LTB;
          }
        case 169: break;
        case 68: 
          { matchedValue = yytext(); return Parser.HALT;
          }
        case 170: break;
        case 37: 
          { matchedValue = yytext(); return Parser.ORI;
          }
        case 171: break;
        case 9: 
          { matchedValue = yytext(); return Parser.EQ;
          }
        case 172: break;
        case 3: 
          { matchedValue = Integer.parseInt(yytext()); return Parser.INTEGER;
          }
        case 173: break;
        case 92: 
          { matchedValue = yytext(); return Parser.PUSHF;
          }
        case 174: break;
        case 62: 
          { matchedValue = yytext(); return Parser.SUBF;
          }
        case 175: break;
        case 24: 
          { matchedValue = yytext(); return Parser.INB;
          }
        case 176: break;
        case 36: 
          { matchedValue = yytext(); return Parser.OUT;
          }
        case 177: break;
        case 38: 
          { matchedValue = yytext(); return Parser.ORB;
          }
        case 178: break;
        case 35: 
          { matchedValue = yytext(); return Parser.SUB;
          }
        case 179: break;
        case 71: 
          { matchedValue = yytext(); return Parser.ANDF;
          }
        case 180: break;
        case 86: 
          { matchedValue = yytext(); return Parser.LOADF;
          }
        case 181: break;
        case 11: 
          { matchedValue = Float.parseFloat(yytext()); return Parser.STRING;
          }
        case 182: break;
        case 48: 
          { matchedValue = yytext(); return Parser.GEI;
          }
        case 183: break;
        case 95: 
          { matchedValue = yytext(); return Parser.STOREF;
          }
        case 184: break;
        case 53: 
          { matchedValue = yytext(); return Parser.GTF;
          }
        case 185: break;
        case 65: 
          { matchedValue = yytext(); return Parser.OUTF;
          }
        case 186: break;
        case 54: 
          { matchedValue = yytext(); return Parser.JNZ;
          }
        case 187: break;
        case 66: 
          { matchedValue = yytext(); return Parser.CALL;
          }
        case 188: break;
        case 2: 
          { 
          }
        case 189: break;
        case 59: 
          { matchedValue = yytext(); return Parser.NOTF;
          }
        case 190: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return 0; }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}