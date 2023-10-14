package edu.miu.cs.lab07.services;

import edu.miu.cs.lab07.config.SecurityConfig;
import edu.miu.cs.lab07.models.User;
import edu.miu.cs.lab07.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(User user){
        user.setPassword(this.encodePassword(user.getPassword()));
        return userRepository.save(user);
    }

    private String encodePassword(String password){
        return new BCryptPasswordEncoder().encode(password);
    }

}
