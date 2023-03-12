/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistence.dao;

import java.util.List;
import model.Task;
import java.sql.SQLException;

/**
 *
 * @author Somika
 */
public interface TaskDao {
    public List<Task> getAllTasks() throws SQLException;
    public List<Task> getUnassignedTasks() throws SQLException;
    public void saveTask(Task task) throws SQLException;
    public void updateTask(Task task) throws SQLException;
    public void deleteTask(Task task) throws SQLException;
}
