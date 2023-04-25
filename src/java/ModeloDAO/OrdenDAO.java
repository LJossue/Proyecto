/* and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.OrdenVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import Util.ConexionBd;
import Util.Crud;
import java.util.ArrayList;

/**
 *
 * @author APRENDIZ
 */
public class OrdenDAO extends ConexionBd implements Crud {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    private String ordId = "", ordEstado = "", ordFechaPedido = "", ordFechaEntrega = "", ordTotal = "0", ordIdRepostero_fk = "", cliId_fk = "";

    public OrdenDAO() {
    }

    public OrdenDAO(OrdenVO ordVO) {
        super();
        try {
            conexion = this.obtenerConexion();

            ordId = ordVO.getOrdId();
            ordEstado = ordVO.getOrdEstado();
            ordFechaPedido = ordVO.getOrdFechaPedido();
            ordFechaEntrega = ordVO.getOrdFechaEntrega();
            ordTotal = ordVO.getOrdTotal();
            ordIdRepostero_fk = ordVO.getOrdIdRepostero_fk();
            cliId_fk = ordVO.getCliId_fk();
        } catch (Exception e) {
            Logger.getLogger(OrdenDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public boolean agregarRegistro() {

        try {

            sql = "insert into orden(ordId, ordEstado, ordFechaPedido, ordFechaEntrega, ordIdRepostero_fk, cliId_fk) values(?,?,?,?,?,?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, ordId);
            puente.setString(2, ordEstado);
            puente.setString(3, ordFechaPedido);
            puente.setString(4, ordFechaEntrega);
            puente.setString(5, ordIdRepostero_fk);
            puente.setString(6, cliId_fk);
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(OrdenDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(OrdenDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {

        try {

            sql = "UPDATE orden SET ordEstado = ?, ordFechaPedido = ?, ordFechaEntrega = ?, ordTotal = ?, ordIdRepostero_fk = ?, cliId_fk = ? WHERE ordId = ?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, ordEstado);
            puente.setString(2, ordFechaPedido);
            puente.setString(3, ordFechaEntrega);
            puente.setString(4, ordTotal);
            puente.setString(5, ordIdRepostero_fk);
            puente.setString(6, cliId_fk);
            puente.setString(7, ordId);
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(OrdenDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(OrdenDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean eliminarRegistro() {

        try {
            sql = "UPDATE orden SET  ordEstado = 'Cancelada' WHERE ordId=?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, ordId);
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(OrdenDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(OrdenDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    public OrdenVO consultarOrden(String ordId) {

        OrdenVO ordVO = null;

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM orden WHERE ordId=?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, ordId);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                ordVO = new OrdenVO(ordId, mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7));

            }
        } catch (Exception e) {
            Logger.getLogger(OrdenDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();

            } catch (Exception e) {
                Logger.getLogger(OrdenDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return ordVO;
    }

    public ArrayList<OrdenVO> listar() {
        ArrayList<OrdenVO> listaOrdenes = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "select * from consultar_orden order by ordFechaPedido desc";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                OrdenVO ordVO = new OrdenVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8));
                listaOrdenes.add(ordVO);
            }
        } catch (Exception e) {
            Logger.getLogger(OrdenDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(OrdenDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaOrdenes;
    }
      public ArrayList<OrdenVO> listarDashboard() {
        ArrayList<OrdenVO> listaOrdenesDashboard = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "select * from consultar_orden order by ordFechaPedido desc limit 6;";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                OrdenVO ordVO = new OrdenVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8));
                listaOrdenesDashboard.add(ordVO);
            }
        } catch (Exception e) {
            Logger.getLogger(OrdenDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(OrdenDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaOrdenesDashboard;
    }
}