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
public class ListaEnfermeiros implements Serializable{
    
    private TreeMap<String, Enfermeiro> listaEnfermeiro;

    public class EnfermeiroNaoExistenteException extends Exception {
        public EnfermeiroNaoExistenteException() { }
        public EnfermeiroNaoExistenteException(String message) {
            super(message);
        }        
    }
    
    public class EnfermeiroDuplicadoException extends Exception {
        public EnfermeiroDuplicadoException() { }
        public EnfermeiroDuplicadoException(String message) {
            super(message);
        }        
    }
    
    public void remover(String key){
        listaEnfermeiro.remove(key);
    }
    
    public ListaEnfermeiros() {
        listaEnfermeiro = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);        
    }
    
    public void adicionar(Enfermeiro a) throws EnfermeiroDuplicadoException {
        if (a == null) {
            throw new NullPointerException("O parâmetro 'Enfermeiro' não pode ser um valor nulo");
        }        
        
        if (!listaEnfermeiro.containsKey(a.getId())) {
            listaEnfermeiro.put(a.getId(), a);
        }else{
            throw new EnfermeiroDuplicadoException(String.format("A Enfermaria '%s' já existe na coleção", a.getId()));
        }
        
    }        
    
    public boolean existe(String id) {
        return listaEnfermeiro.containsKey(id);
    }
    
    public int size() {
        return listaEnfermeiro.size();
    }
    
    public Enfermeiro getEnfermeiro(String id) throws EnfermeiroNaoExistenteException {
        if (listaEnfermeiro.containsKey(id)){
            return listaEnfermeiro.get(id);
        }else{
            throw new EnfermeiroNaoExistenteException("O Enfermeiro '%s' já existe na lista");
        }
    }
    
    
    public ArrayList<Enfermeiro> todos() {
        return new ArrayList<>(listaEnfermeiro.values());
    }
    
}
