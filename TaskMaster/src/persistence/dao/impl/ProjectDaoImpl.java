/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;
import model.Project;
import model.Task;
import persistence.connection.DBConnectionFactory;
import persistence.dao.ProjectDao;

/**
 *
 * @author Somika
 */
public class ProjectDaoImpl implements ProjectDao {

    @Override
    public List<Project> getAllProjects() {
        List<Project> projects = new ArrayList<>();
        try {
            Map<Long, Project> projectMap = new HashMap<>();
            Connection conn = DBConnectionFactory.getInstance().getConnection();
            String sql = "SELECT p.*, t.*, e.* FROM project p\n"
                    + "LEFT JOIN task t\n"
                    + "ON p.id = t.project_fk\n"
                    + "LEFT JOIN employee e\n"
                    + "ON t.assigned_employee_fk = e.id";

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                long projectId = resultSet.getLong("p.id");

                if (!projectMap.containsKey(projectId)) {
                    Project project = new Project();
                    project.setId(projectId);
                    project.setProjectName(resultSet.getString("p.project_name"));
                    project.setDescription(resultSet.getString("p.description"));
                    project.setStartDate(resultSet.getDate("p.start_date").toLocalDate());
                    project.setEndDate(resultSet.getDate("p.end_date").toLocalDate());
                    project.setBudget(BigDecimal.valueOf(resultSet.getDouble("p.budget")));

                    projectMap.put(projectId, project);
                    projects.add(project);
                }

                long taskId = resultSet.getLong("t.id");

                if (!resultSet.wasNull()) {
                    String title = resultSet.getString("t.title");
                    String description = resultSet.getString("t.description");
                    LocalDate dueDate = resultSet.getDate("t.due_date").toLocalDate();
                    Employee assignedEmployee = new Employee();
                    long employeeId = resultSet.getLong("e.id");

                    if (!resultSet.wasNull()) {

                        String fullName = resultSet.getString("e.full_name");
                        String email = resultSet.getString("e.email");
                        String phoneNumber = resultSet.getString("e.phone_number");
                        LocalDate dateOfBirth = resultSet.getDate("e.date_of_birth").toLocalDate();
                        double monthlySalary = resultSet.getDouble("e.monthly_salary");
                        assignedEmployee = new Employee(employeeId, fullName, email, phoneNumber, dateOfBirth, BigDecimal.valueOf(monthlySalary));
                    }

                    Task task = new Task(taskId, title, description, assignedEmployee, dueDate, projectMap.get(projectId));
                    projectMap.get(projectId).getTasks().add(task);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ProjectDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return projects;
    }

    @Override
    public void saveProject(Project project) throws SQLException {
        try {
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            String query = "INSERT INTO project(project_name, description, start_date, end_date, budget) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, project.getProjectName());
            preparedStatement.setString(2, project.getDescription());
            preparedStatement.setDate(3, Date.valueOf(project.getStartDate()));
            preparedStatement.setDate(4, Date.valueOf(project.getEndDate()));
            preparedStatement.setBigDecimal(5, project.getBudget());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                Long id = rs.getLong(1);
                project.setId(id);
                query = "INSERT INTO task(title, description, assigned_employee_fk, due_date, project_fk) VALUES (?,?,?,?,?)";
                preparedStatement = connection.prepareStatement(query);
                for (Task task : project.getTasks()) {
                    preparedStatement.setString(1, task.getTitle());
                    preparedStatement.setString(2, task.getDescription());

                    Long assignedEmployeeId = null;
                    Employee assignedEmployee = task.getAssignedEmployee();
                    if (assignedEmployee != null) {
                        assignedEmployeeId = assignedEmployee.getId();
                    }

                    preparedStatement.setObject(3, assignedEmployeeId, Types.BIGINT);
                    preparedStatement.setDate(4, java.sql.Date.valueOf(task.getDueDate()));
                    preparedStatement.setLong(5, project.getId());
                    preparedStatement.executeUpdate();
                }
            } else {
                throw new Exception("Project id is not generated!");
            }
            rs.close();
            preparedStatement.close();
        } catch (Exception ex) {
            Logger.getLogger(ProjectDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteProject(Project project) throws SQLException {
        try {
            String sql = "DELETE FROM project WHERE id = ?";
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, project.getId());
            preparedStatement.execute();

            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            Logger.getLogger(TaskDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Map<String, BigDecimal> getAverageSalaryByProject() throws SQLException {
        Map<String, BigDecimal> averageSalaryMap = new HashMap<>();
        try {
            String sql = "SELECT p.project_name, AVG(e.monthly_salary) AS average_salary "
                    + "FROM Project p "
                    + "INNER JOIN Task t ON t.project_fk = p.id "
                    + "INNER JOIN Employee e ON e.id = t.assigned_employee_fk "
                    + "GROUP BY p.project_name;";
            Connection conn = DBConnectionFactory.getInstance().getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String projectName = rs.getString("project_name");
                BigDecimal averageSalary = BigDecimal.valueOf(rs.getDouble("average_salary"));
                averageSalaryMap.put(projectName, averageSalary);
            }

        } catch (Exception ex) {
            Logger.getLogger(ProjectDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return averageSalaryMap;
    }

    @Override
    public Map<String, Integer> getTaskCountPerProject() throws SQLException {
        Map<String, Integer> taskCounts = new HashMap<>();
        try {
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT p.project_name, COUNT(t.id) AS num_tasks "
                    + "FROM Project p "
                    + "LEFT JOIN Task t ON p.id = t.project_fk "
                    + "GROUP BY p.id, p.project_name";

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String projectName = resultSet.getString("project_name");
                int numTasks = resultSet.getInt("num_tasks");
                taskCounts.put(projectName, numTasks);
            }

        } catch (Exception ex) {
            Logger.getLogger(ProjectDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return taskCounts;
    }

    @Override
    public double calculateAverageProjectDuration() throws SQLException {
        try {
            double avarageProjectDuration;
            String sql = "SELECT AVG(DATEDIFF(IFNULL(end_date, CURRENT_DATE), start_date)) AS avg_duration FROM project";
            Connection conn = DBConnectionFactory.getInstance().getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            rs.next();
            avarageProjectDuration = rs.getDouble(1);

            statement.close();
            conn.close();

            return avarageProjectDuration;
        } catch (Exception ex) {
            Logger.getLogger(ProjectDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
