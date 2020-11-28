package com.example.demo.Service;

import com.example.demo.Beans.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(User user)
    {
        userRepository.save(user);

    }

    public List<User> getUser()
    {
        return userRepository.findAll();
    }

    public User searchBook(int id)
    {
        return userRepository.findById(id);
    }
}
