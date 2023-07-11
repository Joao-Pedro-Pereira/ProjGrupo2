/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author UTILIZADOR
 */
public class Equipamento implements Serializable {
    
    //variaveis de instancia
    private String nome;
    private String codigo;
    private String estado_uso;
    private String lugar_uso;
    private Enfermaria enf;
    
    //construtor
    public Equipamento(String nomeEquipamento, String codEquipamento, String Estado_uso,Enfermaria enf) {
        this.nome = nomeEquipamento;
        this.codigo = codEquipamento;
        this.estado_uso = Estado_uso;
        this.lugar_uso = null;
        this.enf = enf;
    }
    //seletores e modificadores

    public String getNome() {
        return nome;
    }

    public void setNome(String nomeEquipamento) {
        this.nome = nomeEquipamento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codEquipamento) {
        this.codigo = codEquipamento;
    }

    public String getEstado_uso() {
        return estado_uso;
    }

    public void setEstado_uso(String Estado_uso) {
        this.estado_uso = Estado_uso;
    }

    public String getLugar_uso() {
        return lugar_uso;
    }

    public void setLugar_uso(String lugar_uso) {
        this.lugar_uso = lugar_uso;
    }

    public Enfermaria getEnf() {
        return enf;
    }
    
    
    //tostring

    @Override
    public String toString() {
        return "Equipamentos{" + "nomeEquipamento=" + nome + ", codEquipamento=" + codigo + ", Estado_uso=" + estado_uso + ", Lugar_uso=" + lugar_uso + '}';
    }
    
    
    
    
}
