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
public class ListaEquipamentos implements Serializable{
private TreeMap<String, Equipamento> listaEquipamentos;

    void adicionar(Enfermaria a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public class EquipamentoNaoExistenteException extends Exception {
        public EquipamentoNaoExistenteException() { }
        public EquipamentoNaoExistenteException(String message) {
            super(message);
        }        
    }
    
    public class EquipamentoDuplicadoException extends Exception {
        public EquipamentoDuplicadoException() { }
        public EquipamentoDuplicadoException(String message) {
            super(message);
        }        
    }
    
    public ListaEquipamentos() {
        listaEquipamentos = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);        
    }
    
    public void adicionar(Equipamento a) throws EquipamentoDuplicadoException {
        if (a == null) {
            throw new NullPointerException("O parâmetro 'equipamento' não pode ser um valor nulo");
        }        
        
        if (!listaEquipamentos.containsKey(a.getCodigo())) {
            listaEquipamentos.put(a.getCodigo(), a);
        }else{
            throw new EquipamentoDuplicadoException(String.format("O equipamento '%s' já existe na coleção", a.getCodigo()));
        }
        
    }  
    
    public void remover(String key){
        listaEquipamentos.remove(key);
    }
    
    
    public boolean existe(String id) {
        return listaEquipamentos.containsKey(id);
    }
    
    public int size() {
        return listaEquipamentos.size();
    }
    
    public Equipamento getEquipamento(String id) throws EquipamentoNaoExistenteException {
        if (listaEquipamentos.containsKey(id)){
            return listaEquipamentos.get(id);
        }else{
            throw new EquipamentoNaoExistenteException("O equipamento '%s' já existe na lista");
        }
    }
    
    
    public ArrayList<Equipamento> todos() {
        return new ArrayList<>(listaEquipamentos.values());
    }
}
