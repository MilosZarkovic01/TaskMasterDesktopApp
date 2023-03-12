/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.math.BigDecimal;
import java.util.List;
import model.Project;
import persistence.dao.impl.ProjectDaoImpl;
import java.sql.SQLException;
import java.util.Map;
import persistence.dao.ProjectDao;

/**
 *
 * @author Somika
 */
public class ProjectController {

    private static ProjectController instance;
    private final ProjectDao repositoryProject;

    private ProjectController() {
        repositoryProject = new ProjectDaoImpl();
    }

    public static ProjectController getInstance() {
        if (instance == null) {
            instance = new ProjectController();
        }
        return instance;
    }

    public List<Project> getAllProjects() throws SQLException {
        return repositoryProject.getAllProjects();
    }

    public void saveProject(Project project) throws SQLException {
        repositoryProject.saveProject(project);
    }

    public void deleteProject(Project project) throws SQLException {
        repositoryProject.deleteProject(project);
    }

    public Map<String, BigDecimal> getAverageSalaryByProject() throws SQLException {
        return repositoryProject.getAverageSalaryByProject();
    }

    public Map<String, Integer> getTaskCountPerProject() throws SQLException {
        return repositoryProject.getTaskCountPerProject();
    }

    public double calculateAverageProjectDuration() throws SQLException{
        return repositoryProject.calculateAverageProjectDuration();
    }

}
