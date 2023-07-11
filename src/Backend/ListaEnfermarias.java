/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

public class ListaEnfermarias implements Serializable{
    
  private TreeMap<String, Enfermaria> listaEnfermarias;

    public class EnfermariaNaoExistenteException extends Exception {
        public EnfermariaNaoExistenteException() { }
        public EnfermariaNaoExistenteException(String message) {
            super(message);
        }        
    }
    
    public class EnfermariaDuplicadoException extends Exception {
        public EnfermariaDuplicadoException() { }
        public EnfermariaDuplicadoException(String message) {
            super(message);
        }        
    }
    
    public ListaEnfermarias() {
        listaEnfermarias = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);        
    }
    
    public void adicionar(Enfermaria a) throws EnfermariaDuplicadoException {
        if (a == null) {
            throw new NullPointerException("O parâmetro 'Enfermaria' não pode ser um valor nulo");
        }        
        
        if (!listaEnfermarias.containsKey(a.getCodigoEnfermaria())) {
            listaEnfermarias.put(a.getCodigoEnfermaria(), a);
        }else{
            throw new EnfermariaDuplicadoException(String.format("A Enfermaria '%s' já existe na coleção", a.getCodigoEnfermaria()));
        }
        
    }  
    
    public void remover(String key){
        listaEnfermarias.remove(key);
    }
    
    
    public void remover(Enfermaria a){
        listaEnfermarias.remove(a);
    }
    public boolean existe(String id) {
        return listaEnfermarias.containsKey(id);
    }
    
    public int size() {
        return listaEnfermarias.size();
    }
    
    public Enfermaria getEnfermaria(String id) throws EnfermariaNaoExistenteException {
        if (listaEnfermarias.containsKey(id)){
            return listaEnfermarias.get(id);
        }else{
            throw new EnfermariaNaoExistenteException("A Enfermaria '%s' já existe na lista");
        }
    }
    
    
    public ArrayList<Enfermaria> todos() {
        return new ArrayList<>(listaEnfermarias.values());
    }
}
