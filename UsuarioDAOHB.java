/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifsp.p1.classes;

//import com.ifsp.p1.classes.IUsuarioDAO;
import java.sql.SQLException;
import java.util.List;
 
  
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Elienai
 */
public class UsuarioDAOHB{
    
         private static UsuarioDAOHB instance;
         protected EntityManager entityManager;
         
         public static UsuarioDAOHB getInstance(){
                   if (instance == null){
                            instance = new UsuarioDAOHB();
                   }                    
                   return instance;
         }

         public UsuarioDAOHB() {
                   entityManager = getEntityManager();
         }
  
         private EntityManager getEntityManager() {
                   EntityManagerFactory factory = Persistence.createEntityManagerFactory("cadastro");
                   if (entityManager == null) {
                            entityManager = factory.createEntityManager();
                   }
  
                   return entityManager;
         }   
         


    public void adicionar(Usuario usuario) {
       
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
        }catch(Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
                
    }


    public void alterar(Usuario usuario) {
                try{
            entityManager.getTransaction().begin();
            entityManager.merge(usuario);
            entityManager.getTransaction().commit();
        }catch(Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }


    public Usuario getByLogin(String login) throws SQLException {
         return entityManager.find(Usuario.class, login);
    }


    public List<Usuario> listar() {
       return entityManager.createQuery("FROM " + Usuario.class.getName()).getResultList();
    }


    public void excluir(String login) {
        try {
                Usuario u = getByLogin(login);
                remove(u);
        } catch (Exception ex) {
            ex.printStackTrace();
        }  
    }
    
        public void remove(Usuario u) {
        try {
                entityManager.getTransaction().begin();
                u = entityManager.find(Usuario.class, u.getLogin());
                entityManager.remove(u);
                entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
}
