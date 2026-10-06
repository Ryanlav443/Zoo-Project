// This class extends the Animal base class and implements the Swimmable interface
// It demonstrates:
// - Inheritance (inherits common Animal properties and methods)
// - Interface implementation (Swimmable)
// - Polymorphism (overrides makeSound())
// - Abstraction (must implement all Swimmable methods)
public class Fish extends Animal implements Swimmable {

    // Additional instance variable specific to Fish
    // Stores whether the fish lives in freshwater or saltwater
    private String waterType;

    // Constructor used to initialize inherited and fish-specific attributes
    public Fish(String name, int age, String color, double weight, String waterType ) {
        // Call superclass constructor to initialize common Animal variables
        super(name, age, weight, color);
        // Set fish-specific attribute
        this.waterType = waterType;
    }

    // Overridden makeSound() method
    // Demonstrates polymorphism with fish-specific behavior
    @Override
    public String makeSound() {
        return "Blub! I am " + name + ", a " + age + " year old fish.";
    }

    // Implementation of Swimmable interface method
    // Defines fish swimming behavior
    public void swim() {
        System.out.println(name + " is swimming.");
    }

    // Implementation of Swimmable interface method
    // Performs aquatic care such as tank cleaning
    public void waterCare() {
        System.out.println(name + " tank cleared.");
    }

    // toString method
    // Converts Fish object into CSV format for file storage
    // Includes inherited data plus fish-specific water type
    @Override
    public String toString() {
        return super.toString() + "," + waterType;
    }
}
