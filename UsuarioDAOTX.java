/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifsp.p1.classes;

//import com.ifsp.p1.classes.IUsuarioDAO;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Elienai
 */
public class UsuarioDAOTX {


    public void adicionar(Usuario usuario) {
        String linha="";
        linha= usuario.getLogin() + "-" + usuario.getNome() + "-" +  usuario.getSenha();
        
		try {
			
	
			//FileWriter - Utilizada na escrita de caracteres em um arquivo.
			FileWriter o =new FileWriter("d:\\arquivos\\gravar.txt");
			
	
			//Classe que escreve no arquivo
                        PrintWriter out =new PrintWriter(o);
                        out.println(linha);
			out.flush();		 
			o.close();	
		
		
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
                
    }


    public void alterar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public void excluir(String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public Usuario getByLogin(String login) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public List<Usuario> listar() {
        
        List<Usuario> lista=new ArrayList<Usuario>();
        
        Usuario u=new Usuario();
        u.setId(1);
        u.setNome("Elienai");
        u.setLogin("eneves");
        u.setSenha("123");
        
        lista.add(u);
        
        u=new Usuario();
        u.setId(1);
        u.setNome("Jose");
        u.setLogin("Jose");
        u.setSenha("123");    
        
        
        
        lista.add(u);
        return lista;
        
    }
    
}
