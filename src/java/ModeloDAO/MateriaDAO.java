/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Util.ConexionBd;
import ModeloVO.MateriaVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Util.Crud;

/**
 *
 * @author esteb
 */
public class MateriaDAO extends ConexionBd implements Crud {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;

    private String matId = "", matNombre = "", matCantidad = "", matUnidadDeMedida = "",matEstado = "" ;

    public MateriaDAO() {
    }

    public MateriaDAO(MateriaVO matVO) {
        super();
        try {
            // Conectarse a la base de datos
            conexion = this.obtenerConexion();
            // Trae los datos del VO al DAO
            matId = matVO.getMatId();
            matNombre = matVO.getMatNombre();
            matCantidad = matVO.getMatCantidad();
            matEstado = matVO.getMatEstado();
             matUnidadDeMedida = matVO.getMatUnidadDeMedida();

        } catch (Exception e) {

        }

    }

    @Override
    public boolean agregarRegistro() {
        matEstado = "Activo";
        try {
            
            sql = "insert into materiaprima (matNombre,matCantidad,matUnidadDeMedida,matEstado) values (?,?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, matNombre);
            puente.setString(2, matCantidad);
            puente.setString(3, matUnidadDeMedida);
            puente.setString(4, matEstado);
            puente.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            sql = "update materiaprima set matNombre=?,matCantidad=?,matUnidadDeMedida=? where matId=?";
            puente = conexion.prepareStatement(sql);

            puente.setString(1, matNombre);
            puente.setString(2, matCantidad);
            puente.setString(3, matUnidadDeMedida);
            puente.setString(4, matId);
            puente.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean eliminarRegistro() {
        try {
            sql = "update materiaprima set matEstado = ? where matId = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, matEstado);
             puente.setString(2, matId);
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }


    public ArrayList<MateriaVO> listar() {
        ArrayList<MateriaVO> listaMateriaPrima = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "select * from materiaprima order by case matEstado WHEN 'Activo' THEN 0 ELSE 1 END";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                MateriaVO matVO = new MateriaVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5));
                listaMateriaPrima.add(matVO);
            }
        } catch (Exception e) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();

            } catch (Exception e) {
                Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaMateriaPrima;
    }
}
