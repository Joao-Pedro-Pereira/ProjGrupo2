/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.io.Serializable;


/**
 *
 * @author UTILIZADOR
 */
public class Sistema implements Serializable{
    private final ListaUtilizadores utilizadores;
    private Utilizador utilizadorLigado;
    private final ListaHospitais Hospitais;

    

    public Sistema() {
        utilizadores = new ListaUtilizadores();   
        Hospitais = new ListaHospitais();
    }                       

    public ListaUtilizadores getListaUtilizadores() {
        return utilizadores;
    }
    public ListaHospitais getListaHospitais() {
        return Hospitais;
    }
    
    public boolean autenticarUtilizador(String ID, String password){
        if (utilizadores.existe(ID)) {
            try{
                Utilizador u = utilizadores.getUtilizador(ID);                
                if (u.getCodigoConta().equals(password)){
                    utilizadorLigado = u;
                    return true;
                } 
            }catch (Exception e) {}  
        }
 return false;
    }
    
    public Utilizador getUtilizadorLigado() {
        return utilizadorLigado;
    }
    
    public void inicializar() throws ListaUtilizadores.UtilizadorDuplicadoException, ListaMedicos.MedicoDuplicadoException {
        utilizadores.adicionar(new Adm("admin", "admin", "Aministrador"));
        utilizadores.adicionar(new Utilizador("user1", "1234", "Utilizador 1"));
        utilizadores.adicionar(new Utilizador("user2", "1234", "Utilizador 2"));
        
    }
    
    public void terminar() {
        System.exit(0);
    }
    
}