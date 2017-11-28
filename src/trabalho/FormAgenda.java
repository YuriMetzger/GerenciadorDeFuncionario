/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import Classes.Agenda;
import Classes.Funcionario;
import Classes.SimpleTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Joao
 */
public class FormAgenda extends javax.swing.JFrame {

    /**
     * Creates new form FormAgenda
     */
    public FormAgenda() {
        initComponents();
    }

    ArrayList<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
    ArrayList<Agenda> listaAgenda = new ArrayList<Agenda>();
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane7 = new javax.swing.JScrollPane();
        jtAgenda = new javax.swing.JTable();
        agenda_excluir = new javax.swing.JButton();
        agenda_editar = new javax.swing.JButton();
        agenda_salvar = new javax.swing.JButton();
        agenda_prioridade = new javax.swing.JComboBox<>();
        agenda_tituloCompromisso = new javax.swing.JTextField();
        agenda_hora = new javax.swing.JFormattedTextField();
        try{
            javax.swing.text.MaskFormatter data = new javax.swing.text.MaskFormatter("##:##");
            agenda_hora = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        try{
            javax.swing.text.MaskFormatter data = new javax.swing.text.MaskFormatter("##/##/####");
            agenda_data = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        agenda_data = new javax.swing.JFormattedTextField();
        try{
            javax.swing.text.MaskFormatter data = new javax.swing.text.MaskFormatter("##/##/####");
            agenda_data = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        agenda_nome = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        btAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agenda");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jtAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Título", "Prioridade", "Data ", "Hora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtAgendaMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jtAgenda);

        agenda_excluir.setText("Excluir");
        agenda_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agenda_excluirActionPerformed(evt);
            }
        });

        agenda_editar.setText("Limpar");
        agenda_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agenda_editarActionPerformed(evt);
            }
        });

        agenda_salvar.setText("Salvar");
        agenda_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agenda_salvarActionPerformed(evt);
            }
        });

        agenda_prioridade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baixa", "Média", "Alta" }));

        agenda_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agenda_dataActionPerformed(evt);
            }
        });

        agenda_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agenda_nomeActionPerformed(evt);
            }
        });

        jLabel34.setText("Nome:");

        jLabel36.setText("Título Compromisso:");

        jLabel37.setText("Prioridade:");

        jLabel35.setText("Data:");

        jLabel38.setText("Hora:");

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel37)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel36)
                        .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(agenda_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(agenda_tituloCompromisso)
                                .addGap(61, 61, 61))
                            .addComponent(agenda_prioridade, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(123, 123, 123)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel35)
                            .addComponent(jLabel38))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(agenda_data)
                            .addComponent(agenda_hora, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(agenda_salvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAlterar)
                        .addGap(5, 5, 5)
                        .addComponent(agenda_editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(agenda_excluir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(agenda_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(agenda_tituloCompromisso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(agenda_prioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(agenda_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(agenda_hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agenda_salvar)
                    .addComponent(agenda_editar)
                    .addComponent(agenda_excluir)
                    .addComponent(btAlterar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void agenda_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agenda_salvarActionPerformed
        Integer contador = 0;
        if(agenda_tituloCompromisso.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null,"Favor inserir Título para o comprisso!");
            contador++;
        }
        if(agenda_data.getText().length() != 10 && contador == 0 || agenda_data.getText().equals("  /  /    ")){
            JOptionPane.showMessageDialog(null, "Data inválida!");
            contador++;
        }
        if(agenda_hora.getText().length() != 5 && contador == 0){
            JOptionPane.showMessageDialog(null, "Hora inválida!");
            contador++;
        }
        if(contador == 0){
            Agenda agenda = new Agenda();
            String titulo = agenda_tituloCompromisso.getText();
            String prioridade = (String)agenda_prioridade.getSelectedItem();
            String funcionario = (String)agenda_nome.getSelectedItem();
            int idFuncionario = 0;
            String data = agenda_data.getText();
            String hora = agenda_hora.getText();

            for (int i = 0; i < listaFuncionario.size(); i++) {
                if( listaFuncionario.get(i).getNome().equalsIgnoreCase(funcionario) ){
                    idFuncionario = listaFuncionario.get(i).getCodigo();
                }
            }
                agenda.setTitulo(titulo);
                agenda.setPrioridade(prioridade);
                agenda.setNomeFuncionario(funcionario);
                agenda.setIdFuncionario(idFuncionario);
                agenda.setData(data);
                agenda.setHora(hora);
            if(jtAgenda.getSelectedRow() == -1){
                try {
                    agenda.cadastrarAgenda();
                } catch (SQLException ex) {
                    Logger.getLogger(CadFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                try {
                Integer idx = jtAgenda.getSelectedRow();
                String ID = (String) jtAgenda.getModel().getValueAt(idx,0);
                agenda.atualizaAgenda(ID);
                } catch (SQLException ex) {
                    Logger.getLogger(FormAgenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            atualizaTabelaAgenda();
        }
    }//GEN-LAST:event_agenda_salvarActionPerformed
    public void atualizaTabelaAgenda(){
        Agenda agenda = new Agenda();
        try {
            listaAgenda = agenda.listarAgenda();
            
            jtAgenda = createJtableAgenda( listaAgenda );
            jScrollPane7.setViewportView(jtAgenda);
            
        } catch (SQLException ex) {
            Logger.getLogger(CadFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public JTable createJtableAgenda( ArrayList<Agenda> listaAgenda ){
        JLabel labelSingleClick = new JLabel("Single click me.");
        ArrayList dados = new ArrayList();
        String[] colunas = new String[] 
        {"ID","Nome","Titulo", "Prioridade", "Data", "Hora"};
         
         for (Agenda d:listaAgenda){
            dados.add(new String[]
                {d.getIdAgenda(), d.getNomeFuncionario(), d.getTitulo(), d.getPrioridade(), d.getData(), d.getHora(),}
            );
         }
         
         SimpleTableModel modelo =
                new SimpleTableModel(dados, colunas);
         
         JTable jtable = new JTable(modelo);
         return jtable;
    }
    
    public void comboFuncionario(){
        Funcionario funcionario = new Funcionario();
        Object[] items = null; 
        
        try {
            listaFuncionario = funcionario.listarFuncionario();
        } catch (SQLException ex) {
            Logger.getLogger(CadFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < listaFuncionario.size(); i++) {
            agenda_nome.addItem( listaFuncionario.get(i).getNome() );
        }
    }
    private void agenda_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agenda_dataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agenda_dataActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void agenda_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agenda_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agenda_nomeActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        atualizaTabelaAgenda();
        comboFuncionario();
    }//GEN-LAST:event_formWindowOpened

    private void jtAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtAgendaMouseClicked
        JOptionPane.showMessageDialog(null,"teste");
    }//GEN-LAST:event_jtAgendaMouseClicked

    private void agenda_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agenda_editarActionPerformed
        agenda_nome.setSelectedIndex(0);
        agenda_tituloCompromisso.setText("");
        agenda_prioridade.setSelectedIndex(0);
        agenda_data.setText("");
        agenda_hora.setText("");
        jtAgenda.clearSelection();
    }//GEN-LAST:event_agenda_editarActionPerformed

    private void agenda_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agenda_excluirActionPerformed
        Agenda agenda = new Agenda();
        Integer idx = jtAgenda.getSelectedRow();
        String ID = (String) jtAgenda.getModel().getValueAt(idx,0);
        try { 
            agenda.excluiItemAgenda(ID);
        } catch (SQLException ex) {
            Logger.getLogger(FormAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        atualizaTabelaAgenda();
    }//GEN-LAST:event_agenda_excluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        Integer idx = jtAgenda.getSelectedRow();
        agenda_nome.setSelectedItem(jtAgenda.getModel().getValueAt(idx,1));
        agenda_tituloCompromisso.setText((String) jtAgenda.getModel().getValueAt(idx,2));
        agenda_prioridade.setSelectedItem(jtAgenda.getModel().getValueAt(idx,3));
        agenda_data.setText((String) jtAgenda.getModel().getValueAt(idx,4));
        agenda_hora.setText((String) jtAgenda.getModel().getValueAt(idx,5));
    }//GEN-LAST:event_btAlterarActionPerformed

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
            java.util.logging.Logger.getLogger(FormAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAgenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField agenda_data;
    private javax.swing.JButton agenda_editar;
    private javax.swing.JButton agenda_excluir;
    private javax.swing.JFormattedTextField agenda_hora;
    private javax.swing.JComboBox<String> agenda_nome;
    private javax.swing.JComboBox<String> agenda_prioridade;
    private javax.swing.JButton agenda_salvar;
    private javax.swing.JTextField agenda_tituloCompromisso;
    private javax.swing.JButton btAlterar;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jtAgenda;
    // End of variables declaration//GEN-END:variables
}
