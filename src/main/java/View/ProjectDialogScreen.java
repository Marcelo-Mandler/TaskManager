/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ProjectController;
import Model.Project;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcelo
 */
public class ProjectDialogScreen extends javax.swing.JDialog {

    ProjectController controller;
    
    public ProjectDialogScreen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        controller = new ProjectController();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelProjectDialog = new javax.swing.JPanel();
        jLabelProjectDialogName = new javax.swing.JLabel();
        jLabelProjectDialogCheck = new javax.swing.JLabel();
        jPanelProjectDialogDescription = new javax.swing.JPanel();
        jLabelProjectNameField = new javax.swing.JLabel();
        jTextFieldProjectNameField = new javax.swing.JTextField();
        jLabelProjectDescriptionField = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescriptionField = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 400));

        jPanelProjectDialog.setBackground(new java.awt.Color(0, 153, 102));

        jLabelProjectDialogName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelProjectDialogName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProjectDialogName.setText("Projeto");

        jLabelProjectDialogCheck.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProjectDialogCheck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/check.png"))); // NOI18N
        jLabelProjectDialogCheck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProjectDialogCheckMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelProjectDialogLayout = new javax.swing.GroupLayout(jPanelProjectDialog);
        jPanelProjectDialog.setLayout(jPanelProjectDialogLayout);
        jPanelProjectDialogLayout.setHorizontalGroup(
            jPanelProjectDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProjectDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelProjectDialogName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProjectDialogCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelProjectDialogLayout.setVerticalGroup(
            jPanelProjectDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProjectDialogName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelProjectDialogCheck, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanelProjectDialogDescription.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProjectDialogDescription.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelProjectNameField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelProjectNameField.setText("Nome");

        jTextFieldProjectNameField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabelProjectDescriptionField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelProjectDescriptionField.setText("Descri��o");

        jTextAreaDescriptionField.setColumns(20);
        jTextAreaDescriptionField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextAreaDescriptionField.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDescriptionField);

        javax.swing.GroupLayout jPanelProjectDialogDescriptionLayout = new javax.swing.GroupLayout(jPanelProjectDialogDescription);
        jPanelProjectDialogDescription.setLayout(jPanelProjectDialogDescriptionLayout);
        jPanelProjectDialogDescriptionLayout.setHorizontalGroup(
            jPanelProjectDialogDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProjectDialogDescriptionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProjectDialogDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                    .addComponent(jLabelProjectNameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldProjectNameField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelProjectDescriptionField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelProjectDialogDescriptionLayout.setVerticalGroup(
            jPanelProjectDialogDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProjectDialogDescriptionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelProjectNameField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldProjectNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelProjectDescriptionField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelProjectDialog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelProjectDialogDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelProjectDialog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelProjectDialogDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelProjectDialogCheckMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProjectDialogCheckMouseClicked
        try {
            // TODO add your handling code here:
            if(!jTextFieldProjectNameField.getText().isEmpty()){
                Project project = new Project();
                project.setName(jTextFieldProjectNameField.getText());
                project.setDescription(jTextAreaDescriptionField.getText());           
                controller.save(project);
                JOptionPane.showMessageDialog(rootPane, "Projeto salvo com sucesso!");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "O projeto n�o foi salvo, pois o campo nome n�o foi preenchido.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
        
    }//GEN-LAST:event_jLabelProjectDialogCheckMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Java swing".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProjectDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProjectDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProjectDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProjectDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProjectDialogScreen dialog = new ProjectDialogScreen(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelProjectDescriptionField;
    private javax.swing.JLabel jLabelProjectDialogCheck;
    private javax.swing.JLabel jLabelProjectDialogName;
    private javax.swing.JLabel jLabelProjectNameField;
    private javax.swing.JPanel jPanelProjectDialog;
    private javax.swing.JPanel jPanelProjectDialogDescription;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDescriptionField;
    private javax.swing.JTextField jTextFieldProjectNameField;
    // End of variables declaration//GEN-END:variables
}
