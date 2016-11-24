package com.github.aelmod.geekhub.homework5.task2;

/**
 * Created by Євгеній on 21.11.2016.
 */
public class App {
    public static void main(String[] args) throws Exception {
        Translator translator = new Translator();
        translator.translate(GetTextFromExample.getText());
    }
}

