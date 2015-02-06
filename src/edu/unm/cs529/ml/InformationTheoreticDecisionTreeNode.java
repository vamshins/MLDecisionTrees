package edu.unm.cs529.ml;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class InformationTheoreticDecisionTreeNode extends
		AbstractDecisionTreeNode {
	public InformationTheoreticDecisionTreeNode(ExampleSet examples)
			throws IllegalArgumentException {
		super(examples);
	}

	public InformationTheoreticDecisionTreeNode(ExampleSet examples,
			Set<String> selectionProperties) throws IllegalArgumentException {
		super(examples, selectionProperties);
	}

	protected AbstractDecisionTreeNode createChildNode(ExampleSet examples,
			Set<String> selectionProperties) throws IllegalArgumentException {
		return new InformationTheoreticDecisionTreeNode(examples,
				selectionProperties);
	}

	protected double evaluatePartitionQuality(HashMap<String, ExampleSet> part,
			ExampleSet examples) throws IllegalArgumentException {
		double examplesInfo = computeInformation(examples);
		int totalSize = examples.getSize();
		double expectedInfo = 0.0;
		Iterator<String> iter = part.keySet().iterator();
		while (iter.hasNext()) {
			ExampleSet ex = part.get(iter.next());
			int partSize = ex.getSize();
			expectedInfo += computeInformation(ex) * partSize / totalSize;
		}
		return examplesInfo - expectedInfo;
	}

	private double computeInformation(ExampleSet examples)
			throws IllegalArgumentException {
		Set<String> categories = examples.getCategories();
		double info = 0.0;
		double totalCount = examples.getSize();
		Iterator<String> iter = categories.iterator();
		while (iter.hasNext()) {
			String cat = iter.next();
			double catCount = examples.getExampleCountByCategory(cat);
			info += -(catCount / totalCount) * log2(catCount / totalCount);
		}
		return info;
	}

	private double log2(double a) {
		return Math.log10(a) / Math.log10(2);
	}
}