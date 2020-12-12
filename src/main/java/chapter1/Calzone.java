/**
 * 
 */
package chapter1;

import java.util.Objects;

/**
 * @author ishaqkhan
 * 
 */
public class Calzone extends Pizza{
	public enum Sauce {GARLIC, KETCHUP, BARBEQUE}
	private final Sauce sauce;
	
	public static class Builder extends Pizza.Builder<Builder>{
		private Sauce sauce;
		
		public Builder(Sauce sauce) {
			sauce = Objects.requireNonNull(sauce);
		}
		
		@Override public Calzone build() {
			return new Calzone(this);
		}

		@Override
		protected Builder self() {
			return this;
		}
	}
	
	private Calzone(Builder builder) {
		super(builder);
		sauce = builder.sauce;
	}
	
}
