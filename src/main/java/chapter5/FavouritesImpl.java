/**
 * 
 */
package chapter5;

import java.util.Map;
import java.util.Objects;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.HashMap;

/**
 * @author nsa
 *
 */
//For example, you could have a DatabaseRow type representing a database row (the container), and a generic type Column<T> as its key.
// Typesafe heterogeneous container pattern - implementation
public class FavouritesImpl implements Favourites{

	private Map<Class<?>, Object> favourites = new HashMap<>();
	
	// Typesafe heterogeneous container pattern - client
		public static void main(String[] args) {
			Favourites f = new FavouritesImpl();
			f.putFavourite(String.class, "Java");
			f.putFavourite(Integer.class, 0xcafebabe);
			f.putFavourite(Class.class, Favourites.class);
			
			String favouriteString = f.getFavourite(String.class);
			int favouriteInteger = f.getFavourite(Integer.class);
			Class<?> favouriteClass = f.getFavourite(Class.class);
			
			System.out.printf("%s %x %s%n", favouriteString,
			           favouriteInteger, favouriteClass.getName());
		}

//		@Override
//		public <T> void putFavourite(Class<T> type, T instance) {
//			favourites.put(Objects.requireNonNull(type), instance);
//		}
		
		// Achieving runtime type safety with a dynamic cast
		@Override public <T> void putFavourite(Class<T> type, T instance) {
            favourites.put(type, type.cast(instance));
        }
		//the getFavorite implementation dynamically casts the object ref- erence to the type represented by the Class object, using Class’s cast method.

		@Override
		public <T> T getFavourite(Class<T> type) {
			return type.cast(favourites.get(type));
		}
		//The thing to notice is that the wildcard type is nested: it’s not the type of the map that’s a wildcard type but the type of its key. This means that every key can have a different parameterized type: one can be Class<String>, the next Class<Integer>, and so on. 
		//That’s where the heterogeneity comes from.
		//discards the “type linkage” between the key and the value; it loses the knowledge that the value is an instance of the key.
		
		//public class Class<T> {
	    //   T cast(Object obj);
	   //}
		
		//Collection wrappers in java.util.Collections that play the same trick. They are called checkedSet, checkedList, checkedMap,
		
//		Second limitation of the Favorites class is that it cannot be used on a non-reifiable type (Item 28). 
		//In other words, you can store your favorite String or String[], but not your favorite List<String>
		// List<String> and List<Integer> share a single Class object, which is List.class.
		
//		type tokens used by Favorites are unbounded: getFavorite and put- Favorite accept any Class object
		
		//Sometimes you may need to limit the types that can be passed to a method. This can be achieved with a bounded type token,
		//which is simply a type token that places a bound on what type can be represented, using a bounded type parameter (Item 30) or a bounded wildcard (Item 31).
		
//		public <T extends Annotation> T getAnnotation(Class<T> annotationType);
		//an annotated element is a typesafe heterogeneous container whose keys are annotation types.
		
		
		//Luckily, class Class provides an instance method that performs this sort of cast safely (and dynamically). 
		//The method is called asSubclass, and it casts the Class object on which it is called to represent subclass of the class in the argument
		// Use of asSubclass to safely cast to a bounded type token
		static Annotation getAnnotation(AnnotatedElement element,
		                                   String annotationTypeName) {
			
		Class<?> annotationType = null; // Unbounded type token 
		try {
		           annotationType = Class.forName(annotationTypeName);
		       } catch (Exception ex) {
		           throw new IllegalArgumentException(ex);
		       }
		return element.getAnnotation( annotationType.asSubclass(Annotation.class));
		}

}
