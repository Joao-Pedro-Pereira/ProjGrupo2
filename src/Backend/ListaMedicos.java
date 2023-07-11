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
public class ListaMedicos implements Serializable {
    
private TreeMap<String, Medico> listaMedicos;

    public class MedicoNaoExistenteException extends Exception {
        public MedicoNaoExistenteException() { }
        public MedicoNaoExistenteException(String message) {
            super(message);
        }        
    }
    
    public class MedicoDuplicadoException extends Exception {
        public MedicoDuplicadoException() { }
        public MedicoDuplicadoException(String message) {
            super(message);
        }        
    }
    
    public void remover(String key){
        listaMedicos.remove(key);
    }
    
    public ListaMedicos() {
        listaMedicos = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);        
    }
    
    public void adicionar(Medico medico) throws MedicoDuplicadoException {
        if (medico == null) {
            throw new NullPointerException("O parâmetro 'medico' não pode ser um valor nulo");
        }        
        
        if (!listaMedicos.containsKey(medico.getId())) {
            listaMedicos.put(medico.getId(), medico);
        }else{
            throw new MedicoDuplicadoException(String.format("O medico '%s' já existe na coleção", medico.getId()));
        }
        
    }        
    
    public boolean existe(String codigo) {
        return listaMedicos.containsKey(codigo);
    }
    
    public int size() {
        return listaMedicos.size();
    }
    
    public Medico getMedico(String id) throws MedicoNaoExistenteException {
        if (listaMedicos.containsKey(id)){
            return listaMedicos.get(id);
        }else{
            throw new MedicoNaoExistenteException("O medico '%s' já existe na lista");
        }
    }
    
    public ArrayList<Medico> todos() {
        return new ArrayList<>(listaMedicos.values());
    }


    
}
