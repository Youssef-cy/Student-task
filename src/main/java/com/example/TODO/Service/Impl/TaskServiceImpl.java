package com.example.TODO.Service.Impl;

import com.example.TODO.DTO.TaksDTO.TaskRequest;
import com.example.TODO.DTO.TaksDTO.TaskResponse;
import com.example.TODO.Entity.TaskEntity;
import com.example.TODO.Repo.TaskRepo;
import com.example.TODO.Service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepo taskRepo;

    @Override
    public HttpStatus addTask(Map<String, TaskRequest> task) {
        TaskEntity task1 = new TaskEntity();
        task1.setTask(task);

        try {
            taskRepo.save(task1);
        } catch (Exception ex) {
            return HttpStatus.NOT_ACCEPTABLE;
        }

        return HttpStatus.CREATED;
    }

    @Override
    public HttpStatus updateTask(Long id, Map<String, TaskRequest> task) {

        if (taskRepo.existsById(id)) {
            TaskEntity task1 = taskRepo.findById(id).get();
            task1.setTask(task);
            taskRepo.save(task1);
            return HttpStatus.OK;
        }

        return HttpStatus.NOT_ACCEPTABLE;
    }

    @Override
    public HttpStatus deleteTask(Long id) {
        if (taskRepo.existsById(id)) {
            taskRepo.deleteById(id);
            return HttpStatus.OK;
        }
        return HttpStatus.NOT_ACCEPTABLE;
    }

    @Override
    public List<TaskResponse> getAllTasks() {
        List<TaskEntity> tasks = taskRepo.findAll();
        if (tasks.isEmpty()) {
            return new ArrayList<>();
        }
        List<TaskResponse> taskResponses = new ArrayList<>();
        for (TaskEntity task : tasks) {
            TaskResponse taskResponse = new TaskResponse();
            taskResponse.setId(task.getId());
        }
        return taskResponses;
    }
}
