package expressivo;

import org.hamcrest.core.IsInstanceOf;

public class FloatNumberExpression implements Expression {

	private final float var;
	
	public FloatNumberExpression(float i) {
		this.var=i;
		
	}
	
	private void checkRepo() {
		assert(var>0 || var==0);
	}
	
	public float getNumber() {
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
	
	@Override
	public String toString() {
		return String.valueOf(var);
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * 2.0 equals 2
	 * 2.1 equals 2.100
	 */
	@Override
	public boolean equals(Object o) {
		if(o instanceof FloatNumberExpression) {
			FloatNumberExpression a=(FloatNumberExpression) o;
			return Math.abs(var-a.getNumber())<0.000000001;
		}
		else if(o instanceof IntegerNumberExpression) {
			IntegerNumberExpression a=(IntegerNumberExpression) o;
			return Math.abs(var-a.getNumber())<0.000000001;
		}
		else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return Float.hashCode(var);
	}
}
