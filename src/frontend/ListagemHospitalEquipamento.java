/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import Backend.Hospital;
import Backend.Sistema;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author UTILIZADOR
 */
public class ListagemHospitalEquipamento extends javax.swing.JFrame {
    private Hospital hospital;
    private Sistema sistema;
    private AbstractTableModel modeloTabela;
    public ListagemHospitalEquipamento(Sistema sistema, Hospital hospital) {
        initComponents();
        this.hospital = hospital;
        this.sistema = sistema;
        this.modeloTabela = criarModeloTabela();
        tabEquipamentos.setModel(modeloTabela);
        tabEquipamentos.setAutoCreateRowSorter(true);
    }
    
    
     private AbstractTableModel criarModeloTabela() {   
        String[] nomeColunas = {"Codigo", "Nome","Estado", "Enfermaria"};
        
        return new AbstractTableModel() {     
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }
           
            @Override
            public int getRowCount() {
                
                    //Retorna o número de linhas que a tabela deverá ter
                    return hospital.getListaEquip().size();
                
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
                    
                        return hospital.getListaEquip().todos().get(rowIndex).getCodigo();
                    

                    case 1:
                    
                        return hospital.getListaEquip().todos().get(rowIndex).getNome();
                    
                    case 2:
                    
                        return hospital.getListaEquip().todos().get(rowIndex).getEstado_uso();
                    
                    case 3:
                        return hospital.getListaEquip().todos().get(rowIndex).getEnf().getNomeEnfermeira();

                    default:
                        return "";
                }                              
            }            
        };
    }
    private void fechar() {
        dispose();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabEquipamentos = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabEquipamentos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabEquipamentos);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        fechar();
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabEquipamentos;
    // End of variables declaration//GEN-END:variables
}
