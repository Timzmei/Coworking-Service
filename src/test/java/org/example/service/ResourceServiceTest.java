package org.example.service;

import org.example.model.ConferenceRoom;
import org.example.model.Resource;
import org.example.model.User;
import org.example.model.Workspace;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class ResourceServiceTest {

    @Mock
    private Map<Integer, Resource> mockResources;

    @InjectMocks
    private ResourceService resourceServiceUnderTest;

    private AutoCloseable mockitoCloseable;

    @BeforeEach
    void setUp() {
        mockitoCloseable = openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        mockitoCloseable.close();
    }

    @Test
    void testGetAllResources() {
        // Setup
        when(mockResources.values()).thenReturn(List.of());

        // Run the test
        final List<Resource> result = resourceServiceUnderTest.getAllResources();

        // Verify the results
    }

    @Test
    void testGetAllResources_MapReturnsNoItems() {
        // Setup
        when(mockResources.values()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Resource> result = resourceServiceUnderTest.getAllResources();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetResource() {
        // Setup
        when(mockResources.get(0)).thenReturn(null);

        // Run the test
        final Resource result = resourceServiceUnderTest.getResource(0);

        // Verify the results
    }

    @Test
    void testGetResource_MapReturnsNull() {
        // Setup
        when(mockResources.get(0)).thenReturn(null);

        // Run the test
        final Resource result = resourceServiceUnderTest.getResource(0);

        // Verify the results
        assertThat(result).isNull();
    }

    @Test
    void testGetAllAvailableResources() {
        // Setup
        when(mockResources.values()).thenReturn(List.of());

        // Run the test
        final List<Resource> result = resourceServiceUnderTest.getAllAvailableResources();

        // Verify the results
    }

    @Test
    void testGetAllAvailableResources_MapReturnsNoItems() {
        // Setup
        when(mockResources.values()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Resource> result = resourceServiceUnderTest.getAllAvailableResources();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testAddWorkspace() {
        // Setup
        // Run the test
        resourceServiceUnderTest.addWorkspace();

        // Verify the results
        verify(mockResources).put(eq(0), any(Workspace.class));
    }

    @Test
    void testAddConferenceRoom() {
        // Setup
        // Run the test
        resourceServiceUnderTest.addConferenceRoom();

        // Verify the results
        verify(mockResources).put(eq(0), any(ConferenceRoom.class));
    }

    @Test
    void testRemoveResource() {
        // Setup
        when(mockResources.containsKey(0)).thenReturn(false);

        // Run the test
        final Resource result = resourceServiceUnderTest.removeResource(0);

        // Verify the results
        assertThat(result).isNull();
    }

    @Test
    void testRemoveResource_MapContainsKeyReturnsTrue() {
        // Setup
        when(mockResources.containsKey(0)).thenReturn(true);
        when(mockResources.remove(0)).thenReturn(null);

        // Run the test
        final Resource result = resourceServiceUnderTest.removeResource(0);

        // Verify the results
    }

    @Test
    void testRemoveResource_MapRemoveReturnsNull() {
        // Setup
        when(mockResources.containsKey(0)).thenReturn(true);
        when(mockResources.remove(0)).thenReturn(null);

        // Run the test
        final Resource result = resourceServiceUnderTest.removeResource(0);

        // Verify the results
        assertThat(result).isNull();
    }

    @Test
    void testBookResource() {
        // Setup
        final User user = new User("username", "password");
        when(mockResources.get(0)).thenReturn(null);

        // Run the test
        final boolean result = resourceServiceUnderTest.bookResource(0, user, LocalDateTime.of(2020, 1, 1, 0, 0, 0),
                LocalDateTime.of(2020, 1, 1, 0, 0, 0));

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testBookResource_MapReturnsNull() {
        // Setup
        final User user = new User("username", "password");
        when(mockResources.get(0)).thenReturn(null);

        // Run the test
        final boolean result = resourceServiceUnderTest.bookResource(0, user, LocalDateTime.of(2020, 1, 1, 0, 0, 0),
                LocalDateTime.of(2020, 1, 1, 0, 0, 0));

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testCancelBooking() {
        // Setup
        when(mockResources.get(0)).thenReturn(null);

        // Run the test
        final boolean result = resourceServiceUnderTest.cancelBooking(0);

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testCancelBooking_MapReturnsNull() {
        // Setup
        when(mockResources.get(0)).thenReturn(null);

        // Run the test
        final boolean result = resourceServiceUnderTest.cancelBooking(0);

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testGetAllBookings() {
        // Setup
        when(mockResources.values()).thenReturn(List.of());

        // Run the test
        final List<Resource> result = resourceServiceUnderTest.getAllBookings();

        // Verify the results
    }

    @Test
    void testGetAllBookings_MapReturnsNoItems() {
        // Setup
        when(mockResources.values()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Resource> result = resourceServiceUnderTest.getAllBookings();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetBookingsByUser() {
        // Setup
        when(mockResources.values()).thenReturn(List.of());

        // Run the test
        final List<Resource> result = resourceServiceUnderTest.getBookingsByUser("username");

        // Verify the results
    }

    @Test
    void testGetBookingsByUser_MapReturnsNoItems() {
        // Setup
        when(mockResources.values()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Resource> result = resourceServiceUnderTest.getBookingsByUser("username");

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetBookingsByDate() {
        // Setup
        when(mockResources.values()).thenReturn(List.of());

        // Run the test
        final List<Resource> result = resourceServiceUnderTest.getBookingsByDate(LocalDate.of(2020, 1, 1));

        // Verify the results
    }

    @Test
    void testGetBookingsByDate_MapReturnsNoItems() {
        // Setup
        when(mockResources.values()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Resource> result = resourceServiceUnderTest.getBookingsByDate(LocalDate.of(2020, 1, 1));

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetBookingsByResource() throws Exception {
        // Setup
        when(mockResources.values()).thenReturn(List.of());

        // Run the test
        final List<Resource> result = resourceServiceUnderTest.getBookingsByResource("resourceType");

        // Verify the results
    }

    @Test
    void testGetBookingsByResource_MapReturnsNoItems() throws Exception {
        // Setup
        when(mockResources.values()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Resource> result = resourceServiceUnderTest.getBookingsByResource("resourceType");

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetBookingsForResourceOnDate() throws Exception {
        // Setup
        when(mockResources.values()).thenReturn(List.of());

        // Run the test
        final List<Resource> result = resourceServiceUnderTest.getBookingsForResourceOnDate("resourceType",
                LocalDate.of(2020, 1, 1));

        // Verify the results
    }

    @Test
    void testGetBookingsForResourceOnDate_MapReturnsNoItems() throws Exception {
        // Setup
        when(mockResources.values()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Resource> result = resourceServiceUnderTest.getBookingsForResourceOnDate("resourceType",
                LocalDate.of(2020, 1, 1));

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }
}
