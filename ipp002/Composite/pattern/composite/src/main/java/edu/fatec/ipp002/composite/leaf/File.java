package edu.fatec.ipp002.composite.leaf;

import edu.fatec.ipp002.composite.component.FileSystemItem;

public class File implements FileSystemItem
{
    private String name;

    public File(String name)
    {
        this.name = name;
    }

    // @Override
    public void display(String indent)
    {
        System.out.println(indent + "- File: " + name);
    }
}
