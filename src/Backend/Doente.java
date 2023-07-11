/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 *
 * @author UTILIZADOR
 */
public class Doente implements Serializable {
    
    //variaveis de instancia
    private String nome;
    private String codigo;
    private String estadoDoente;
    private String localidadeDoente;
    private LocalDateTime data_entrada;
    private LocalDateTime data_saida;
    private int numero_CamaDoente;
    private Enfermaria enf;
    
    //construtores
    public Doente(String nomeDoente, String codDoente, String localidadeDoente, LocalDateTime data_entrada,Enfermaria enf) {
        this.nome = nomeDoente;
        this.codigo = codDoente;
        this.estadoDoente = null;
        this.localidadeDoente = localidadeDoente;
        this.data_entrada = data_entrada;
        this.data_saida = null;
        this.numero_CamaDoente = 0;
        this.enf = enf;
    }
    
    //seletores e modificadores

    public String getNome() {
        return nome;
    }

    public void setNome(String nomeDoente) {
        this.nome = nomeDoente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codDoente) {
        this.codigo = codDoente;
    }

    public String getEstadoDoente() {
        return estadoDoente;
    }

    public void setEstadoDoente(String estadoDoente) {
        this.estadoDoente = estadoDoente;
    }

    public String getLocalidadeDoente() {
        return localidadeDoente;
    }

    public void setLocalidadeDoente(String localidadeDoente) {
        this.localidadeDoente = localidadeDoente;
    }

    public LocalDateTime getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(LocalDateTime data_entrada) {
        this.data_entrada = data_entrada;
    }

    public LocalDateTime getData_saida() {
        return data_saida;
    }

    public void setData_saida(LocalDateTime data_saida) {
        this.data_saida = data_saida;
    }

    public int getNumero_camaDoente() {
        return numero_CamaDoente;
    }

    public void setNumero_camaDoente(int numero_camaDoente) {
        this.numero_CamaDoente = numero_camaDoente;
    }

    public Enfermaria getEnf() {
        return enf;
    }
    
    //tostring

    @Override
    public String toString() {
        return "Doentes{" + "nomeDoente=" + nome + ", codDoente=" + codigo + ", estadoDoente=" + estadoDoente + ", localidadeDoente=" + localidadeDoente + ", data_entrada=" + data_entrada + ", data_saida=" + data_saida + ", numero_camaDoente=" + numero_CamaDoente + '}';
    }
    
   
    
    
    
    
}
