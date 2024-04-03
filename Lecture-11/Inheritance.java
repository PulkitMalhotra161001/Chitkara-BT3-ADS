//D.R.Y. code
//is-a relationship between the two classes
//extend properties from parent class (so we don't need to make same fields/perperties for different classes)



//1. Single Inheritance
class Animal{  
  void eat(){
    System.out.println("eating...");
  }  
}  
class Dog extends Animal{  
  void bark(){
    System.out.println("barking...");
  }  
}  
class TestInheritance{  
  public static void main(String args[]){  
    Dog d=new Dog();  
    d.bark();  
    d.eat();  
  }
}



//2. Multilevel Inheritance
class Animal{  
  void eat(){
    System.out.println("eating...");
  }  
}  
class Dog extends Animal{  
  void bark(){
    System.out.println("barking...");
  }  
}  
class BabyDog extends Dog{  
  void weep(){
    System.out.println("weeping...");
    }  
}  
class TestInheritance2{  
  public static void main(String args[]){  
    BabyDog d=new BabyDog();  
    d.weep();  
    d.bark();  
    d.eat();  
  }
} 



//3. Hierarchical Inheritance
class Animal{  
  void eat(){
    System.out.println("eating...");
  }  
}  
class Dog extends Animal{  
  void bark(){
    System.out.println("barking...");
  }  
}  
class Cat extends Animal{  
  void meow(){
    System.out.println("meowing...");
  }  
}  
class TestInheritance3{  
  public static void main(String args[]){  
    Cat c=new Cat();  
    c.meow();  
    c.eat();  
    //c.bark();//C.T.Error  
  }
} 


//4. Multiple inheritance
/*
The C class inherits A and B classes. 
If A and B classes have the same method and you call it from child class object, 
there will be ambiguity to call the method of A or B class.
It will lead to diamond problem
*/


//5. Hybrid Inheritance
