package com.example.render.service;

import com.example.render.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<User> getAll(Pageable pageable);

    User findById(Long id);

    void save(User user);

    void deleteById(Long id);
}
