package in.ineuron.main;

abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void sound();

    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    public void sound() {
        System.out.println(name + " barks.");
    }
}

public class AbstractClassExample {
    public static void main(String[] args) {
        Dog dog = new Dog("Charlie");
        dog.sound();
        dog.sleep();
    }
}

