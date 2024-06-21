package org.example.controller;

import org.example.model.ConferenceRoom;
import org.example.model.Workspace;
import org.example.service.ResourceService;

import java.util.List;

public class ResourceController {
    private ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    public List<Workspace> getAllWorkspaces() {
        return resourceService.getAllWorkspaces();
    }

    public List<ConferenceRoom> getAllConferenceRooms() {
        return resourceService.getAllConferenceRooms();
    }
}