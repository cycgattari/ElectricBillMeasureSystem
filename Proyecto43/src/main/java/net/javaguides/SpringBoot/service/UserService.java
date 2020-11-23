package net.javaguides.SpringBoot.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import net.javaguides.SpringBoot.user.User;
import net.javaguides.SpringBoot.web.dto.UserRegistrationDto;

@Service
public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
