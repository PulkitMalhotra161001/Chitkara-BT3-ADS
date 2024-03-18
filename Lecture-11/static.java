//Static Keyword - Used for memory management, share the same variable or method of a given class, it belongs to the class than an instance of the class.
//Priority (Method, Block,)

// 1. Static Block (Helps computation before calling main function)
class Test
{
	// static variable
	static int a = 10;
	static int b;
	
	// static block
	static {
		System.out.println("Static block initialized.");
		b = a * 4;
	}

	public static void main(String[] args)
	{
	System.out.println("from main");
	System.out.println("Value of a : "+a);
	System.out.println("Value of b : "+b);
	}
}



// 2. Static variables (single copy of the variable is created and shared among all objects)
// NOTE - static block and static variables are executed in the order they are present in a program.
class Test
{
	// static variable
	static int a = m1();
	
	// static block
	static {
		System.out.println("Inside static block");
	}
	
	// static method
	static int m1() {
		System.out.println("from m1");
		return 20;
	}
	
	// static method(main !!)
	public static void main(String[] args)
	{
	System.out.println("Value of a : "+a);
	System.out.println("from main");
	}
}



// 3. Static methods (accessed before any object is created) e.g. main method
class Student {
	String name;
	int rollNo;

	// static variable
	static String cllgName;

	// static counter to set unique roll no
	static int counter = 0;

	public Student(String name)
	{
		this.name = name;

		this.rollNo = setRollNo();
	}

	// getting unique rollNo
	// through static variable(counter)
	static int setRollNo()
	{
		counter++;
		return counter;
	}

	// static method
	static void setCllg(String name) { cllgName = name; }

	// instance method
	void getStudentInfo()
	{
		System.out.println("name : " + this.name);
		System.out.println("rollNo : " + this.rollNo);

		// accessing static variable
		System.out.println("cllgName : " + cllgName);
	}
}

// Driver class
public class StaticDemo {
	public static void main(String[] args)
	{
		// calling static method
		// without instantiating Student class
		Student.setCllg("XYZ");

		Student s1 = new Student("Alice");
		Student s2 = new Student("Bob");

		s1.getStudentInfo();
		s2.getStudentInfo();
	}
}



// 4. Static Classes (A class can be made static only if it is a nested class.)
import java.io.*;
public class GFG {

	private static String str = "GeeksforGeeks";

	// Static class
	static class MyNestedClass {
	
		// non-static method
		public void disp(){ 
		System.out.println(str); 
		}
	}

	public static void main(String args[])
	{
		GFG.MyNestedClass obj
			= new GFG.MyNestedClass();
		obj.disp();
	}
}
