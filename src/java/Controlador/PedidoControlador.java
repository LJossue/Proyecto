package Controlador;

import ModeloDAO.PedidoDAO;
import ModeloVO.PedidoVO;
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
@WebServlet(name = "PedidoControlador", urlPatterns = {"/Pedido"})
public class PedidoControlador extends HttpServlet {

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
        String pedId = request.getParameter("pedId");
        String pedFechaPedido = request.getParameter("pedFechaPedido");
        String pedFechaEntrega = request.getParameter("pedFechaEntrega");
        String pedEstado = request.getParameter("pedEstado");
        String prvId_fk = request.getParameter("prvId_fk");
        String pedTotal = request.getParameter("pedTotal");

        int opcion = Integer.parseInt(request.getParameter("opcion"));

        //2. ¿Quiién tiene los datos de forma segura? VO
        PedidoVO pedVO = new PedidoVO(pedId, pedFechaPedido, pedFechaEntrega, pedEstado, prvId_fk, pedTotal);

        //3. ¿Quién hace las operaciones? DAO
        PedidoDAO pedDAO = new PedidoDAO(pedVO);

        //4. Administrar operaciones
        switch (opcion) {
            case 1: //Agregar registro
                if (pedDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "¡El pedido se registro correctamente!");
                } else {
                    request.setAttribute("mensajeError", "¡El pedido no se registro!");
                }
                request.getRequestDispatcher("registrarPedido.jsp").forward(request, response); //para enviar a la otra vista
                break;
            case 2: //Actualizar registro
                if (pedDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "¡El pedido se actualizó correctamente!");
                } else {
                    request.setAttribute("mensajeError", "¡El pedido no se actualizó!");
                }
                request.getRequestDispatcher("actualizarPedido.jsp").forward(request, response); //para enviar a la otra vista
                break;
            case 3: //Eliminar registro
                if (pedDAO.eliminarRegistro()) {
                    request.setAttribute("mensajeExito", "¡El pedido se eliminó correctamente!");
                } else {
                    request.setAttribute("mensajeError", "¡El pedido no se eliminó!");
                }
                request.getRequestDispatcher("consultarPedido.jsp").forward(request, response); //para enviar a la otra vista
                break;

            case 4:
                pedVO = pedDAO.consultarPorId(pedId);
                if (pedVO != null) {
                    request.setAttribute("pedidoEncontrado", pedVO);
                    request.getRequestDispatcher("actualizarPedido.jsp").forward(request, response);

                } else {
                    request.setAttribute("mensajeError", "Pedido NO Encontrado");
                    request.getRequestDispatcher("consultarPedido.jsp").forward(request, response);
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
