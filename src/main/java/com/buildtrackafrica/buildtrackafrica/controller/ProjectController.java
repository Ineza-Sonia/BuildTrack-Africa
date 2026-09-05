package com.buildtrackafrica.buildtrackafrica.controller;

import com.buildtrackafrica.buildtrackafrica.dao.ProjectDAO;
import com.buildtrackafrica.buildtrackafrica.entity.Project;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.List;

@Named("projectController")
@RequestScoped
public class ProjectController {

    private Long editId;

    public Long getEditId() { return editId; }
    public void setEditId(Long editId) { this.editId = editId; }
    private Project project = new Project();
    private final ProjectDAO projectDAO = new ProjectDAO();

    public String save() {
        projectDAO.save(project);
        project = new Project(); // reset form
        return "list.xhtml?faces-redirect=true";
    }

    public String update() {
        projectDAO.update(project);
        return "list.xhtml?faces-redirect=true";
    }

    public String delete(Long id) {
        projectDAO.delete(id);
        return "list.xhtml?faces-redirect=true";
    }

    public void loadForEdit(Long id) {
        this.project = projectDAO.findById(id);
    }

    public List<Project> getAllProjects() {
        return projectDAO.findAll();
    }

    public Project getProject() { return project; }
    public void setProject(Project project) { this.project = project; }
}