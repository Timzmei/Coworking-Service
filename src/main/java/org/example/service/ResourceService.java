package org.example.service;

import org.example.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResourceService {
    private Map<Integer, Resource> resources = new HashMap<>();
    private int resourcesIdCounter = 5;

    public ResourceService() {
        // Инициализация с несколькими ресурсами для тестирования
        resources.put(1, new Workspace(1));
        resources.put(2, new Workspace(2));
        resources.put(3, new ConferenceRoom(3));
        resources.put(4, new ConferenceRoom(4));
    }

    public List<Resource> getAllResources() {
        return resources.values().stream().toList();
    }

    public Resource getResource(int id) {
        return resources.get(id);
    }

    public List<Resource> getAllAvailableResources() {
        return resources.values().stream()
                .filter(Resource::getStatus)
                .collect(Collectors.toList());
    }
    public void addWorkspace() {
        resourcesIdCounter++;
        resources.put(resourcesIdCounter, new Workspace(resourcesIdCounter));
    }

    public void addConferenceRoom() {
        resourcesIdCounter++;
        resources.put(resourcesIdCounter, new ConferenceRoom(resourcesIdCounter));
    }

    public Resource removeResource(int id) {
        if (resources.containsKey(id)) {
            return resources.remove(id);
        } else {
            return  null;
        }

    }

    public boolean bookResource(int id, User user, LocalDateTime startTime, LocalDateTime endTime) {
        Resource resource = resources.get(id);
        if (resource.getStatus()) {
            resource.bookResource(startTime, endTime, user);
            return true;
        } else {
            return false;
        }

    }

    public boolean cancelBooking(int id) {
        Resource resource = resources.get(id);
        if (resource.getStatus()) {
            resource.bookResource(null, null, null);
            return true;
        } else {
            return false;
        }
    }

    public List<Resource> getAllBookings() {
        return resources.values().stream()
                .filter(resource -> !resource.getStatus())
                .collect(Collectors.toList());
    }

    public List<Resource> getBookingsByUser(String username) {
        return resources.values().stream()
                .filter(resource -> !resource.getStatus() && resource.getUser().getUsername().equals(username))
                .collect(Collectors.toList());
    }

    public List<Resource> getBookingsByDate(LocalDate date) {
        return resources.values().stream()
                .filter(resource -> !resource.getStatus() && resource.getStartTime().toLocalDate().equals(date))
                .collect(Collectors.toList());


    }




    public List<Resource> getBookingsByResource(String resourceType) throws ClassNotFoundException {
        Class<?> clazz = Class.forName(resourceType);
        return resources.values().stream()
                .filter(resource -> resource.getClass().equals(clazz))
                .collect(Collectors.toList());
    }

    public List<Resource> getBookingsForResourceOnDate(String resourceType, LocalDate date) throws ClassNotFoundException {
        Class<?> clazz = Class.forName(resourceType);
        return resources.values().stream().filter(resource -> resource.getClass().equals(clazz) &&
                        resource.getStartTime().toLocalDate().equals(date))
                        .collect(Collectors.toList());
    }

//    public boolean removeWorkspace(int id) {
//        return resources.removeIf(workspace -> workspace.getId() == id && workspace instanceof Workspace);
//    }


}