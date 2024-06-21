package org.example.model;

public class Workspace {
    private int id;
    private String name;

    public Workspace(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Workspace{id=" + id + ", name='" + name + "'}";
    }
}