/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifsp.p1.classes;

import com.ifsp.p1.classes.IClienteDAO;


/**
 *
 * @author Elienai
 */
public class DAOFactory {
    
//       public static IClienteDAO createClienteDAO(){
      public static IClienteDAO createUsuarioDAO(){
        
            return new ClienteDAOHB();        
    }
}
