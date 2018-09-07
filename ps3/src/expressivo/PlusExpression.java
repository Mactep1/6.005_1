package expressivo;

public class PlusExpression implements Expression{
	
	private final Expression e1;
	private final Expression e2;
	
	public PlusExpression(Expression e1,Expression e2) {
		this.e1=e1;
		this.e2=e2;
	}
	
	@Override
	public Expression addLeftExpression(Expression leftExpression) {
		return new PlusExpression(leftExpression,this);
	}
	@Override
	public Expression addRightExpression(Expression rightExpression) {
		return new PlusExpression(this,rightExpression);
	}
	
	@Override
	public Expression timesLeftExpression(Expression leftExpression) {
		return new TimesExpression(leftExpression, this);
	}
	
	@Override
	public Expression timesRightExpression(Expression rightExpression) {
		return new TimesExpression(this, rightExpression);
	}
}
