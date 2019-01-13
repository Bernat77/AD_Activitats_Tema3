/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseexercises;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author windeveloper
 */
public class Main {

    private static EntityManager em;
    private static EntityManagerFactory emf;

    public static void main(String[] args) throws SQLException {

        emf = Persistence.createEntityManagerFactory("JPA_excercisePU");
        em = emf.createEntityManager();

        GestorJpaClient gestor = new GestorJpaClient(em);

    }

}
