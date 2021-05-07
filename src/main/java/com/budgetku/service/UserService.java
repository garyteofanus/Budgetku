package com.budgetku.service;

import com.budgetku.dto.UserRegistrationDto;
import com.budgetku.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
