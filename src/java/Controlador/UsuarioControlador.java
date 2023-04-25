package Controlador;

import ModeloDAO.RolDAO;
import ModeloDAO.UsuarioDAO;
import ModeloVO.RolVO;
import ModeloVO.UsuarioVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author APRENDIZ
 */
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/Usuario"}) //se borra el UsuarioControlador del url patterns para no dejar a la vista que es un controlador
public class UsuarioControlador extends HttpServlet {

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
        String usuId = request.getParameter("usuId");
        String usuCorreo = request.getParameter("usuCorreo");
        String usuContrasena = request.getParameter("usuContrasena");
        String usuApellido = request.getParameter("usuApellido");
        String usuNombre = request.getParameter("usuNombre");
        String usuTipoDocumento = request.getParameter("usuTipoDocumento");
        String usuDocumento = request.getParameter("usuDocumento");
        String usuTelefono = request.getParameter("usuTelefono");
        String usuDireccion = request.getParameter("usuDireccion");
        String usuEstado = request.getParameter("usuEstado");
        String rolId_fk = request.getParameter("rolId_fk");
        String rolDescripcion = request.getParameter("rolDescripcion");
        String cantidad_ordenes = request.getParameter("cantidad_ordenes"); //de la vista y del rolvo

        int opcion = Integer.parseInt(request.getParameter("opcion"));

        //2. ¿Quiién tiene los datos de forma segura? VO
        UsuarioVO usuVO = new UsuarioVO(usuId, usuCorreo, usuContrasena, usuApellido, usuNombre, usuTipoDocumento, usuDocumento, usuTelefono, usuDireccion, usuEstado, rolId_fk, rolDescripcion, cantidad_ordenes);
RolVO rolVO = new RolVO();
        //3. ¿Quién hace las operaciones? DAO
        UsuarioDAO usuDAO = new UsuarioDAO(usuVO);
RolDAO rolDAO = new RolDAO(rolVO);
        //4. Administrar operaciones
        switch (opcion) {
            case 1: //Agregar registro
                if (usuDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "¡El usuario se registro correctamente!");
                    response.sendRedirect("login.jsp?mensajeExito=El+usuario+se+registro+correctamente");
                } else {
                    request.setAttribute("mensajeError", "¡El usuario no se registro!");
                    response.sendRedirect("login.jsp?mensajeError=El+usuario+no+se+registro+correctamente");
                }
                
                break;
            case 2: //Actualziar registro clientes
                if (usuDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "¡El usuario se actualizó correctamente!");
                    response.sendRedirect("index.jsp?mensajeExito=El+usuario+se+actualizo+correctamente");
                } else {
                    request.setAttribute("mensajeError", "¡El usuario no se actualizó!");
                    response.sendRedirect("index.jsp?mensajeError=El+usuario+no+se+actualizo+correctamente");
                }
               
                break;
            case 3: //Eliminar registro
                if (usuDAO.eliminarRegistro()) {
                    request.setAttribute("mensajeExito", "¡El usuario se eliminó correctamente!");
                    response.sendRedirect("index.jsp?mensajeExito=El+rol+del+usuario+se+actualizo+correctamente");
                } else {
                    request.setAttribute("mensajeError", "¡El usuario no se eliminó!");
                    response.sendRedirect("index.jsp?mensajeError=El+rol+del+usuario+no+se+actualizo+correctamente");
                }
                
                break;
            case 4: //LOGIN
                if (usuDAO.iniciarSesion(usuCorreo, usuContrasena)) {
//copias desde aqui dentro de tu if
                    HttpSession miSesion = request.getSession(true);
                    usuVO = usuDAO.consultarPorCorreo(usuCorreo);
                    miSesion.setAttribute("datosUsuario", usuVO);
                    String idUsuario = usuVO.getUsuId();

                    ArrayList<RolVO> listaRoles = rolDAO.listarLogin(idUsuario);
                    for (int i = 0; i < listaRoles.size(); i++) {
                        rolVO = listaRoles.get(i);
                       
	                        if (rolVO.getRolId().equals("1")) { //yo no se porque se me mostraba aqui el menu de administrador entonces tuve que cambiarlos ajshasja
                            request.getRequestDispatcher("perfilPropietario.jsp").forward(request, response);

                        }
                        if (rolVO.getRolId().equals("2")) {
                            request.getRequestDispatcher("perfilSupervisor.jsp").forward(request, response);

                        }
                        if (rolVO.getRolId().equals("3")) {
                            request.getRequestDispatcher("perfilRepostero.jsp").forward(request, response);

                        }
                      
                    }
                } else {
                    request.setAttribute("mensajeError", "¡Datos incorrectos!");
                    response.sendRedirect("login.jsp?mensajeError=Datos+Incorrectos");
                }
                break;
                case 5:
                usuVO = usuDAO.consultarPorId(usuId);
                if (usuVO != null) {
                    request.setAttribute("UsuarioEncontrado", usuVO);
                    request.getRequestDispatcher("actualizarUsuario.jsp").forward(request, response);

                } else {
                    request.setAttribute("mensajeError", "Usuario NO Encontrado");
                    request.getRequestDispatcher("consultarUsuario.jsp").forward(request, response);
                }
                break;
                 case 6: //Actualziar registro Rol (ADMIN)
                if (usuDAO.actualizarRegistroRol()) {
                    request.setAttribute("mensajeExito", "¡El usuario se actualizó correctamente!");
                } else {
                    request.setAttribute("mensajeError", "¡El usuario no se actualizó!");
                }
                request.getRequestDispatcher("consultarUsuario.jsp").forward(request, response); //para enviar a la otra vista
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
