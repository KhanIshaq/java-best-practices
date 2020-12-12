package chapter11;
// Set obeserver callback interface - Page 266

// We chose to define a custom functional interface because the interface and method names make the code more readable 
//and because the interface could evolve to incorporate multiple callbacks
@FunctionalInterface public interface SetObserver<E> {
    // Invoked when an element is added to the observable set
    void added(ObservableSet<E> set, E element);
}