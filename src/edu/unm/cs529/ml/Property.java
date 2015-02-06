package edu.unm.cs529.ml;

public class Property {
	private String name = null;
	private String value = null;

	public Property(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}
}