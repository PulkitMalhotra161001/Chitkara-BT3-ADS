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
