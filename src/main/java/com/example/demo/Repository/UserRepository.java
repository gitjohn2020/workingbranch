package com.example.demo.Repository;

import com.example.demo.Beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

  public User findById(int id);

  public User findByUsername(String username);
}
