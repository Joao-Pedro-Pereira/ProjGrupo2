/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import Backend.Doente;
import Backend.Enfermaria;
import Backend.Hospital;
import Backend.ListaDoentes;
import Backend.Medico;
import Backend.Sistema;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author UTILIZADOR
 */
public class ListagemDoentes extends javax.swing.JFrame {
    private Sistema sistema;
    private Medico medico;
    private AbstractTableModel modeloTabela;
    private Hospital hospital;
    private Enfermaria enf;
  
    public ListagemDoentes(Sistema sistema, Medico medico,Hospital hospital,Enfermaria enf) {
        initComponents();
        this.sistema = sistema;
        this.medico = medico;
        this.hospital=hospital;
        this.enf = enf;
        this.modeloTabela = criarModeloTabela();
        tabDoentes.setModel(modeloTabela);
        tabDoentes.setAutoCreateRowSorter(true);
    }
   
    private AbstractTableModel criarModeloTabela() {   
        String[] nomeColunas = {"Codigo", "Nome","Estado", "localidade", "data de entrada","data de saida","numero da cama"};
        
        return new AbstractTableModel() {     
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }
           
            @Override
            public int getRowCount() {
                
                    //Retorna o número de linhas que a tabela deverá ter
                    return medico.getDoente().size();
                
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
                    
                        return medico.getDoente().todos().get(rowIndex).getCodigo();
                    

                    case 1:
                    
                        return medico.getDoente().todos().get(rowIndex).getNome();
                    
                    case 2:
                    
                        return medico.getDoente().todos().get(rowIndex).getEstadoDoente();
                    
                    case 3:
                        return medico.getDoente().todos().get(rowIndex).getLocalidadeDoente();
                    
                    case 4:
                        return medico.getDoente().todos().get(rowIndex).getData_entrada();
                    case 5:
                        return medico.getDoente().todos().get(rowIndex).getData_saida();
                    case 6:
                        return medico.getDoente().todos().get(rowIndex).getNumero_camaDoente();

                    default:
                        return "";
                }                              
            }            
        };
    }
    private void fechar() {
        dispose();
    }
    private void adicionarD(){
            AdicionarDoente add = new AdicionarDoente(sistema, medico,this,hospital,enf);   
            add.setVisible(true);
       
   }
    private void remover(){
        
        int rowIndex = tabDoentes.getSelectedRow();
        if (rowIndex == -1) return;
            
        String codigo = (String) modeloTabela.getValueAt(rowIndex, 0);
        
        medico.getDoente().remover(codigo);
        this.atualizar();
    }
    
    public void atualizar() {    
        
        modeloTabela.fireTableDataChanged();
    }
    
    private void editar(){
        
        int rowIndex = tabDoentes.getSelectedRow();
        if (rowIndex == -1) return;
            
        String codigo = (String) modeloTabela.getValueAt(rowIndex, 0);
            
           
            
        try {
            Doente d = medico.getDoente().getDoente(codigo);
            EditarDoente janela = new EditarDoente(sistema, d,this,enf);   
            janela.setVisible(true);
        } catch (ListaDoentes.DoenteNaoExistenteException ex) {
            Logger.getLogger(ListagemDoentes.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabDoentes = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabDoentes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabDoentes);

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Adicionar");
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

        jMenu3.setText("Geral");
        jMenu3.setToolTipText("");

        jMenuItem1.setText("Fechar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(16, 16, 16)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        adicionarD();
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
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabDoentes;
    // End of variables declaration//GEN-END:variables
}
