/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence.dao.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import persistence.dao.TaskDao;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;
import model.Project;
import persistence.connection.DBConnectionFactory;

/**
 *
 * @author Somika
 */
public class TaskDaoImpl implements TaskDao {

    @Override
    public List<Task> getAllTasks() throws SQLException {
        List<Task> tasks = new ArrayList<>();

        String sql = """
                     SELECT t.*, e.*, p.* FROM task t
                     LEFT JOIN employee e
                     ON t.assigned_employee_fk = e.id
                     INNER JOIN project p
                     ON t.project_fk = p.id""";

        try {
            Connection conn = DBConnectionFactory.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Task task = new Task();
                task.setId(rs.getLong("t.id"));
                task.setTitle(rs.getString("t.title"));
                task.setDescription(rs.getString("t.description"));
                task.setDueDate(rs.getDate("t.due_date").toLocalDate());

                // Set assigned employee for task
                Long employeeId = rs.getLong("assigned_employee_fk");
                if (employeeId != 0) {
                    Employee employee = new Employee();
                    employee.setId(employeeId);
                    employee.setFullName(rs.getString("e.full_name"));
                    employee.setEmail(rs.getString("e.email"));
                    employee.setPhoneNumber(rs.getString("e.phone_number"));
                    employee.setDateOfBirth(rs.getDate("e.date_of_birth").toLocalDate());
                    employee.setMonthlySalary(BigDecimal.valueOf(rs.getDouble("e.monthly_salary")));
                    task.setAssignedEmployee(employee);
                }

                // Set project for task
                Project project = new Project();
                project.setId(rs.getLong("project_fk"));
                project.setProjectName(rs.getString("p.project_name"));
                project.setDescription(rs.getString("p.description"));
                project.setStartDate(rs.getDate("p.start_date").toLocalDate());
                project.setEndDate(rs.getDate("p.end_date").toLocalDate());
                project.setBudget(BigDecimal.valueOf(rs.getDouble("p.budget")));
                task.setProject(project);

                tasks.add(task);
            }
        } catch (Exception ex) {
            Logger.getLogger(TaskDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tasks;
    }

    @Override
    public void saveTask(Task task) throws SQLException {
        try {
            String sql = "INSERT INTO task(title, description, due_date, assigned_employee_fk, project_fk) VALUES(?,?,?,?,?);";
            Connection conn = DBConnectionFactory.getInstance().getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, task.getTitle());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setDate(3, java.sql.Date.valueOf(task.getDueDate()));

            Long assignedEmployeeId = null;
            Employee assignedEmployee = task.getAssignedEmployee();
            if (assignedEmployee != null) {
                assignedEmployeeId = assignedEmployee.getId();
            }

            preparedStatement.setObject(4, assignedEmployeeId, Types.BIGINT);
            preparedStatement.setLong(5, task.getProject().getId());
            preparedStatement.executeUpdate();

            preparedStatement.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(TaskDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateTask(Task task) throws SQLException {
        try {

            String sql = "UPDATE task SET title = ?, description = ?, assigned_employee_fk = ?, due_date = ?,  project_fk = ? WHERE id = ?";
            Connection connection = DBConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, task.getTitle());
            ps.setString(2, task.getDescription());

            if (task.getAssignedEmployee() != null) {
                ps.setLong(3, task.getAssignedEmployee().getId());
            } else {
                ps.setNull(3, Types.BIGINT);
            }
            ps.setDate(4, java.sql.Date.valueOf(task.getDueDate()));
            ps.setLong(5, task.getProject().getId());
            ps.setLong(6, task.getId());

            ps.executeUpdate();

            ps.close();
            connection.close();
        } catch (Exception ex) {
            Logger.getLogger(TaskDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteTask(Task task) throws SQLException {
        try {
            String sql = "DELETE FROM task WHERE id = ?";
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, task.getId());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            Logger.getLogger(TaskDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Task> getUnassignedTasks() throws SQLException {
        try {
            String sql = """
                         SELECT t.*, p.* FROM task t
                         INNER JOIN project p
                         ON t.project_fk = p.id
                         WHERE t.assigned_employee_fk IS NULL""";

            List<Task> unassignedTasks = new ArrayList<>();
            Connection conn = DBConnectionFactory.getInstance().getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Task task = new Task();
                task.setId(rs.getLong("t.id"));
                task.setTitle(rs.getString("t.title"));
                task.setDescription(rs.getString("t.description"));
                task.setDueDate(rs.getDate("t.due_date").toLocalDate());

                Project project = new Project();
                project.setId(rs.getLong("p.id"));
                project.setProjectName(rs.getString("p.project_name"));
                project.setDescription(rs.getString("p.description"));
                project.setStartDate(rs.getDate("p.start_date").toLocalDate());
                project.setEndDate(rs.getDate("p.end_date").toLocalDate());
                project.setBudget(BigDecimal.valueOf(rs.getDouble("p.budget")));
                task.setProject(project);

                unassignedTasks.add(task);
            }

            statement.close();
            conn.close();

            return unassignedTasks;
        } catch (Exception ex) {
            Logger.getLogger(TaskDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
