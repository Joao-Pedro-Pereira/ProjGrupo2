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
public class ListaHospitais implements Serializable {
    
private TreeMap<String, Hospital> listaHospitais;

    public class HospitalNaoExistenteException extends Exception {
        public HospitalNaoExistenteException() { }
        public HospitalNaoExistenteException(String message) {
            super(message);
        }        
    }
    
    public class HospitalDuplicadoException extends Exception {
        public HospitalDuplicadoException() { }
        public HospitalDuplicadoException(String message) {
            super(message);
        }        
    }
    
    public ListaHospitais() {
        listaHospitais = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);        
    }
    
    public void adicionar(Hospital hospital) throws HospitalDuplicadoException{
        if (hospital == null) {
            throw new NullPointerException("O parâmetro 'hospital' não pode ser um valor nulo");
        }        
        
        if (!listaHospitais.containsKey(hospital.getCodigoHospital())) {
            listaHospitais.put(hospital.getCodigoHospital(), hospital);
        }else{
            throw new HospitalDuplicadoException(String.format("O Hospital'%s' já existe na coleção", hospital.getCodigoHospital()));
        }
        
    }        
    
    public void remover(String key){
        listaHospitais.remove(key);
    }
    
    public void remover(Hospital hospital){
        listaHospitais.remove(hospital.getCodigoHospital());
    }
    
    public boolean existe(String codigo) {
        return listaHospitais.containsKey(codigo);
    }
    
    public int size() {
        return listaHospitais.size();
    }
    
    public Hospital getHospital(String codigo) throws HospitalNaoExistenteException {
        if (listaHospitais.containsKey(codigo)){
            return listaHospitais.get(codigo);
        }else{
            throw new HospitalNaoExistenteException("O medico '%s' já existe na lista");
        }
    }
    
    public ArrayList<Hospital> todos() {
        return new ArrayList<>(listaHospitais.values());
    }


    
}
