package in.ineuron.main;

class Parent {
    public Parent() {
        System.out.println("Parent class constructor");
    }
}

class Child extends Parent {
    public Child() {
        super(); // Invokes the parent class constructor
        System.out.println("Child class constructor");
    }
}

public class Program02 {
    public static void main(String[] args) {
    	
        Child child = new Child();
        
    }
}
