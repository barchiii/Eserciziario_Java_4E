package utility;

import java.util.Random;
import java.util.Scanner;

public class Tools {
    /*Clears the screen of the terminal */
    public static void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*Halts the current thread by the specified amount of milliseconds */
    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /*Prints a menu and asks the user the options passed using the scanner
     * attribute.
     * The first element of the passed string array is the title, so the
     * passed array's length can't be lower than 2, otherwise null is returned.
     * If the scanner object passed is null, the method returns a negative value.
     * The method clears the screen.
     * If the user inputs an incorrect value the method requests the value again until
     * it's correct.
     */
    public static int menu(String[] content, Scanner keyboard) {
        //If the content array is null or not big enough return -1
        if(content == null || content.length < 2 || keyboard == null)
            return -1;

        //Contains the user input
        int userInput;
        do {
            /*Print the interface */
            //Clear the screen
            clearScreen();
            System.out.println("=== " + content[0] + " ===");
            //Iterate trough all the elements in the options and print them out
            for(int currentElement = 1; currentElement < content.length; currentElement++)
                System.out.println("[" + currentElement + "] : " + content[currentElement]);
            //Print a space
            System.out.print("\n> ");

            //Fill the user input
            userInput = keyboard.nextInt();
        } while (userInput <= 0 || userInput >= content.length);

        //Return the value the user inserted as input
        return userInput;
    }

    /*Returns a new array of random numbers.
     * If the amount of values passed is lower than the span between the max bound
     * and the min bound, the returned value will be null, otherwise an infinite loop would occur.
     */
    public static int[] randomGenerate(int amount, int minBound, int maxBound) {
        /*Check if the amount of values passed is lower than 0
         * or if the maxBound preceedes the minBound */
        if(maxBound <= minBound || amount < 0)
            return null;

        //Create the random generator
        Random generator = new Random();
        //Create the output array
        int[] output = new int[amount];

        //Iterate trough all the elements of the array and fill them with the random value
        for(int currentValue = 0; currentValue < amount; currentValue++)
            output[currentValue] = generator.nextInt(minBound, maxBound);

        //Return the created array
        return output;
    }

    /*Returns an array of random, non repeating numbers.
     * If the amount of values passed is lower than the span between the max bound
     * and the min bound, the returned value will be null, otherwise an infinite loop would occur.
     */
    public static int[] randomGenerateNonRepeating(int amount, int minBound, int maxBound) {
        //Create a new random number generator
        Random generator = new Random();

        /*In case the amount is smaller than the span between the min and
         * max bound, return null to indicate invalid parameters.
         * Also check if the amount of values passed is lower than 0
         * or if the maxBound preceedes the minBound */
        if(maxBound <= minBound || amount < maxBound - minBound || amount < 0)
            return null;

        //Create the output array
        int[] output = new int[amount];

        //Iterate trough all the elements of the array creating the random ones
        for(int currentElement = 0; currentElement < amount; currentElement++)
        {
            //Contains the generated random value
            int currentVal;
            do {
                //Generate a new random value
                currentVal = generator.nextInt(minBound, maxBound);
                //Check if the value is contained in the array already, if so, generate it again
            } while(containedInArray(currentVal, output, currentElement));

            //Now that a new non repeating value is generated, add it in the array
            output[currentElement] = currentVal;
        }

        //Return the output array
        return output;
    }

    /* Checks if the element passed is contained in the passed array
     * In case it is, it returns true.
     * The method checks all the elements until the passed iterator is reached.
     * If the array passed is null, then the method returns false.
     */
    private static boolean containedInArray(int value, int[] check, int checkStop) {
        //Validate the input data
        if(check == null)
            return false;

        //Iterate trough the whole array, until the stop iterator or the array end
        for(int checkIter = 0; checkIter < checkStop && checkIter < check.length; checkIter++)
            //If a value is found, then return true
            if(check[checkIter] == value)
                return true;

        /*If the for loop ended without finding any values, then the method returns false*/
        return false;
    }
}