/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesapp.modules.presencia;

import com.l2fprod.common.swing.StatusBar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;
import org.iesapp.clients.iesdigital.guardies.Presencia;
import org.iesapp.clients.iesdigital.guardies.RowModel;
import org.iesapp.framework.dialogs.CellRenderer;
import org.iesapp.framework.table.CellTableState;
import org.iesapp.framework.table.MyIconLabelRenderer;
import org.iesapp.util.StringUtils;

/**
 *
 * @author Josep
 */
public class PresenciaModule extends org.iesapp.framework.pluggable.TopModuleWindow {
    private Presencia presencia;
    private DefaultTableModel modelTable1;
    private DefaultTableModel modelTable2;
    private boolean isSignat;
    private ArrayList<BeanLlistatFaltes> listllistatFaltes;
    private DefaultTableModel modelTable4;
    private boolean listening = false;
    
    /**
     * Creates new form MensajesUPModule
     */
    public PresenciaModule() {
        
        this.moduleDescription = "Este módulo permite comprobar si un profesor ha fichado y si no le brinda la oportunidad";
        this.moduleDisplayName = "Presencia";
        this.moduleName = "Presencia";
        initComponents();
        jTable1.setEnabled(false);
        jTable2.setEnabled(false);
        jButton2.setIcon(new ImageIcon(getClass().getResource("/org/iesapp/framework/icons/icon02.gif")));
        jTable1.setIntercellSpacing( new java.awt.Dimension(2,2) );
        jTable1.setGridColor(java.awt.Color.gray);
        jTable1.setShowGrid(true);
       
        jTable2.setIntercellSpacing(new java.awt.Dimension(2, 2));
        jTable2.setGridColor(java.awt.Color.gray);
        jTable2.setShowGrid(true);
        jLabel2.setVisible(false);

        jTable4.setIntercellSpacing(new java.awt.Dimension(2, 2));
        jTable4.setGridColor(java.awt.Color.gray);
        jTable4.setShowGrid(true);
        listening = true;
    }

    /**
     *
     */
    @Override
    public void postInitialize() {
         if (coreCfg.getUserInfo() != null) {
            presencia = new Presencia(coreCfg.getIesClient());
            isSignat = presencia.haSignat(coreCfg.getUserInfo().getAbrev());
            this.openingRequired = !isSignat;
            int torn = presencia.getTorn(coreCfg.getUserInfo().getAbrev());
            int idx;
            if(torn==0 || torn==2)
            {
                idx = 0;
            }
            else
            {
                idx = 1;
            }
            jComboBox1.setSelectedIndex(idx);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        } ;
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("* Atenció: Recordau que les hores anteriors a l'actual no es signaran. Consultau a prefectura.");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Encara no heu signat");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Horari de ");

        modelTable1 = new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "","1a hora", "2a hora", "3a hora",
                "4a hora", "5a hora", "6a hora", "7a hora"
            }
        );
        jTable1.setModel(modelTable1);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer());
        jTable1.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer());
        jTable1.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer());
        jTable1.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer());
        jTable1.getColumnModel().getColumn(5).setCellRenderer(new CellRenderer());
        jTable1.getColumnModel().getColumn(6).setCellRenderer(new CellRenderer());
        jTable1.getColumnModel().getColumn(7).setCellRenderer(new CellRenderer());

        jTable1.setRowHeight(32);
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Si premeu Signar el programa signarà per vostè.");

        modelTable2 = new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "","8a hora", "9a hora", "10a hora",
                "11a hora", "12a hora", "13a hora", "14a hora"
            }
        );
        jTable2.setModel(modelTable2);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer());
        jTable2.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer());
        jTable2.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer());
        jTable2.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer());
        jTable2.getColumnModel().getColumn(5).setCellRenderer(new CellRenderer());
        jTable2.getColumnModel().getColumn(6).setCellRenderer(new CellRenderer());
        jTable2.getColumnModel().getColumn(7).setCellRenderer(new CellRenderer());

        jTable2.setRowHeight(32);
        jScrollPane2.setViewportView(jTable2);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("MATÍ:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("TARDA:");

        jButton2.setText("Signar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jLabel4))
        );

        jTabbedPane1.addTab("Signatures d'avui", jPanel1);

        modelTable4 = new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Dia", "1a hora", "2a hora", "3a hora",
                "4a hora", "5a hora", "6a hora", "7a hora"
            }
        );
        jTable4.setModel(modelTable4);
        jTable4.getTableHeader().setReorderingAllowed(false);
        jTable4.setRowHeight(28);

        jTable4.getColumnModel().getColumn(0).setPreferredWidth(160);
        jTable4.getColumnModel().getColumn(1).setPreferredWidth(90);

        //Columna de data + comentari
        String[] resources = new String[]{"/org/iesapp/framework/icons/blank.gif","/org/iesapp/modules/presencia/icons/postit.gif"};
        jTable4.getColumnModel().getColumn(1).setCellRenderer(
            new MyIconLabelRenderer(resources));

        //Columnes de clases
        for(int i=2; i<9; i++)
        jTable4.getColumnModel().getColumn(i).setCellRenderer(new CellRendererInformes());
        jScrollPane4.setViewportView(jTable4);

        jLabel1.setText("Torn");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Matí", "Tarda" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(552, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                    .addGap(15, 15, 15)))
        );

        jTabbedPane1.addTab("Faltes d'assistència", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentContainer());
        getContentContainer().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 
            //Both mati and tarda
            presencia.autoSigna(coreCfg.getUserInfo().getAbrev());

            while (jTable1.getRowCount() > 0) {
                modelTable1.removeRow(0);
            }

            while (jTable2.getRowCount() > 0) {
                modelTable2.removeRow(0);
            }

            RowModel mati = presencia.getHorari(coreCfg.getUserInfo().getAbrev(), false);
            RowModel tarda = presencia.getHorari(coreCfg.getUserInfo().getAbrev(), true);
           

            modelTable1.addRow(new Object[]{"", mati.cells[1], mati.cells[2],
                        mati.cells[3], mati.cells[4], mati.cells[5], mati.cells[6],
                        mati.cells[7]});

            modelTable2.addRow(new Object[]{"", tarda.cells[1], tarda.cells[2],
                        tarda.cells[3], tarda.cells[4], tarda.cells[5], tarda.cells[6],
                        tarda.cells[7]});


            jButton2.setEnabled(false);
            isSignat = true;
            jLabel2.setVisible(false);
             
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
       if(!listening)
       {
           return;
       }
       
       if(listllistatFaltes==null && jTabbedPane1.getSelectedIndex()>0)
       {
           doLlistat();
       
       }
       
       
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        doLlistat();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    
    @Override
    public void refreshUI() {
        
        
        if(presencia==null && coreCfg.getUserInfo()!=null)
        {
            presencia = new Presencia(coreCfg.getIesClient());
        }
        if(presencia==null)
        {
            return;
        }
        
        jLabel2.setVisible(!isSignat);
        jButton2.setEnabled(!isSignat);
        
        RowModel mati = presencia.getHorari(coreCfg.getUserInfo().getAbrev(), false);
        RowModel tarda = presencia.getHorari(coreCfg.getUserInfo().getAbrev(), true);
        
        
        modelTable1.addRow(new Object[]{"",mati.cells[1],mati.cells[2],
            mati.cells[3],mati.cells[4],mati.cells[5],mati.cells[6],
            mati.cells[7]});
        
        modelTable2.addRow(new Object[]{"",tarda.cells[1],tarda.cells[2],
        tarda.cells[3],tarda.cells[4],tarda.cells[5],tarda.cells[6],
        tarda.cells[7]});

        jLabel6.setText(coreCfg.getUserInfo().getName());
    
        
    }

    @Override
    public void setMenus(JMenuBar jMenuBar1, JToolBar jToolbar1, StatusBar jStatusBar1) {
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    // End of variables declaration//GEN-END:variables

    
    private void doLlistat() {
        String abrev = coreCfg.getUserInfo().getAbrev();
        
        while(jTable4.getRowCount()>0)
        {
            modelTable4.removeRow(0);
        }

        String taula = "";
        int torn =  jComboBox1.getSelectedIndex();  //presencia.getTorn(abrev);
        if (torn == 0) {
            taula = "signatures ";
            for (int i = 2; i < 9; i++) {
                jTable4.getColumnModel().getColumn(i).setHeaderValue((i - 1) + "a hora");
            }
        } else {
            taula = "signatures_tarda ";
            for (int i = 2; i < 9; i++) {
                jTable4.getColumnModel().getColumn(i).setHeaderValue((i + 6) + "a hora");
            }
        }

       listllistatFaltes = new ArrayList<BeanLlistatFaltes>();


        String SQL1 = "SELECT sig.DATA, H1, H2, H3, H4, H5, H6, H7, com.text FROM sig_" + taula + " AS sig "
                + " INNER JOIN sig_professorat AS prof ON sig.ABREV=prof.ABREV "
                + " LEFT JOIN sig_signatures_comentaris as com ON (com.abrev=prof.abrev and com.data=sig.data) "
                + " WHERE prof.ABREV='" + abrev + "' ORDER BY sig.DATA";


        try {
            Statement st = coreCfg.getMysql().createStatement();
            ResultSet rs1 = coreCfg.getMysql().getResultSet(SQL1, st);
            int nel = 0;
            while (rs1 != null && rs1.next()) {

                BeanLlistatFaltes aline = new BeanLlistatFaltes();

                int[] hs = new int[7];
                for (int k = 1; k < 8; k++) {
                    hs[k - 1] = rs1.getInt("H" + k);

                }
                String data = rs1.getString("DATA");
                String comtext = rs1.getString("text");

                Object[] fila = esFalta(hs, abrev, data, torn); //comprova si es falta. A mes, si/no justificada

                //determina si aquesta fila nomes conte camps justificats
                boolean solojustificat = true;
                if (fila != null) //no incloguis els justificats
                {
                    //String tmp="";
                    for (int ij = 2; ij < 9; ij++) {
                        solojustificat &= (fila[ij].equals(-1) || fila[ij].equals(3) || fila[ij].equals(4));
                        // tmp += fila[ij]+":";
                    }

                    //System.out.println(tmp +" Solojustifat is "+solojustificat+" for "+abrev+"; "+data);
                    solojustificat = !solojustificat;
                }

                if (fila != null ) { //&& solojustificat

                    fila[0] = abrev;
                    CellTableState cts = new CellTableState(StringUtils.Sql2EUData(data, 2), -1,
                            comtext == null ? 0 : 1);
                    cts.setTooltip(comtext);
                    fila[1] = cts;
                    modelTable4.addRow(fila);

                    aline.setNombre(StringUtils.BeforeLast((String) fila[0], "["));
                    aline.setData(((CellTableState) fila[1]).getText());
                    aline.setComentari(comtext);

                    boolean showInReport = true;

                    for (int ij = 2; ij < 9; ij++) {
                        showInReport |= fila[ij].equals(0) || fila[ij].equals(1) || fila[ij].equals(3);

                        String msg = "";
                        switch (((Number) fila[ij]).intValue()) {
                            case -1:
                                msg = "";
                                break;
                            case 0:
                                msg = "No Sig.";
                                break;
                            case 1:
                                msg = "Falta";
                                break;
                            case 2:
                                msg = "Sortida";
                                break;
                            case 3:
                                msg = "No Sig.-J";
                                break;
                            case 4:
                                msg = "Falta-J";
                                break;
                        }
                        aline.setHn(msg, ij - 1);

                    }

                    if (showInReport) {
                        listllistatFaltes.add(aline);
                    }
                }

                nel += 1;
            }
            if (rs1 != null) {
                rs1.close();
                st.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(PresenciaModule.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    
    private Object[] esFalta(int[] hs, String abrev, String data, int torn) {

        boolean incsurt = false;
        boolean incnosign = true;

        Object[] obj = null; // new Object[7];
        boolean falta = false;
        for (int i = 0; i < 7; i++) {
            if (incsurt) {
                if (incnosign) {
                    if (hs[i] == 0 || hs[i] > 1) {
                        falta = true;
                        break;
                    }
                } else {
                    if (hs[i] > 1) {
                        falta = true;
                        break;
                    }
                }
            } else {
                if (incnosign) {
                    if (hs[i] == 0 || hs[i] == 2) {
                        falta = true;
                        break;
                    }
                } else {
                    if (hs[i] == 2) {
                        falta = true;
                        break;
                    }
                }

            }
        }

        if (falta) {

            obj = new Object[9];
            for (int i = 0; i < 7; i++) {
                int hora = i + 1;
                if (torn == 1) {
                    hora += 7;
                }

                //comprovem si la trobam a la taula de justificants
                String SQL1 = "SELECT * FROM sig_justificat WHERE abrev='" + abrev + "' AND data='" + data
                        + "' AND hora='" + hora + "'";

                ResultSet rs2 = null;
                boolean justificat = false;
                try {

                    Statement st = coreCfg.getMysql().createStatement();
                    rs2 = coreCfg.getMysql().getResultSet(SQL1, st);

                    if (rs2 != null && rs2.next()) {
                        justificat = true;
                    }
                    rs2.close();
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PresenciaModule.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (hs[i] == 0) {
                    if (justificat) {
                        obj[i + 2] = 3;
                    } //no signat Justificat
                    else {
                        obj[i + 2] = 0;
                    } //no signat NO Justificat
                } else if (hs[i] == 2) {
                    if (justificat) {
                        obj[i + 2] = 4;
                    } //falta justificada
                    else {
                        obj[i + 2] = 1;
                    } //falta no justificada
                } else if (hs[i] == 3 && incsurt) {
                    obj[i + 2] = 2; //sortida
                } else {
                    obj[i + 2] = -1; //hora buida o OK
                }
            }

        }
        return obj;
    }
}
