/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseexercises;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

/**
 *
 * @author windeveloper
 */

@Entity
public class Zona implements Serializable{
   
    @Id
    @Column(length = 30)
    private int id;
    @Column(length = 100)
    private String descripcio;
    
    @OneToOne
    private Comercial comercial;
    @OneToMany(mappedBy = "zona",fetch = FetchType.LAZY)
    @OrderBy(value="nom")
    private List<Client> clients = new ArrayList<Client>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
    
    
    
}
