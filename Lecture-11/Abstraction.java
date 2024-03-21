/*
Data abstraction is the process of hiding certain details and sharing only essential info to the user.
In this parent class have all the methods but child classes implements
Acheived by abstract class or interface
*/

//----------------------------------------------abstract class-----------------------------------------------------------
abstract class Shape { 
	String color; 

	// these are abstract methods
	//if any method is abstract then class must be abstract
	abstract double area(); 
	public abstract String toString(); 

    //constructor
	public Shape(String color) { 
		System.out.println("Shape constructor called"); 
		this.color = color; 
	} 

    //method
	public String getColor() { 
	    return color; 
	} 
} 


class Circle extends Shape { 
	double radius; 
    
    //constructor
	public Circle(String color, double radius) { 

		// calling Shape constructor 
		super(color); 
		System.out.println("Circle constructor called"); 
		this.radius = radius; 
	} 

	@Override 
	double area() {
		return Math.PI * Math.pow(radius, 2); 
	} 

	@Override 
	public String toString() { 
		return "Circle color is " + super.getColor() 
			+ "and area is : " + area(); 
	} 
} 
class Rectangle extends Shape { 

	double length; 
	double width; 

    //constructor
	public Rectangle(String color, double length, double width){
	    
		// calling Shape constructor 
		super(color); 
		System.out.println("Rectangle constructor called"); 
		this.length = length; 
		this.width = width; 
	} 

	@Override 
	double area() { 
	    return length * width; 
	} 

	@Override 
	public String toString() { 
		return "Rectangle color is " + super.getColor() 
			+ "and area is : " + area(); 
	} 
} 

class Test { 
	public static void main(String[] args) 
	{ 
		Shape s1 = new Circle("Red", 2.2); 
		Shape s2 = new Rectangle("Yellow", 2, 4); 

		System.out.println(s1.toString()); 
		System.out.println(s2.toString()); 
	} 
}

//----------------------------------------------interface-----------------------------------------------------------
// NOTE - To implement an interface we use the keyword “implements” with class.

// Define an interface named Shape 
interface Shape { 
	double calculateArea(); // Abstract method for 
							// calculating the area 
} 

// Implement the interface in a class named Circle 
class Circle implements Shape { 
	private double radius; 

	// Constructor for Circle 
	public Circle(double radius) { 
	    this.radius = radius; 
	} 

	// Implementing the abstract method from the Shape 
	// interface 
	public double calculateArea() { 
		return Math.PI * radius * radius; 
	} 
} 

// Implement the interface in a class named Rectangle 
class Rectangle implements Shape { 
	private double length; 
	private double width; 

	// Constructor for Rectangle 
	public Rectangle(double length, double width) { 
		this.length = length; 
		this.width = width; 
	} 

	// Implementing the abstract method from the Shape 
	// interface 
	public double calculateArea() { 
	    return length * width; 
	} 
} 

class Main { 
	public static void main(String[] args) 
	{ 
		// Creating instances of Circle and Rectangle 
		Circle myCircle = new Circle(5.0); 
		Rectangle myRectangle = new Rectangle(4.0, 6.0); 

		System.out.println("Area of Circle: "
						+ myCircle.calculateArea()); 
		System.out.println("Area of Rectangle: "
						+ myRectangle.calculateArea()); 
	} 
}


/* 
Abstract classes are used to define a generic template for other classes to follow. 
They define a set of rules and guidelines that their subclasses must follow.
By providing an abstract class, we can ensure that the classes that extend it have a consistent structure and behavior. 
This makes the code more organized and easier to maintain.
*/
