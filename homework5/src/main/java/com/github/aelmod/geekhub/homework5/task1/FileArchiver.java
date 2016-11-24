package com.github.aelmod.geekhub.homework5.task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Євгеній on 21.11.2016.
 */
public class FileArchiver {
    public void createZip(List<File> files, String archiveName, File folder) {
        try {
            byte[] buffer = new byte[1024];

            FileOutputStream fileOutputStream = new FileOutputStream(folder + "/" + archiveName + ".zip");
            ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);

            for (int i = 0; i < files.size(); i++) {
                System.out.println("Added file: " + files.get(i).getName());
                FileInputStream fileInputStream = new FileInputStream(files.get(i));
                zipOutputStream.putNextEntry(new ZipEntry(files.get(i).getName()));
                int length;
                while ((length = fileInputStream.read(buffer)) > 0) {
                    zipOutputStream.write(buffer, 0, length);
                }
                zipOutputStream.closeEntry();
                fileInputStream.close();
            }

            zipOutputStream.close();

        } catch (IOException e) {
            System.out.println("Error creating zip file\n" + e);
        }
    }
}

