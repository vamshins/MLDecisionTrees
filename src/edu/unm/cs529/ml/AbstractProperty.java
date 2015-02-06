package edu.unm.cs529.ml;

public abstract class AbstractProperty {
	private String value = null;

	public AbstractProperty(String value) throws IllegalArgumentException {
		if (isLegalValue(value) == false)
			throw new IllegalArgumentException(value
					+ "is an illegal Property Value for " + getName());
		this.value = value;
	}

	public abstract boolean isLegalValue(String value);

	public abstract String getName();

	public final String getValue() {
		return value;
	}

	// Enforcing Immutable object pattern
	public final void setValue(String v) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	// Enforcing Immutable object pattern
	public final void setName(String n) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
}