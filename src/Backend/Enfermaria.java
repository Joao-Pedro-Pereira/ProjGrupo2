/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author UTILIZADOR
 */
public class Enfermaria implements Serializable {
    
    //variaveis de instancia
    private String codigoEnfermaria;
    private String nomeEnfermaria;
    private int ncamas;
    private ListaEquipamentos listaEquip;
    private ListaMedicos listaM;
    private ListaEnfermeiros listaE;

    public Enfermaria(String codigoEnfermaria, String nomeEnfermeiro, int Ncamas) {
        this.codigoEnfermaria = codigoEnfermaria;
        this.nomeEnfermaria = nomeEnfermeiro;
        this.ncamas = Ncamas;
        listaEquip = new ListaEquipamentos();
        listaM = new ListaMedicos();
        listaE = new ListaEnfermeiros();
    }

    public String getCodigoEnfermaria() {
        return codigoEnfermaria;
    }

    public void setCodigoEnfermaria(String codigoEnfermaria) {
        this.codigoEnfermaria = codigoEnfermaria;
    }

    public String getNomeEnfermeira() {
        return nomeEnfermaria;
    }

    public void setNomeEnfermeiro(String nomeEnfermeiro) {
        this.nomeEnfermaria = nomeEnfermeiro;
    }

    public int getNcamas() {
        return ncamas;
    }

    public void setNcamas(int Ncamas) {
        this.ncamas = Ncamas;
    }
    
    
        //metodo para adicionar EQUIPAMENTO
   public void inserirEquipamento(Equipamento a) throws ListaEquipamentos.EquipamentoDuplicadoException{
       listaEquip.adicionar(a);}
    
    //metodo para obeter a lista
         public ListaEquipamentos getEquipamento(){
           return listaEquip;
       }
         public ListaMedicos getMedicos(){
           return listaM;
       }
         public ListaEnfermeiros getEnfermeiros(){
           return listaE;
       }
         
    public void inserirMedico(Medico a) throws ListaMedicos.MedicoDuplicadoException{
       listaM.adicionar(a);}
    
    public void inserirEnfermeiro(Enfermeiro a) throws ListaEnfermeiros.EnfermeiroDuplicadoException {
       listaE.adicionar(a);}
    
    public void removerMedico(String key){
        listaM.remover(key);
    }
    public void removerEnfermeiro(String key){
        listaE.remover(key);
    }
    public void removerEquipamento(String key){
        listaEquip.remover(key);
    }
         

    @Override
    public String toString() {
        return "Enfermaria{" + super.toString()+ "codigoEnfermaria=" + codigoEnfermaria + ", nomeEnfermeira=" + nomeEnfermaria + ", ncamas=" + ncamas + ", listaEquip=" + listaEquip + '}';
    }
    
    



    
    
    
    
}
