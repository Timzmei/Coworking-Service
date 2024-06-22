package org.example.model;

import java.time.LocalDateTime;

public abstract class Resource implements Booking{
    public int getId() {
        return 0;
    }

    public void changeStatus() {

    }

    public boolean getStatus() {
        return false;
    }

}
