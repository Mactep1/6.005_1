// Generated from Expression.g4 by ANTLR 4.5.1

package expressivo.parser;
// Do not edit this .java file! Edit the grammar in Expression.g4 and re-run Antlr.

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpressionParser}.
 */
public interface ExpressionListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link ExpressionParser#root}.
   * @param ctx the parse tree
   */
  void enterRoot(ExpressionParser.RootContext ctx);
  /**
   * Exit a parse tree produced by {@link ExpressionParser#root}.
   * @param ctx the parse tree
   */
  void exitRoot(ExpressionParser.RootContext ctx);
  /**
   * Enter a parse tree produced by {@link ExpressionParser#expression}.
   * @param ctx the parse tree
   */
  void enterExpression(ExpressionParser.ExpressionContext ctx);
  /**
   * Exit a parse tree produced by {@link ExpressionParser#expression}.
   * @param ctx the parse tree
   */
  void exitExpression(ExpressionParser.ExpressionContext ctx);
  /**
   * Enter a parse tree produced by {@link ExpressionParser#primitive}.
   * @param ctx the parse tree
   */
  void enterPrimitive(ExpressionParser.PrimitiveContext ctx);
  /**
   * Exit a parse tree produced by {@link ExpressionParser#primitive}.
   * @param ctx the parse tree
   */
  void exitPrimitive(ExpressionParser.PrimitiveContext ctx);
  /**
   * Enter a parse tree produced by {@link ExpressionParser#numberstring1}.
   * @param ctx the parse tree
   */
  void enterNumberstring1(ExpressionParser.Numberstring1Context ctx);
  /**
   * Exit a parse tree produced by {@link ExpressionParser#numberstring1}.
   * @param ctx the parse tree
   */
  void exitNumberstring1(ExpressionParser.Numberstring1Context ctx);
  /**
   * Enter a parse tree produced by {@link ExpressionParser#number}.
   * @param ctx the parse tree
   */
  void enterNumber(ExpressionParser.NumberContext ctx);
  /**
   * Exit a parse tree produced by {@link ExpressionParser#number}.
   * @param ctx the parse tree
   */
  void exitNumber(ExpressionParser.NumberContext ctx);
  /**
   * Enter a parse tree produced by {@link ExpressionParser#string}.
   * @param ctx the parse tree
   */
  void enterString(ExpressionParser.StringContext ctx);
  /**
   * Exit a parse tree produced by {@link ExpressionParser#string}.
   * @param ctx the parse tree
   */
  void exitString(ExpressionParser.StringContext ctx);
}