/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import Guardar.Serializacao;
import Backend.ListaUtilizadores;
import Backend.Sistema;
import Backend.Utilizador;
import Backend.ListaEnfermeiros;
import Backend.Adm;




/**
 *
 * @author UTILIZADOR
 */
public class Piloto {     
    
    public static void main(String[] args) throws ListaUtilizadores.UtilizadorDuplicadoException, ListaEnfermeiros.EnfermeiroDuplicadoException {
        Sistema sistema;        
        String ficheiroDados = String.format("%s\\utilizadores.data", System.getProperty("user.dir"));
        System.out.println(String.format("Ficheiro de dados: %s.", ficheiroDados));
        Serializacao bd = new Serializacao(ficheiroDados);        
        
        if (!bd.getFicheiro().exists()) {
            sistema = new Sistema();
            sistema.getListaUtilizadores().adicionar(new Utilizador("dono", "D9827", "dono"));
            sistema.getListaUtilizadores().adicionar(new Adm("admin", "A8237", "admin"));
            
        }else{
            sistema = bd.carregar();            
        }           
        
        
        JanelaDeLogin login = new JanelaDeLogin(sistema);               
        login.setVisible(true);
    
        PainelPrincipal principal = new PainelPrincipal(sistema, bd);
        principal.setVisible(true);        
        
    }          
    
}
