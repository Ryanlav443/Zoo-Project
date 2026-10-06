// This interface defines behaviors that all swimming animals must implement
// It demonstrates abstraction by specifying required methods without implementation
public interface Swimmable {

        // Method for swimming behavior
        // Any animal implementing this interface must define how it swims
        void swim();

        // Method for water-based care
        // Used by the zoo's daily care system to perform specialized aquatic maintenance
        void waterCare();
}
