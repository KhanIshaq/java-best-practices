package chapter3;

public class Yum {

	// A copy constructor is simply a constructor that takes a single argument whose
	// type is the class containing the constructor, for example,
	// Copy constructor
	public Yum(Yum yum) {
		//
	};

	// A copy factory is the static factory (Item 1) analogue of a copy constructor:
	// Copy factory
	public static Yum newInstance(Yum yum) {
		//
		return new Yum(yum);
	};

}
