package com.app.factory;

import com.app.model.Task;

//task Factory
public class TaskFactory {
    public Task getTask(String taskName){
        return new Task(taskName, "description");
    }
}
