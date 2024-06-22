package org.example.model;

import java.time.LocalDateTime;

public interface Booking {

    User getUser();

    void setUser(User user);

    LocalDateTime getStartTime();

    LocalDateTime getEndTime();

    void bookResource(LocalDateTime startTime, LocalDateTime endTime, User user);

}
