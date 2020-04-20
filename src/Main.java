import java.util.Scanner;
import java.util.Random;
// Random class is used to generate random numbers -
// Scanner is a class in java.util package used for obtaining the input of the primitive types

public class Main {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        int mode = 0;
/// mode = game type easy or hard 1 or 2 ...
        while (true) {

            System.out.println("1. Easy - number 1-30 - 20 guesses");
            System.out.println("2. Hard - number 1-60 - 10 guesses");
            System.out.println("Chose your mode with a 1 or a 2 ...");

            do {
                mode = userInput.nextInt();
            } while (mode < 1 || mode > 3);

            int numberOfGuesses = 0;
            int maxNumber = 0;
            /// initialize with default to 0 just in case
            switch (mode) {
                case 1:
                    numberOfGuesses = 20;
                    maxNumber = 30;
                    System.out.println("Guess a number between 1 and 30");
                    break;
                case 2:
                    numberOfGuesses = 10;
                    maxNumber = 60;
                    System.out.println("Guess a number between 1 and 60");
                    break;
            }

            Random rand = new Random();
            int numberToGuess = rand.nextInt(maxNumber) + 1;
            /// it starts at zero so have to add one
            int guess = 0;
/// for loop counts number of guesses as variable i
            for (int i = 0; i < numberOfGuesses; i++) {
                guess = userInput.nextInt();
                if (guess > numberToGuess)
                    System.out.println("Too high guess something smaller");
                    // not sure why but if I uncomment the below I get an error
                    // Error:(56, 17) java: 'else' without 'if'
                    // Surely there is some way to display the number of guesses taken or remaining
//                    System.out.println("__");
//                    System.out.println(numberOfGuesses);
//                    System.out.println("__");
//                    System.out.println("your # of guesses left");
                else if (guess < numberToGuess)
                    System.out.println("That's too low guess a bigger number");
//                    System.out.println("__");
//                    System.out.println(numberOfGuesses);
//                    System.out.println("__");
//                    System.out.println("your # of guesses left");
                else {
                    System.out.println("Congrats - you guessed the number correctly!!!!! Hurray! Winner Winner !");
                    break;
                }
            }

            if (guess != numberToGuess)
                System.out.println("So sorry - Better luck next time");
            System.out.print(numberToGuess);
            System.out.println("");
            System.out.println("was the number");

            System.out.println("Play again? [ any positive number for yes, any negative number for no .... like 1 or -7]");
            int answer = userInput.nextInt();

            if (answer < 0)
                break;

        }

    }
}
