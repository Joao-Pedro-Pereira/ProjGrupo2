/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.io.Serializable;

public class Utilizador implements Serializable {
    
    //variaveis de instancia
    private String id;
    private String userName;
    private String codigoConta;
    
     public Utilizador() { } 

    public Utilizador(String id, String userName, String codigoConta) {
        this.id = id;
        this.userName = userName;
        this.codigoConta = codigoConta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCodigoConta() {
        return codigoConta;
    }

    public void setCodigoConta(String codigoConta) {
        this.codigoConta = codigoConta;
    }

    @Override
    public String toString() {
        return "Utilizador{" + "id=" + id + ", userName=" + userName + '}';
    }



 
    
    
    
    
}
