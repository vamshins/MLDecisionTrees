package edu.unm.cs529.ml;

public class DebtProperty extends AbstractProperty {
	public static final String DEBT = "Debt";
	public static final String HIGH = "high";
	public static final String LOW = "low";

	public DebtProperty(String value) {
		super(value);
	}

	public boolean isLegalValue(String value) {
		return (value.equals(HIGH) || value.equals(LOW));
	}

	public final String getName() {
		return DEBT;
	}
}