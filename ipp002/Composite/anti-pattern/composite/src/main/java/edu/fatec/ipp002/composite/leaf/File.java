package edu.fatec.ipp002.composite.leaf;

import edu.fatec.ipp002.composite.component.FileSystemItem;

public class File implements FileSystemItem
{
    private String name;

    public File(String name)
    {
        this.name = name;
    }

    public void add(FileSystemItem item)
    {
        System.out.println("I'm just a file, can't add");
    }

    // @Override
    public void display(String indent)
    {
        System.out.println(indent + "- File: " + name);
    }
}
