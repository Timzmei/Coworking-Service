package org.example.model;

import java.time.LocalDateTime;

public class Workspace extends Resource implements Booking {
    private int id;
    private boolean status;
    private User user;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    public Workspace(int id) {
        this.id = id;
        this.status = true;
        this.user = null;
        this.startTime = null;
        this.endTime = null;
    }
    @Override
    public int getId() {
        return id;
    }
    @Override
    public void changeStatus() {
        this.status = !this.status;
    }
    @Override
    public boolean getStatus() {
        return this.status;
    }

    @Override
    public User getUser() {
        return user;
    }
    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public LocalDateTime getStartTime() {
        return startTime;
    }

    @Override
    public LocalDateTime getEndTime() {
        return endTime;
    }

    @Override
    public void bookResource(LocalDateTime startTime, LocalDateTime endTime, User user) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.user = user;
        this.status = false;
    }


    @Override
    public String toString() {
        if (this.status) {
            return "Workspace{id=" + id + "}";
        } else {
            return "Workspace{id=" + id + ", username='" + user.getUsername() + "', startTime=" + startTime + ", endTime=" + endTime + '}';
        }

    }
}