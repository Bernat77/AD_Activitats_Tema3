/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseexercises;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author windeveloper
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Client.Nom",query = "SELECT c FROM Client c "
            + "WHERE c.nom LIKE :nom"),
    @NamedQuery(name="Client.Nif",query="SELECT c FROM Client c "
            + "WHERE c.nif = :nif"),
    @NamedQuery(name="Client.Sector",query="SELECT c FROM Client c "
            + "WHERE c.sector.id = :sector")
})
public class Client implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true,length=15)
    private int nif;
    @Column(name = "denominacio",length = 120)
    private String nom;
    @ManyToOne
    private Sector sector;
    @ManyToOne
    private Zona zona;
    
    public Client(int nif,String nom){
        this.nif = nif;
        this.nom = nom;
    }
    
    public Client(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

}
