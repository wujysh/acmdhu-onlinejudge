package client;

import com.zxp.*;

public class PaperPanel extends javax.swing.JPanel {

    /** Creates new form PaperPanel */
    public PaperPanel() {
        initComponents();
        try {
            JEP_Problem.setContentType("text/html");
            ((javax.swing.text.html.HTMLDocument) (JEP_Problem.getDocument())).setBase(new java.io.File(System.getProperty("java.io.tmpdir")).toURL());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPaper() {
        try {
            JCB_Problem.removeAllItems();
            pb = Control.getPaperBean();
            papernum = pb.getProblemCount();
            for (int i = 0; i < papernum; i++) {
                JCB_Problem.addItem((char) ('A' + i) + ".   " + pb.getProblemAt(i).getTitle());
            }
            JCB_Problem.addItem("-Rule-");
            JEP_Problem.setText(pb.getProblemAt(0).transform());
            JEP_Problem.setCaretPosition(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        JCB_Problem = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        JEP_Problem = new javax.swing.JEditorPane();

        setLayout(new java.awt.BorderLayout());

        jToolBar1.setFloatable(false);

        JCB_Problem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_ProblemActionPerformed(evt);
            }
        });
        jToolBar1.add(JCB_Problem);

        add(jToolBar1, java.awt.BorderLayout.NORTH);

        jScrollPane1.setViewportView(JEP_Problem);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void JCB_ProblemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_ProblemActionPerformed
        int i = JCB_Problem.getSelectedIndex();
        if (i < 0) {
            i = 0;
        }
        try {
            if (i == papernum) {
                Control.setNowpapernum(0);
                JEP_Problem.setText(pb.getPaperDetail().getDecribe());
            } else {
                Control.setNowpapernum(i);
                JEP_Problem.setText(pb.getProblemAt(i).transform());
            }
            JEP_Problem.setCaretPosition(0);
        } catch (Exception E) {
            E.printStackTrace();
        }
    }//GEN-LAST:event_JCB_ProblemActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox JCB_Problem;
    private javax.swing.JEditorPane JEP_Problem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

    private PaperBean pb;
    private int papernum;
}
