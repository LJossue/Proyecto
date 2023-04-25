/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author APRENDIZ
 */
public class DetallesPedidoVO {
    String detpId, pedId_fk, matId_fk, detpPrecioUnidad, detpCantidad, detpSubTotal, matNombre;

    public DetallesPedidoVO() {
    }

    public DetallesPedidoVO(String detpId, String pedId_fk, String matId_fk, String detpPrecioUnidad, String detpCantidad, String detpSubTotal) {
        this.detpId = detpId;
        this.pedId_fk = pedId_fk;
        this.matId_fk = matId_fk;
        this.detpPrecioUnidad = detpPrecioUnidad;
        this.detpCantidad = detpCantidad;
        this.detpSubTotal = detpSubTotal;
    }

    public DetallesPedidoVO(String detpId, String pedId_fk, String matId_fk, String detpPrecioUnidad, String detpCantidad, String detpSubTotal, String matNombre) {
        this.detpId = detpId;
        this.pedId_fk = pedId_fk;
        this.matId_fk = matId_fk;
        this.detpPrecioUnidad = detpPrecioUnidad;
        this.detpCantidad = detpCantidad;
        this.detpSubTotal = detpSubTotal;
        this.matNombre = matNombre;
    }

        

    public String getDetpId() {
        return detpId;
    }

    public void setDetpId(String detpId) {
        this.detpId = detpId;
    }

    public String getPedId_fk() {
        return pedId_fk;
    }

    public void setPedId_fk(String pedId_fk) {
        this.pedId_fk = pedId_fk;
    }

    public String getMatId_fk() {
        return matId_fk;
    }

    public void setMatId_fk(String matId_fk) {
        this.matId_fk = matId_fk;
    }

    public String getDetpPrecioUnidad() {
        return detpPrecioUnidad;
    }

    public void setDetpPrecioUnidad(String detpPrecioUnidad) {
        this.detpPrecioUnidad = detpPrecioUnidad;
    }

    public String getDetpCantidad() {
        return detpCantidad;
    }

    public void setDetpCantidad(String detpCantidad) {
        this.detpCantidad = detpCantidad;
    }
    
    public String getDetpSubTotal() {
        return detpSubTotal;
    }

    public void setDetpSubTotal(String detpSubTotal) {
        this.detpSubTotal = detpSubTotal;
    }

    public String getMatNombre() {
        return matNombre;
    }

    public void setMatNombre(String matNombre) {
        this.matNombre = matNombre;
    }

    
    
    
   
}
