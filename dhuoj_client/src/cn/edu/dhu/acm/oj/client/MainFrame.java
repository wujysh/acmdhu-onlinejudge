package cn.edu.dhu.acm.oj.client;

import cn.edu.dhu.acm.oj.client.panel.*;
import cn.edu.dhu.acm.oj.common.config.Const;

public class MainFrame extends MyFrame {

    /** Creates new form MainFrame */
    public MainFrame() {
        paperpanel = new PaperPanel();
        initComponents();
        Control.setMainFrame(this);
        Control.init();
        Control.setPaperpanel(paperpanel);
        JP_Paper.add(paperpanel, java.awt.BorderLayout.CENTER);
        int i = Control.getAllcodecnt();
        String title = "New0";
        codenum = 1;
        JTP_Code.add(title, new CodePanel(title, i, JTP_Code));
        JTP_Code.setTabComponentAt(i, new ButtonTabComponent(JTP_Code));

        StatusTable.setModel(statusdtb = new javax.swing.table.DefaultTableModel(
                new Object[][]{}, Const.STATUSTABLECOLNAME) {

            Class[] types = Const.STATUSTABLECOLTYPE;

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        StatusTable.setEnabled(false);

        QuestionTable.setModel(questiondtb = new javax.swing.table.DefaultTableModel(
                new Object[][]{}, Const.QUESTIONTABLECOLNAME) {

            Class[] types = Const.QUESTIONTABLECOLTYPE;

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        QuestionTable.setEnabled(false);


        Control.setPaper(Const.INITPAPER);
        paperpanel.setPaper();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TP_Main = new javax.swing.JTabbedPane();
        JP_Coding = new javax.swing.JPanel();
        JSP_PC = new javax.swing.JSplitPane();
        JP_Paper = new javax.swing.JPanel();
        JTP_Code = new javax.swing.JTabbedPane();
        JP_Status = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        StatusTable = new javax.swing.JTable();
        JP_Rank = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JEP_Rank = new javax.swing.JEditorPane();
        jToolBar1 = new javax.swing.JToolBar();
        JB_Reflash = new javax.swing.JButton();
        TF_URL = new javax.swing.JTextField();
        JP_Question = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        QuestionTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        JTA_Question = new javax.swing.JTextArea();
        jToolBar2 = new javax.swing.JToolBar();
        JB_Post = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        JM_Tool1 = new javax.swing.JMenu();
        JMI_New = new javax.swing.JMenuItem();
        JMI_Open = new javax.swing.JMenuItem();
        JMI_Save = new javax.swing.JMenuItem();
        JMI_SaveAs = new javax.swing.JMenuItem();
        JM_Tool = new javax.swing.JMenu();
        JMI_SetEnv = new javax.swing.JMenuItem();
        JM_Help = new javax.swing.JMenu();
        JMI_Help = new javax.swing.JMenuItem();
        JMI_About = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JP_Coding.setLayout(new java.awt.BorderLayout());

        JSP_PC.setDividerLocation(382);
        JSP_PC.setDividerSize(7);
        JSP_PC.setOneTouchExpandable(true);

        JP_Paper.setLayout(new java.awt.BorderLayout());
        JSP_PC.setLeftComponent(JP_Paper);
        JSP_PC.setRightComponent(JTP_Code);

        JP_Coding.add(JSP_PC, java.awt.BorderLayout.CENTER);

        TP_Main.addTab("Coding", JP_Coding);

        JP_Status.setLayout(new java.awt.BorderLayout());

        StatusTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        StatusTable.setEnabled(false);
        jScrollPane1.setViewportView(StatusTable);

        JP_Status.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        TP_Main.addTab("Status", JP_Status);

        JP_Rank.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setViewportView(JEP_Rank);

        JP_Rank.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jToolBar1.setRollover(true);

        JB_Reflash.setText("ShowRankList");
        JB_Reflash.setFocusable(false);
        JB_Reflash.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JB_Reflash.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        JB_Reflash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_ReflashActionPerformed(evt);
            }
        });
        jToolBar1.add(JB_Reflash);

        TF_URL.setEditable(false);
        TF_URL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_URLActionPerformed(evt);
            }
        });
        jToolBar1.add(TF_URL);

        JP_Rank.add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        TP_Main.addTab("Rank", JP_Rank);

        JP_Question.setLayout(new java.awt.BorderLayout());

        QuestionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(QuestionTable);

        JP_Question.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.BorderLayout());

        JTA_Question.setColumns(20);
        JTA_Question.setRows(5);
        jScrollPane4.setViewportView(JTA_Question);

        jPanel1.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        JB_Post.setText("Post This Question");
        JB_Post.setFocusable(false);
        JB_Post.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JB_Post.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        JB_Post.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_PostActionPerformed(evt);
            }
        });
        jToolBar2.add(JB_Post);

        jPanel1.add(jToolBar2, java.awt.BorderLayout.SOUTH);

        jLabel1.setText("Ask your question:");
        jPanel1.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        JP_Question.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        TP_Main.addTab("Question", JP_Question);

        getContentPane().add(TP_Main, java.awt.BorderLayout.CENTER);

        JM_Tool1.setText("File");

        JMI_New.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        JMI_New.setText("New");
        JMI_New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMI_NewActionPerformed(evt);
            }
        });
        JM_Tool1.add(JMI_New);

        JMI_Open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        JMI_Open.setText("Open");
        JMI_Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMI_OpenActionPerformed(evt);
            }
        });
        JM_Tool1.add(JMI_Open);

        JMI_Save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        JMI_Save.setText("Save");
        JMI_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMI_SaveActionPerformed(evt);
            }
        });
        JM_Tool1.add(JMI_Save);

        JMI_SaveAs.setText("Save As");
        JMI_SaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMI_SaveAsActionPerformed(evt);
            }
        });
        JM_Tool1.add(JMI_SaveAs);

        MenuBar.add(JM_Tool1);

        JM_Tool.setText("Tool");

        JMI_SetEnv.setText("SetEnvironment");
        JMI_SetEnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMI_SetEnvActionPerformed(evt);
            }
        });
        JM_Tool.add(JMI_SetEnv);

        MenuBar.add(JM_Tool);

        JM_Help.setText("Help");

        JMI_Help.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        JMI_Help.setText("Help");
        JMI_Help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMI_HelpActionPerformed(evt);
            }
        });
        JM_Help.add(JMI_Help);

        JMI_About.setText("About");
        JM_Help.add(JMI_About);

        MenuBar.add(JM_Help);

        setJMenuBar(MenuBar);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-834)/2, (screenSize.height-577)/2, 834, 577);
    }// </editor-fold>//GEN-END:initComponents

private void JMI_SetEnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMI_SetEnvActionPerformed
    showEnvPanel();
}//GEN-LAST:event_JMI_SetEnvActionPerformed

    private void JMI_HelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMI_HelpActionPerformed
    }//GEN-LAST:event_JMI_HelpActionPerformed

    private void JMI_NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMI_NewActionPerformed
        NewCodePanel();
}//GEN-LAST:event_JMI_NewActionPerformed

    private void JMI_OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMI_OpenActionPerformed
        OpenCodePanel();
    }//GEN-LAST:event_JMI_OpenActionPerformed

    private void JMI_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMI_SaveActionPerformed
        CodePanel cp = (CodePanel) JTP_Code.getSelectedComponent();
        if (cp != null) {
            try {
                cp.Save();
            } catch (Exception e) {
                smallDialog("Save File Error!", "Error", 0);
            }
        }
    }//GEN-LAST:event_JMI_SaveActionPerformed

    private void JMI_SaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMI_SaveAsActionPerformed
        CodePanel cp = (CodePanel) JTP_Code.getSelectedComponent();
        if (cp != null) {
            try {
            } catch (Exception e) {
                smallDialog("Save File Error!", "Error", 0);
            }
        }

    }//GEN-LAST:event_JMI_SaveAsActionPerformed

    private void JB_ReflashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_ReflashActionPerformed
        try {
            if (java.awt.Desktop.isDesktopSupported()) {
                java.awt.Desktop.getDesktop().browse(new java.net.URI(TF_URL.getText()));
            } else {
                JEP_Rank.setPage(TF_URL.getText());
                smallDialog("Please use your browser to open:\n" + TF_URL.getText(), "Warning", 0);
            }
        } catch (Exception e) {
            smallDialog("Please use your browser to open:\n" + TF_URL.getText(), "Warning", 0);
        }
}//GEN-LAST:event_JB_ReflashActionPerformed

    private void TF_URLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_URLActionPerformed
        this.JB_ReflashActionPerformed(evt);
}//GEN-LAST:event_TF_URLActionPerformed

    private void JB_PostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_PostActionPerformed
        String str = JTA_Question.getText();
        if (str.equals("")) {
            smallDialog("Your Question is empty!", "Error", 0);
        } else {
            Control.PostQuestion(str);
        }
    }//GEN-LAST:event_JB_PostActionPerformed

    public void showEnvPanel() {
        javax.swing.JDialog dialog = new javax.swing.JDialog();
        EnvironmentPanel dlg = new EnvironmentPanel(dialog);
        newDialog(dialog, dlg, "SetEnvironment");
    }

    public void NewCodePanel() {
        int i = Control.getAllcodecnt();
        String title = "New";
        title += codenum;
        codenum++;
        JTP_Code.add(title, new CodePanel(title, i, JTP_Code));
        JTP_Code.setTabComponentAt(i, new ButtonTabComponent(JTP_Code));
        JTP_Code.setSelectedIndex(i);
    }

    public void OpenCodePanel() {
        javax.swing.JFileChooser chooser = new javax.swing.JFileChooser(Control.getWorkpath());
        if (chooser.showOpenDialog(this) == javax.swing.JFileChooser.APPROVE_OPTION) {
            try {
                String fileName = chooser.getSelectedFile().getPath();
                java.io.File file = new java.io.File(fileName);

                System.out.println(file.getParent());

                int fileSize = (int) file.length();

                int charReaded = 0;
                java.io.FileReader in = new java.io.FileReader(file);
                char[] data = new char[fileSize];
                while (in.ready()) {
                    charReaded += in.read(data, charReaded, fileSize - charReaded);
                }
                in.close();
                StringBuffer SourceCode = new StringBuffer();
                for (int i = 0; i < charReaded; i++) {
                    SourceCode.append(data[i]);
                }

                int i = Control.getAllcodecnt();
                String title = file.getName();
                CodePanel cp = new CodePanel(title, i, JTP_Code);
                cp.setCode(SourceCode.toString());
                JTP_Code.add(title, cp);
                JTP_Code.setTabComponentAt(i, new ButtonTabComponent(JTP_Code));
                JTP_Code.setSelectedIndex(i);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void deleteStatusQid(Integer qid) {
        int len = statusdtb.getRowCount();
        for (int i = 0; i < len; i++) {
            Integer id = (Integer) statusdtb.getValueAt(i, 0);
            if (qid.equals(id)) {
                statusdtb.removeRow(i);
                break;
            }
        }
        StatusTable.repaint();
    }

    public String getStatusRowString(Integer qid) {
        String ans = "";
        int len = statusdtb.getRowCount();
        for (int i = 0; i < len; i++) {
            Integer id = (Integer) statusdtb.getValueAt(i, 0);
            if (qid.equals(id)) {
                ans = String.format("%s : %s", Const.STATUSTABLECOLNAME[2], statusdtb.getValueAt(i, 2));
                for (int j = 3; j < Const.STATUSTABLECOLNAME.length - 1; j++) {
                    ans += String.format("\n%s : %s", Const.STATUSTABLECOLNAME[j], statusdtb.getValueAt(i, j));
                }
                break;
            }
        }
        return ans;
    }

    public void updateStatusRow(Object[] row) {
        Integer qid = (Integer) row[0];
        int len = statusdtb.getRowCount();
        boolean find = false;
        int i;
        for (i = 0; i < len; i++) {
            Integer id = (Integer) statusdtb.getValueAt(i, 0);
            if (qid.equals(id)) {
                find = true;
                break;
            }
        }
        if (!find) {
            statusdtb.addRow(row);
        } else {
            statusdtb.setValueAt(row[1], i, 1);
            statusdtb.setValueAt(row[3], i, 3);
            statusdtb.setValueAt(row[5], i, 5);
            statusdtb.setValueAt(row[6], i, 6);
        }
        StatusTable.repaint();
    }

    public void updateQuestionRow(Object[] row) {
        Integer qid = (Integer) row[0];
        int len = questiondtb.getRowCount();
        boolean find = false;
        int i;
        for (i = 0; i < len; i++) {
            Integer id = (Integer) questiondtb.getValueAt(i, 0);
            if (qid.equals(id)) {
                find = true;
                break;
            }
        }
        if (!find) {
            questiondtb.addRow(row);
        } else {
            questiondtb.setValueAt(row[2], i, 2);
        }
        QuestionTable.repaint();
    }

    public void setURL(String url) {
        TF_URL.setText(url);
    }

    public void showStatus() {
        TP_Main.setSelectedIndex(1);
    }

    public void setPaper() {
        paperpanel.setPaper();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_Post;
    private javax.swing.JButton JB_Reflash;
    private javax.swing.JEditorPane JEP_Rank;
    private javax.swing.JMenuItem JMI_About;
    private javax.swing.JMenuItem JMI_Help;
    private javax.swing.JMenuItem JMI_New;
    private javax.swing.JMenuItem JMI_Open;
    private javax.swing.JMenuItem JMI_Save;
    private javax.swing.JMenuItem JMI_SaveAs;
    private javax.swing.JMenuItem JMI_SetEnv;
    private javax.swing.JMenu JM_Help;
    private javax.swing.JMenu JM_Tool;
    private javax.swing.JMenu JM_Tool1;
    private javax.swing.JPanel JP_Coding;
    private javax.swing.JPanel JP_Paper;
    private javax.swing.JPanel JP_Question;
    private javax.swing.JPanel JP_Rank;
    private javax.swing.JPanel JP_Status;
    private javax.swing.JSplitPane JSP_PC;
    private javax.swing.JTextArea JTA_Question;
    private javax.swing.JTabbedPane JTP_Code;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JTable QuestionTable;
    private javax.swing.JTable StatusTable;
    private javax.swing.JTextField TF_URL;
    private javax.swing.JTabbedPane TP_Main;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    // End of variables declaration//GEN-END:variables
    private PaperPanel paperpanel;
    private int codenum;
    public javax.swing.table.DefaultTableModel statusdtb;
    public javax.swing.table.DefaultTableModel questiondtb;
}
