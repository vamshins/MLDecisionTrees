package edu.unm.cs529.ml;

public class DebtProperty extends AbstractProperty {
	public static final String CLASS = "Class";
	public static final String PLUS = "+";
	public static final String MINUS = "-";

	public DebtProperty(String value) {
		super(value);
	}

	public boolean isLegalValue(String value) {
		return (value.equals(PLUS) || value.equals(MINUS));
	}

	public final String getName() {
		return CLASS;
	}
}