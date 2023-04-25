package Controlador;

import ModeloDAO.DetallesPedidoDAO;
import ModeloVO.DetallesPedidoVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author APRENDIZ
 */
@WebServlet(name = "DetallespedidoControlador", urlPatterns = {"/Detallespedido"})
public class DetallesPedidoControlador extends HttpServlet {

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

        //1. Recibir datos de las vistas
        String detpId = request.getParameter("detpId");
        String pedId_fk = request.getParameter("pedId_fk");
        String matId_fk = request.getParameter("matId_fk");
        String detpPrecioUnidad = request.getParameter("detpPrecioUnidad");
        String detpCantidad = request.getParameter("detpCantidad");
        String detpSubTotal = request.getParameter("detpSubTotal");
       
       
        
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        
        
        
        //2. ¿Quiién tiene los datos de forma segura? VO
        DetallesPedidoVO detpVO = new DetallesPedidoVO(detpId, pedId_fk, matId_fk, detpPrecioUnidad, detpCantidad,detpSubTotal);
        
        //3. ¿Quién hace las operaciones? DAO
        DetallesPedidoDAO detpDAO = new DetallesPedidoDAO(detpVO);
        
        //4. Administrar operaciones
        switch(opcion){
            case 1: //Agregar registro
                if(detpDAO.agregarRegistro()){
                request.setAttribute("mensajeExito", "¡Los detalles del pedido se registraron correctamente!");
                }
                else{
                    request.setAttribute("mensajeError", "¡Los detalles del pedido no se registraron!");
                }
                request.getRequestDispatcher("registrarDetallesPedido.jsp").forward(request, response); //para enviar a la otra vista
                break;
            case 2: //Actualziar registro
                if(detpDAO.actualizarRegistro()){
                request.setAttribute("mensajeExito", "¡Los detalles del pedido se actualizaron correctamente!");
                }
                else{
                    request.setAttribute("mensajeError", "¡Los detalles del pedido no se actualizaron!");
                }
                request.getRequestDispatcher("actualizarDetallesPedido.jsp").forward(request, response); //para enviar a la otra vista
                break;
            
            case 3:
                detpVO = detpDAO.consultarPorId(detpId);
                if (detpVO != null) {
                    request.setAttribute("detallespedidoEncontrado", detpVO);
                    request.getRequestDispatcher("actualizarDetallesPedido.jsp").forward(request, response);

                } else {
                    request.setAttribute("mensajeError", "Detalles NO Encontrados");
                    request.getRequestDispatcher("consultarDetallesPedido.jsp").forward(request, response);
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
