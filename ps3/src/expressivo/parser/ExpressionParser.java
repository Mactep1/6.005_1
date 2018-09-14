// Generated from Expression.g4 by ANTLR 4.5.1

package expressivo.parser;
// Do not edit this .java file! Edit the grammar in Expression.g4 and re-run Antlr.

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpressionParser extends Parser {
  static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache =
    new PredictionContextCache();
  public static final int
    T__0=1, T__1=2, NUMBER=3, STRING=4, OPERATOR=5, SPACES=6;
  public static final int
    RULE_root = 0, RULE_expression = 1, RULE_primitive = 2, RULE_numberstring1 = 3, 
    RULE_number = 4, RULE_string = 5;
  public static final String[] ruleNames = {
    "root", "expression", "primitive", "numberstring1", "number", "string"
  };

  private static final String[] _LITERAL_NAMES = {
    null, "'('", "')'"
  };
  private static final String[] _SYMBOLIC_NAMES = {
    null, null, null, "NUMBER", "STRING", "OPERATOR", "SPACES"
  };
  public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

  /**
   * @deprecated Use {@link #VOCABULARY} instead.
   */
  @Deprecated
  public static final String[] tokenNames;
  static {
    tokenNames = new String[_SYMBOLIC_NAMES.length];
    for (int i = 0; i < tokenNames.length; i++) {
      tokenNames[i] = VOCABULARY.getLiteralName(i);
      if (tokenNames[i] == null) {
        tokenNames[i] = VOCABULARY.getSymbolicName(i);
      }

      if (tokenNames[i] == null) {
        tokenNames[i] = "<INVALID>";
      }
    }
  }

  @Override
  @Deprecated
  public String[] getTokenNames() {
    return tokenNames;
  }

  @Override

  public Vocabulary getVocabulary() {
    return VOCABULARY;
  }

  @Override
  public String getGrammarFileName() { return "Expression.g4"; }

  @Override
  public String[] getRuleNames() { return ruleNames; }

  @Override
  public String getSerializedATN() { return _serializedATN; }

  @Override
  public ATN getATN() { return _ATN; }


      // This method makes the lexer or parser stop running if it encounters
      // invalid input and throw a ParseCancellationException.
      public void reportErrorsAsExceptions() {
          // To prevent any reports to standard error, add this line:
          //removeErrorListeners();
          
          addErrorListener(new BaseErrorListener() {
              public void syntaxError(Recognizer<?, ?> recognizer,
                                      Object offendingSymbol,
                                      int line, int charPositionInLine,
                                      String msg, RecognitionException e) {
                  throw new ParseCancellationException(msg, e);
              }
          });
      }

  public ExpressionParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
  }
  public static class RootContext extends ParserRuleContext {
    public ExpressionContext expression() {
      return getRuleContext(ExpressionContext.class,0);
    }
    public TerminalNode EOF() { return getToken(ExpressionParser.EOF, 0); }
    public RootContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_root; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterRoot(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitRoot(this);
    }
  }

  public final RootContext root() throws RecognitionException {
    RootContext _localctx = new RootContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_root);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(12);
      expression(0);
      setState(13);
      match(EOF);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class ExpressionContext extends ParserRuleContext {
    public PrimitiveContext primitive() {
      return getRuleContext(PrimitiveContext.class,0);
    }
    public List<ExpressionContext> expression() {
      return getRuleContexts(ExpressionContext.class);
    }
    public ExpressionContext expression(int i) {
      return getRuleContext(ExpressionContext.class,i);
    }
    public TerminalNode OPERATOR() { return getToken(ExpressionParser.OPERATOR, 0); }
    public ExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_expression; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterExpression(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitExpression(this);
    }
  }

  public final ExpressionContext expression() throws RecognitionException {
    return expression(0);
  }

  private ExpressionContext expression(int _p) throws RecognitionException {
    ParserRuleContext _parentctx = _ctx;
    int _parentState = getState();
    ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
    ExpressionContext _prevctx = _localctx;
    int _startState = 2;
    enterRecursionRule(_localctx, 2, RULE_expression, _p);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
      setState(23);
      switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
      case 1:
        {
        setState(16);
        primitive();
        }
        break;
      case 2:
        {
        {
        setState(17);
        match(T__0);
        setState(18);
        expression(0);
        setState(19);
        match(OPERATOR);
        setState(20);
        expression(0);
        setState(21);
        match(T__1);
        }
        }
        break;
      }
      _ctx.stop = _input.LT(-1);
      setState(30);
      _errHandler.sync(this);
      _alt = getInterpreter().adaptivePredict(_input,1,_ctx);
      while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
        if ( _alt==1 ) {
          if ( _parseListeners!=null ) triggerExitRuleEvent();
          _prevctx = _localctx;
          {
          {
          _localctx = new ExpressionContext(_parentctx, _parentState);
          pushNewRecursionContext(_localctx, _startState, RULE_expression);
          setState(25);
          if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
          setState(26);
          match(OPERATOR);
          setState(27);
          expression(3);
          }
          } 
        }
        setState(32);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input,1,_ctx);
      }
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      unrollRecursionContexts(_parentctx);
    }
    return _localctx;
  }

  public static class PrimitiveContext extends ParserRuleContext {
    public Numberstring1Context numberstring1() {
      return getRuleContext(Numberstring1Context.class,0);
    }
    public PrimitiveContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_primitive; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterPrimitive(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitPrimitive(this);
    }
  }

  public final PrimitiveContext primitive() throws RecognitionException {
    PrimitiveContext _localctx = new PrimitiveContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_primitive);
    try {
      setState(38);
      switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
      case 1:
        enterOuterAlt(_localctx, 1);
        {
        setState(33);
        numberstring1();
        }
        break;
      case 2:
        enterOuterAlt(_localctx, 2);
        {
        {
        setState(34);
        match(T__0);
        setState(35);
        numberstring1();
        setState(36);
        match(T__1);
        }
        }
        break;
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class Numberstring1Context extends ParserRuleContext {
    public NumberContext number() {
      return getRuleContext(NumberContext.class,0);
    }
    public StringContext string() {
      return getRuleContext(StringContext.class,0);
    }
    public Numberstring1Context(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_numberstring1; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterNumberstring1(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitNumberstring1(this);
    }
  }

  public final Numberstring1Context numberstring1() throws RecognitionException {
    Numberstring1Context _localctx = new Numberstring1Context(_ctx, getState());
    enterRule(_localctx, 6, RULE_numberstring1);
    try {
      setState(42);
      switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
      case 1:
        enterOuterAlt(_localctx, 1);
        {
        setState(40);
        number();
        }
        break;
      case 2:
        enterOuterAlt(_localctx, 2);
        {
        setState(41);
        string();
        }
        break;
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class NumberContext extends ParserRuleContext {
    public TerminalNode NUMBER() { return getToken(ExpressionParser.NUMBER, 0); }
    public NumberContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_number; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterNumber(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitNumber(this);
    }
  }

  public final NumberContext number() throws RecognitionException {
    NumberContext _localctx = new NumberContext(_ctx, getState());
    enterRule(_localctx, 8, RULE_number);
    try {
      setState(48);
      switch (_input.LA(1)) {
      case NUMBER:
        enterOuterAlt(_localctx, 1);
        {
        setState(44);
        match(NUMBER);
        }
        break;
      case T__0:
        enterOuterAlt(_localctx, 2);
        {
        setState(45);
        match(T__0);
        setState(46);
        match(NUMBER);
        setState(47);
        match(T__1);
        }
        break;
      default:
        throw new NoViableAltException(this);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class StringContext extends ParserRuleContext {
    public TerminalNode STRING() { return getToken(ExpressionParser.STRING, 0); }
    public StringContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_string; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterString(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitString(this);
    }
  }

  public final StringContext string() throws RecognitionException {
    StringContext _localctx = new StringContext(_ctx, getState());
    enterRule(_localctx, 10, RULE_string);
    try {
      setState(54);
      switch (_input.LA(1)) {
      case STRING:
        enterOuterAlt(_localctx, 1);
        {
        setState(50);
        match(STRING);
        }
        break;
      case T__0:
        enterOuterAlt(_localctx, 2);
        {
        setState(51);
        match(T__0);
        setState(52);
        match(STRING);
        setState(53);
        match(T__1);
        }
        break;
      default:
        throw new NoViableAltException(this);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
    switch (ruleIndex) {
    case 1:
      return expression_sempred((ExpressionContext)_localctx, predIndex);
    }
    return true;
  }
  private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
    switch (predIndex) {
    case 0:
      return precpred(_ctx, 2);
    }
    return true;
  }

  public static final String _serializedATN =
    "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\b;\4\2\t\2\4\3"+
      "\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
      "\3\3\3\3\3\3\3\5\3\32\n\3\3\3\3\3\3\3\7\3\37\n\3\f\3\16\3\"\13\3\3"+
      "\4\3\4\3\4\3\4\3\4\5\4)\n\4\3\5\3\5\5\5-\n\5\3\6\3\6\3\6\3\6\5\6\63"+
      "\n\6\3\7\3\7\3\7\3\7\5\79\n\7\3\7\2\3\4\b\2\4\6\b\n\f\2\2:\2\16\3"+
      "\2\2\2\4\31\3\2\2\2\6(\3\2\2\2\b,\3\2\2\2\n\62\3\2\2\2\f8\3\2\2\2"+
      "\16\17\5\4\3\2\17\20\7\2\2\3\20\3\3\2\2\2\21\22\b\3\1\2\22\32\5\6"+
      "\4\2\23\24\7\3\2\2\24\25\5\4\3\2\25\26\7\7\2\2\26\27\5\4\3\2\27\30"+
      "\7\4\2\2\30\32\3\2\2\2\31\21\3\2\2\2\31\23\3\2\2\2\32 \3\2\2\2\33"+
      "\34\f\4\2\2\34\35\7\7\2\2\35\37\5\4\3\5\36\33\3\2\2\2\37\"\3\2\2\2"+
      " \36\3\2\2\2 !\3\2\2\2!\5\3\2\2\2\" \3\2\2\2#)\5\b\5\2$%\7\3\2\2%"+
      "&\5\b\5\2&\'\7\4\2\2\')\3\2\2\2(#\3\2\2\2($\3\2\2\2)\7\3\2\2\2*-\5"+
      "\n\6\2+-\5\f\7\2,*\3\2\2\2,+\3\2\2\2-\t\3\2\2\2.\63\7\5\2\2/\60\7"+
      "\3\2\2\60\61\7\5\2\2\61\63\7\4\2\2\62.\3\2\2\2\62/\3\2\2\2\63\13\3"+
      "\2\2\2\649\7\6\2\2\65\66\7\3\2\2\66\67\7\6\2\2\679\7\4\2\28\64\3\2"+
      "\2\28\65\3\2\2\29\r\3\2\2\2\b\31 (,\628";
  public static final ATN _ATN =
    new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}