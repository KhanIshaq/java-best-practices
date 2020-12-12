/**
 * 
 */
package chapter5;

/**
 * @author nsa
 *
 */

// Typesafe heterogeneous container pattern - API
public interface Favourites {

	public <T> void putFavourite(Class<T> type, T instance);
	public <T> T getFavourite(Class<T> type);
}
