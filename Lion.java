// This class extends the Animal base class
// It demonstrates inheritance by reusing common Animal properties
// and polymorphism by overriding the makeSound() method
public class Lion extends Animal {

    // Additional instance variable specific to Lion
    // Represents the size of the lion's mane
    private double maneSize;

    // Constructor used to initialize both inherited and lion-specific attributes
    public Lion(String name, int age, String color, double weight, double maneSize) {
        // Call superclass constructor to initialize common Animal data
        super(name, age, weight, color);
        // Initialise lion-specific data
        this.maneSize = maneSize;
    }

    // Overridden makeSound() method
    // Demonstrates polymorphism by providing Lion-specific behavior
    @Override
    public String makeSound() {
        return "Roar! I am " + name + ", a " + age + " year old lion.";
    }

    // toString method converts Lion object into CSV format for file saving
    // Includes inherited details plus lion-specific mane size
    @Override
    public String toString() {
        return super.toString() + "," + maneSize;
    }
}
