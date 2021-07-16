package com.taty.usermanager.service;

import com.taty.usermanager.model.User;
import com.taty.usermanager.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user) {
         return userRepo.save(user);
    }

    public List<User> findAllUsers() {
         return userRepo.findAll();
    }


}
