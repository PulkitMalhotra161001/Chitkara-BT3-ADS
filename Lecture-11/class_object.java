//class 
  // - class is a blueprint for the object
  // - it is a logical entity
  // - it doesn't store in a memory and don't take any space

//object
  // -  Object have some state and behaviour
  // -  Object contains space in memory


class Person {
  String name;
  int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public void introduce() {
    System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
  }
}

public class Main {
  public static void main(String[] args) {
    Person john = new Person("John Doe", 30);
    john.introduce();
  }
}
