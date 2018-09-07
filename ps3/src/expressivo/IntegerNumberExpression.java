package expressivo;

public class IntegerNumberExpression implements Expression{
	private final int var;
	
	public IntegerNumberExpression(int i) {
		this.var=i;
		
	}
	
	private void checkRepo() {
		assert(var>0 || var==0);
	}
	
	public int getNumber() {
		return var;                                                                                                                                           
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
