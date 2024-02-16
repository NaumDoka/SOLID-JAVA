package com.app.service.implementation;

import com.app.model.Project;
import com.app.repository.ProjectRepository;
import com.app.service.ProjectService;

import java.util.Optional;


public class ProjectServiceImplementation implements ProjectService {

    private ProjectRepository projectRepository;


    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }
}
