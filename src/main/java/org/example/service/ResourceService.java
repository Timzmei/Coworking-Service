package org.example.service;

import org.example.model.ConferenceRoom;
import org.example.model.Workspace;

import java.util.ArrayList;
import java.util.List;

public class ResourceService {
    private List<Workspace> workspaces = new ArrayList<>();
    private List<ConferenceRoom> conferenceRooms = new ArrayList<>();

    public ResourceService() {
        // Инициализация с несколькими ресурсами для тестирования
        workspaces.add(new Workspace(1, "Workspace 1"));
        workspaces.add(new Workspace(2, "Workspace 2"));
        conferenceRooms.add(new ConferenceRoom(1, "Conference Room 1"));
        conferenceRooms.add(new ConferenceRoom(2, "Conference Room 2"));
    }

    public List<Workspace> getAllWorkspaces() {
        return workspaces;
    }

    public List<ConferenceRoom> getAllConferenceRooms() {
        return conferenceRooms;
    }
}