/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifsp.p1.classes;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Elienai
 */
public interface IClienteDAO {
    
    public void adicionar (Cliente usuario);
    public void alterar (Cliente usuario);
    public void excluir(String nome);
    public Cliente getByLogin(String nome) throws SQLException;
    public List<Cliente> listar();
            
    
}
