/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.List;
import model.Task;
import persistence.dao.TaskDao;
import persistence.dao.impl.TaskDaoImpl;
import java.sql.SQLException;

/**
 *
 * @author Somika
 */
public class TaskController {

    private static TaskController instance;
    private final TaskDao repositoryTask;

    private TaskController() {
        repositoryTask = new TaskDaoImpl();
    }

    public static TaskController getInstance() {
        if (instance == null) {
            instance = new TaskController();
        }
        return instance;
    }

    public List<Task> getAllTasks() throws SQLException {
        return repositoryTask.getAllTasks();
    }
    
    public void saveTask(Task task) throws SQLException{
        repositoryTask.saveTask(task);
    }
    
    public void updateTask(Task task) throws SQLException{
        repositoryTask.updateTask(task);
    }
    
    public void deleteTask(Task task) throws SQLException{
        repositoryTask.deleteTask(task);
    }
    
    public List<Task> getUnassignedTasks()throws SQLException{
        return repositoryTask.getUnassignedTasks();
    }
}
