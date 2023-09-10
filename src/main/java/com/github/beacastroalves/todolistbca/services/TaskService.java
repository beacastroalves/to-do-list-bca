package com.github.beacastroalves.todolistbca.services;

import com.github.beacastroalves.todolistbca.models.Task;
import com.github.beacastroalves.todolistbca.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> findAll() {
        return this.repository.findAll();
    }

    public void toggleCheckedById(Long taskId) {
        Optional<Task> optional = this.repository.findById(taskId);
        if (optional.isPresent()) {
            Task task = optional.get();
            task.setChecked(!task.getChecked());
            this.repository.save(task);
        } else {
            System.out.println("Error task #" + taskId + " is not present");
        }
    }

    public Task store(String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }

        Task task = new Task(null, name, false);
        this.repository.save(task);
        return task;
    }

    public Task deleteById(Long id) {
        Optional<Task> optional = this.repository.findById(id);
        if (optional.isPresent()) {
            Task task = optional.get();
            this.repository.deleteById(id);

            return task;
        } else {
            System.out.println("Error task #" + id + " is not present");
        }

        return null;
    }

}
