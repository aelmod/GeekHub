package HomeWork2;

import java.util.Scanner;

/**
 * Created by Євгеній on 02.11.2016.
 */
public class ConcoleInputUtils {
    private static Scanner scanner = new Scanner(System.in);


    public static int getIntFromUser() {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.err.print("Wrong input, please try again: ");
        }
        return scanner.nextInt();
    }

    public static int getIntFromUser(int min, int max) {
        int inputedNumber = getIntFromUser();
        while (inputedNumber < min || inputedNumber > max) {
            System.err.print("Wrong input, please try again: ");
            inputedNumber = getIntFromUser();
        }
        return inputedNumber;
    }

    public static double getDoubleFromUser() {
        while (!scanner.hasNextDouble()) {
            scanner.next();
            System.err.print("Wrong input, please try again: ");
        }
        return scanner.nextDouble();
    }


}
