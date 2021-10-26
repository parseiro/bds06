package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private AuthService authService;

/*    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        authService.validateSelfOrAdmin(id);
        Optional<User> obj = repository.findById(id);
        User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new UserDTO(entity);
    }*/

    @Transactional(readOnly = true)
    public UserDTO getSelfProfile() {
        var loggedUser = authService.authenticated();
        return new UserDTO(loggedUser);
    }

    @Override
    public User loadUserByUsername(final String s) throws UsernameNotFoundException {
        final User user = repository.findByEmail(s);
        if (user == null) {
            log.error("User not found: " + s);
            throw new UsernameNotFoundException("Email not found");
        }
        log.info("User found: " + s);
        return user;
    }
}
