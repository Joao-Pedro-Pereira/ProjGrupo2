/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author UTILIZADOR
 */
public class ListaUtilizadores implements Serializable{
    
private TreeMap<String, Utilizador> listaUtilizadores;

    public class UtilizadorNaoExistenteException extends Exception {
        public UtilizadorNaoExistenteException() { }
        public UtilizadorNaoExistenteException(String message) {
            super(message);
        }        
    }
    
    public class UtilizadorDuplicadoException extends Exception {
        public UtilizadorDuplicadoException() { }
        public UtilizadorDuplicadoException(String message) {
            super(message);
        }        
    }
    
    public ListaUtilizadores() {
        listaUtilizadores = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);        
    }
    
    public void adicionar(Utilizador utilizador) throws UtilizadorDuplicadoException {
        if (utilizador == null) {
            throw new NullPointerException("O parâmetro 'utilizador' não pode ser um valor nulo");
        }        
        
        if (!listaUtilizadores.containsKey(utilizador.getId())) {
            listaUtilizadores.put(utilizador.getId(), utilizador);
        }else{
            throw new UtilizadorDuplicadoException(String.format("O utilizador '%s' já existe na coleção", utilizador.getId()));
        }
        
    } 
    
    public void remover(String key){
        listaUtilizadores.remove(key);
    }
    
    
    public boolean existe(String id) {
        return listaUtilizadores.containsKey(id);
    }
    
    public int size() {
        return listaUtilizadores.size();
    }
    
    public Utilizador getUtilizador(String id) throws UtilizadorNaoExistenteException {
        if (listaUtilizadores.containsKey(id)){
            return listaUtilizadores.get(id);
        }else{
            throw new UtilizadorNaoExistenteException("O utilizador '%s' já existe na lista");
        }
    }
    
    public ArrayList<Utilizador> todos() {
        return new ArrayList<>(listaUtilizadores.values());
    }

}
