/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.OrdenDAO;
import ModeloVO.OrdenVO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author APRENDIZ
 */
@WebServlet(name = "OrdenControlador", urlPatterns = {"/Orden"})
public class OrdenControlador extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        //1. recibir datos de las vistas
        String ordId = request.getParameter("ordId");
        String ordEstado = request.getParameter("ordEstado");
        String ordFechaPedido = request.getParameter("ordFechaPedido");
        String ordFechaEntrega = request.getParameter("ordFechaEntrega");
        String ordTotal = request.getParameter("ordTotal");
        String ordIdRepostero_fk = request.getParameter("ordIdRepostero_fk");
        String cliId_fk = request.getParameter("cliId_fk");

        
        
        int opcion = Integer.parseInt(request.getParameter("opcion"));

        //2. quien tiene los datps de forma segura? VO
        OrdenVO ordVO = new OrdenVO(ordId, ordEstado, ordFechaPedido, ordFechaEntrega, ordTotal, ordIdRepostero_fk, cliId_fk);

        //3. quien hace las operaciones DAO
        OrdenDAO ordDAO = new OrdenDAO(ordVO);

        //4. administar opciones
        switch (opcion) {

            case 1:
                if (ordDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "¡La orden se registro correctamente!");
                } else {
                    request.setAttribute("mensajeError", "La orden NO se registro correctamente");
                }
                request.getRequestDispatcher("registrarOrden.jsp").forward(request, response);
                break;

            case 2:
                if (ordDAO.actualizarRegistro()) {

                    request.setAttribute("mensajeExito", "¡La orden se actualizo correctamente!");
                } else {
                    request.setAttribute("mensajeError", "La orden NO se actualizo correctamente");
                }
                request.getRequestDispatcher("actualizarOrden.jsp").forward(request, response);
                break;

            case 3:
                if (ordDAO.eliminarRegistro()) {

                    request.setAttribute("mensajeExito", "¡La orden se elimino correctamente!");
                } else {
                    request.setAttribute("mensajeError", "La orden NO se elimino correctamente");
                }
                request.getRequestDispatcher("consultarOrden.jsp").forward(request, response);
                break;

            case 4:
                ordVO = ordDAO.consultarOrden(ordId);
                if (ordVO != null) {
                    request.setAttribute("OrdenEncontrado", ordVO);
                    request.getRequestDispatcher("actualizarOrden.jsp").forward(request, response);

                } else {
                    request.setAttribute("mensajeError", "orden NO Encontrado");
                    request.getRequestDispatcher("consultarOrden.jsp").forward(request, response);
                }
                break;
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
