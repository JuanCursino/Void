package edu.fatec.ipp002.composite.composite;

import java.util.ArrayList;
import java.util.List;

import edu.fatec.ipp002.composite.component.FileSystemItem;

public class Folder implements FileSystemItem
{
    private String name;
    private List<FileSystemItem> children = new ArrayList<>();

    public Folder(String name)
    {
        this.name = name;
    }

    public void add(FileSystemItem item)
    {
        children.add(item);
    }

    // @Override
    public void display(String indent)
    {
        System.out.println(indent + "+ Folder: " + name);
        for (FileSystemItem item : children)
        {
            item.display(indent + "  ");
        }
    }
}
