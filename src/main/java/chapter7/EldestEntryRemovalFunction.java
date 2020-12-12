package chapter7;

import java.util.Map;

// Unnecessary functional interface; use a standard one instead.
@FunctionalInterface interface EldestEntryRemovalFunction<K,V>{
	boolean removeEldestEntry(Map<K,V> map, Map.Entry<K, V> eldestEntry);
}