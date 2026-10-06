// Generated with help from Claude AI
// Ryan Lavery - B01023499

import java.util.Scanner;

// This is the entry point of the zoo management application
// It provides the console-based menu system
public class Main {
    // Main method - execution begins here
    public static void main(String[] args) {
        // Create Zoo object to manage all zoo operations
        Zoo zoo = new Zoo();
        // Scanner object used for keyboard input
        Scanner sc = new Scanner(System.in);

        // Load previously saved zoo data from text files on startup
        zoo.loadData();

        // Variable to store user menu selection
        int choice;

        // Main program loop
        // Continues running until the user selects Exit (option 8)
        do {
            // Display menu options to user
            System.out.println("\n=== ZOO MENU ===");
            System.out.println("1. Add Animal");
            System.out.println("2. View Animals");
            System.out.println("3. Remove Animal");
            System.out.println("4. Update Animal");
            System.out.println("5. Search");
            System.out.println("6. Daily Care");
            System.out.println("7. Report");
            System.out.println("8. Exit");

            // Read user menu choice
            choice = sc.nextInt();
            // Clear scanner buffer after numeric input
            sc.nextLine();

            // Switch statement controls program flow
            switch (choice) {
                // OPTION 1: Add a new animal
                case 1:
                    // Ask user which type of animal to create
                    System.out.println("1. Lion 2. Duck 3. Fish");
                    // Read animal type selection
                    int type = sc.nextInt();
                    // Clear buffer
                    sc.nextLine();

                    // Collect shared animal details
                    System.out.println("Name: ");
                    String name = sc.nextLine();

                    System.out.println("Age: ");
                    int age = sc.nextInt();

                    System.out.println("Weight: ");
                    double weight = sc.nextDouble();
                    // Clear buffer
                    sc.nextLine();

                    System.out.println("Color: ");
                    String color = sc.nextLine();

                    // Nested switch for subclass-specific details
                    switch (type) {
                        // Create and add Lion
                        case 1:
                            System.out.println("Mane size: ");
                            double mane = sc.nextDouble();
                            // Add Lion object to zoo
                            zoo.addAnimal(new Lion(name, age, color, weight, mane));
                            break;

                        case 2:
                            System.out.println("Wing span: ");
                            double wing =  sc.nextDouble();
                            // Add Duck object to zoo
                            zoo.addAnimal(new Duck(name, age, color, weight, wing));
                            break;

                        case 3:
                            System.out.println("Water type: ");
                            String water = sc.nextLine();
                            // Add Fish object to zoo
                            zoo.addAnimal(new Fish(name, age, color, weight, water));
                            break;
                    }
                    break;

                case 2:
                    // Calls Zoo method to display all registered animals
                    zoo.displayAnimals();
                    break;

                case 3:
                    // Ask user for animal name
                    System.out.println("Enter name: ");
                    // Remove matching animal
                    zoo.removeAnimal(sc.nextLine());
                    break;

                case 4:
                    // Ask user which animal to update
                    System.out.println("Enter name: ");
                    // Calls update method
                    zoo.updateAnimal(sc.nextLine(), sc);
                    break;

                case 5:
                    // User can search by name or color
                    System.out.println("Search: ");
                    // Display matching animals and makeSound()
                    zoo.searchAnimal(sc.nextLine());
                    break;

                case 6:
                    // Runs interface-specific care routines
                    // Example: wingCheck() or waterCare()
                    zoo.dailyCare();
                    break;

                case 7:
                    // Shows zoo name, total animals, types, and colors
                    zoo.report();
                    break;

                case 8:
                    // Save zoo and animal details before closing
                    zoo.saveData();
                    System.out.println("Goodbye!");
                    break;
            }
            // Continue loop until option 8 selected
        } while (choice != 8);
    }
}
