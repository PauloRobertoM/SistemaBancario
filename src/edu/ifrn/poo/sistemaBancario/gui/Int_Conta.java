package edu.ifrn.poo.sistemaBancario.gui;

import edu.ifrn.poo.sistemaBancario.controlador.ControladorAgencia;
import edu.ifrn.poo.sistemaBancario.controlador.ControladorCliente;
import edu.ifrn.poo.sistemaBancario.controlador.ControladorConta;
import edu.ifrn.poo.sistemaBancario.dominio.Conta;
import java.sql.SQLException;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class Int_Conta extends javax.swing.JFrame {

    public Int_Conta() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Número");

        jLabel2.setText("Ativa");

        jLabel3.setText("Saldo");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Conta");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Sim");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Não");

        jComboBox1.setModel(listarClientes());
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Cliente");

        jLabel6.setText("Agência");

        jComboBox2.setModel(listarAgencias());
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton2.setText("Votar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jRadioButton1)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addComponent(jRadioButton2))
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, 117, Short.MAX_VALUE))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 98, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // cadastro
        Integer numeroAgencia;
        Integer numero;
        Boolean ativa = true;
        Double saldo;
<<<<<<< HEAD
        Conta c = new Conta();
        ControladorConta controlador = new ControladorConta();
//        ContaDao cd = new ContaDao();
=======
        String nomeCliente;
        
>>>>>>> origin/master
        numero = Integer.parseInt(this.jTextField1.getText());
        saldo = Double.parseDouble(this.jTextField2.getText());
        nomeCliente = this.jComboBox1.getSelectedItem().toString();
        numeroAgencia = Integer.parseInt((String) this.jComboBox2.getSelectedItem());
        
        if (jRadioButton1.isSelected()){
            ativa = true;
        }
        else if (jRadioButton2.isSelected()){
            ativa = false;
        }
        
        ControladorCliente cliente_controlador = new ControladorCliente(); 
        int cliente_id = 0;
        try {
           cliente_id = cliente_controlador.getIdByNome(nomeCliente); 
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this,"Driver não instalado!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Comandos SQL Inválido! - Cliente");
        }
        
        ControladorAgencia agencia_controlador = new ControladorAgencia();
        int agencia_id = 0;
        try {
           agencia_id = agencia_controlador.getIdByNumero(numeroAgencia); 
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this,"Driver não instalado!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Comandos SQL Inválido! - Agencia");
        }
        
        ControladorConta conta_controlador = new ControladorConta();
        try {
            Conta c = new Conta();
            c.setNumero(numero);
            c.setAtiva(ativa);
            c.setSaldo(saldo);
            c.setIdCliente(cliente_id);
            c.setIdAgencia(agencia_id);

            conta_controlador.cadastrarConta(c);
            
            jTextField1.setText(null);
            jTextField2.setText(null);
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Driver não instalado!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Comando SQL inválido - CadastrarAgencia!");
        }
        
        new NavegacaoInicial().setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        listarClientes();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        listarAgencias();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
<<<<<<< HEAD
        VisualizarConta vc = new VisualizarConta();
        vc.setVisible(true);
=======
        new CadastContaAgencia().setVisible(true);
        this.dispose();
>>>>>>> origin/master
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Int_Conta().setVisible(true);
            }
        });
    }
    
    private ComboBoxModel listarClientes (){
        ControladorCliente cliente_controlador = new ControladorCliente();
        DefaultComboBoxModel df = null;
        try {            
            df = cliente_controlador.listarClientes();           
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Driver não instalado!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Comando SQL inválido!");
        } finally {
            return df;
        }
    }
    
    private ComboBoxModel listarAgencias(){
        ControladorAgencia agencias_controlador = new ControladorAgencia();
        DefaultComboBoxModel df = null;
        try {            
            df = agencias_controlador.listarAgencias();           
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Driver não instalado!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Comando SQL inválido! - Lis_Agencias");
        }finally {
            return df;
        }
    }
     
    
    public int getIdConta(){
        int numero = Integer.parseInt(this.jTextField1.getText());
        ControladorConta conta_controlador = new ControladorConta(); 
        int conta_id = 0;
        try {
           conta_id = conta_controlador.getIdByNumero(numero); 
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this,"Driver não instalado!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Comandos SQL Inválido! - Cliente");
        }
        return conta_id;
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
