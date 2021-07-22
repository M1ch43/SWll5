/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifsp.p1.servlet;

//import com.ifsp.login.Login;
import com.ifsp.p1.classes.Usuario;
import com.ifsp.p1.classes.UsuarioDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Elienai
 */
public class Autenticacao extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                        
          
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
         try{
             
        UsuarioDAO da =new UsuarioDAO();
        Usuario u=new Usuario();
        HttpSession sessao;
        u=da.getByLogin(login);
        
        
        if (u!=null)
        if (u.getLogin().equals(login) && u.getSenha().equals(senha)){
            sessao=request.getSession();
            sessao.setAttribute("sessao", login);
            request.getRequestDispatcher("criar_cliente.jsp").forward(request, response);            
        
        }else{
            
            request.setAttribute("erro", "Erro de autenticacao!"  );
            request.getRequestDispatcher("login.jsp").forward(request, response);        
        }
        else{
            request.setAttribute("erro", "Usuario nao cadatrado!"  );
            request.getRequestDispatcher("login.jsp").forward(request, response);            
        }
        }catch (SQLException e){
           throw new RuntimeException(e);
        }catch (ClassNotFoundException ex){
            throw new RuntimeException(ex);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
