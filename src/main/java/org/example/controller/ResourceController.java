package org.example.controller;

import org.example.model.*;
import org.example.service.ResourceService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class ResourceController {
    private ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    public List<Resource> getAllResources() {
        return resourceService.getAllResources();
    }

    public Resource getResource(int id) {
        return resourceService.getResource(id);
    }

    public List<Resource> getAllAvailableResources() {
        return resourceService.getAllAvailableResources();
    }

    public void addWorkspace() {
        resourceService.addWorkspace();
    }

    public void addConferenceRoom() {
        resourceService.addConferenceRoom();
    }

    public Resource removeResource(int id) {
        return resourceService.removeResource(id);
    }

    public boolean bookResource(int resourceId, User user, LocalDateTime startTime, LocalDateTime endTime) {
        return resourceService.bookResource(resourceId, user, startTime, endTime);

    }

    public boolean cancelBooking(int id) {
        return resourceService.cancelBooking(id);
    }

    public List<Resource> getAllBookings() {
        return resourceService.getAllBookings();
    }

    public List<Resource> getBookingsByUser(String username) {
        return resourceService.getBookingsByUser(username);
    }

    public List<Resource> getBookingsByDate(LocalDate date) {
        return resourceService.getBookingsByDate(date);
    }

    public List<Resource> getBookingsByResource(String resourceType) throws ClassNotFoundException {
        return resourceService.getBookingsByResource(resourceType);
    }

    public List<Resource> getBookingsForResourceOnDate(String resourceType, LocalDate date) throws ClassNotFoundException {
        return resourceService.getBookingsForResourceOnDate(resourceType, date);
    }
}