package HomeWork1;

import java.util.Scanner;
import static HomeWork1.Utils.*;


public class App {

    public static final String errorFormatNumber = "Wrong input, please try again";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter number: ");
        long num = scanner.nextLong();
        if (String.valueOf(Math.abs(num)).length() < 9 || String.valueOf(Math.abs(num)).length() > 13) {
            System.out.println(errorFormatNumber);
        } else {
            consoleOut(num);
        }

    }

    public static void consoleOut(long num) {
        int sum = getSum(num);

        switch (sum) {
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            case 3:
                System.out.println("Three");
                break;
            case 4:
                System.out.println("Four");
                break;
            case 5:
                System.out.println("Five");
                break;
            case 6:
                System.out.println("Six");
                break;
            case 7:
                System.out.println("Seven");
                break;
            case 8:
                System.out.println("Eight");
                break;
            case 9:
                System.out.println("Nine");
                break;
        }
        System.out.println(sum);
    }

    private static int getSum(long num) {
        int sum = 0;
        final char[] arr = getChars(num);
        for (int i = 0; i < arr.length; i++) {
            sum = sum + Character.getNumericValue(arr[i]);
        }


        if (!(String.valueOf(Math.abs(sum)).length() == 1)) {
            consoleOut(sum);
        }
        return sum;
    }
}
