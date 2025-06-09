package edu.fatec.ipp002.composite.component;

public interface FileSystemItem
{
    void add(FileSystemItem item);
    void display(String indent);   
}
