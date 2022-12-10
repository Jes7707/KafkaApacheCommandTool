/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Jes
 */
public class CommandsToolGUI extends javax.swing.JFrame {
    
    String binSelected;
    final String FROM_BEGINNING=" --from-beginning";
    int xMouse, yMouse;

    /**
     * Creates new form CommandsToolGUI
     */
    public CommandsToolGUI() {
        initComponents();
        elementsOnStart();
    }
    
//    public void scaleImage(){
//        ImageIcon icon = new ImageIcon("/img/fondo.png");
//        Image img = icon.getImage();
//        Image imgScale = img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon scaledIcon = new ImageIcon(imgScale);
//        jLabel1.setIcon(scaledIcon);
//    }
    
    private void elementsOnStart(){
        startZookeeperjLabel.setVisible(true);
        binZookeeperjLabel.setVisible(true);
        startKafkajLabel.setVisible(true);
        binKafkajLabel.setVisible(true);
        jScrollPane1.setVisible(false);
        
        topicjTextField.setVisible(false);
        bServerjTextField.setVisible(false);
        partitionsjTextField.setVisible(false);
        repFactjTextField.setVisible(false);
        buildjButton.setVisible(false);
        beginningjCheckBox1.setVisible(false);
        jScrollPane1.setVisible(false);
    }
    private void limpiarTextFieldsCreateTopic(){
        topicjTextField.setText("--topic");
        bServerjTextField.setText("--bootstrap-server");
        partitionsjTextField.setText("--partitions");
        repFactjTextField.setText("--replication-factor");
        bServerjTextField.setText("--bootstrap-server");
        
        topicjTextField.setVisible(true);
        bServerjTextField.setVisible(true);
        partitionsjTextField.setVisible(true);
        repFactjTextField.setVisible(true);
        bServerjTextField.setVisible(true);
        
        topicjTextField.setForeground(Color.GRAY);
        bServerjTextField.setForeground(Color.GRAY);
        partitionsjTextField.setForeground(Color.GRAY);
        repFactjTextField.setForeground(Color.GRAY);
    }
    private void limpiarTextFieldsTopicList(){
        bServerjTextField.setText("--bootstrap-server");
        bServerjTextField.setForeground(Color.GRAY);
    }
    private void limpiarTextFieldsTopicDescribe(){
        topicjTextField.setText("--topic");
        bServerjTextField.setText("--bootstrap-server");
        
        topicjTextField.setForeground(Color.GRAY);
        bServerjTextField.setForeground(Color.GRAY);
    }
    private void limpiarTextFieldsCreateProducer(){
        topicjTextField.setText("--topic");
        bServerjTextField.setText("--bootstrap-server");
        
        topicjTextField.setForeground(Color.GRAY);
        bServerjTextField.setForeground(Color.GRAY);
    }
    private void limpiarTextFieldsCreateConsumer(){
        topicjTextField.setText("--topic");
        bServerjTextField.setText("--bootstrap-server");
        
        topicjTextField.setForeground(Color.GRAY);
        bServerjTextField.setForeground(Color.GRAY);
    }
    
    private void reducirAnchoTextFields(){
        topicjTextField.setSize(250,topicjTextField.getHeight());
        bServerjTextField.setSize(250,topicjTextField.getHeight());
        partitionsjTextField.setSize(250,topicjTextField.getHeight());
        repFactjTextField.setSize(250,topicjTextField.getHeight());
    }
    private void aumentarAnchoTextFields(){
        topicjTextField.setSize(570,topicjTextField.getHeight());
        bServerjTextField.setSize(570,topicjTextField.getHeight());
        partitionsjTextField.setSize(570,topicjTextField.getHeight());
        repFactjTextField.setSize(570,topicjTextField.getHeight());
    }
    private void createTopic(String partitions, String repFact, String topic, String bServer){
        if(!topic.equals("--topic")
                        &&!bServer.equals("--bootstrap-server")
                        &&!partitions.equals("--partitions")
                        &&!repFact.equals("--replication-factor")){
                if(!topic.isEmpty()
                            &&!bServer.isEmpty()
                            &&!partitions.isEmpty()
                            &&!repFact.isEmpty()){
                    int nPartitions = Integer.parseInt(partitions);
                    int nRepFactor = Integer.parseInt(repFact);
                    reducirAnchoTextFields();
                    jScrollPane1.setVisible(true);
                    jTextArea1.setText("");
                    jTextArea1.setText("bin/kafka-topics.sh --create --topic "+topic+" --bootstrap-server "+bServer+" --partitions "+partitions+" --replication-factor "+repFact);
                    limpiarTextFieldsCreateTopic();
                }
        }else{
            JOptionPane.showMessageDialog(null,"Debes llenar todos los campos","Campos Obligatorios",2);
            limpiarTextFieldsCreateTopic();
            }
    }
    private void topicList(String bServer){
        if(!bServer.equals("--bootstrap-server")){
            if(!bServer.isEmpty()){
                reducirAnchoTextFields();
                jScrollPane1.setVisible(true);
                jTextArea1.setText("");
                jTextArea1.setText("bin/kafka-topics.sh --list --bootstrap-server "+bServer);
                limpiarTextFieldsTopicList();
            }
        }else{
                JOptionPane.showMessageDialog(null,"Debes llenar todos los campos","Campos Obligatorios",2);
                jScrollPane1.setVisible(false);
                aumentarAnchoTextFields();
                limpiarTextFieldsTopicList();
            }
    }
    private void topicDescribe(String topic, String bServer){
        if(!topic.equals("--topic")&&!bServer.equals("--bootstrap-server")){
            if(!topic.isEmpty()&&!bServer.isEmpty()){
                reducirAnchoTextFields();
                jScrollPane1.setVisible(true);
                jTextArea1.setText("");
                jTextArea1.setText("bin/kafka-topics.sh --describe --bootstrap-server "+bServer);
                limpiarTextFieldsTopicDescribe();
            }
        }else{
                JOptionPane.showMessageDialog(null,"Debes llenar todos los campos","Campos Obligatorios",2);
                jScrollPane1.setVisible(false);
                aumentarAnchoTextFields();
                limpiarTextFieldsTopicDescribe();
            }
    }
    private void createProducer(String topic, String bServer){
        if(!topic.equals("--topic")&&!bServer.equals("--bootstrap-server")){
            if(!topic.isEmpty()&&!bServer.isEmpty()){
                reducirAnchoTextFields();
                jScrollPane1.setVisible(true);
                jTextArea1.setText("");
                jTextArea1.setText("bin/kafka-console-producer.sh --topic "+topic+" --bootstrap-server "+bServer);
                limpiarTextFieldsCreateProducer();
            }
        }else{
            JOptionPane.showMessageDialog(null,"Debes llenar todos los campos","Campos Obligatorios",2);
            jScrollPane1.setVisible(false);
            aumentarAnchoTextFields();
            limpiarTextFieldsCreateProducer();
            }
    }
    private void createConsumer(String topic, String bServer){
        if(!topic.equals("--topic")&&!bServer.equals("--bootstrap-server")){
                if(!topic.isEmpty()&&!bServer.isEmpty()){
                    if(beginningjCheckBox1.isSelected()){
                        reducirAnchoTextFields();
                        jScrollPane1.setVisible(true);
                        jTextArea1.setText("");
                        jTextArea1.setText("bin/kafka-console-consumer.sh --topic "+topic+FROM_BEGINNING+" --bootstrap-server "+bServer);
                        limpiarTextFieldsCreateConsumer();
                    }else{
                        reducirAnchoTextFields();
                        jScrollPane1.setVisible(true);
                        jTextArea1.setText("");
                        jTextArea1.setText("bin/kafka-console-consumer.sh --topic "+topic+" --bootstrap-server "+bServer);
                        
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null,"Debes llenar todos los campos","Campos Obligatorios",2);
                jScrollPane1.setVisible(false);
                aumentarAnchoTextFields();
                limpiarTextFieldsCreateConsumer();
            }
    }
    private void elementsInCreateTopic(){
        startZookeeperjLabel.setVisible(false);
        binZookeeperjLabel.setVisible(false);
        startKafkajLabel.setVisible(false);
        binKafkajLabel.setVisible(false);
        jScrollPane1.setVisible(false);
        beginningjCheckBox1.setVisible(false);

        topicjTextField.setVisible(true);
        bServerjTextField.setVisible(true);
        partitionsjTextField.setVisible(true);
        repFactjTextField.setVisible(true);
        buildjButton.setVisible(true);
    }
    private void elementsInListTopic(){
        startZookeeperjLabel.setVisible(false);
        binZookeeperjLabel.setVisible(false);
        startKafkajLabel.setVisible(false);
        binKafkajLabel.setVisible(false);
        jScrollPane1.setVisible(false);
        beginningjCheckBox1.setVisible(false);
        topicjTextField.setVisible(false);
        partitionsjTextField.setVisible(false);
        repFactjTextField.setVisible(false);
        
        bServerjTextField.setVisible(true);
        buildjButton.setVisible(true);
    }
    private void elementsInDescribeTopic(){
        startZookeeperjLabel.setVisible(false);
        binZookeeperjLabel.setVisible(false);
        startKafkajLabel.setVisible(false);
        binKafkajLabel.setVisible(false);
        jScrollPane1.setVisible(false);
        beginningjCheckBox1.setVisible(false);
        partitionsjTextField.setVisible(false);
        repFactjTextField.setVisible(false);
        
        topicjTextField.setVisible(true);
        bServerjTextField.setVisible(true);
        buildjButton.setVisible(true);
    }
    private void elementsInProducer(){
        topicjTextField.setVisible(true);
        bServerjTextField.setVisible(true);
        buildjButton.setVisible(true);

        startZookeeperjLabel.setVisible(false);
        binZookeeperjLabel.setVisible(false);
        startKafkajLabel.setVisible(false);
        binKafkajLabel.setVisible(false);
        partitionsjTextField.setVisible(false);
        repFactjTextField.setVisible(false);
        beginningjCheckBox1.setVisible(false);
        jScrollPane1.setVisible(false);
    }
    private void elementsInConsumer(){
        topicjTextField.setVisible(true);
        bServerjTextField.setVisible(true);
        beginningjCheckBox1.setVisible(true);
        buildjButton.setVisible(true);

        startZookeeperjLabel.setVisible(false);
        binZookeeperjLabel.setVisible(false);
        startKafkajLabel.setVisible(false);
        binKafkajLabel.setVisible(false);
        partitionsjTextField.setVisible(false);
        repFactjTextField.setVisible(false);
        jScrollPane1.setVisible(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        topicjTextField = new javax.swing.JTextField();
        bServerjTextField = new javax.swing.JTextField();
        partitionsjTextField = new javax.swing.JTextField();
        repFactjTextField = new javax.swing.JTextField();
        beginningjCheckBox1 = new javax.swing.JCheckBox();
        buildjButton = new javax.swing.JButton();
        startZookeeperjLabel = new javax.swing.JLabel();
        binZookeeperjLabel = new javax.swing.JLabel();
        startKafkajLabel = new javax.swing.JLabel();
        binKafkajLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(720, 580));
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(java.awt.Color.white);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(java.awt.Color.white);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, 320, 190));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 48)); // NOI18N
        jLabel2.setText("Command Tool");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Kokonor", 1, 36)); // NOI18N
        jLabel3.setForeground(java.awt.Color.lightGray);
        jLabel3.setText("Apache Kafka");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Command", "create-topic", "list-topic", "describe-topic", "producer", "consumer" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 270, 30));

        topicjTextField.setForeground(java.awt.Color.gray);
        topicjTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                topicjTextFieldMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                topicjTextFieldMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                topicjTextFieldMousePressed(evt);
            }
        });
        topicjTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topicjTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(topicjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 570, -1));

        bServerjTextField.setForeground(java.awt.Color.gray);
        bServerjTextField.setText("--bootstrap-server");
        bServerjTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bServerjTextFieldMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bServerjTextFieldMousePressed(evt);
            }
        });
        bServerjTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bServerjTextFieldActionPerformed(evt);
            }
        });
        bServerjTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bServerjTextFieldKeyPressed(evt);
            }
        });
        jPanel1.add(bServerjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 570, -1));

        partitionsjTextField.setForeground(java.awt.Color.gray);
        partitionsjTextField.setText("--partitions");
        partitionsjTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                partitionsjTextFieldMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                partitionsjTextFieldMousePressed(evt);
            }
        });
        partitionsjTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partitionsjTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(partitionsjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 570, -1));

        repFactjTextField.setForeground(java.awt.Color.gray);
        repFactjTextField.setText("--replication-factor");
        repFactjTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repFactjTextFieldMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                repFactjTextFieldMousePressed(evt);
            }
        });
        repFactjTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repFactjTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(repFactjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 570, -1));

        beginningjCheckBox1.setBackground(java.awt.Color.white);
        beginningjCheckBox1.setForeground(java.awt.Color.gray);
        beginningjCheckBox1.setText("--from-beginning");
        beginningjCheckBox1.setOpaque(true);
        jPanel1.add(beginningjCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 150, -1));

        buildjButton.setBackground(java.awt.Color.black);
        buildjButton.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        buildjButton.setForeground(java.awt.Color.white);
        buildjButton.setText("Build");
        buildjButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buildjButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buildjButtonMouseClicked(evt);
            }
        });
        jPanel1.add(buildjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 90, 50));

        startZookeeperjLabel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        startZookeeperjLabel.setForeground(java.awt.Color.white);
        startZookeeperjLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        startZookeeperjLabel.setText("# Start the ZooKeeper service");
        jPanel1.add(startZookeeperjLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, -1, 30));

        binZookeeperjLabel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        binZookeeperjLabel.setForeground(java.awt.Color.white);
        binZookeeperjLabel.setText("bin/zookeeper-server-start.sh config/zookeeper.properties");
        jPanel1.add(binZookeeperjLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 420, -1));

        startKafkajLabel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        startKafkajLabel.setForeground(java.awt.Color.white);
        startKafkajLabel.setText("# Start the Kafka broker service");
        jPanel1.add(startKafkajLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, -1, -1));

        binKafkajLabel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        binKafkajLabel.setForeground(java.awt.Color.white);
        binKafkajLabel.setText("bin/kafka-server-start.sh config/server.properties");
        jPanel1.add(binKafkajLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, -1, -1));

        jPanel2.setBackground(java.awt.Color.black);
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(java.awt.Color.red);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("X");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("AppleMyungjo", 0, 12)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("GWFM -Interfaces");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(0, 568, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addComponent(jLabel6))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 707, 30));

        jLabel5.setFont(new java.awt.Font("Snell Roundhand", 0, 24)); // NOI18N
        jLabel5.setText("byJes");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 520, -1, -1));

        jLabel1.setBackground(java.awt.Color.white);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -4, 710, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        binSelected = (String)jComboBox1.getSelectedItem();
        if("Select Command".equals(binSelected)){
            elementsOnStart();
        }
        if("create-topic".equals(binSelected)){
            elementsInCreateTopic();
        }
        if("list-topic".equals(binSelected)){
            elementsInListTopic();
        }
        if("describe-topic".equals(binSelected)){
            elementsInDescribeTopic();
        }
        if("producer".equals(binSelected)){
            elementsInProducer();
        }
        if("consumer".equals(binSelected)){
            elementsInConsumer();
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void buildjButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buildjButtonMouseClicked
        // TODO add your handling code here:
        String topic = topicjTextField.getText();
        String bServer = bServerjTextField.getText();
        String partitions = partitionsjTextField.getText();
        String repFact = repFactjTextField.getText();
        
        if("create-topic".equals(binSelected)){
            try {
                createTopic(partitions, repFact, topic, bServer);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Debes introducir numeros en los campos de \n \"partitions\" y \"replication factor\". Error: \n"+e,"Datos Invalidos",2);
            }
        }
        if("list-topic".equals(binSelected)){
            topicList(bServer);
        }
        if("describe-topic".equals(binSelected)){
            topicDescribe(topic, bServer);
        }
        if("producer".equals(binSelected)){
            createProducer(topic, bServer);
        }
        if("consumer".equals(binSelected)){
            createConsumer(topic, bServer);
        }
    }//GEN-LAST:event_buildjButtonMouseClicked

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        // TODO add your handling code here:
        jScrollPane1.setVisible(false);
        if(topicjTextField.getText().equals("--topic")){
            topicjTextField.setText("");
            topicjTextField.setForeground(Color.BLACK);
        }if(topicjTextField.getText().isEmpty()){
            topicjTextField.setText("--topic");
            topicjTextField.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void topicjTextFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topicjTextFieldMousePressed
        // TODO add your handling code here:
        if(topicjTextField.getText().equals("--topic")){
            topicjTextField.setText("");
            topicjTextField.setForeground(Color.BLACK);
        }
        if(bServerjTextField.getText().isEmpty()
                ||partitionsjTextField.getText().isEmpty()
                ||repFactjTextField.getText().isEmpty()){
            bServerjTextField.setText("--bootstrap-server");
            bServerjTextField.setForeground(Color.GRAY);
            partitionsjTextField.setText("--partitions");
            partitionsjTextField.setForeground(Color.GRAY);
            repFactjTextField.setText("--replication-factor");
            repFactjTextField.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_topicjTextFieldMousePressed

    private void bServerjTextFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bServerjTextFieldMousePressed
        // TODO add your handling code here:
        if(bServerjTextField.getText().equals("--bootstrap-server")){
            bServerjTextField.setText("");
            bServerjTextField.setForeground(Color.BLACK);
        }
        if(topicjTextField.getText().isEmpty()
                ||partitionsjTextField.getText().isEmpty()
                ||repFactjTextField.getText().isEmpty()){
            topicjTextField.setText("--topic");
            topicjTextField.setForeground(Color.GRAY);
            partitionsjTextField.setText("--partitions");
            partitionsjTextField.setForeground(Color.GRAY);
            repFactjTextField.setText("--replication-factor");
            repFactjTextField.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_bServerjTextFieldMousePressed

    private void partitionsjTextFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_partitionsjTextFieldMousePressed
        // TODO add your handling code here:
        if(partitionsjTextField.getText().equals("--partitions")){
            partitionsjTextField.setText("");
            partitionsjTextField.setForeground(Color.BLACK);
        }
        if(topicjTextField.getText().isEmpty()
                ||bServerjTextField.getText().isEmpty()
                ||repFactjTextField.getText().isEmpty()){
            topicjTextField.setText("--topic");
            topicjTextField.setForeground(Color.GRAY);
            bServerjTextField.setText("--bootstrap-server");
            bServerjTextField.setForeground(Color.GRAY);
            repFactjTextField.setText("--replication-factor");
            repFactjTextField.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_partitionsjTextFieldMousePressed

    private void repFactjTextFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repFactjTextFieldMousePressed
        // TODO add your handling code here:
        if(repFactjTextField.getText().equals("--replication-factor")){
            repFactjTextField.setText("");
            repFactjTextField.setForeground(Color.BLACK);
        }
        if(topicjTextField.getText().isEmpty()
                ||bServerjTextField.getText().isEmpty()
                ||partitionsjTextField.getText().isEmpty()){
            topicjTextField.setText("--topic");
            topicjTextField.setForeground(Color.GRAY);
            bServerjTextField.setText("--bootstrap-server");
            bServerjTextField.setForeground(Color.GRAY);
            partitionsjTextField.setText("--partitions");
            partitionsjTextField.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_repFactjTextFieldMousePressed

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        xMouse=evt.getX();
        yMouse=evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse, y-yMouse);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        // TODO add your handling code here:
        jLabel4.setForeground(Color.WHITE);
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        // TODO add your handling code here:
        jLabel4.setForeground(Color.RED);
    }//GEN-LAST:event_jLabel4MouseExited

    private void topicjTextFieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topicjTextFieldMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_topicjTextFieldMouseEntered

    private void bServerjTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bServerjTextFieldKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_bServerjTextFieldKeyPressed

    private void topicjTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topicjTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_topicjTextFieldActionPerformed

    private void bServerjTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bServerjTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bServerjTextFieldActionPerformed

    private void partitionsjTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partitionsjTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_partitionsjTextFieldActionPerformed

    private void repFactjTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repFactjTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repFactjTextFieldActionPerformed

    private void topicjTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topicjTextFieldMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_topicjTextFieldMouseClicked

    private void bServerjTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bServerjTextFieldMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bServerjTextFieldMouseClicked

    private void partitionsjTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_partitionsjTextFieldMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_partitionsjTextFieldMouseClicked

    private void repFactjTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repFactjTextFieldMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_repFactjTextFieldMouseClicked

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
            java.util.logging.Logger.getLogger(CommandsToolGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CommandsToolGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CommandsToolGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CommandsToolGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CommandsToolGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bServerjTextField;
    private javax.swing.JCheckBox beginningjCheckBox1;
    private javax.swing.JLabel binKafkajLabel;
    private javax.swing.JLabel binZookeeperjLabel;
    private javax.swing.JButton buildjButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField partitionsjTextField;
    private javax.swing.JTextField repFactjTextField;
    private javax.swing.JLabel startKafkajLabel;
    private javax.swing.JLabel startZookeeperjLabel;
    private javax.swing.JTextField topicjTextField;
    // End of variables declaration//GEN-END:variables
}
