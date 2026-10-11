package com.example.TODO.Controller;

import com.example.TODO.DTO.TaksDTO.TaskRequest;
import com.example.TODO.DTO.TaksDTO.TaskResponse;
import com.example.TODO.Service.Impl.TaskServiceImpl;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/API/V1/Tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskServiceImpl taskService;

    @PostMapping
    //    add Task
    public HttpStatus addTask(@RequestBody @NotBlank Map<String, TaskRequest> taskRequest) {

        HttpStatus task = taskService.addTask(taskRequest);
        return task;

    }


    //    updateTask
    @PutMapping("/{id}")
    public HttpStatus updateTask(@PathVariable Long id, @RequestBody @NotBlank Map<String, TaskRequest> taskRequest) {
        HttpStatus task = taskService.updateTask(id, taskRequest);
        return task;
    }

    //    delete
    @DeleteMapping("/{id}")
    public HttpStatus deleteTask(@PathVariable Long id) {
        HttpStatus task = taskService.deleteTask(id);
        return task;
    }

    @GetMapping
    public List<TaskResponse> getAllTasks() {
        List<TaskResponse> tasks = taskService.getAllTasks();
        if (tasks.isEmpty()) {
            return new ArrayList<>();
        }
        return tasks;
    }


}
