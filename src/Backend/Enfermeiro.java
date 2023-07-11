/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

public class Enfermeiro extends Utilizador{
        //variaveis de instancia
    private String tipoEnfermeiro;
    private String localidadeEnfermeiro;

    //construtor
    public Enfermeiro(String id, String codigo, String nomeEnfermeiro, String tipoenfermeiro, String Localidade) {
        super(id, codigo, nomeEnfermeiro);
        this.tipoEnfermeiro = tipoenfermeiro;
        this.localidadeEnfermeiro = Localidade;
    }
    
    //seletores e modificadores
    public String getTipoEnfermeiro() {
        return tipoEnfermeiro;
    }

    public void setTipoEnfermeiro(String tipoEnfermeiro) {
        this.tipoEnfermeiro = tipoEnfermeiro;
    }

    public String getLocalidadeEnfermeiro() {
        return localidadeEnfermeiro;
    }

    public void setLocalidadeEnfermeiro(String LocalidadeEnfermeiro) {
        this.localidadeEnfermeiro = LocalidadeEnfermeiro;
    }
    
   //tostring

    @Override
    public String toString() {
        return "Enfermeiro{"+ super.toString() + "tipoEnfermeiro=" + tipoEnfermeiro + ", localidadeEnfermeiro=" + localidadeEnfermeiro + '}';
    }


    
            
    
    
    
    
    
    
    
}
