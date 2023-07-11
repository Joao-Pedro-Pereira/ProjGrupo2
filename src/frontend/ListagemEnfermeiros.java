/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package frontend;

import Backend.Enfermaria;
import Backend.Enfermeiro;
import Backend.Sistema;
import javax.swing.table.AbstractTableModel;
import Backend.ListaEnfermarias;
import Backend.ListaEnfermeiros;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raquel
 */
public class ListagemEnfermeiros extends javax.swing.JFrame {
    private Sistema sistema;
    private AbstractTableModel modeloTabela;
    private Enfermaria enfermaria;
    private ListaEnfermeiros list;
    private Enfermeiro e;
    
    public ListagemEnfermeiros(Sistema sistema, Enfermaria enfermaria) {
        initComponents();
        this.sistema = sistema;
        this.enfermaria = enfermaria;
        this.modeloTabela = criarModeloTabela();
        tabEnfermeiros.setModel(modeloTabela);
        tabEnfermeiros.setAutoCreateRowSorter(true);
       
    }
    
    private AbstractTableModel criarModeloTabela() {   
        String[] nomeColunas = {"ID", "Password", "Nome", "Tipo de Enfermeiro", "Localidade"};
        
        return new AbstractTableModel() {     
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }
           
            @Override
            public int getRowCount() {
                
                    //Retorna o número de linhas que a tabela deverá ter
                    return enfermaria.getEnfermeiros().size();
                
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
                        return enfermaria.getEnfermeiros().todos().get(rowIndex).getId();
                    }

                    case 1:
                    {
                        return enfermaria.getEnfermeiros().todos().get(rowIndex).getCodigoConta();
                    }
                    case 2: 
                    {
                        return enfermaria.getEnfermeiros().todos().get(rowIndex).getUserName();
                    }

                    case 3:
                    {
                        return enfermaria.getEnfermeiros().todos().get(rowIndex).getTipoEnfermeiro(); 
                    }
                    case 4:
                    {
                        return enfermaria.getEnfermeiros().todos().get(rowIndex).getLocalidadeEnfermeiro();
                    }

                    default:
                        return "";
                }                              
            }            
        };
    }

    
    private void editar(){
        
        int rowIndex = tabEnfermeiros.getSelectedRow();
        if (rowIndex == -1) return;
            
        String codigo = (String) modeloTabela.getValueAt(rowIndex, 0);
            
          try {  
            Enfermeiro e = enfermaria.getEnfermeiros().getEnfermeiro(codigo);
            EditarEnfermeiro janela = new EditarEnfermeiro(sistema, e,this);   
            janela.setVisible(true);
        } catch (Backend.ListaEnfermeiros.EnfermeiroNaoExistenteException ex) {
            Logger.getLogger(ListagemHospitais.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
    private void remover(){
        
        int rowIndex = tabEnfermeiros.getSelectedRow();
        if (rowIndex == -1) return;
            
        String codigo = (String) modeloTabela.getValueAt(rowIndex, 0);
        
        enfermaria.getEnfermeiros().remover(codigo);
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
        tabEnfermeiros = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabEnfermeiros.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabEnfermeiros);

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Remover");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("Geral");

        jMenuItem1.setText("Fechar/Voltar");
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabEnfermeiros;
    // End of variables declaration//GEN-END:variables
}
