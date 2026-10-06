import java.util.*;
import java.io.*;
import java.io.PrintWriter;
import java.io.IOException;

// This class manages all animals registered in the zoo
// It demonstrates:
// - Collections Framework (ArrayList)
// - File handling (saving/loading text files)
// - Polymorphism (Animal superclass references)
// - Program control structures (loops, conditionals, switch logic)
public class Zoo {
    // Hard-coded zoo name
    private String zooName = "Belfast Zoo";
    // ArrayList used to dynamically store all Animal objects
    // Allows polymorphic storage of Lion, Duck, Fish
    private ArrayList<Animal> animals = new ArrayList<>();

    // Method to add a valid animal to the zoo
    public void addAnimal(Animal a) {
        // Check object exists and passes validation
        if (a != null && a.isValid()) {
            animals.add(a);
            System.out.println("Animal added.");
        } else {
            // Reject invalid or incomplete records
            System.out.println("Animal not added.");
        }
    }

    // Method to remove an animal by name
    public void removeAnimal(String name) {
        // removeIf uses lambda expression to match animal name
        animals.removeIf(a -> a.getName().equalsIgnoreCase(name));
        System.out.println("Animal removed.");
    }

    // Method to update existing animal details
    public void updateAnimal(String name, Scanner sc) {
        // Loop through all animals
        for (Animal a : animals) {
            // Search for matching name
            if (a.getName().equalsIgnoreCase(name)) {
                // Update animal details
                System.out.print("New age: ");
                a.setAge(sc.nextInt());

                System.out.print("New weight: ");
                a.setWeight(sc.nextDouble());

                sc.nextLine(); // clear buffer

                System.out.print("New color: ");
                a.setColor(sc.nextLine());

                System.out.print("Updated.");
                return;
            }
        }
        // If no match found
        System.out.println("Animal not added.");
    }

    // Method to display all registered animals
    public void displayAnimals() {
        // Check if zoo is empty
        if (animals.isEmpty()) {
            System.out.println("Animal list is empty.");
            return;
        }
        // Display each animal
        for (Animal a : animals) {
            System.out.println(a);
        }
    }

    // Search animals by name or color
    public void searchAnimal(String keyword) {
        // Loop through all animals
        for (Animal a : animals) {
            // Match by name OR color
            if (a.getName().equalsIgnoreCase(keyword)
                || a.getColor().equalsIgnoreCase(keyword)) {
                // Display animal details
                System.out.println(a);
                // Call polymorphic makeSound()
                System.out.println(a.makeSound());
            }
        }
    }

    // Daily care routine for all animals
    public void dailyCare() {
        // Loop through collection
        for (Animal a : animals) {
            // Check if animal can fly
            if (a instanceof Flyable f) {
                f.wingCheck();
            }
            // Check if animal can swim
            if (a instanceof Swimmable s) {
                s.waterCare();
            }
        }
    }

    // Generate zoo report
    public void report() {
        System.out.println("\nZoo: " + zooName);
        // Total animal count
        System.out.println("Total Animals: " + animals.size());

        // HashMaps used for counting types and colors
        Map<String, Integer> typeCount = new HashMap<>();
        Map<String, Integer> colorCount =  new HashMap<>();

        // Process each animal
        for (Animal a : animals) {
            // Count by class type
            typeCount.merge(a.getClass().getSimpleName(), 1, Integer::sum);
            // Count by color
            colorCount.merge(a.getColor(), 1, Integer::sum);
        }
        // Display results
        System.out.println("Animal Types: " + typeCount);
        System.out.println("Animal Colors: " + colorCount);
    }

    // SAVE FILES
    public void saveData() {
        // Try-with-resources automatically closes files
        try (PrintWriter writer = new PrintWriter("AnimalDetails.txt")) {

            // Save valid animals only
            for (Animal animal : animals) {
                if (animal != null && animal.isValid()) {
                    writer.println(animal.toString());
                }
            }
            System.out.println("Data saved.");
        } catch (IOException e) {
            // Handle file saving errors
            System.out.println("Error saving data.");
        }
    }

    // LOAD FILES
    public void loadData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("AnimalDetails.txt"))) {
            String line;

            // Read file line-by-line
            while ((line = reader.readLine()) != null) {
                // Split CSV values
                String[] parts = line.split(",");

                // Rebuild correct object type
                switch (parts[0]) {
                    case "Lion":
                        animals.add(new Lion(parts[1], Integer.parseInt(parts[2]),
                                parts[3], Double.parseDouble(parts[4]),
                                Double.parseDouble(parts[5])));
                        break;
                    case "Duck":
                        animals.add(new Duck(parts[1], Integer.parseInt(parts[2]),
                                parts[3], Double.parseDouble(parts[4]),
                                Double.parseDouble(parts[5])));
                        break;
                    case "Fish":
                        animals.add(new Fish(parts[1], Integer.parseInt(parts[2]),
                                parts[3], Double.parseDouble(parts[4]),
                                parts[5]));
                        break;
                }
            }
            System.out.println("Data loaded.");
        } catch (IOException e) {
            // If file does not exist yet
            System.out.println("Error loading data.");
        }
    }
}
