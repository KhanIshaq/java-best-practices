package chapter7;

public class Album {

	private final int sales;
	private final String artist;
	
	public Album(String artist, int sales) {
		this.artist = artist;
		this.sales = sales;
	}
	
	public String artist() {return this.artist;}
	
	public int sales() {return this.sales;}
}
