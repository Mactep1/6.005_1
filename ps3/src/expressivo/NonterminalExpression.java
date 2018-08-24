package expressivo;

public class NonterminalExpression implements Expression {

	private final Expression leftExpresion;
	private final Expression rigthExpression;
	private final String operator;
	
	public NonterminalExpression(Expression left,Expression right,String operator) {
		this.leftExpresion=left;
		this.rigthExpression=right;
		this.operator=operator;
	}
	
	@Override
	public Expression addLeftExpression(Expression leftExpression,String operator) {
		return new NonterminalExpression(leftExpression,this,operator);
	}
	@Override
	public Expression addRightExpression(Expression rightExpression,String operator) {
		return new NonterminalExpression(this,rightExpression,operator);
	}
}
