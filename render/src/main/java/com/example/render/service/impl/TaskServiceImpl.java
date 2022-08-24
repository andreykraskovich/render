package com.example.render.service.impl;

import com.example.render.enums.TaskStatus;
import com.example.render.exception.ObjectNotFoundException;
import com.example.render.model.Task;
import com.example.render.model.User;
import com.example.render.repository.TaskRepository;
import com.example.render.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Page<Task> getAll(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(

                        () -> new ObjectNotFoundException("Task with id: " + id + " not found")
                );
    }

    @Override
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> findByUser(User user){
        return taskRepository.findByUser(user);
    }

    public void updateStatus(Task task) {
        int min = 60000;
        int max = 300000;
        int randomTimeInterval = min + (int) (Math.random() * max);

        try {
            Thread.sleep(randomTimeInterval);
            log.info("Задача с id = " + task.getId() + " выполнена");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.setTaskStatus(TaskStatus.COMPLETE);
        taskRepository.save(task);
    }
}
