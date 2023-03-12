/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui.form;

import controllers.EmployeeController;
import controllers.TaskController;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Employee;
import model.Task;
import session.Session;

/**
 *
 * @author Somika
 */
public class UpdateEmployeeForm extends javax.swing.JFrame {

    public UpdateEmployeeForm() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        prepareForm();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jdcDateOfBirth = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txtMonthlySalary = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlUnassignedTasks = new javax.swing.JList<>();
        jLabel9 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlAssignedTasks = new javax.swing.JList<>();
        btnRemove = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 143, 32));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Employee");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Update");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setText("Email:");

        jLabel5.setText("Phone number:");

        jLabel6.setText("Date of birth:");

        jLabel7.setText("Monthly salary:");

        jLabel8.setText("Full name:");

        jlUnassignedTasks.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jlUnassignedTasksValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jlUnassignedTasks);

        jLabel9.setText("Assigned tasks:");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel10.setText("Unssigned tasks:");

        jlAssignedTasks.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jlAssignedTasksValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jlAssignedTasks);

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMonthlySalary)
                            .addComponent(jdcDateOfBirth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmail)
                            .addComponent(txtFullName)
                            .addComponent(txtPhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUpdate)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(btnAdd)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(55, 55, 55))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnRemove)
                                        .addGap(76, 76, 76)))
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnClose)
                                .addGap(17, 17, 17))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jdcDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtMonthlySalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd)
                    .addComponent(btnRemove))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnClose))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Task t = jlUnassignedTasks.getSelectedValue();
        DefaultListModel<Task> modelAssigned = (DefaultListModel<Task>) jlAssignedTasks.getModel();
        modelAssigned.addElement(t);

        DefaultListModel<Task> modelUnassigned = (DefaultListModel<Task>) jlUnassignedTasks.getModel();
        modelUnassigned.removeElement(t);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        Task t = jlAssignedTasks.getSelectedValue();
        DefaultListModel<Task> modelUnassigned = (DefaultListModel<Task>) jlUnassignedTasks.getModel();
        modelUnassigned.addElement(t);

        DefaultListModel<Task> modelAssigned = (DefaultListModel<Task>) jlAssignedTasks.getModel();
        modelAssigned.removeElement(t);
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
        new EmployeeForm().setVisible(true);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Employee employee = getInputData();
        if (employee == null) {
            return;
        }

        try {
            EmployeeController.getInstance().updateEmployee(employee);

            for (int i = 0; i < jlAssignedTasks.getModel().getSize(); i++) {
                Task task = jlAssignedTasks.getModel().getElementAt(i);
                task.setAssignedEmployee(employee);
                TaskController.getInstance().updateTask(task);
            }

            for (int i = 0; i < jlUnassignedTasks.getModel().getSize(); i++) {
                Task task = jlUnassignedTasks.getModel().getElementAt(i);
                task.setAssignedEmployee(null);
                TaskController.getInstance().updateTask(task);
            }
            btnCloseActionPerformed(evt);
            JOptionPane.showMessageDialog(this, "Employee is successfully updated!");
        } catch (SQLException ex) {
            Logger.getLogger(UpdateEmployeeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jlUnassignedTasksValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jlUnassignedTasksValueChanged
        if (jlUnassignedTasks.getSelectedIndex() != -1) {
            btnAdd.setEnabled(true);
        } else {
            btnAdd.setEnabled(false);
        }
    }//GEN-LAST:event_jlUnassignedTasksValueChanged

    private void jlAssignedTasksValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jlAssignedTasksValueChanged
        if (jlAssignedTasks.getSelectedIndex() != -1) {
            btnRemove.setEnabled(true);
        } else {
            btnRemove.setEnabled(false);
        }
    }//GEN-LAST:event_jlAssignedTasksValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcDateOfBirth;
    private javax.swing.JList<Task> jlAssignedTasks;
    private javax.swing.JList<Task> jlUnassignedTasks;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtMonthlySalary;
    private javax.swing.JTextField txtPhoneNumber;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {
        Employee e = Session.getInstance().get("employee_for_update");
        txtFullName.setText(e.getFullName());
        txtEmail.setText(e.getEmail());
        txtPhoneNumber.setText(e.getPhoneNumber());
        jdcDateOfBirth.setDate(java.sql.Date.valueOf(e.getDateOfBirth()));
        txtMonthlySalary.setText(e.getMonthlySalary() + "");

        DefaultListModel<Task> modelAssigned = new DefaultListModel<>();
        for (Task assignTasks : e.getTasks()) {
            modelAssigned.addElement(assignTasks);
        }
        jlAssignedTasks.setModel(modelAssigned);

        DefaultListModel<Task> modelUnassigned = new DefaultListModel<>();
        try {
            for (Task unassignTasks : TaskController.getInstance().getUnassignedTasks()) {
                modelUnassigned.addElement(unassignTasks);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateEmployeeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        jlUnassignedTasks.setModel(modelUnassigned);

        btnAdd.setEnabled(false);
        btnRemove.setEnabled(false);
    }

    private Employee getInputData() {
        if (txtFullName.getText() == null || txtEmail.getText() == null || txtPhoneNumber.getText() == null || jdcDateOfBirth.getDate() == null || txtMonthlySalary.getText() == null) {
            JOptionPane.showMessageDialog(this, "You must enter all values", "Invalid input", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        Employee employee = Session.getInstance().get("employee_for_update");

        if (!Pattern.matches("[a-zA-Z ]+", txtFullName.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Full name must contain only letters", "Invalid input", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        employee.setFullName(txtFullName.getText().trim());
        if (!txtEmail.getText().trim().contains("@")) {
            JOptionPane.showMessageDialog(this, "Email must contain '@' symbol", "Invalid input", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        employee.setEmail(txtEmail.getText().trim());
        employee.setPhoneNumber(txtPhoneNumber.getText().trim());
        employee.setDateOfBirth(jdcDateOfBirth.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        
        if (!Pattern.matches("^(?!0)\\d*\\.?\\d+", txtMonthlySalary.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Invalid input for monthly salary!");
            return null;
        }
        employee.setMonthlySalary(BigDecimal.valueOf(Double.parseDouble(txtMonthlySalary.getText())));
        employee.setTasks(jlAssignedTasks.getSelectedValuesList());
        return employee;
    }
}
