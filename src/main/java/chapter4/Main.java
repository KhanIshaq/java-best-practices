package chapter4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	
    public static void main(String[] args) {
        System.out.println(Utensil.NAME + Dessert.NAME);
    }
    
    //Step 1:
//    private static final Thing[] PRIVATE_VALUES = { };
//    public static final List<Thing> VALUES =
//        Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));
    
    
    //Step 2:
    private static final Thing[] PRIVATE_VALUES = {};
    public static final Thing[] values() {
        return PRIVATE_VALUES.clone();
    }
    
    //Item 15: Minimize the accessibility of classes and members
    
    // A module is a grouping of packages, like a package is a grouping of classes. 
    //A module may explicitly export some of its packages via export declarations in its module declaration (which is by convention contained in a source file named module-info.java).
    
    //Item16: In public classes,use accessor methods,not public fields
    //should always be replaced by classes with private fields and public accessor methods (getters) and, for mutable classes, mutators (setters):
    
    //if a class is package-private or is a private nested class, there is nothing inherently wrong with exposing its data fields
    
    //Item17: Minimize mutability
    
    //immutable classes, including String, the boxed primitive classes, and BigInteger and BigDecimal
    
    //1. Don’t provide methods that modify the object’s state (known as mutators).
    //2. Ensure that the class can’t be extended
    // Preventing subclassing is generally accomplished by making the class final, but there is an alternative that we’ll discuss later.
    //3. Make all fields final. 
    // 		as spelled out in the memory model [JLS, 17.5; Goetz06, 16].
    //4. Make all fields private.
    //5. Ensure exclusive access to any mutable components. 
    //Make defensive copies (Item 50) in constructors, accessors, and readObject methods (Item 88).
    
    //Item18: Favorcompositionoverinheritance
    
    //Item19: Designanddocumentforinheritanceorelseprohibitit
    
    //Item20: Preferinterfacestoabstractclasses
    
    //Item21: Designinterfacesforposterity
    
    //Item22: Useinterfacesonlytodefinetypes
    
    //Item23: Preferclasshierarchiestotaggedclasses
    
    //Item24: Favorstaticmemberclassesovernonstatic
    
    //Item25: Limitsourcefilestoasingletop-levelclass


}