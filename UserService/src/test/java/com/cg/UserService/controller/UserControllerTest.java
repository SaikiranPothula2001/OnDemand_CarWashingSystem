package com.cg.UserService.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cg.UserService.exception.UserException;
import com.cg.UserService.model.UserEntity;
import com.cg.UserService.service.UserServiceImpl;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserServiceImpl userService;

    @BeforeEach
    public void setup() throws UserException {
        MockitoAnnotations.initMocks(this);
        userController.addwashPackId(1, new UserEntity(null, null, null, null, null, 0)); // Initialize the controller
    }

//    @Test
//    public void testAddUser() throws UserException {
//        UserEntity user = new UserEntity(null, null, null, null, null, 0);
//        when(userService.addUser(user)).thenReturn(user);
//
//        ResponseEntity<UserEntity> response = userController.addUser(user);
//
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//        assertEquals(user, response.getBody());
//    }

    @Test
    public void testUpdateUserPhoneNumberAndEmail() throws UserException {
        int userId = 1;
        UserEntity user = new UserEntity(null, null, null, null, null, userId);
        when(userService.updateUserPhoneNumberAndEmail(userId, user)).thenReturn(user);

        ResponseEntity<UserEntity> response = userController.updateUserPhoneNumberAndEmail(userId, user);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    public void testGetUserById() throws UserException {
        int userId = 1;
        UserEntity user = new UserEntity(null, null, null, null, null, userId);
        when(userService.getUserById(userId)).thenReturn(user);

        ResponseEntity<UserEntity> response = userController.getUserById(userId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

//    @Test
//    public void testGetAllUsers() {
//        // Mock the list of users returned by the service
//        when(userService.getAllUsers()).thenReturn(List.of());
//
//        ResponseEntity<List<UserEntity>> response = userController.getAllUsers();
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(2, response.getBody().size()); // Assuming 2 users in the list
//    }

    @Test
    public void testAddWashPackId() throws UserException {
        int userId = 1;
        UserEntity washPackId = new UserEntity(null, null, null, null, null, userId);
        when(userService.addwashPackId(userId, washPackId)).thenReturn(washPackId);

        ResponseEntity<UserEntity> response = userController.addwashPackId(userId, washPackId);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(washPackId, response.getBody());
    }

    @Test
    public void testFindByEmail() throws UserException {
        String emailId = "test@example.com";
        UserEntity user = new UserEntity(emailId, emailId, emailId, emailId, emailId, 0);
        when(userService.findByEmail(emailId)).thenReturn(user);

        ResponseEntity<UserEntity> response = userController.findByEmail(emailId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }
}
