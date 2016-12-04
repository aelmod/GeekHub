package com.github.aelmod.geekhub.homework5.task2;

/**
 * Created by Євгеній on 21.11.2016.
 */
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Original text: " + GetTextFromExample.getText());
        Translator translator = new Translator();
        System.out.println(translator.translate(GetTextFromExample.getText()));
    }
}

