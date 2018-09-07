package expressivo;

public class TimesExpression implements Expression {
	
	private final Expression e1;
	private final Expression e2;
	
	public TimesExpression(Expression e1,Expression e2) {
		this.e1=e1;
		this.e2=e2;
	}
	public Expression getLeftExpression() {
		return e1;//e1 is immutable,it's fine to return e1.same below
	}
	
	public Expression getRightExpression() {
		return e2;
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
	
	@Override
	public String toString() {
		return "("+e1.toString()+")"+"*"+"("+e2.toString()+")";
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * 2.0 equals 2
	 * 2.1 equals 2.100
	 */
	@Override
	public boolean equals(Object o) {
		if(o instanceof TimesExpression) {
			TimesExpression e=(TimesExpression) o;
			return (e.getLeftExpression().equals(e1) && e.getRightExpression().equals(e2));
			
		}
		else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return e1.hashCode()*e2.hashCode();
	}
}
