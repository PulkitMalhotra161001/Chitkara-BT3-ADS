/* The word polymorphism means having many forms. e.g. A man is a father, a husband, and an employee

Types
1. Compile-time Polymorphism/static or early Binding (achieved by function "overloading") - fast execution
Note: But Java doesn’t support the Operator Overloading.
*/

class Helper {

	static int Multiply(int a, int b)
	{
		return a * b;
	}

	static double Multiply(double a, double b)
	{
		return a * b;
	}
}

class Main {
	public static void main(String[] args)
	{
		System.out.println(Helper.Multiply(2, 4));
		System.out.println(Helper.Multiply(5.5, 6.3));
	}
}



//2. Run-time Polymorphism/Dynamic or late Binding (achieved by function "overriding") - slower execution


class Parent {
	void Print(){
		System.out.println("parent class");
	}
}

class subclass1 extends Parent {
	void Print() { 
    System.out.println("subclass1"); 
  }
}

class subclass2 extends Parent {
	void Print(){
		System.out.println("subclass2");
	}
}

class Main {
	public static void main(String[] args){
		Parent a;
		a = new subclass1();
		a.Print();
		a = new subclass2();
		a.Print();
	}
}

