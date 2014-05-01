package display;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.lang.Exception;
/**
 *
 * @author Jeffrey Creighton
 */
public class GUI extends javax.swing.JFrame {
    DefaultTableModel available_model;
    DefaultTableModel implemented_model;
    FileSaveWindow save_window;
    Patient_Info_Window patient_info_window;
    Exception_Window exw;
    
    Object [][] available_genes = {{"Gene 1"}, {"Gene 2"}, {"Gene 3"}, {"Gene 4"}, {"Gene 5"}}; 
    Object [] implemented_genes = {};
    Object available_gene;
    Object implemented_gene;
    String type;
    
    //Patient Info
    private static String patient_name = "";
    private static String patient_address = "";
    private static String patient_city = "";
    private static String patient_state = "";
    private static String patient_dob = "";
    private static String patient_gender = "";
    private Exception Exception;
    
    /**
     * Creates new form GUI
     */
    public GUI() {
        type = "Homozygous";       
        available_model = new DefaultTableModel(0, 1);
        implemented_model = new DefaultTableModel(0,2);
        save_window = new FileSaveWindow();
        patient_info_window = new Patient_Info_Window();
        for(Object item: available_genes){
            available_model.insertRow(available_model.getRowCount(), (Object[]) item);
        }
        for(Object item: implemented_genes){
            implemented_model.insertRow(implemented_model.getRowCount(), (Object[]) item);
        }
        initComponents(); 
        cbHmo.setSelected(true);
    }
    
    public void displayException(Exception e){
        exw = new Exception_Window(e);
        exw.setVisible(true);
    }
    
    private void reset_checks(){
        cbWd.setSelected(false);
        cbHtr.setSelected(false);
        cbHmo.setSelected(false);        
    }
    private boolean check_implemented_list(Object o) {
        boolean already_here = false;
        Object item; //place holder for checking contents of existing rows 
        for (int i = 0; i < implemented_model.getRowCount(); i++) {
            item = (Object) String.valueOf(implemented_model.getValueAt(i, 0));
            if (item.equals(available_gene)) {
                already_here = true;
            }
        }
        return already_here;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        primary_panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        available_gene_table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        implemented_gene_table = new javax.swing.JTable();
        include_gene_button = new javax.swing.JButton();
        exclude_gene_button = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        generate_report_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        include_gene_text = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        cbHtr = new javax.swing.JCheckBox();
        cbHmo = new javax.swing.JCheckBox();
        cbWd = new javax.swing.JCheckBox();
        cbpres = new javax.swing.JCheckBox();
        cbabs = new javax.swing.JCheckBox();
        exclude_gene_text = new javax.swing.JTextField();
        edit_type_button = new javax.swing.JButton();
        edit_type_text = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        preview_detail_button = new javax.swing.JButton();
        save_as_button = new javax.swing.JButton();
        patient_info_button = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        change_preset_menu_item = new javax.swing.JMenuItem();
        change_language_menu_item = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Genomic Solutions Now!");

        primary_panel.setBackground(new java.awt.Color(102, 153, 255));
        primary_panel.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        available_gene_table.setModel(available_model);
        available_gene_table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        available_gene_table.setCellSelectionEnabled(true);
        available_gene_table.setSelectionBackground(new java.awt.Color(255, 102, 0));
        available_gene_table.setTableHeader(null);
        available_gene_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                available_gene_tableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(available_gene_table);
        if (available_gene_table.getColumnModel().getColumnCount() > 0) {
            available_gene_table.getColumnModel().getColumn(0).setResizable(false);
            available_gene_table.getColumnModel().getColumn(0).setHeaderValue("Available Genes");
        }

        jScrollPane1.setViewportView(jScrollPane3);

        implemented_gene_table.setModel(implemented_model);
        implemented_gene_table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        implemented_gene_table.setSelectionBackground(new java.awt.Color(102, 255, 204));
        implemented_gene_table.setSelectionForeground(new java.awt.Color(0, 0, 0));
        implemented_gene_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                implemented_gene_tableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(implemented_gene_table);

        jScrollPane2.setViewportView(jScrollPane4);

        include_gene_button.setText("Include Gene");
        include_gene_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                include_gene_buttonMouseClicked(evt);
            }
        });

        exclude_gene_button.setText("Exclude Gene");
        exclude_gene_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exclude_gene_buttonMouseClicked(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        generate_report_button.setText("Generate Report");
        generate_report_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generate_report_buttonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Available Genes");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Implemented Genes");

        include_gene_text.setEditable(false);
        include_gene_text.setBackground(new java.awt.Color(255, 102, 0));

        jPanel1.setBackground(new java.awt.Color(204, 153, 255));

        cbHtr.setText("Heterozygous");
        cbHtr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHtrActionPerformed(evt);
            }
        });

        cbHmo.setText("Homozygous");
        cbHmo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHmoActionPerformed(evt);
            }
        });

        cbWd.setText("Wild");
        cbWd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbWdActionPerformed(evt);
            }
        });

        cbpres.setText("Present");
        cbpres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbpresActionPerformed(evt);
            }
        });

        cbabs.setText("Absent");
        cbabs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbabsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbWd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbHtr, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(cbHmo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbpres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cbabs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(cbabs, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbpres)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbHmo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbHtr, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbWd)
                .addGap(0, 0, 0))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbHmo, cbHtr});

        exclude_gene_text.setBackground(new java.awt.Color(102, 255, 204));

        edit_type_button.setText("Edit Type");
        edit_type_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit_type_buttonMouseClicked(evt);
            }
        });

        edit_type_text.setBackground(new java.awt.Color(102, 255, 204));
        edit_type_text.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Report Generation");

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        preview_detail_button.setText("Preview Details");
        preview_detail_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                preview_detail_buttonMouseClicked(evt);
            }
        });

        save_as_button.setText("Save As");
        save_as_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                save_as_buttonMouseClicked(evt);
            }
        });

        patient_info_button.setText("Edit Patient Info");
        patient_info_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patient_info_buttonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout primary_panelLayout = new javax.swing.GroupLayout(primary_panel);
        primary_panel.setLayout(primary_panelLayout);
        primary_panelLayout.setHorizontalGroup(
            primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(primary_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(primary_panelLayout.createSequentialGroup()
                            .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(primary_panelLayout.createSequentialGroup()
                                    .addComponent(include_gene_button, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(include_gene_text, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(primary_panelLayout.createSequentialGroup()
                                    .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(edit_type_button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(exclude_gene_button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(exclude_gene_text)
                                        .addComponent(edit_type_text))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(primary_panelLayout.createSequentialGroup()
                .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(primary_panelLayout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(primary_panelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(patient_info_button, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(save_as_button, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(preview_detail_button, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(generate_report_button, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 11, Short.MAX_VALUE))
            .addComponent(jSeparator3)
        );
        primary_panelLayout.setVerticalGroup(
            primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(primary_panelLayout.createSequentialGroup()
                .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(primary_panelLayout.createSequentialGroup()
                        .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(primary_panelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, primary_panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(primary_panelLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(primary_panelLayout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(include_gene_text, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(include_gene_button))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(exclude_gene_button)
                                            .addComponent(exclude_gene_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(edit_type_button)
                                            .addComponent(edit_type_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, primary_panelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addComponent(jSeparator1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patient_info_button)
                    .addComponent(save_as_button)
                    .addComponent(preview_detail_button)
                    .addComponent(generate_report_button))
                .addGap(18, 18, 18))
        );

        primary_panelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {edit_type_text, exclude_gene_text, include_gene_text});

        jMenu2.setText("Edit");

        jMenuItem1.setText("Add Gene");
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Remove Gene");
        jMenu2.add(jMenuItem2);

        change_preset_menu_item.setText("Change Presets");
        jMenu2.add(change_preset_menu_item);

        change_language_menu_item.setText("Change Language");
        jMenu2.add(change_language_menu_item);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(primary_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(primary_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exclude_gene_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exclude_gene_buttonMouseClicked
        Object item;
        for(int i=0; i<implemented_model.getRowCount(); i++){
            item = (Object) String.valueOf(implemented_model.getValueAt(i, 0));
            if(implemented_gene.equals(item)){
                implemented_model.removeRow(i);
            }
        }
    }//GEN-LAST:event_exclude_gene_buttonMouseClicked

    private void include_gene_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_include_gene_buttonMouseClicked
        if (available_gene != null) { //make sure that a gene was selected 
            if (!check_implemented_list(available_gene)) { //check to see if the gene is already included
                    Object[] to_insert = {available_gene, type};
                    implemented_model.addRow(to_insert);                                
                    available_gene = null;
            }         
        }        
    }//GEN-LAST:event_include_gene_buttonMouseClicked

    private void cbWdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbWdActionPerformed
        cbabs.setSelected(false);
        cbpres.setSelected(false);
        cbWd.setSelected(true);
        cbHtr.setSelected(false);
        cbHmo.setSelected(false);
        type = "Wild";
    }//GEN-LAST:event_cbWdActionPerformed

    private void cbHtrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHtrActionPerformed
        cbabs.setSelected(false);
        cbpres.setSelected(false);
        cbWd.setSelected(false);
        cbHtr.setSelected(true);
        cbHmo.setSelected(false);
        type = "Heterozygous";
    }//GEN-LAST:event_cbHtrActionPerformed

    private void cbHmoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHmoActionPerformed
        cbabs.setSelected(false);
        cbpres.setSelected(false);
        cbWd.setSelected(false);
        cbHtr.setSelected(false);
        cbHmo.setSelected(true);
        type = "Homozygous";
    }//GEN-LAST:event_cbHmoActionPerformed

    private void available_gene_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_available_gene_tableMouseClicked
        available_gene = (Object) String.valueOf(available_model.getValueAt(available_gene_table.getSelectedRow(), 0));
        include_gene_text.setText(String.valueOf(available_gene));
    }//GEN-LAST:event_available_gene_tableMouseClicked

    private void implemented_gene_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_implemented_gene_tableMouseClicked
        implemented_gene = (Object) String.valueOf(implemented_model.getValueAt(implemented_gene_table.getSelectedRow(), 0));
        exclude_gene_text.setText(String.valueOf(implemented_gene));
        edit_type_text.setText(String.valueOf(implemented_gene));
    }//GEN-LAST:event_implemented_gene_tableMouseClicked

    private void edit_type_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_type_buttonMouseClicked
        for(int i=0; i<implemented_model.getRowCount(); i++){
            Object item = (Object) String.valueOf(implemented_model.getValueAt(i, 0));
            if(implemented_gene.equals(item)){
                implemented_model.setValueAt(type, i, 1);
            }
        }
    }//GEN-LAST:event_edit_type_buttonMouseClicked

    private void cbabsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbabsActionPerformed
        cbabs.setSelected(true);
        cbpres.setSelected(false);
        cbWd.setSelected(false);
        cbHtr.setSelected(false);
        cbHmo.setSelected(false);
        type = "Absent";       
    }//GEN-LAST:event_cbabsActionPerformed

    private void cbpresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbpresActionPerformed
        cbabs.setSelected(false);
        cbpres.setSelected(true);
        cbWd.setSelected(false);
        cbHtr.setSelected(false);
        cbHmo.setSelected(false);
        type = "Present";
    }//GEN-LAST:event_cbpresActionPerformed

    private void preview_detail_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_preview_detail_buttonMouseClicked
        PreviewWindow pw = new PreviewWindow(this, true, implemented_model, get_name(), get_address(), get_city(), get_state(), get_dob(), get_gender() );
        pw.setVisible(true);
    }//GEN-LAST:event_preview_detail_buttonMouseClicked

    private void save_as_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save_as_buttonMouseClicked
        save_window.setVisible(true);
    }//GEN-LAST:event_save_as_buttonMouseClicked

    private void patient_info_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patient_info_buttonMouseClicked
       patient_info_window.setVisible(true);
    }//GEN-LAST:event_patient_info_buttonMouseClicked

    private void generate_report_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generate_report_buttonActionPerformed
        // TODO add your handling code here:
        
        
        
        // How to send info to the GUI, one gene at a time or all at once at the end?
    }//GEN-LAST:event_generate_report_buttonActionPerformed

    public static void set_name(String n){
        patient_name = n;
    }
    public static String get_name(){
        return patient_name;
    }
    public static void set_address(String addr){
        patient_address = addr;
    }
    public static String get_address(){
        return patient_address;
    }
    public static void set_city(String c){
        patient_city = c;
    }
    public static String get_city(){
        return patient_city;
    }
    public static void set_state(String s){
        patient_state = s;
    }
    public static String get_state(){
        return patient_state;
    }
    public static void set_dob(String d){
        patient_dob = d;
    }
    public static String get_dob(){
        return patient_dob;
    }
    public static void set_gender(String g){
        patient_gender = g;
    }
    public static String get_gender(){
        return patient_gender;
    }
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable available_gene_table;
    private javax.swing.JCheckBox cbHmo;
    private javax.swing.JCheckBox cbHtr;
    private javax.swing.JCheckBox cbWd;
    private javax.swing.JCheckBox cbabs;
    private javax.swing.JCheckBox cbpres;
    private javax.swing.JMenuItem change_language_menu_item;
    private javax.swing.JMenuItem change_preset_menu_item;
    private javax.swing.JButton edit_type_button;
    private javax.swing.JTextField edit_type_text;
    private javax.swing.JButton exclude_gene_button;
    private javax.swing.JTextField exclude_gene_text;
    private javax.swing.JButton generate_report_button;
    private javax.swing.JTable implemented_gene_table;
    private javax.swing.JButton include_gene_button;
    private javax.swing.JTextField include_gene_text;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton patient_info_button;
    private javax.swing.JButton preview_detail_button;
    private javax.swing.JPanel primary_panel;
    private javax.swing.JButton save_as_button;
    // End of variables declaration//GEN-END:variables
}
