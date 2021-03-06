package display;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import model.*;
/**
 *
 * @author Jeffrey Creighton
 */
public class GUI extends javax.swing.JFrame {
    Calendar cal;                           //Calendar to generate report ID
    DefaultTableModel available_model;      //Represents all genes currently available
    DefaultTableModel implemented_model;    //Represents all genes implemented in report
    Patient patient = new Patient();        //Manages patient info
    AddGeneWindow a_window;
    Color available_color = new Color(255, 156, 58);
    Color implemented_color = new Color(102, 255, 204);
    
    private static final String root = System.getProperty("user.dir") + "/Resources/";
    
    
    
    String available_gene;      //Depreciated: manages available genes highlighted 
    String implemented_gene;    //Depreciated: manages implemented genes highlighted
    String selected_gene;       //Manages the place of both available and implemented genes
    boolean focus_available;    //Maintains which table has control over 'selected_gene'
    
    
    //boolean already_saved = false;
    String type;
    String urgency;
    
    
   DefaultComboBoxModel type_model;
   DefaultComboBoxModel urgency_model; 
    
    private static String[] available_genes;   
    private static String output_filepath = "";
    
    /**
     * Refreshes the two tables.
     * Perform when a gene type is changed, or when data is imported.
     */
    public void refreshData()
    {
    	Map<String, Gene> test_map;
    	for(int i = available_model.getRowCount()-1; i >= 0; i--)
    	{
    		available_model.removeRow(i);
    	}
    	for(int i = implemented_model.getRowCount()-1; i >= 0; i--)
    	{
    		implemented_model.removeRow(i);
    	}
    	test_map =  Main.getData();
        Set<String> string_list = test_map.keySet();
        for(String key: string_list){
            //String[] temp = {key, test_map.get(key).getType(), test_map.get(key).getUrgency(), 
            //test_map.get(key).getRSNumber(), test_map.get(key).getVariant()}; //Added the remaining gene fields
            String[] temp = {key, test_map.get(key).getType(), test_map.get(key).getUrgency(), test_map.get(key).getRSNumber(), test_map.get(key).getVariant()};
            available_model.insertRow(available_model.getRowCount(), temp);
        }
        test_map = Main.getSelected();
        string_list = test_map.keySet();
        for(String key: string_list){
            String[] temp2 = {key, test_map.get(key).getType(), test_map.get(key).getUrgency()};
            implemented_model.insertRow(implemented_model.getRowCount(), temp2);
        }
    }
    
    /**
     * Create new GUI, no attributes
     */
    public GUI() {
        
        type_model = new DefaultComboBoxModel(new String[]{Main.findString("label18"), Main.findString("label19"), Main.findString("label20"), Main.findString("label21")});
        
        //urgency_model = new DefaultComboBoxModel(new String[]{Main.findString("label23"), Main.findString("label24"), Main.findString("label25"), Main.findString("label26"), Main.findString("label27")});
        urgency_model = new DefaultComboBoxModel(new String[]{Main.findString("label72"), Main.findString("label24"), Main.findString("label25"), Main.findString("label23")});
        
        
        //String[] cols = {"Genes", "Types", "Urgency", "RS Number", "Variant"};
        String[] cols = {Main.findString("label34"), Main.findString("label35"), Main.findString("label36"), Main.findString("label37")};//, Main.findString("label38")}; //, Main.findString("label38")};
        available_model = new DefaultTableModel(cols, 0);
        //String[] cols2 = {"Genes", "Types", "Urgency"};
        String[] cols2 = {Main.findString("label34"), Main.findString("label35"), Main.findString("label36")};
        implemented_model = new DefaultTableModel(cols2, 0); 
        refreshData();
       
        initComponents(); 
        
    }
    
    /**
     * Displays error 'e' for the user
     * 
     * @param e 
     */
    public static void displayException(Exception e){
        JFrame frame = new JFrame("Error");
    	JOptionPane.showMessageDialog(frame , e.getMessage());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        primary_panel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        implemented_gene_table = new javax.swing.JTable(){
            private static final long serialVerionUID = 1L;
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        include_gene_button = new javax.swing.JButton();
        exclude_gene_button = new javax.swing.JButton();
        generate_report_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        selected_text = new javax.swing.JTextField();
        edit_type_button = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        preview_detail_button = new javax.swing.JButton();
        save_as_button = new javax.swing.JButton();
        patient_info_button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        available_gene_table = new javax.swing.JTable(){
            private static final long serialVersionUID = 1L;
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        remove_button = new javax.swing.JButton();
        add_button = new javax.swing.JButton();
        urgency_box = new javax.swing.JComboBox();
        type_box = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        import_button = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        orange_arrow = new javax.swing.JLabel();
        blue_arrow = new javax.swing.JLabel();
        blue_arrow.setIcon(new ImageIcon(root + "implemented_arrow.png"));
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Genomic Solutions Now!");
        setIconImages(null);
        setResizable(false);

        primary_panel.setBackground(new java.awt.Color(135, 143, 160));
        primary_panel.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        implemented_gene_table.setModel(implemented_model);
        implemented_gene_table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        implemented_gene_table.setSelectionBackground(new java.awt.Color(102, 255, 204));
        implemented_gene_table.setSelectionForeground(new java.awt.Color(0, 0, 0));
        implemented_gene_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                implemented_gene_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(implemented_gene_table);

        include_gene_button.setText(Main.findString("label12"));
        include_gene_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                include_gene_buttonMouseClicked(evt);
            }
        });

        exclude_gene_button.setText(Main.findString("label11"));
        exclude_gene_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exclude_gene_buttonMouseClicked(evt);
            }
        });

        generate_report_button.setText(Main.findString("label33"));
        generate_report_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generate_report_buttonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(Main.findString("label9")
        );

        jLabel5.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText(Main.findString("label10"));

        selected_text.setBackground(new java.awt.Color(255, 156, 58));
        selected_text.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        selected_text.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        edit_type_button.setText(Main.findString("label15"));
        edit_type_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit_type_buttonMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText(Main.findString("label28"));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        preview_detail_button.setText(Main.findString("label32"));
        preview_detail_button.setActionCommand(Main.findString("label32"));
        preview_detail_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                preview_detail_buttonMouseClicked(evt);
            }
        });

        save_as_button.setText(Main.findString("label30"));
        save_as_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                save_as_buttonMouseClicked(evt);
            }
        });

        patient_info_button.setText(Main.findString("label31"));
        patient_info_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patient_info_buttonMouseClicked(evt);
            }
        });

        available_gene_table.setModel(available_model);
        available_gene_table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        available_gene_table.setSelectionBackground(new java.awt.Color(255, 156, 58));
        available_gene_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                available_gene_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(available_gene_table);

        remove_button.setText(Main.findString("label14"));
        remove_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                remove_buttonMouseClicked(evt);
            }
        });

        add_button.setText(Main.findString("label13"));
        add_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_buttonMouseClicked(evt);
            }
        });

        urgency_box.setModel(urgency_model);

        type_box.setModel(type_model);
        type_box.setSelectedIndex(0);

        jLabel2.setFont(new java.awt.Font("Bitstream Charter", 1, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText(Main.findString("label16"));

        jLabel3.setFont(new java.awt.Font("Bitstream Charter", 1, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText(Main.findString("label22"));

        import_button.setText(Main.findString("label29"));
        import_button.setActionCommand(Main.findString("label29"));
        import_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                import_buttonMouseClicked(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        orange_arrow.setText(" ");
        orange_arrow.setIcon(new ImageIcon(root + "available_arrow.png"));

        javax.swing.GroupLayout primary_panelLayout = new javax.swing.GroupLayout(primary_panel);
        primary_panel.setLayout(primary_panelLayout);
        primary_panelLayout.setHorizontalGroup(
            primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(primary_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(primary_panelLayout.createSequentialGroup()
                        .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(primary_panelLayout.createSequentialGroup()
                                .addComponent(add_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(remove_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(exclude_gene_button, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(include_gene_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selected_text)
                            .addComponent(orange_arrow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(blue_arrow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(primary_panelLayout.createSequentialGroup()
                                .addComponent(edit_type_button, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(type_box, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(urgency_box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(primary_panelLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(primary_panelLayout.createSequentialGroup()
                        .addComponent(import_button, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(save_as_button, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(patient_info_button, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(preview_detail_button, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(generate_report_button, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );

        primary_panelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {add_button, edit_type_button, remove_button});

        primary_panelLayout.setVerticalGroup(
            primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, primary_panelLayout.createSequentialGroup()
                .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(primary_panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(primary_panelLayout.createSequentialGroup()
                        .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(primary_panelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, primary_panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(primary_panelLayout.createSequentialGroup()
                                .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(primary_panelLayout.createSequentialGroup()
                                .addComponent(blue_arrow)
                                .addGap(12, 12, 12)
                                .addComponent(exclude_gene_button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selected_text, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(include_gene_button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(orange_arrow)
                                .addGap(80, 80, 80)))
                        .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(add_button)
                            .addComponent(remove_button)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(edit_type_button)
                                .addComponent(jLabel2)
                                .addComponent(type_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(urgency_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(primary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(import_button)
                    .addComponent(save_as_button)
                    .addComponent(patient_info_button)
                    .addComponent(preview_detail_button)
                    .addComponent(generate_report_button, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        primary_panelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {import_button, patient_info_button, preview_detail_button, save_as_button});

        jMenu2.setText(Main.findString("label1"));

        jMenu1.setText(Main.findString("label2"));

        jMenuItem3.setText(Main.findString("label4"));
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem3MouseClicked(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem1.setText(Main.findString("label5"));
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenu4.setText(Main.findString("label6"));

        jMenuItem2.setText(Main.findString("label7")
        );
        jMenuItem2.setActionCommand(Main.findString("label7"));
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseClicked(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuItem4.setText(Main.findString("label17"));
        jMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem4MouseClicked(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuItem6.setText(Main.findString("label8"));
        jMenuItem6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem6MouseClicked(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenu1.add(jMenu4);

        jMenu2.add(jMenu1);

        jMenuItem5.setText(Main.findString("label3"));
        jMenuItem5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem5MouseClicked(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(primary_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(primary_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void patient_info_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patient_info_buttonMouseClicked
        Patient_Info_Window patientw = new Patient_Info_Window(patient);
        patientw.setVisible(true);
    }//GEN-LAST:event_patient_info_buttonMouseClicked

    private void save_as_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save_as_buttonMouseClicked
        
        JFileChooser chooser = new JFileChooser();
    	FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Spreadsheets (.xls)", "xls");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showSaveDialog(null);      
        if(returnVal == JFileChooser.APPROVE_OPTION) {
        	Main.saveGene(chooser.getSelectedFile().getPath());
                //already_saved = true;
                //set_output_file(chooser.getSelectedFile().getPath());
        }
    }//GEN-LAST:event_save_as_buttonMouseClicked

    private void preview_detail_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_preview_detail_buttonMouseClicked
        String id = "";
        
        cal = Calendar.getInstance();
        int y = cal.get(Calendar.YEAR);
        int m = cal.get(Calendar.MONTH);
        int d = cal.get(Calendar.DAY_OF_MONTH);
        
        id = d + "-" + m + "-" + y;
                
        if(patient.is_filled_out()) {
            String f = patient.get_first_name().substring(0, 1);
            String l = patient.get_last_name();
            String s = patient.get_state();
            id = l + f + "-" + s + "-" + id;
            patient.set_age(patient.get_year(), patient.get_month()+"", patient.get_day()+"");
            patient.set_id(id);
        PreviewWindow pw = new PreviewWindow(this, true, implemented_model, patient, id);
        pw.setVisible(true);
        } else {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, Main.findString("label39"));
        }
    }//GEN-LAST:event_preview_detail_buttonMouseClicked

    private void edit_type_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_type_buttonMouseClicked
                Gene old = Main.getGene(selected_gene);
                Gene new_gene = new Gene(selected_gene, old.getVariant(), old.getRSNumber(), type_box.getSelectedItem().toString(), urgency_box.getSelectedItem().toString());
                Main.setGene(new_gene);
    }//GEN-LAST:event_edit_type_buttonMouseClicked

    private void generate_report_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generate_report_buttonActionPerformed
            
                
            String id = "";
            cal = Calendar.getInstance();
            int y = cal.get(Calendar.YEAR);
            int m = cal.get(Calendar.MONTH);
             int d = cal.get(Calendar.DAY_OF_MONTH);
        
            id = d + "-" + m + "-" + y;
                
            
            String f = patient.get_first_name().substring(0, 1);
            String l = patient.get_last_name();
            String s = patient.get_state();
            id = l + f + "-" + s + "-" + id;
            patient.set_age(patient.get_year(), patient.get_month()+"", patient.get_day()+"");
            patient.set_id(id);
                
            
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Spreadsheets (.xls)", "xls");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showSaveDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                    Main.writeOut(chooser.getSelectedFile().getPath(), patient);
            }
        
        
    }//GEN-LAST:event_generate_report_buttonActionPerformed

    private void exclude_gene_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exclude_gene_buttonMouseClicked
    		boolean found = false;
    		int i = 0;
    		if(focus_available == false)
    		{
	    		while(found == false && i < implemented_model.getRowCount())
	    		{
	    			String item = implemented_model.getValueAt(i, 0).toString();
	                if(selected_gene.equals(item)){                            
	                    Main.deselectGene(item);
	                    found = true;
                            
	                }
	                i++;
	    		}
    		}
    }//GEN-LAST:event_exclude_gene_buttonMouseClicked

    private void include_gene_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_include_gene_buttonMouseClicked
        if (focus_available == true) {
            Main.selectGene(selected_gene.toString());
            selected_gene = null;
        }
          
    }//GEN-LAST:event_include_gene_buttonMouseClicked

    private void import_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_import_buttonMouseClicked
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Spreadsheets (.xls)", "xls");
        fc.setFileFilter(filter);
        int returnVal = fc.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            Main.readGene(fc.getSelectedFile().toString());
        }
    }//GEN-LAST:event_import_buttonMouseClicked
    
    
    private void add_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_buttonMouseClicked
        a_window = new AddGeneWindow();
        a_window.setVisible(true);  
    }//GEN-LAST:event_add_buttonMouseClicked

            
            
    private void implemented_gene_table_update(java.awt.event.KeyEvent evt)
    {
    	focus_available = false;
    	if(evt.getKeyCode() == KeyEvent.VK_DOWN)
    	{
			if (implemented_gene_table.getSelectedRow() != implemented_gene_table.getRowCount() - 1) {
				selected_gene = implemented_gene_table.getValueAt(implemented_gene_table.getSelectedRow() + 1, 0).toString();
			}
    	}
    	else if(evt.getKeyCode() == KeyEvent.VK_UP)
    	{
    		if(implemented_gene_table.getSelectedRow() != 0)
    		{selected_gene = implemented_gene_table.getValueAt(implemented_gene_table.getSelectedRow() - 1, 0).toString();
            }
    	}
    	else if(evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN)
    	{
    		int rowsToEnd = (implemented_gene_table.getRowCount() - 1) - implemented_gene_table.getSelectedRow();
    		if(!(rowsToEnd <= 25))
    		{	
    			selected_gene = implemented_gene_table.getValueAt(implemented_gene_table.getSelectedRow() + 25, 0).toString();
    		}
    		else
    		{
    			selected_gene = implemented_gene_table.getValueAt(implemented_gene_table.getSelectedRow() + rowsToEnd, 0).toString();
    		}
    	}
    	else if(evt.getKeyCode() == KeyEvent.VK_PAGE_UP)
    	{
    		int rowsToTop = implemented_gene_table.getSelectedRow();
    		if(!(rowsToTop<= 25))
    		{	
    			selected_gene = implemented_gene_table.getValueAt(implemented_gene_table.getSelectedRow() - 25, 0).toString();
    		}
    		else
    		{
    			selected_gene = implemented_gene_table.getValueAt(implemented_gene_table.getSelectedRow() - rowsToTop, 0).toString();
    		}
    	}
		selected_text.setText(selected_gene);
		selected_text.setBackground(implemented_color);
    }
    
    
    private void implemented_gene_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_implemented_gene_tableMouseClicked
        focus_available = false;
        selected_gene = implemented_gene_table.getValueAt(implemented_gene_table.getSelectedRow(), 0).toString();
        selected_text.setText(selected_gene);
        selected_text.setBackground(implemented_color);
    }//GEN-LAST:event_implemented_gene_tableMouseClicked

    private void available_gene_table_update(java.awt.event.KeyEvent evt)
    {
    	focus_available = true;
    	if(evt.getKeyCode() == KeyEvent.VK_DOWN)
    	{
			if (available_gene_table.getSelectedRow() != available_gene_table
					.getRowCount() - 1) {
				selected_gene = available_gene_table.getValueAt(
						available_gene_table.getSelectedRow() + 1, 0)
						.toString();
			}
    	}
    	else if(evt.getKeyCode() == KeyEvent.VK_UP)
    	{
    		if(available_gene_table.getSelectedRow() != 0)
    		{selected_gene = available_gene_table.getValueAt(available_gene_table.getSelectedRow() - 1, 0).toString();
}
    	}
    	else if(evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN)
    	{
    		int rowsToEnd = (available_gene_table.getRowCount() - 1) - available_gene_table.getSelectedRow();
    		if(!(rowsToEnd <= 25))
    		{	
    			selected_gene = available_gene_table.getValueAt(available_gene_table.getSelectedRow() + 25, 0).toString();
    		}
    		else
    		{
    			selected_gene = available_gene_table.getValueAt(available_gene_table.getSelectedRow() + rowsToEnd, 0).toString();
    		}
    	}
    	else if(evt.getKeyCode() == KeyEvent.VK_PAGE_UP)
    	{
    		int rowsToTop = available_gene_table.getSelectedRow();
    		if(!(rowsToTop<= 25))
    		{	
    			selected_gene = available_gene_table.getValueAt(available_gene_table.getSelectedRow() - 25, 0).toString();
    		}
    		else
    		{
    			selected_gene = available_gene_table.getValueAt(available_gene_table.getSelectedRow() - rowsToTop, 0).toString();
    		}
    	}
		selected_text.setText(selected_gene);
		selected_text.setBackground(available_color);
	}
    
    private void available_gene_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_available_gene_tableMouseClicked
        focus_available = true;
        selected_gene = available_gene_table.getValueAt(available_gene_table.getSelectedRow(), 0).toString();
        selected_text.setText(selected_gene);
        selected_text.setBackground(available_color);
    }//GEN-LAST:event_available_gene_tableMouseClicked

    private void remove_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_remove_buttonMouseClicked
        if(focus_available == true) {
    		Main.removeGene(selected_gene.toString());
    		selected_gene = null;
    	}
    }//GEN-LAST:event_remove_buttonMouseClicked

    private void jMenuItem5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem5MouseClicked
        String e = "This feature is currently unavailable!";     
        displayException(new Exception(e));
    }//GEN-LAST:event_jMenuItem5MouseClicked

    private void jMenuItem3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MouseClicked
        String e = "This feature is currently unavailable!";     
        displayException(new Exception(e));
    }//GEN-LAST:event_jMenuItem3MouseClicked

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        String e = "This feature is currently unavailable!";     
        displayException(new Exception(e));
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseClicked
        String e = "This feature is currently unavailable!";     
        displayException(new Exception(e));
    }//GEN-LAST:event_jMenuItem2MouseClicked

    private void jMenuItem4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem4MouseClicked
        String e = "This feature is currently unavailable!";     
        displayException(new Exception(e));
    }//GEN-LAST:event_jMenuItem4MouseClicked

    private void jMenuItem6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem6MouseClicked
        String e = "This feature is currently unavailable!";     
        displayException(new Exception(e));
    }//GEN-LAST:event_jMenuItem6MouseClicked
 
    
    public static void set_output_file(String f) {
     output_filepath = f;   
    }
    public static String get_output_file() {
        return output_filepath;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_button;
    private javax.swing.JTable available_gene_table;
    private javax.swing.JLabel blue_arrow;
    private javax.swing.JButton edit_type_button;
    private javax.swing.JButton exclude_gene_button;
    private javax.swing.JButton generate_report_button;
    private javax.swing.JTable implemented_gene_table;
    private javax.swing.JButton import_button;
    private javax.swing.JButton include_gene_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel orange_arrow;
    private javax.swing.JButton patient_info_button;
    private javax.swing.JButton preview_detail_button;
    private javax.swing.JPanel primary_panel;
    private javax.swing.JButton remove_button;
    private javax.swing.JButton save_as_button;
    private javax.swing.JTextField selected_text;
    private javax.swing.JComboBox type_box;
    private javax.swing.JComboBox urgency_box;
    // End of variables declaration//GEN-END:variables
}
