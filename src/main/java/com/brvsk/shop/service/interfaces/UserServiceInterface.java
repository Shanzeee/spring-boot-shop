package com.brvsk.shop.service.interfaces;

import com.brvsk.shop.utils.Role;
import com.brvsk.shop.model.User;

import java.util.Optional;

public interface UserServiceInterface {
    User saveUser(User user);

    Optional<User> findUserByUsername(String username);

    void changeRole(Role newRole, String username);
}
