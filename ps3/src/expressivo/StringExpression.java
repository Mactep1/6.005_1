package expressivo;

public class StringExpression implements Expression{
	private final String s;
	
	public StringExpression(String s) {
		this.s=s;
	}
	
	public String getValue() {
		return s;
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
		return s;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof StringExpression) {
			StringExpression e=(StringExpression) o;
			return s.equals(e.getValue());
		}
		else {
			return false;
		}

	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 * convert int to float,then calculate the hashcode. in this way,make sure 2.hashcode() == 2.0.hashcode()
	 * 
	 */
	@Override
	public int hashCode() {
		return s.hashCode();
	}
}
