package com.github.aelmod.geekhub.homework4.task2;

import static com.github.aelmod.common.util.ConsoleUtils.*;

/**
 * Created by Євгеній on 13.11.2016.
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Enter count of words: ");
        int n = getIntFromUser(1, 100);
        for (int i = 0; i < n; i++) {
            String word = getWordFromUser();
            if (word.length() <= 10) {
                System.out.println(word);
            } else {
                System.out.println(word.charAt(0) + "" + (word.length() - 2) + word.charAt(word.length() - 1));
            }
        }
    }
}
