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
public class ListaDoentes implements Serializable {
    
private TreeMap<String, Doente> listaDoentes;

    public class DoenteNaoExistenteException extends Exception {
        public DoenteNaoExistenteException() { }
        public DoenteNaoExistenteException(String message) {
            super(message);
        }        
    }
    
    public class DoenteDuplicadoException extends Exception {
        public DoenteDuplicadoException() { }
        public DoenteDuplicadoException(String message) {
            super(message);
        }        
    }
    
    public ListaDoentes() {
        listaDoentes = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);        
    }
    
    public void adicionar(Doente doente) throws DoenteDuplicadoException {
        if (doente == null) {
            throw new NullPointerException("O parâmetro 'doente' não pode ser um valor nulo");
        }        
        
        if (!listaDoentes.containsKey(doente.getCodigo())) {
            listaDoentes.put(doente.getCodigo(), doente );
        }else{
            throw new DoenteDuplicadoException(String.format("O doente '%s' já existe na coleção", doente.getCodigo()));
        }
        
    }        
    
    public void remover(String key){
        listaDoentes.remove(key);
    }
    
    public boolean existe(String codigo) {
        return listaDoentes.containsKey(codigo);
    }
    
    public int size() {
        return listaDoentes.size();
    }
    
    public Doente getDoente(String id) throws DoenteNaoExistenteException {
        if (listaDoentes.containsKey(id)){
            return listaDoentes.get(id);
        }else{
            throw new DoenteNaoExistenteException("O doente '%s' já existe na lista");
        }
    }
    
    public ArrayList<Doente> todos() {
        return new ArrayList<>(listaDoentes.values());
    }
}
