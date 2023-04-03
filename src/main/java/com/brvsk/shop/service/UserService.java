package com.brvsk.shop.service;

import com.brvsk.shop.utils.Role;
import com.brvsk.shop.model.User;
import com.brvsk.shop.repository.UserRepository;
import com.brvsk.shop.service.interfaces.UserServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreateTime(LocalDateTime.now());

        return userRepository.save(user);
    }
    @Override
    public Optional<User> findUserByUsername(String username){
        return userRepository.findByUsername(username);
    }
    @Override
    @Transactional
    public void changeRole(Role newRole, String username){
        userRepository.updateUserRole(username, newRole);
    }
}
