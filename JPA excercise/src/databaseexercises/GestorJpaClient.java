/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseexercises;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author windeveloper
 */
public class GestorJpaClient implements Serializable {

    private EntityManager manager;

    public GestorJpaClient(EntityManager manager) {

        this.manager = manager;

    }

    public void insert(Client client) {

        try {
            manager.getTransaction().begin();
            manager.persist(client);
            manager.getTransaction().commit();
        } catch (PersistenceException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void update(Client client, int id) {
        try {
            manager.getTransaction().begin();
            Client client2 = manager.getReference(Client.class, id);
            client2.setNif(client.getNif());
            client2.setNom(client.getNom());
            manager.getTransaction().commit();
        } catch (EntityNotFoundException ex) {
            System.out.println("El client amb la ID " + id + " no existeix.");
        }
    }

    public void update(Client client) {

        if (client.getId() > 1) {
            try {
                manager.getTransaction().begin();
                Client client2 = manager.getReference(Client.class, client.getId());
                client2.setNif(client.getNif());
                client2.setNom(client.getNom());
                manager.getTransaction().commit();
            } catch (EntityNotFoundException ex) {
                System.out.println("El client amb la ID " + client.getId() + " no existeix.");
            }
        } else {
            System.out.println("L'Id de l'objecte no es correcta");
        }
    }

    public void delete(int id) {
        try {
            manager.getTransaction().begin();
            manager.remove(manager.getReference(Client.class, id));
            manager.getTransaction().commit();
        } catch (EntityNotFoundException ex) {
            System.out.println("El client amb la ID " + id + " no existeix.");
        }
    }

    public List<Client> obtenirPerNom(String nom) {
        Query query = manager.createNamedQuery("Client.Nom", Client.class);
        query.setParameter("nom", "%" + nom + "%");
        return query.getResultList();
    }

    public Client obtenirPerNif(int nif) {
        Query query = manager.createNamedQuery("Client.Nif", Client.class);
        query.setParameter("nif", nif);
        return (Client) query.getSingleResult();
    }

    public List<Client> obtenirPerSector(Sector sector) {
        Query query = manager.createNamedQuery("Client.Sector", Client.class);
        query.setParameter("sector", sector.getId());
        return query.getResultList();
    }
}
