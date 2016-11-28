package com.geekhub.hw5.archivator;

import com.geekhub.hw5.archivator.utils.ArchiveException;
import com.geekhub.hw5.archivator.utils.Archiver;
import com.geekhub.hw5.archivator.utils.FileSorter;
import com.geekhub.hw5.archivator.utils.FileType;

import java.io.File;
import java.util.Scanner;

public class ArchiverApplication {
    public static void main(String[] args) throws ArchiveException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter path of directory to zip");
        String sourcePath = scanner.nextLine();

        for (FileType fileType : FileType.values()) {
            new Archiver().archiveToZip(new FileSorter().fileSorting(new File(sourcePath), fileType.getExtensions()), sourcePath + "/" + fileType.toString() + ".zip");
        }
    }
}



