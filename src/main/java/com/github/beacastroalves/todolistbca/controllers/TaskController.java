package com.github.beacastroalves.todolistbca.controllers;

import com.github.beacastroalves.todolistbca.controllers.dto.request.TaskRequest;
import com.github.beacastroalves.todolistbca.models.Task;
import com.github.beacastroalves.todolistbca.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<Task> findAll() {
        return this.service.findAll();
    }

    @PutMapping("{id}")
    public void toggleCheckedById(@PathVariable Long id) {
        this.service.toggleCheckedById(id);
    }

    @PostMapping
    public Task store(@RequestBody TaskRequest request) {
        return this.service.store(request.getName());
    }

    @DeleteMapping("{id}")
    public Task deleteById(@PathVariable Long id){
        return this.service.deleteById(id);
    }






}
