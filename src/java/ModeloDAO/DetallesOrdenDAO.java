/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.DetallesOrdenVO;
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
 * @author rodri
 */
public class DetallesOrdenDAO extends ConexionBd implements Crud {
    
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    private String detoId = "", ordId_fk = "", prodId_fk = "", detoCantidad = "", detoPrecio = "", detoDetalles = "", detoSubTotal = "", detoPrecioDomicilio = "0";

    public DetallesOrdenDAO() {
    }
    
    
    
    public DetallesOrdenDAO(DetallesOrdenVO detOrdVO){
       super();
        try {
            conexion = this.obtenerConexion();
            
            detoId = detOrdVO.getDetoId();
            ordId_fk = detOrdVO.getOrdId_fk();
            prodId_fk = detOrdVO.getProdId_fk();
            detoCantidad = detOrdVO.getDetoCantidad();
            detoPrecio = detOrdVO.getDetoPrecio();
            detoDetalles = detOrdVO.getDetoDetalles();
            detoSubTotal = detOrdVO.getDetoSubTotal();
            detoPrecioDomicilio = detOrdVO.getDetoPrecioDomicilio();

        } catch (Exception e) {
            Logger.getLogger(DetallesOrdenDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public boolean agregarRegistro() {
        
        try {
            
            sql = "insert into detallesorden(detoId, ordId_fk, prodId_fk, detoCantidad, detoPrecio, detoDetalles, detoPrecioDomicilio) values (?,?,?,?,?,?,?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, detoId);
            puente.setString(2, ordId_fk);
            puente.setString(3, prodId_fk);
            puente.setString(4, detoCantidad);
            puente.setString(5, detoPrecio);
            puente.setString(6, detoDetalles);
            puente.setString(7, detoPrecioDomicilio);
            puente.executeUpdate();
            operacion = true;
            
        } catch (Exception e) {
            Logger.getLogger(DetallesOrdenDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(DetallesOrdenDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
    
        try {
            sql = "UPDATE detallesorden SET ordId_fk = ?, prodId_fk = ?, detoCantidad = ?, detoPrecio = ?, detoDetalles = ?, detoPrecioDomicilio = ? WHERE detoId = ?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, ordId_fk);
            puente.setString(2, prodId_fk);
            puente.setString(3, detoCantidad);
            puente.setString(4, detoPrecio);
            puente.setString(5, detoDetalles);
            puente.setString(6, detoPrecioDomicilio);
            puente.setString(7, detoId);
            puente.executeUpdate();
            operacion = true;
            
        }catch (Exception e) {
            Logger.getLogger(DetallesOrdenDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(DetallesOrdenDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    
    public DetallesOrdenVO consultarOrden(String detoId) {

        DetallesOrdenVO detOrdVO = null;
        
    try {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM detallesorden WHERE detoId=?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, detoId);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                detOrdVO = new DetallesOrdenVO(detoId, mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8));
            }
        } catch (Exception e) {
            Logger.getLogger(DetallesOrdenDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();

            } catch (Exception e) {
                Logger.getLogger(DetallesOrdenDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return detOrdVO;
    }
    
    public ArrayList<DetallesOrdenVO> listar() {
        ArrayList<DetallesOrdenVO> listarDetallesOrden = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "select * from consultar_nomproducto";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                DetallesOrdenVO detOrdVO = new DetallesOrdenVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8), mensajero.getString(9));
                listarDetallesOrden.add(detOrdVO);
            }
        } catch (Exception e) {
            Logger.getLogger(DetallesOrdenDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(DetallesOrdenDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listarDetallesOrden;
    }

    @Override
    public boolean eliminarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}