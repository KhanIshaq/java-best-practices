package chapter5;

import java.util.Collection;

public class Chooser2<T> {

	private final T[] choiceArray;
	public Chooser2(Collection<T> choices) {
		choiceArray = (T[]) choices.toArray();
	}
	//choose method unchanged
 }

