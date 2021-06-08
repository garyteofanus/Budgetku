package com.budgetku.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.budgetku.dto.UserRegistrationDto;
import com.budgetku.model.Role;
import com.budgetku.model.User;
import com.budgetku.repository.UserRepository;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setEmail("test@mail.com");
        user.setPassword("4ea1be751a72");
        user.setRoles(Collections.singletonList(new Role("ROLE_USER")));
    }

    @Test
    public void testServiceSaveUser() {
        UserRegistrationDto registrationDto = new UserRegistrationDto();
        registrationDto.setEmail("test@mail.com");
        registrationDto.setPassword("4ea1be751a72");
        registrationDto.setLastName("dirg");
        registrationDto.setFirstName("rafi");

        User result = userService.save(registrationDto);
        Assertions.assertEquals("test@mail.com", user.getEmail());
    }

    @Test
    void testServiceLoadUserByUsernameUserFound() {
        when(userRepository.findByEmail(any(String.class))).thenReturn(user);

        UserDetails result = userService.loadUserByUsername("test@email.com");
        verify(userRepository, atLeastOnce()).findByEmail(any(String.class));
        Assertions.assertEquals(result.getUsername(), user.getEmail());
    }

    @Test
    void testServiceLoadUserByUsernameUserNotFound() {
        when(userRepository.findByEmail(any(String.class))).thenReturn(null);

        Exception exception = assertThrows(UsernameNotFoundException.class, () ->
                userService.loadUserByUsername("dummy@email.com"));

        assertTrue(exception.getMessage().contains("Invalid username or password."));
    }

}
