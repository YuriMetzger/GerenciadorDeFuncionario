/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import Classes.Agenda;
import Classes.Funcionario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Yuri
 */
public class relFiltroAgenda extends javax.swing.JFrame {


    public relFiltroAgenda() {
        initComponents();
    }
    ArrayList<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
    ArrayList<Agenda> listaAgenda = new ArrayList<Agenda>();
    ArrayList<Agenda> pesquisa = new ArrayList<Agenda>();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbNome = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ctDataInicio = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter data = new javax.swing.text.MaskFormatter("##/##/####");
            ctDataInicio = new javax.swing.JFormattedTextField(data);
            ctDataInicio.setText("00/00/0000");
        }
        catch (Exception e){
        }
        ctTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ctHoraFim = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter hora = new javax.swing.text.MaskFormatter("##:##");
            ctHoraFim = new javax.swing.JFormattedTextField(hora);
            ctHoraFim.setText("00:00");
        }
        catch (Exception e){
        }
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ctHoraInicio = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter hora = new javax.swing.text.MaskFormatter("##:##");
            ctHoraInicio = new javax.swing.JFormattedTextField(hora);
            ctHoraInicio.setText("00:00");
        }
        catch (Exception e){
        }
        jLabel6 = new javax.swing.JLabel();
        ctDataFim = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter data = new javax.swing.text.MaskFormatter("##/##/####");
            ctDataFim = new javax.swing.JFormattedTextField(data);
            ctDataFim.setText("00/00/0000");
        }
        catch (Exception e){
        }
        cbPrioridade = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btSair = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        btFiltrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cbNome.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos" }));

        jLabel1.setText("Funcionário:");

        jLabel2.setText("Data Inicio:");

        ctDataInicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ctDataInicioFocusLost(evt);
            }
        });

        jLabel3.setText("Data Fim:");

        jLabel4.setText("Horia Inicio:");

        jLabel5.setText("Horia Fim:");

        ctHoraInicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ctHoraInicioFocusLost(evt);
            }
        });

        jLabel6.setText("Titulo Compromisso:");

        cbPrioridade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "Baixa", "Média", "Alta" }));

        jLabel7.setText("Prioridade:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ctTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ctDataInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                    .addComponent(ctDataFim))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ctHoraFim, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                                    .addComponent(ctHoraInicio)))
                            .addComponent(cbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ctDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(ctDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(ctHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(ctHoraFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ctTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btSair.setText("Sair");

        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btFiltrar.setText("Filtrar");
        btFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFiltrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btFiltrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btSair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSair)
                    .addComponent(btLimpar)
                    .addComponent(btFiltrar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        comboFuncionario();
    }//GEN-LAST:event_formWindowOpened

    private void btFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFiltrarActionPerformed
        String horaVazia = "00:00";
        String dataVazia = "00/00/0000";
        Integer contError = 0;
        Agenda agenda = new Agenda();
        Relatorio rel = new Relatorio();
        ArrayList<Agenda> lista = null;
        //query para buscar todos os itens do banco, cada condição ativa será adicionado após o where
        String query = "select a.idAgenda, a.data, a.hora, a.titulo, a.prioridade, a.ativo, f.nome_funcionario "
                     + "from agenda a inner join funcionario f on a.idFuncionario = f.idFuncionario "
                     + "where f.idFuncionario = a.idFuncionario and a.ativo <> 0 ";
        
        if((!ctDataInicio.getText().equalsIgnoreCase(dataVazia) && ctDataFim.getText().equals(dataVazia))
            || (!ctDataFim.getText().equals(dataVazia) && ctDataInicio.getText().equalsIgnoreCase(dataVazia))){
            JOptionPane.showMessageDialog(null,"Favor informar Data de início e Fim!");
            contError++;
        }
        if((!ctHoraInicio.getText().equals(horaVazia) && ctHoraFim.getText().equalsIgnoreCase(horaVazia))
            ||(!ctHoraFim.getText().equalsIgnoreCase(horaVazia) && ctHoraInicio.getText().equalsIgnoreCase(horaVazia)) && contError == 0){
            JOptionPane.showMessageDialog(null,"Favor informar Hora de incio e Fim!");
            contError++;
        }
        //a construção da query será feita com base nos campos informados.
        //Verificação para o Funcionário
        if(cbNome.getSelectedIndex() !=  0){
            query = query + "and f.nome_funcionario = '"+cbNome.getSelectedItem().toString()+"' ";
        }
        //Verificação da data
        if(!ctDataInicio.getText().equalsIgnoreCase(dataVazia)){
            String inicio = ctDataInicio.getText();
            String fim = ctDataFim.getText();
            query = query + "and data between '"+inicio+"' and '"+fim+"' ";
        }
        //Verificação da hora
        if(!ctHoraInicio.getText().equalsIgnoreCase(horaVazia)){
            String inicio = ctHoraInicio.getText();
            String fim = ctHoraFim.getText();
            query = query + "and hora between '"+inicio+"' and '"+fim+"' ";
        }
        //Verificação da prioridade
        if(cbPrioridade.getSelectedIndex() != 0){
            query = query + "and prioridade = '"+cbPrioridade.getSelectedItem().toString()+"' ";
        }
        //Verificação do titulo
        if(!ctTitulo.getText().equalsIgnoreCase("")){
            query = query + "and titulo ='"+ctTitulo.getText()+"' ";
        }
        try {
            lista = agenda.pesquisaAgenda(query);
        } catch (SQLException ex) {
            Logger.getLogger(relFiltroAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(lista.size() == 0){
            JOptionPane.showMessageDialog(null,"Nenhum resultado para a pesquisa!");
        }else{
            new Relatorio().setVisible(true);
            rel.setPesquisa(lista);
        }
    }//GEN-LAST:event_btFiltrarActionPerformed

    private void ctDataInicioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ctDataInicioFocusLost
        String conteudo = "";
        conteudo = ctDataInicio.getText();
        if(ctDataFim.getText().equals("00/00/0000") 
           || ctDataFim.getText().equals("  /  /    ")){
            ctDataFim.setText(conteudo);
        }
        conteudo= "";
    }//GEN-LAST:event_ctDataInicioFocusLost

    private void ctHoraInicioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ctHoraInicioFocusLost
        String conteudo = "";
        conteudo = ctHoraInicio.getText();
        if(ctHoraFim.getText().equals("00:00")){
            ctHoraFim.setText(conteudo);
        }
        conteudo= "";
    }//GEN-LAST:event_ctHoraInicioFocusLost

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btLimparActionPerformed

        public void comboFuncionario(){
        Funcionario funcionario = new Funcionario();
        Object[] items = null; 
        
        try {
            listaFuncionario = funcionario.listarFuncionario();
        } catch (SQLException ex) {
            Logger.getLogger(CadFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < listaFuncionario.size(); i++) {
            cbNome.addItem( listaFuncionario.get(i).getNome() );
        }
    }
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new relFiltroAgenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFiltrar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btSair;
    private javax.swing.JComboBox<String> cbNome;
    private javax.swing.JComboBox<String> cbPrioridade;
    private javax.swing.JTextField ctDataFim;
    private javax.swing.JTextField ctDataInicio;
    private javax.swing.JTextField ctHoraFim;
    private javax.swing.JTextField ctHoraInicio;
    private javax.swing.JTextField ctTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
