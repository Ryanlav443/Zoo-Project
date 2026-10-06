// This class extends Animal and implements both Flyable and Swimmable
// It demonstrates:
// - Inheritance (inherits from Animal)
// - Multiple interface implementation (Flyable + Swimmable)
// - Polymorphism (overrides makeSound())
// - Abstraction (must define interface methods)
public class Duck extends Animal implements Flyable, Swimmable {

    // Additional instance variable specific to Duck
    // Represents the duck's wingspan
    private double wingSpan;

    // Constructor used to initialize inherited and duck-specific attributes
    public Duck(String name, int age, String color, double weight, double wingSpan) {
        // Call Animal superclass constructor
        super(name, age, weight, color);
        // Set duck-specific value
        this.wingSpan = wingSpan;
    }

    // Overridden makeSound() method
    // Provides species-specific sound for Duck
    @Override
    public String makeSound() {
        return "Quack! I am " + name + ", a " + age + " year old duck.";
    }

    // Implementation of Flyable interface method
    // Defines duck flying behavior
    public void fly() {
        System.out.println(name + " is flying.");
    }

    // Implementation of Flyable interface method
    // Performs wing health checks during daily care
    public void wingCheck() {
        System.out.println(name + " wing check completed.");
    }

    // Implementation of Swimmable interface method
    // Defines duck swimming behavior
    public void swim() {
        System.out.println(name + " is swimming.");
    }

    // Implementation of Swimmable interface method
    // Performs water-related care
    public void waterCare() {
        System.out.println(name + " water cleaned.");
    }

    // toString method
    // Converts Duck object into text format for display or file saving
    // Includes inherited values plus duck-specific wingspan
    @Override
    public String toString() {
        return super.toString() + "," + wingSpan;
    }
}