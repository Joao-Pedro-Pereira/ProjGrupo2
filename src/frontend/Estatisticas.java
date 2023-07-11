/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import Backend.Doente;
import Backend.Enfermaria;
import Backend.Equipamento;
import Backend.Hospital;
import Backend.ListaDoentes;
import Backend.ListaEnfermarias;
import Backend.ListaEquipamentos;
import Backend.Sistema;
import java.util.ArrayList;

/**
 *
 * @author UTILIZADOR
 */
public class Estatisticas extends javax.swing.JDialog {

    private Sistema sistema;
    private Hospital hospital;
    private ListaDoentes listad;
    private ListaEquipamentos listaE;
    private ListaEnfermarias listaEnfer;
    private ArrayList<Doente> doente;
    private ArrayList<Equipamento> equipamento;
    private ArrayList<Enfermaria> enfermaria;
    private float totalDGraves;
    private float percentagemD;
    private float totalOcupadosE;
    private float percentagemE;


    public Estatisticas(Sistema sistema,Hospital hospital) {
        initComponents();
        this.hospital = hospital;
        this.sistema = sistema;
        this.listad = hospital.getListaD();
        this.listaE = hospital.getListaEquip();
        this.listaEnfer = hospital.getEnfermaria();
        doente = listad.todos();
        equipamento = listaE.todos();
        enfermaria = listaEnfer.todos();
        this.setModal(true);           
        this.setResizable(false);                        
        this.setLocationRelativeTo(null);
        pgrave.setEditable(false);
        nGrave.setEditable(false);
        pOcupados.setEditable(false);
        nOcupados.setEditable(false);
        critico.setEditable(false);
        
    }

    
    private void doente(){
        float total = doente.size();
        float grave = 0;
        
        for(Doente d: doente){
            if((d.getEstadoDoente().compareTo("grave")) == 0){
                grave = grave + 1;
            }
        }
        percentagemD= grave/total * 100;
        totalDGraves = grave;
        nGrave.setText(String.valueOf(totalDGraves));
        pgrave.setText(String.valueOf(percentagemD)+"%");
    }
    
    
    private void equipamento(){
        float total = equipamento.size();
        float ocupados = 0;
        
        
        for (Equipamento e: equipamento){
            if((e.getEstado_uso().compareTo("ocupado")) == 0){
                ocupados = ocupados + 1;
            }
        }
       totalOcupadosE = ocupados;
       percentagemE = ocupados/total *100;
       nOcupados.setText(String.valueOf(totalOcupadosE));
       pOcupados.setText(String.valueOf(percentagemE)+"%");
        
  
    }
    
    private void enfermaria(){
        
        String nome = null;
        ArrayList<Equipamento> equip;
        Enfermaria enfer = null;
        float pc = 0;
        float pc2 = 0;
        float ocupados = 0;
        
        for(Enfermaria e: enfermaria){
        
        ListaEquipamentos listaEquip = e.getEquipamento();
        equip = listaEquip.todos();
        float total = equip.size();
        pc = ocupados/total;
        
        if(pc>pc2){
            pc2 = pc;
            nome =  e.getNomeEnfermeira();
        }
        
        
         for (Equipamento obj: equip){
            if((obj.getEstado_uso().compareTo("ocupado")) == 0){
                ocupados = ocupados + 1;
            }
            
        }
        }
        critico.setText(nome);
    }
    
    private void fechar(){
        dispose();
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nGrave = new javax.swing.JTextField();
        pgrave = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pOcupados = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nOcupados = new javax.swing.JTextField();
        Carregar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        critico = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(" recursos do hospital "));

        jLabel2.setText("Percentagem de doentes em estado grave:");

        jLabel1.setText("Doentes em estado grave:");

        jLabel3.setText("Percentagem de equipamentos Ocupados:");

        jLabel4.setText("Equipamentos ocupados:");

        Carregar.setText("Carregar");
        Carregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarregarActionPerformed(evt);
            }
        });

        jLabel5.setText("Enfermaria em estado critico:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Carregar, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(nGrave, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pgrave, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pOcupados, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nOcupados, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(critico))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pgrave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nGrave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pOcupados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nOcupados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(critico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(Carregar)
                .addContainerGap())
        );

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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarregarActionPerformed
        equipamento();
        doente();
        enfermaria();
    }//GEN-LAST:event_CarregarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        fechar();
    }//GEN-LAST:event_jMenuItem1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Carregar;
    private javax.swing.JTextField critico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nGrave;
    private javax.swing.JTextField nOcupados;
    private javax.swing.JTextField pOcupados;
    private javax.swing.JTextField pgrave;
    // End of variables declaration//GEN-END:variables
}
