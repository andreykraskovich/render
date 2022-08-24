package com.example.render.service;

import com.example.render.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {

    Page<Task> getAll(Pageable pageable);
    Task findById(Long id);

    void save(Task task);

    void deleteById(Long id);
}
