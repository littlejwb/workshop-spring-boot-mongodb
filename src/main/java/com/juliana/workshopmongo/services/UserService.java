package com.juliana.workshopmongo.services;

import com.juliana.workshopmongo.domain.User;
import com.juliana.workshopmongo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll(){
        return repository.findAll();
    }
}
