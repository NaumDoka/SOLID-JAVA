package com.app.service.implementation;

import com.app.factory.TaskFactory;
import com.app.model.Task;
import com.app.model.implmentation.SingletonProject;
import com.app.service.TaskService;

import java.time.LocalDate;

public class TaskServiceImplementation implements TaskService {
    private final TaskFactory taskFactory;
    private final SingletonProject singletonProject;

    public TaskServiceImplementation(TaskFactory taskFactory) {
        this.taskFactory = taskFactory;
        this.singletonProject = SingletonProject.getSingletonProject(1L,"FirstProject", LocalDate.now());
    }

    public TaskServiceImplementation(TaskFactory taskFactory, SingletonProject singletonProject) {
        this.taskFactory = taskFactory;
        this.singletonProject = singletonProject;
    }

    @Override
    public Task getTask(String taskName) {
        Task task = singletonProject.getValue(taskName, Task.class);
        if (task == null) {
            task = taskFactory.getTask(taskName);
        }
        return task;
    }
}
