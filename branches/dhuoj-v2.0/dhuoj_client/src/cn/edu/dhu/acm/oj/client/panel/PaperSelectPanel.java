package cn.edu.dhu.acm.oj.client.panel;

import cn.edu.dhu.acm.oj.client.Control;
import cn.edu.dhu.acm.oj.common.config.Const;

public class PaperSelectPanel extends javax.swing.JPanel {

    class Item {

        String name;
        int index;

        Item(String str, int i) {
            name = str;
            index = i;
        }

        @Override
        public String toString() {
            return name;
        }

        public int getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }
    }
    /** Creates new form PaperSelectPanel */
    private javax.swing.JDialog dialog;

    public PaperSelectPanel(javax.swing.JDialog d) {
        initComponents();
        dialog = d;
        if (Control.getModel().indexOf("Local") != -1) {
            //Local model
            try {
                java.io.File dir = new java.io.File(Control.getDhuojhomepath());
                String[] files = dir.list();
                for (int i = 0; i < files.length; i++) {
                    java.io.File file = new java.io.File(dir, files[i]);
                    String name = file.getName();
                    if (name.indexOf(Const.INITPAPER) == -1 && name.indexOf(Const.CLIENTPAPERSUFFIX) != -1) {
                        JCB_Paper.addItem(file.getName());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        JCB_Paper = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        JPF_Password = new javax.swing.JPasswordField();
        JB_Get = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());
        add(jPanel1, java.awt.BorderLayout.NORTH);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.add(JCB_Paper);

        jLabel1.setText("Password:");
        jToolBar1.add(jLabel1);

        JPF_Password.setColumns(5);
        JPF_Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPF_PasswordActionPerformed(evt);
            }
        });
        jToolBar1.add(JPF_Password);

        JB_Get.setText("Get");
        JB_Get.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_GetActionPerformed(evt);
            }
        });
        jToolBar1.add(JB_Get);

        add(jToolBar1, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents

    private void JB_GetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_GetActionPerformed
        if (Control.getModel().indexOf("Local") != -1) {
            Control.setPaper(JCB_Paper.getSelectedItem().toString());
        } else {
            dialog.dispose();
            String pwd = JPF_Password.getText();
            Control.downloadPaper(pwd);
        }
    }//GEN-LAST:event_JB_GetActionPerformed

    private void JPF_PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPF_PasswordActionPerformed
        JB_GetActionPerformed(evt);
    }//GEN-LAST:event_JPF_PasswordActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_Get;
    private javax.swing.JComboBox JCB_Paper;
    private javax.swing.JPasswordField JPF_Password;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
