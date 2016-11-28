package com.geekhub.hw5.archivator.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Archiver {

    public void archiveToZip(List<File> files, String archiveName) throws ArchiveException {

        byte[] buffer = new byte[1024];

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(archiveName))) {

            for (File file : files) {
                zipOutputStream.putNextEntry(new ZipEntry(file.getPath().substring(3)));
                FileInputStream fileInputStream = new FileInputStream(file);

                int len;
                while ((len = fileInputStream.read(buffer)) > 0) {
                    zipOutputStream.write(buffer, 0, len);
                }
                fileInputStream.close();
            }
            zipOutputStream.closeEntry();
        } catch (IOException e) {
            throw new ArchiveException(e);
        }
    }
}
