package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class WorkspaceTest {

    private Workspace workspaceUnderTest;

    @BeforeEach
    void setUp() {
        workspaceUnderTest = new Workspace(0);
    }

    @Test
    void testGetId() {
        assertThat(workspaceUnderTest.getId()).isEqualTo(0);
    }

    @Test
    void testChangeStatus() {
        // Setup
        // Run the test
        workspaceUnderTest.changeStatus();

        // Verify the results
    }

    @Test
    void testGetStatus() {
        assertThat(workspaceUnderTest.getStatus()).isFalse();
    }

    @Test
    void testUserGetterAndSetter() {
        final User user = new User("username", "password");
        workspaceUnderTest.setUser(user);
        assertThat(workspaceUnderTest.getUser()).isEqualTo(user);
    }

    @Test
    void testGetStartTime() {
        assertThat(workspaceUnderTest.getStartTime()).isEqualTo(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
    }

    @Test
    void testGetEndTime() {
        assertThat(workspaceUnderTest.getEndTime()).isEqualTo(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
    }

    @Test
    void testBookResource() {
        // Setup
        final User user = new User("username", "password");

        // Run the test
        workspaceUnderTest.bookResource(LocalDateTime.of(2020, 1, 1, 0, 0, 0), LocalDateTime.of(2020, 1, 1, 0, 0, 0),
                user);

        // Verify the results
    }

    @Test
    void testToString() {
        // Setup
        // Run the test
        final String result = workspaceUnderTest.toString();

        // Verify the results
        assertThat(result).isEqualTo("result");
    }
}
