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
import javax.persistence.ManyToMany;

/**
 *
 * @author windeveloper
 */
@Entity
public class Sector implements Serializable {

    @Id
    private int id;
    @Column(length = 100)
    private String descripcio;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Article> articles = new ArrayList<Article>();
    
    public Sector() {

    }

    public Sector(int id, String desc) {
        this.id = id;
        descripcio = desc;
    }

    public Integer getId() {
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
