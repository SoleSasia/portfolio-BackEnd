
package com.solesasia.portfolio.services;

import com.solesasia.portfolio.dto.ProjectDto;


public interface IProjectService {
    
    public void createProject(ProjectDto projectDto);
    
    public boolean updateProject(Long id, ProjectDto projectDto);
    
    public void deleteProject(Long id);
    
}
