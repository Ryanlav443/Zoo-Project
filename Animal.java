// This is the parent/base class for all animal types in the zoo system
// It demonstrates abstraction and inheritance by storing common attributes
// and forcing subclasses to define their own makeSound() behaviour
public abstract class Animal {

    // Protected instance variables allow subclasses direct access
    // while still maintaining encapsulation from external classes
    protected String name;
    protected int age;
    protected double weight;
    protected String color;

    // Constructor used to initialize common animal details
    public Animal(String name, int age, double weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    // Getter method for animal name
    public String getName() {
        return name;
    }

    // Getter method for animal color
    public String getColor() {
        return color;
    }

    // Getter method for animal age
    public int getAge() {
        return age;
    }

    // Getter method for animal weight
    public double getWeight() {
        return weight;
    }

    // Setter method to update animal weight
    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Setter method to update animal name
    public void setName(String name) {
        this.name = name;
    }

    // Setter method to update animal colour
    public void setColor(String color) {
        this.color = color;
    }

    // Setter method to update animal age
    public void setAge(int age) {
        this.age = age;
    }

    // Validation method
    // Ensures all required fields are complete and valid before saving
    public boolean isValid() {
        return name != null && !name.isEmpty()       // Name cannot be blank
                && color != null && !color.isEmpty() // Color cannot be blank
                && age > 0 && weight > 0;            // Age and weight must be positive
    }

    // Abstract method for polymorphism
    // Each subclass must override this to provide species-specific sound
    public abstract String makeSound();

    // toString method converts animal object into text format
    // Used when displaying or saving animal details to file
    @Override
    public String toString() {
        return getClass().getSimpleName() + "," + name + "," + age + "," + color + "," + weight;
    }
}
