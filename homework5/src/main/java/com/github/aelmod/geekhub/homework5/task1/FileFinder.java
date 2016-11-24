package com.github.aelmod.geekhub.homework5.task1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Євгеній on 21.11.2016.
 */
public class FileFinder {
    static void setFiles(File path) {
        FileArchiver fileArchiver = new FileArchiver();
        File folder = new File(String.valueOf(path));
        File[] listOfFiles = folder.listFiles();
        List<File> listOfPictures = new ArrayList<>();
        List<File> listOfVideos = new ArrayList<>();
        List<File> listOfMusic = new ArrayList<>();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {

                if (listOfFiles[i].toString().toLowerCase().endsWith(".png") ||
                        listOfFiles[i].toString().toLowerCase().endsWith(".jpg") ||
                        listOfFiles[i].toString().toLowerCase().endsWith(".jpeg") ||
                        listOfFiles[i].toString().toLowerCase().endsWith(".gif") ||
                        listOfFiles[i].toString().toLowerCase().endsWith(".tiff")) {
                    listOfPictures.add(listOfFiles[i]);
                    fileArchiver.createZip(listOfPictures, "images", folder);
                } else if (listOfFiles[i].toString().toLowerCase().endsWith(".avi") ||
                        listOfFiles[i].toString().toLowerCase().endsWith(".mp4") ||
                        listOfFiles[i].toString().toLowerCase().endsWith(".flv")) {
                    listOfVideos.add(listOfFiles[i]);
                    fileArchiver.createZip(listOfVideos, "videos", folder);
                } else if (listOfFiles[i].toString().toLowerCase().endsWith(".mp3") ||
                        listOfFiles[i].toString().toLowerCase().endsWith(".wav") ||
                        listOfFiles[i].toString().toLowerCase().endsWith(".wma")) {
                    listOfMusic.add(listOfFiles[i]);
                    fileArchiver.createZip(listOfMusic, "music", folder);
                }
            }
        }
    }
}
