/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistence.dao;

import java.math.BigDecimal;
import java.util.List;
import model.Project;
import java.sql.SQLException;
import java.util.Map;

/**
 *
 * @author Somika
 */
public interface ProjectDao {
    public List<Project> getAllProjects() throws SQLException;
    public void saveProject(Project project) throws SQLException;
    public void deleteProject(Project project) throws SQLException;
    public Map<String, BigDecimal> getAverageSalaryByProject() throws SQLException;
    public Map<String, Integer> getTaskCountPerProject() throws SQLException;
    public double calculateAverageProjectDuration() throws SQLException;
}
