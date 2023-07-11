/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Backend;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

public class Hospital implements Serializable {
    
   //variaveis de instancia
    private String nomeHospital;
    private String localidadeHospital;
    private String codigoHospital;
    private ListaEnfermarias listaEnf;
    private ListaEquipamentos listaEquip;
    private ListaDoentes listaD;
    
    //construtores
    public Hospital(String nomeHospital, String localidadeHospital, String codigoHospital) {
        this.nomeHospital = nomeHospital;
        this.localidadeHospital = localidadeHospital;
        this.codigoHospital = codigoHospital;
        listaEnf = new ListaEnfermarias();
        listaD = new ListaDoentes();
        listaEquip = new ListaEquipamentos();
        
    }
    
    //seletores e modificdores

    public String getNomeHospital() {
        return nomeHospital;
    }

    public void setNomeHospital(String nomeHospital) {
        this.nomeHospital = nomeHospital;
    }

    public String getLocalidadeHospital() {
        return localidadeHospital;
    }

    public void setLocalidadeHospital(String localidadeHospital) {
        this.localidadeHospital = localidadeHospital;
    }

    public String getCodigoHospital() {
        return codigoHospital;
    }

    public void setCodigoHospital(String codigoHospital) {
        this.codigoHospital = codigoHospital;
    }

    public ListaEquipamentos getListaEquip() {
        return listaEquip;
    }

    public ListaDoentes getListaD() {
        return listaD;
    }
    
    
    //metodo para adicionar
   public void inserir(Enfermaria a) throws ListaEnfermarias.EnfermariaDuplicadoException{
       listaEnf.adicionar(a);
   }
   
   public void inserirEquipamento(Equipamento a) throws ListaEquipamentos.EquipamentoDuplicadoException{
       listaEquip.adicionar(a);
   }
   
   public void inserirDoente(Doente a) throws ListaDoentes.DoenteDuplicadoException{
       listaD.adicionar(a);
   }
   
   //metodo para remover
   public void remover(Enfermaria a){
       listaEnf.remover(a);
   }
   
   //metodo para obeter a lista
       public ListaEnfermarias getEnfermaria(){
           return listaEnf;
       }
       
       public void removerEnfermaria(String key){
        listaEnf.remover(key);
    }
    
    
    //tostring;

    @Override
    public String toString() {
        return "Hospital{" + "nomeHospital=" + nomeHospital + ", localidadeHospital=" + localidadeHospital + ", codigoHospital=" + codigoHospital + ", listaEnf=" + listaEnf + '}';
    }


    

    
    
     
}
