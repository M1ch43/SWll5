/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifsp.p1.classes;

import java.sql.SQLException;
import java.util.List;
 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author aluno
 */
public class ClienteDAOHB implements IClienteDAO {
    
         private static ClienteDAOHB instance;
         protected EntityManager entityManager;
         
         public static ClienteDAOHB getInstance(){
                   if (instance == null){
                            instance = new ClienteDAOHB();
                   }                    
                   return instance;
         }

         public ClienteDAOHB() {
                   entityManager = getEntityManager();
         }
  
         private EntityManager getEntityManager() {
                   EntityManagerFactory factory = Persistence.createEntityManagerFactory("cadastro");
                   if (entityManager == null) {
                            entityManager = factory.createEntityManager();
                   }
  
                   return entityManager;
         }   
         

    @Override
    public void adicionar(Cliente cli) {
       
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(cli);
            entityManager.getTransaction().commit();
        }catch(Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
                
    }

    @Override
    public void alterar(Cliente cli) {
                try{
            entityManager.getTransaction().begin();
            entityManager.merge(cli);
            entityManager.getTransaction().commit();
        }catch(Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public Cliente getByLogin(String nome) throws SQLException {
         return entityManager.find(Cliente.class, nome);
    }

    @Override
    public List<Cliente> listar() {
       return entityManager.createQuery("FROM " + Cliente.class.getName()).getResultList();
    }

    @Override
    public void excluir(String nome) {
        try {
                Cliente cli = getByLogin(nome);
                remove(cli);
        } catch (Exception ex) {
            ex.printStackTrace();
        }  
    }
    
    public void remove(Cliente cli) {
        try {
                entityManager.getTransaction().begin();
                cli = entityManager.find(Cliente.class, cli.getNome());
                entityManager.remove(cli);
                entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
