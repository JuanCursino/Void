package edu.fatec.ipp002.composite;

import edu.fatec.ipp002.composite.composite.File;
import edu.fatec.ipp002.composite.leaf.Folder;

public class Main {
    public static void main(String[] args)
    {
        Folder root = new Folder("root");
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");

        Folder subFolder = new Folder("subfolder");
        File file3 = new File("file3.txt");

        subFolder.add(file3);
        root.add(file1);
        root.add(file2);
        root.add(subFolder);

        root.display("");
    }
}