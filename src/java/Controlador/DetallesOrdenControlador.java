/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.DetallesOrdenDAO;
import ModeloVO.DetallesOrdenVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rodri
 */
@WebServlet(name = "DetallesOrdenControlador", urlPatterns = {"/DetallesOrden"})
public class DetallesOrdenControlador extends HttpServlet {

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
        String detoId = request.getParameter("detoId");
        String ordId_fk = request.getParameter("ordId_fk");
        String prodId_fk = request.getParameter("prodId_fk");
        String detoCantidad = request.getParameter("detoCantidad");
        String detoPrecio = request.getParameter("detoPrecio");
        String detoDetalles = request.getParameter("detoDetalles");
        String detoSubTotal = request.getParameter("detoSubTotal");
        String detoPrecioDomicilio = request.getParameter("detoPrecioDomicilio");
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        
        //2. quien tiene los datps de forma segura? VO
        DetallesOrdenVO detOrdVO = new DetallesOrdenVO(detoId, ordId_fk, prodId_fk, detoCantidad, detoPrecio, detoDetalles, detoSubTotal, detoPrecioDomicilio);

        //3. quien hace las operaciones DAO
        DetallesOrdenDAO detOrdDAO = new DetallesOrdenDAO(detOrdVO);
        
        //4. administar opciones
        switch (opcion) {

            case 1:
                if (detOrdDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "¡El detalle de la orden se registro correctamente!");
                } else {
                    request.setAttribute("mensajeError", "El detalle de la orden NO se registro correctamente");
                }
                request.getRequestDispatcher("registrarDetallesOrden.jsp").forward(request, response);
                break;

            case 2:
                if (detOrdDAO.actualizarRegistro()) {

                    request.setAttribute("mensajeExito", "¡El detalle de la orden se actualizo correctamente!");
                } else {
                    request.setAttribute("mensajeError", "El detalle de la orden NO se actualizo correctamente");
                }
                request.getRequestDispatcher("actualizarDetallesOrden.jsp").forward(request, response);
                break;

            case 3:
                detOrdVO = detOrdDAO.consultarOrden(detoId);
                if (detOrdVO != null) {
                    request.setAttribute("OrdenEncontrado", detOrdVO);
                    request.getRequestDispatcher("actualizarDetallesOrden.jsp").forward(request, response);

                } else {
                    request.setAttribute("mensajeError", "orden NO Encontrado");
                    request.getRequestDispatcher("consultarDetallesOrden.jsp").forward(request, response);
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
