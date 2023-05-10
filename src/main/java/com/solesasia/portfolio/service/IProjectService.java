
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.dto.ProjectDto;


public interface IProjectService {
    
    public void crearProyecto(ProjectDto proyecto);
    
    public boolean editarProyecto(Long id, ProjectDto proyecto);
    
    public void borrarProyecto(Long id);
    
}
