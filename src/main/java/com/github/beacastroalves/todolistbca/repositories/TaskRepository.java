package com.github.beacastroalves.todolistbca.repositories;

import com.github.beacastroalves.todolistbca.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
