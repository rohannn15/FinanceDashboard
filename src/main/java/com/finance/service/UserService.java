package com.finance.service;

import com.finance.entity.User;
import com.finance.exception.CustomException;
import com.finance.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service   // ✅ Registers as Spring Bean
   // ✅ Auto constructor injection
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User save(User user) {
        return repo.save(user);
    }

    public List<User> getAll() {
        return repo.findAll();
    }

    public User getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new CustomException("User not found"));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}