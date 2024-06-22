package org.example.service;

import org.example.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class UserServiceTest {

    @Mock
    private Map<String, User> mockUsers;

    @InjectMocks
    private UserService userServiceUnderTest;

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
    void testRegister() {
        // Setup
        when(mockUsers.containsKey("username")).thenReturn(false);

        // Run the test
        final boolean result = userServiceUnderTest.register("username", "password");

        // Verify the results
        assertThat(result).isTrue();
        verify(mockUsers).put(eq("username"), any(User.class));
    }

    @Test
    void testRegister_MapContainsKeyReturnsTrue() {
        // Setup
        when(mockUsers.containsKey("username")).thenReturn(true);

        // Run the test
        final boolean result = userServiceUnderTest.register("username", "password");

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testLogin() {
        // Setup
        when(mockUsers.get("username")).thenReturn(new User("username", "password"));

        // Run the test
        final User result = userServiceUnderTest.login("username", "password");

        // Verify the results
    }

    @Test
    void testLogin_MapReturnsNull() {
        // Setup
        when(mockUsers.get("username")).thenReturn(null);

        // Run the test
        final User result = userServiceUnderTest.login("username", "password");

        // Verify the results
        assertThat(result).isNull();
    }
}
