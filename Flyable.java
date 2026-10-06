// This interface defines behaviors that all flying animals must implement
// It supports abstraction by enforcing common flying-related methods
public interface Flyable {

        // Method for flying behavior
        // Any animal implementing this interface must define how it flies
        void fly();

        // Method for wing health checks
        // Used during daily care routines to perform specialized wing inspections
        void wingCheck();
}
