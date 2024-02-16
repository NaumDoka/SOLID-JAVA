package com.app.model.implmentation;

import com.app.model.Project;

import java.time.LocalDate;
import java.util.HashMap;

public class SingletonProject extends Project {

    private final HashMap<String,Object> tasks;
    private static SingletonProject singletonProject;

    private SingletonProject(Long id, String name, LocalDate dateCreated) {
        super(id, name, dateCreated);
        this.tasks = new HashMap<>();
    }

    public static SingletonProject getSingletonProject(Long id, String name, LocalDate dateCreated){
        if(singletonProject == null){
            singletonProject = new SingletonProject(id,name,dateCreated);
        }
        return singletonProject;
    }

    public <T> T getValue(String key, Class<T> clazz) {
        return clazz.cast(tasks.get(key));
    }

    public Object setValue(String key, Object value) {
        return tasks.put(key, value);
    }
}
