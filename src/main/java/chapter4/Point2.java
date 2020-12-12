/**
 * 
 */
package chapter4;

/**
 * @author nsa
 *
 */
// Encapsulation of data by accessor methods and mutators
class Point2 {

	//package-private or is a private nested class
	private double x;
	private double y;
	
	public Point2(double x , double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {return x;}
	public double getY() {return y;}
	
	public void setX(double x) {this.x = x;}
	public void setY(double y) {this.y = y;}
	
	//Prominent examples include the Point and Dimension classes in the java.awt package.
	//what is auxiliary actions when field is read?
	
}
