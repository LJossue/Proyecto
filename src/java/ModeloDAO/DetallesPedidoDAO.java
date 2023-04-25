/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.DetallesPedidoVO;
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



public class DetallesPedidoDAO extends ConexionBd implements Crud {

    //1.- Declarar variables y/u objetos 
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    private String detpId = "", pedId_fk = "", matId_fk = "", detpPrecioUnidad = "", detpCantidad = "", detpSubTotal = "";

    public DetallesPedidoDAO() {
    }

   
    
    //2 Metodo principal le paso los datos del VO
    public DetallesPedidoDAO(DetallesPedidoVO detpVO) {
        super();
        try {
            //3 conectarse a la BD
            conexion = this.obtenerConexion();
            //4 traer los datos del VO al DAO 
            detpId = detpVO.getDetpId();
            pedId_fk = detpVO.getPedId_fk();
            matId_fk = detpVO.getMatId_fk();
            detpPrecioUnidad = detpVO.getDetpPrecioUnidad();
            detpCantidad = detpVO.getDetpCantidad();
            detpSubTotal = detpVO.getDetpSubTotal();
        } catch (Exception e) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public boolean agregarRegistro() {
        try {
            sql = "insert into detallespedido (pedId_fk, matId_fk, detpPrecioUnidad, detpCantidad) values (?, ?, ?, ?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, pedId_fk);
            puente.setString(2, matId_fk);
            puente.setString(3, detpPrecioUnidad);
            puente.setString(4, detpCantidad);
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(DetallesPedidoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(DetallesPedidoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            sql = "update detallespedido set pedId_fk = ?, matId_fk = ?, detpPrecioUnidad = ?, detpCantidad = ? where detpId = ?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, pedId_fk);
            puente.setString(2, matId_fk);
             puente.setString(3, detpPrecioUnidad);
            puente.setString(4, detpCantidad);
            puente.setString(5, detpId);
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(DetallesPedidoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(DetallesPedidoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;

    }

     @Override
    public boolean eliminarRegistro() { //hacer
        try {
            sql = "update Detallespedido set  pedEstado = 'Cancelado' where pedid = ?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, detpId);
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
    public DetallesPedidoVO consultarPorId(String Id) {

        DetallesPedidoVO detpVO = null;

        try {
            conexion = this.obtenerConexion();
            sql = "select * from detallespedido where detpId=?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Id);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {

                detpVO = new DetallesPedidoVO(Id, mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5),mensajero.getString(6));
            }
        } catch (Exception e) {
            Logger.getLogger(DetallesPedidoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();

            } catch (Exception e) {
                Logger.getLogger(DetallesPedidoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return detpVO;
    }

    public ArrayList<DetallesPedidoVO> listar() {
        ArrayList<DetallesPedidoVO> listaDetallesPedidos = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "select * from consulta_detalles_pedido";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                DetallesPedidoVO detpVO = new DetallesPedidoVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5),mensajero.getString(6),mensajero.getString(7));
                listaDetallesPedidos.add(detpVO);
            }
        } catch (Exception e) {
            Logger.getLogger(DetallesPedidoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();

            } catch (Exception e) {
                Logger.getLogger(DetallesPedidoDAO.class
                        .getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaDetallesPedidos;
    }

}

