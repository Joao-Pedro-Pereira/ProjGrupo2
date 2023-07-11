/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

/**
 *
 * @author UTILIZADOR
 */
public class Medico extends Utilizador {
    //variaveis de instancia
    private String localTrabalhoMedico;
    private String especialidadeMedico;
    private ListaDoentes listaDoente;
    
    //construtor
    public Medico(String codigo, String localTrabalhoMedico, String especialidadeMedico, String id, String nomeMedico) {
        super(id, codigo, nomeMedico);
        this.localTrabalhoMedico = localTrabalhoMedico;
        this.especialidadeMedico = especialidadeMedico;
        listaDoente = new ListaDoentes();
    }
    
    //seletores e modificadores
    public String getLocalTrabalhoMedico() {
        return localTrabalhoMedico;
    }

    public void setLocalTrabalhoMedico(String localTrabalhoMedico) {
        this.localTrabalhoMedico = localTrabalhoMedico;
    }

    public String getEspecialidadeMedico() {
        return especialidadeMedico;
    }

    public void setEspecialidadeMedico(String especialidadeMedico) {
        this.especialidadeMedico = especialidadeMedico;
    }
    
    
    //metodo para adicionar
   public void inserir(Doente a) throws ListaDoentes.DoenteDuplicadoException{
       listaDoente.adicionar(a);}
    
    public ListaDoentes getDoente(){
        return listaDoente;
    }
    
    public void removerDoente(String key){
        listaDoente.remover(key);
    }
    
    //tostring

    @Override
    public String toString() {
        return "Medico{" +super.toString()+ "localTrabalhoMedico=" + localTrabalhoMedico + ", especialidadeMedico=" + especialidadeMedico + ", listaDoente=" + listaDoente + '}';
    }



    
    
    
    
}
