package com.app.repository.implementation;

import com.app.model.Project;
import com.app.repository.ProjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectRepositoryImplementation implements ProjectRepository {

    private List<Project> projects = new ArrayList<>();
    @Override
    public Optional<Project> findById(Long id) {
        return projects
                .stream()
                .filter(p -> p.getId()==id)
                .findFirst();
    }

    @Override
    public Project save(Project project) {
        Project existingProject = findById(project.getId()).orElse(null);
        if( existingProject == null ) {
            projects.add(project);
        } else {
            projects.remove(existingProject);
            Project newProject  =  new Project(project);
            projects.add(newProject);
        }
        return project;
    }
}
