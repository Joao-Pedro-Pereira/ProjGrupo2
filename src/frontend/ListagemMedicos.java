/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import Backend.Enfermaria;
import Backend.Hospital;
import Backend.ListaMedicos;
import Backend.Medico;
import Backend.Sistema;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;


public class ListagemMedicos extends javax.swing.JFrame {
    private Sistema sistema;
    private Enfermaria enfermaria;
    private AbstractTableModel modeloTabela;
    private Medico m;
    private Hospital hospital;
    
    public ListagemMedicos(Sistema sistema, Enfermaria enfermaria, Hospital hospital) {
        initComponents();
        this.sistema = sistema;
        this.enfermaria = enfermaria;
        this.modeloTabela = criarModeloTabela();
        tabMedicos.setModel(modeloTabela);
        this.hospital=hospital;
        tabMedicos.setAutoCreateRowSorter(true);
    }
    
    
    private AbstractTableModel criarModeloTabela() {   
        String[] nomeColunas = {"ID", "Nome","Password", "Especialidade", "Localidade"};
        
        return new AbstractTableModel() {     
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }
           
            @Override
            public int getRowCount() {
                
                    //Retorna o número de linhas que a tabela deverá ter
                    return enfermaria.getMedicos().size();
                
            }

            @Override
            public int getColumnCount() {
                //Retorna o número de colunas que a tabela deverá ter
                return nomeColunas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0: 
                    {
                        return enfermaria.getMedicos().todos().get(rowIndex).getId();
                    }

                    case 1:
                    {
                        return enfermaria.getMedicos().todos().get(rowIndex).getUserName();
                    }
                    case 2:
                    {
                        return enfermaria.getMedicos().todos().get(rowIndex).getCodigoConta();
                    }
                    case 3:
                        return enfermaria.getMedicos().todos().get(rowIndex).getEspecialidadeMedico();
                    
                    case 4:
                        return enfermaria.getMedicos().todos().get(rowIndex).getLocalTrabalhoMedico();

                    default:
                        return "";
                }                              
            }            
        };
    }
    private void listaDoentes(){
        int rowIndex = tabMedicos.getSelectedRow();
        //Se nenhum registo selecionado, nao é possivel editar
        if (rowIndex == -1)  JOptionPane.showMessageDialog(this, "selecione um hospital!");;
        
        String codigo = (String) modeloTabela.getValueAt(rowIndex, 0);
        try {
            Medico m = enfermaria.getMedicos().getMedico(codigo);
            ListagemDoentes painel = new ListagemDoentes(sistema, m,hospital,enfermaria);   
            painel.setVisible(true);
        } catch (ListaMedicos.MedicoNaoExistenteException ex) {
            Logger.getLogger(ListagemMedicos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        fechar();
    }
    
    private void editar(){
        
        int rowIndex = tabMedicos.getSelectedRow();
        if (rowIndex == -1) return;
            
        String codigo = (String) modeloTabela.getValueAt(rowIndex, 0);
            
          try {  
            Medico m = enfermaria.getMedicos().getMedico(codigo);
            EditarMedico janela = new EditarMedico(sistema, m,this);   
            janela.setVisible(true);
        } catch (Backend.ListaMedicos.MedicoNaoExistenteException ex) {
            Logger.getLogger(ListagemHospitais.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
    private void remover(){
        
        int rowIndex = tabMedicos.getSelectedRow();
        if (rowIndex == -1) return;
            
        String codigo = (String) modeloTabela.getValueAt(rowIndex, 0);
        
       enfermaria.getMedicos().remover(codigo);
       sistema.getListaUtilizadores().remover(codigo);
        this.atualizar();
    }
    
    
    private void fechar() {
        dispose();
    }
    
    public void atualizar() {    
        //Informa o modelo que foram efetuadas alteracoes, o modelo informa a tabela e os dados são redesenhados
        modeloTabela.fireTableDataChanged();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabMedicos = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabMedicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabMedicos);

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Lista de doentes");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("Remover");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("Geral");

        jMenuItem1.setText("Fechar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        listaDoentes();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        fechar();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       editar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        remover();
    }//GEN-LAST:event_jButton1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabMedicos;
    // End of variables declaration//GEN-END:variables
}
