/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui.form;

import controllers.EmployeeController;
import controllers.ProjectController;
import controllers.TaskController;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Employee;
import model.Project;
import model.Task;
import ui.form.table.model.TaskTableModel;

/**
 *
 * @author Somika
 */
public class TaskForm extends javax.swing.JFrame {

    public TaskForm() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        prepareForm();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTasks = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jdcDueDate = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jcbEmployee = new javax.swing.JComboBox<>();
        jcbProject = new javax.swing.JComboBox<>();
        btnUpdate = new javax.swing.JButton();
        btnUnassign = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 143, 42));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("Tasks");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addContainerGap(1014, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        tblTasks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblTasks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblTasks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTasksMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTasks);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Task"));

        jLabel2.setText("Title:");

        jLabel3.setText("Description");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane2.setViewportView(txtDescription);

        jLabel4.setText("Due date:");

        jLabel5.setText("Employee:");

        jLabel6.setText("Project:");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnUnassign.setText("Unassign employee");
        btnUnassign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnassignActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnUpdate)
                        .addGap(31, 31, 31)
                        .addComponent(btnUnassign))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(97, 97, 97)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(txtTitle)
                            .addComponent(jdcDueDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbEmployee, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbProject, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel3)))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jdcDueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcbEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jcbProject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnUnassign))
                .addGap(17, 17, 17))
        );

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(41, 41, 41)
                        .addComponent(btnRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClose))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnClose)
                    .addComponent(btnRemove))
                .addGap(0, 23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        ((TaskTableModel) tblTasks.getModel()).insertNewRow();
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblTasksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTasksMouseClicked
        int selectedRow = tblTasks.getSelectedRow();

        Task task = ((TaskTableModel) tblTasks.getModel()).getTasks().get(selectedRow);

        if (!task.isEmpty()) {
            txtTitle.setText(task.getTitle().trim());
            txtDescription.setText(task.getDescription().trim());
            jdcDueDate.setDate(java.sql.Date.valueOf(task.getDueDate()));
            jcbEmployee.setSelectedItem(task.getAssignedEmployee());
            jcbProject.setSelectedItem(task.getProject());
        } else {
            txtTitle.setText("");
            txtDescription.setText("");
            jdcDueDate.setDate(null);
            jcbEmployee.setSelectedIndex(-1);
            jcbProject.setSelectedIndex(-1);
        }
    }//GEN-LAST:event_tblTasksMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            int selectedRow = tblTasks.getSelectedRow();
            if (selectedRow == -1) {
                return;
            }

            if (selectedRow >= TaskController.getInstance().getAllTasks().size()) {
                if (txtTitle.getText().isEmpty() || txtDescription.getText().isEmpty() || jdcDueDate.getDate() == null || jcbProject.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(this, "Invalid input");
                    return;
                }
                Task newTask = new Task();
                newTask.setTitle(txtTitle.getText().trim());
                newTask.setDescription(txtDescription.getText().trim());
                newTask.setDueDate(jdcDueDate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                newTask.setAssignedEmployee((Employee) jcbEmployee.getSelectedItem());
                newTask.setProject((Project) jcbProject.getSelectedItem());
                //adding new Task
                TaskController.getInstance().saveTask(newTask);
                prepareForm();
                JOptionPane.showMessageDialog(this, "New task added successfully!");
            } else {

                //update Task
                Task task = TaskController.getInstance().getAllTasks().get(selectedRow);

                task.setTitle(txtTitle.getText());
                task.setDescription(txtDescription.getText());
                task.setDueDate(jdcDueDate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                task.setProject((Project) jcbProject.getSelectedItem());
                task.setAssignedEmployee((Employee) jcbEmployee.getSelectedItem());

                TaskController.getInstance().updateTask(task);
                ((TaskTableModel) tblTasks.getModel()).setTasks(TaskController.getInstance().getAllTasks());
                ((TaskTableModel) tblTasks.getModel()).update();
                prepareForm();
                JOptionPane.showMessageDialog(this, "Update successful!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(TaskForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
        new MainForm().setVisible(true);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        if (tblTasks.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Please select the task you want to remove!");
            return;
        }

        try {
            if (tblTasks.getSelectedRow() < TaskController.getInstance().getAllTasks().size()) {
                Task task = ((TaskTableModel) tblTasks.getModel()).getTasks().get(tblTasks.getSelectedRow());
                TaskController.getInstance().deleteTask(task);
                ((TaskTableModel) tblTasks.getModel()).remove(task);
                JOptionPane.showMessageDialog(this, "Task successfully deleted");
                prepareForm();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaskForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnUnassignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnassignActionPerformed
        jcbEmployee.setSelectedIndex(-1);
    }//GEN-LAST:event_btnUnassignActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUnassign;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<Employee> jcbEmployee;
    private javax.swing.JComboBox<Project> jcbProject;
    private com.toedter.calendar.JDateChooser jdcDueDate;
    private javax.swing.JTable tblTasks;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {
        try {
            txtTitle.setText("");
            txtDescription.setText("");
            jdcDueDate.setDate(null);

            tblTasks.setModel(new TaskTableModel(TaskController.getInstance().getAllTasks()));
            tblTasks.setShowHorizontalLines(true);

            jcbEmployee.setModel(new DefaultComboBoxModel(EmployeeController.getInstance().getAllEmployees().toArray()));
            jcbEmployee.setSelectedIndex(-1);
            jcbProject.setModel(new DefaultComboBoxModel(ProjectController.getInstance().getAllProjects().toArray()));
            jcbProject.setSelectedIndex(-1);
        } catch (SQLException ex) {
            Logger.getLogger(TaskForm.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
