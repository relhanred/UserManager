package com.taty.usermanager.repo;

import com.taty.usermanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, Long> {
}
