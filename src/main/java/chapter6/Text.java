package chapter6;

import java.util.EnumSet;
import java.util.Set;

// EnumSet - a modern replacement for bit fields
public class Text {
	public enum Style {
		BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
	}

	// Any Set could be passed in, but EnumSet is clearly best
	public void applyStyles(Set<Style> styles) { 
		this.applyStyles(styles);
	}
	
	public static void main(String[] args) {
		Text text = new Text();
		text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
	}
}