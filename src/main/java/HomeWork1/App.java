package HomeWork1;

import java.util.Scanner;

public class App {

    public static final String errorFormatNumber = "Вы ввели неправильный формат номера";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер:");
        if (scanner.hasNextLong()) {
            long num = scanner.nextLong();
            if (String.valueOf(Math.abs(num)).length() < 9 || String.valueOf(Math.abs(num)).length() > 13)
                System.out.println(errorFormatNumber);
            else {
                out(num);
            }
        } else {
            System.out.println(errorFormatNumber);
        }

    }

    public static void out(long num) {
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
            out(sum);
        }
        return sum;
    }

    private static char[] getChars(long num) {
        final char[] arr = new char[(int) (Math.log10(num) + 1)];
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = (char) ('0' + (num % 10));
            num /= 10;
        }

        return arr;
    }

}
