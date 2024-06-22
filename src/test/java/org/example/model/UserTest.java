package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    private User userUnderTest;

    @BeforeEach
    void setUp() {
        userUnderTest = new User("username", "password");
    }

    @Test
    void testGetUsername() {
        assertThat(userUnderTest.getUsername()).isEqualTo("username");
    }

    @Test
    void testGetPassword() {
        assertThat(userUnderTest.getPassword()).isEqualTo("password");
    }
}
