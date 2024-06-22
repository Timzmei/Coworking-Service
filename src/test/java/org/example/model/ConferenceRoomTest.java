package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class ConferenceRoomTest {

    private ConferenceRoom conferenceRoomUnderTest;

    @BeforeEach
    void setUp() {
        conferenceRoomUnderTest = new ConferenceRoom(0);
    }

    @Test
    void testGetId() {
        assertThat(conferenceRoomUnderTest.getId()).isEqualTo(0);
    }

    @Test
    void testChangeStatus() {
        // Setup
        // Run the test
        conferenceRoomUnderTest.changeStatus();

        // Verify the results
    }

    @Test
    void testGetStatus() {
        assertThat(conferenceRoomUnderTest.getStatus()).isFalse();
    }

    @Test
    void testUserGetterAndSetter() {
        final User user = new User("username", "password");
        conferenceRoomUnderTest.setUser(user);
        assertThat(conferenceRoomUnderTest.getUser()).isEqualTo(user);
    }

    @Test
    void testGetStartTime() {
        assertThat(conferenceRoomUnderTest.getStartTime()).isEqualTo(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
    }

    @Test
    void testGetEndTime() {
        assertThat(conferenceRoomUnderTest.getEndTime()).isEqualTo(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
    }

    @Test
    void testBookResource() {
        // Setup
        final User user = new User("username", "password");

        // Run the test
        conferenceRoomUnderTest.bookResource(LocalDateTime.of(2020, 1, 1, 0, 0, 0),
                LocalDateTime.of(2020, 1, 1, 0, 0, 0), user);

        // Verify the results
    }

    @Test
    void testToString() {
        // Setup
        // Run the test
        final String result = conferenceRoomUnderTest.toString();

        // Verify the results
        assertThat(result).isEqualTo("result");
    }
}
