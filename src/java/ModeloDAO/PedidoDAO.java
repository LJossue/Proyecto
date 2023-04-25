/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.PedidoVO;
import Util.ConexionBd;
import Util.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author APRENDIZ
 */
public class PedidoDAO extends ConexionBd implements Crud {

    //1.- Declarar variables y/u objetos 
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    private String pedId = "", pedFechaPedido = "", pedFechaEntrega = "", pedEstado = "",prvId_fk = "", pedTotal = "";

    public PedidoDAO() {
    }

    //2 Metodo principal le paso los datos del VO
    public PedidoDAO(PedidoVO pedVO) {
        super();
        try {
            //3 conectarse a la BD
            conexion = this.obtenerConexion();
            //4 traer los datos del VO al DAO 
            pedId = pedVO.getPedId();
            pedFechaPedido = pedVO.getPedFechaPedido();
            pedFechaEntrega = pedVO.getPedFechaEntrega();
            pedEstado = pedVO.getPedEstado();
            prvId_fk = pedVO.getPrvId_fk();
            pedTotal = pedVO.getPedTotal();
        } catch (Exception e) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public boolean agregarRegistro() {
        pedEstado = "Realizado";

        try {
            sql = "insert into pedido (pedFechaPedido, pedFechaEntrega, pedEstado, prvId_fk) values (?,?, ?, ?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, pedFechaPedido);
            puente.setString(2, pedFechaEntrega);
            puente.setString(3, pedEstado);
            puente.setString(4, prvId_fk);
          
            
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;
    }

    
    @Override
    public boolean actualizarRegistro() {
        try {

            sql = "update pedido set pedFechaPedido = ?, pedFechaEntrega = ?, pedEstado = ?, prvId_fk = ? where pedid = ?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, pedFechaPedido);
            puente.setString(2, pedFechaEntrega);
            puente.setString(3, pedEstado);
            puente.setString(4, prvId_fk);
            puente.setString(5, pedId);
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;

    }

    @Override
    public boolean eliminarRegistro() { //hacer
        try {
            sql = "update pedido set  pedEstado = 'Cancelado' where pedid = ?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, pedId);
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;

    }

    public PedidoVO consultarPorId(String Id) {

        PedidoVO pedVO = null;

        try {
            conexion = this.obtenerConexion();
            sql = "select * from pedido where pedId=?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Id);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {

                pedVO = new PedidoVO(Id, mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6));
            }
        } catch (Exception e) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();

            } catch (Exception e) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return pedVO;
    }

    public ArrayList<PedidoVO> listar() {
        ArrayList<PedidoVO> listaPedidos = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "select * from consulta_pedido order by pedFechaPedido desc";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                PedidoVO pedVO = new PedidoVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7));
                listaPedidos.add(pedVO);
            }
        } catch (Exception e) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();

            } catch (Exception e) {
                Logger.getLogger(PedidoDAO.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaPedidos;
    }
    

}
