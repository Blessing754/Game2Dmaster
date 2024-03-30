package PlayerEntity; // Declares the package for organization, PlayerEntity in this case

import java.util.Random; // Imports the Random class for generating random numbers

// Dice class definition
public class Dice {
    private final Random random; // Declares a Random object instance variable

    // Constructor for the Dice class
    public Dice() {
        random = new Random(); // Initializes the Random object
    }

    // Method to simulate rolling a dice
    public int roll() {
        // The Random object's nextInt(6) method generates a random number between 0 (inclusive) and 6 (exclusive)
        // Adding 1 shifts the range to be between 1 and 6, inclusive, like a standard dice
        return random.nextInt(6) + 1;
    }
}
