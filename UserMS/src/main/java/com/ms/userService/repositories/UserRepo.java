package com.ms.userService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ms.userService.entities.User;
@Repository
public interface UserRepo extends JpaRepository<User, String>{

}
