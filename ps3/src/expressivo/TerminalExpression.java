package expressivo;

public class TerminalExpression<E> implements Expression {

	private final E var;
	
	public TerminalExpression(E i) {
		this.var=i;
		
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
