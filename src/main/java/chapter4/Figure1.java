package chapter4;

// Tagged class - vastly inferior to a class hierarchy!
class Figure1 {
	enum Shape { RECTANGLE, CIRCLE };
    // Tag field - the shape of this figure
    final Shape shape;
    // These fields are used only if shape is RECTANGLE
    double length;
    double width;
    // This field is used only if shape is CIRCLE
    double radius;
   // Constructor for circle
   Figure1(double radius) {
       shape = Shape.CIRCLE;
       this.radius = radius;
   }
   // Constructor for rectangle
   Figure1(double length, double width) {
       shape = Shape.RECTANGLE;
       this.length = length;
       this.width = width;
   }
   double area() {
       switch(shape) {
         case RECTANGLE:
           return length * width;
         case CIRCLE:
           return Math.PI * (radius * radius);
         default:
           throw new AssertionError(shape);
       } 
   }
}