/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifsp.p1.classes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author aluno
 */
public class FabricaConexao {
    public Connection getConnection() throws ClassNotFoundException {
        
        try{

        	Class.forName("com.mysql.jdbc.Driver");
        	Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/Banco", "root", "");

                 return con;
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        
        }
    }

                
       

