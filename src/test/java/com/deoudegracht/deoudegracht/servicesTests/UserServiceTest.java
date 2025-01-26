package com.deoudegracht.deoudegracht.servicesTests;

import com.deoudegracht.deoudegracht.DeOudegrachtApplication;
import com.deoudegracht.deoudegracht.models.User;
import com.deoudegracht.deoudegracht.repositories.UserRepository;
import com.deoudegracht.deoudegracht.services.UserService;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration(classes={DeOudegrachtApplication.class})
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;
    @Mock
    User user;
    @Test
    public void testFindByUsername() {
        //given
        String username = "test.username";
        String expectedUsername = "test.username";
        user = new User(username, "password12345", "firstname", "lastname", " email@email.com", "not provided");
        User mockSavedUser = userService.createUser(user);

        // when
        Mockito.when(userRepository.findByUsername(expectedUsername)).thenReturn(Optional.of(user));
        Optional<User> found = userService.findByUsername(expectedUsername);

        // then
        assertEquals(expectedUsername, found.get().getUsername());
    }
    @Test
    public void testCreateUser() {
        //given
        User user = new User("username", "password12345", "firstname", "lastname", " email@email.com", "not provided");

        // when
        Mockito.when(userRepository.save(user)).thenReturn(user);
        User createdUser = userService.createUser(user);

        // then
        assertEquals(user.getUsername(), createdUser.getUsername());
        assertEquals(user.getPassword(), createdUser.getPassword());
        assertEquals(user.getFirstname(), createdUser.getFirstname());
        assertEquals(user.getLastname(), createdUser.getLastname());
        assertEquals(user.getEmail(), createdUser.getEmail());
        assertEquals(user.getPhone(), createdUser.getPhone());
    }
}
