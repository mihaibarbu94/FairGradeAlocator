package com.alocator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class QuitPage extends Page {

    public QuitPage() {
        System.exit(0);
    }

    @Override
    void createView() {

    }

    public void storeIntoTextFile(){
        PrintWriter outputStream = null;
        try
        {
            outputStream = new PrintWriter(new FileOutputStream("store.txt"));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error opening or creating the file store.txt.");
        }

        outputStream.print(projectName);
    }
}
