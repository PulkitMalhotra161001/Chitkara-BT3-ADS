/*
Wrapping code or data in a single unit. Data hidden from other classes
For hiddding the data we use 
Access modifiers:
1. Private - Access level is within a class
2. Default - Access level is within a package
3. Protected - Access level is within a package and outside the package throught the child class
4. Public - Access level is everywhere
*/


class HelloWorld {
    public static void main(String[] args) {
        Student s1 = new Student();
        
        s1.setName("Bhupendra Jogi");
        s1.setAge(15);
        
        System.out.println(s1.getName());
    }
}

class Student{
    private int age;
    private String name;

    //bundling related fields and method together
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
