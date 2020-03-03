/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upb.tabd.controladores;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import upb.tabd.ejb.ClienteFacade;
//import upb.tabd.ejb.ClienteFacadeLocal;

import upb.tabd.entidades.Cliente;

/**
 *
 * @author B09S105est
 */
@WebServlet(name = "RegistroClienteServlet", urlPatterns = {"/RegistroClienteServlet"})
public class RegistroClienteServlet extends HttpServlet {

    @EJB
    private ClienteFacade clienteFacade;

    private static final Logger LOG = Logger.getLogger(RegistroClienteServlet.class.getName());
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
         String identCliente = request.getParameter("IdentCliente");
        String nombreCliente = request.getParameter("NombreCliente");
        String telefono = request.getParameter("Telefono");
        String email = request.getParameter("Email");
        
        LOG.log(Level.INFO, "Identificacion:{0}", identCliente);
        LOG.log(Level.INFO, "Nombre:{0}", nombreCliente);
        LOG.log(Level.INFO, "Telefono:{0}", telefono);
        LOG.log(Level.INFO, "Email:{0}", email);
        
        Cliente objCliente = new Cliente();
        objCliente.setIdentCliente(Double.valueOf(identCliente));
        objCliente.setNombreCliente(nombreCliente);
        objCliente.setTelefono(Long.valueOf(telefono));
        objCliente.setEmail(email);
        
        clienteFacade.create(objCliente);
        LOG.log(Level.INFO, "Cliente Creado:{0}", objCliente);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistroClienteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistroClienteServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
