package com.thehecklers.sburrestdemo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class Client
{
    @Getter
    private final String id;
    
    @Setter
    @Getter
    private String name;

    public Client(String id, String name)
    {
        this.id = id == null ? UUID.randomUUID().toString() : id;
        this.name = name;
    }

    public Client(String name)
    {
        this(UUID.randomUUID().toString(), name);
    }
}