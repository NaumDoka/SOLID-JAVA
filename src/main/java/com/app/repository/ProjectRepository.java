package com.app.repository;

import com.app.model.Project;

import java.util.Optional;

public interface ProjectRepository {
    Optional<Project> findById(Long id);
    Project save(Project project);
}
