package com.github.aelmod.geekhub.homework5.task1;

import java.io.File;

/**
 * Created by Євгеній on 21.11.2016.
 */
public class App {
    public static void main(String[] args) {
        File path = new File("homework5/files");
        //File[] path = new File(String.valueOf(path)).listFiles(File::isDirectory);
        FileFinder.setFiles(path);
    }
}
