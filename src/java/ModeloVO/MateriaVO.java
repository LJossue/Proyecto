/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author esteb
 */
public class MateriaVO 
{
    private String matId, matNombre, matCantidad,matUnidadDeMedida,matEstado ;

    public MateriaVO() {
    }

    public MateriaVO(String matId, String matNombre, String matCantidad, String matUnidadDeMedida, String matEstado) {
        this.matId = matId;
        this.matNombre = matNombre;
        this.matCantidad = matCantidad;
        
        this.matUnidadDeMedida = matUnidadDeMedida;
        this.matEstado = matEstado;
    }

    public String getMatId() {
        return matId;
    }

    public void setMatId(String matId) {
        this.matId = matId;
    }

    public String getMatNombre() {
        return matNombre;
    }

    public void setMatNombre(String matNombre) {
        this.matNombre = matNombre;
    }

    public String getMatCantidad() {
        return matCantidad;
    }

    public void setMatCantidad(String matCantidad) {
        this.matCantidad = matCantidad;
    }

    public String getMatUnidadDeMedida() {
        return matUnidadDeMedida;
    }

    public void setMatUnidadDeMedida(String matUnidadDeMedida) {
        this.matUnidadDeMedida = matUnidadDeMedida;
    }

    public String getMatEstado() {
        return matEstado;
    }

    public void setMatEstado(String matEstado) {
        this.matEstado = matEstado;
    }


}
