/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkxdpm05.Provide;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tkxdpm05.models.merchandise.MerchandiseDTO;
import tkxdpm05.models.provide.ProvideDTO;
import tkxdpm05.models.site.SiteDTO;

/**
 *
 * @author thiennd
 */
public class ListProvideFrame extends javax.swing.JFrame {

    /**
     * Creates new form ListProvide
     */
    ArrayList<ProvideDTO> listProvideDTOs;
    ArrayList<SiteDTO> listSiteDTOs;
    ArrayList<MerchandiseDTO> listMerchandiseDTOs;

    DefaultTableModel tableProvideModel;
    DefaultComboBoxModel comboBoxListSiteModel;

    String[] tableHeader = new String[]{"Provide ID", "Site ID", "Merchandise ID", "Instock"};

    public ListProvideFrame() {
        initComponents();
        initUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableProvide = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        comboBoxListSite = new javax.swing.JComboBox<>();
        btnCreate = new javax.swing.JButton();
        delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableProvide.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableProvide);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        comboBoxListSite.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxListSite, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(381, 381, 381)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboBoxListSite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCreate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        showListProvide(-1);
        showListSite();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        new ProvideFrame().setVisible(true);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int index = tableProvide.getSelectedRow();
        if (index < 0) {
            return;
        }
        int valueAt = Integer.parseInt((String) tableProvide.getValueAt(index, 0));

        for (ProvideDTO provide : listProvideDTOs) {
            if (provide.getProvideId() == valueAt) {
                int confirm = JOptionPane.showConfirmDialog(this,
                        "Delete " + provide.getProvideId(),
                        "Confirm Delete",
                        JOptionPane.OK_CANCEL_OPTION);
                if (confirm == JOptionPane.OK_OPTION) {
                    ProvideController.getInstance().deleteProvide(provide);
                }
            }

        }
        showListProvide(comboBoxListSite.getSelectedIndex());
    }//GEN-LAST:event_deleteActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListProvideFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListProvideFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListProvideFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListProvideFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListProvideFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JComboBox<String> comboBoxListSite;
    private javax.swing.JButton delete;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableProvide;
    // End of variables declaration//GEN-END:variables

    private void initUI() {
        this.setTitle(this.getClass().getSimpleName());
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        listProvideDTOs = new ArrayList<>();
        listMerchandiseDTOs = new ArrayList<>();
        listSiteDTOs = new ArrayList<>();

        comboBoxListSiteModel = new DefaultComboBoxModel<String>();
        tableProvideModel = new DefaultTableModel(tableHeader, 0);

        comboBoxListSite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onItemListSiteChanged(e);
            }

        });

        showListProvide(-1);
        showListSite();
    }

    public void showListSite() {
        comboBoxListSiteModel = new DefaultComboBoxModel<String>();
        comboBoxListSite.setModel(comboBoxListSiteModel);
        comboBoxListSiteModel.removeAllElements();
        for (SiteDTO siteDTO : listSiteDTOs) {
            comboBoxListSiteModel.addElement(siteDTO.getSiteId() + " - " + siteDTO.getDispName());
        }
        comboBoxListSite.setSelectedIndex(-1);
    }

    private void showListProvide(int siteIndex) {

        tableProvideModel = new DefaultTableModel(tableHeader, 0);

        tableProvide.setModel(tableProvideModel);

        listMerchandiseDTOs = ProvideController.getInstance().readAllMerchandise();
        listProvideDTOs = ProvideController.getInstance().readAllProvide();
        listSiteDTOs = ProvideController.getInstance().readAllSite();

        for (ProvideDTO provideDTO : listProvideDTOs) {
            if (siteIndex == -1 || listSiteDTOs.get(siteIndex).getSiteId() == provideDTO.getSiteId()) {
                String[] data = new String[4];
                data[0] = provideDTO.getProvideId() + "";
                data[1] = provideDTO.getSiteId() + "";
                data[2] = provideDTO.getMerchandiseId() + "";
                data[3] = provideDTO.getInstock() + "";
                tableProvideModel.addRow(data);
            }
        }
    }

    private void onItemListSiteChanged(ActionEvent e) {
        showListProvide(comboBoxListSite.getSelectedIndex());
    }
}
