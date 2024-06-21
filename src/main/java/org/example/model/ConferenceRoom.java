package org.example.model;

public class ConferenceRoom {
    private int id;
    private String name;

    public ConferenceRoom(int id, String name) {
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
        return "ConferenceRoom{id=" + id + ", name='" + name + "'}";
    }
}