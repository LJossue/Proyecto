/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author rodri
 */
public class DetallesOrdenVO {

    private String detoId, ordId_fk, prodId_fk, detoCantidad, detoPrecio, detoDetalles, detoSubTotal, detoPrecioDomicilio, prodNombre;

    public DetallesOrdenVO(String detoId, String ordId_fk, String prodId_fk, String detoCantidad, String detoPrecio, String detoDetalles, String detoSubTotal, String detoPrecioDomicilio) {
        this.detoId = detoId;
        this.ordId_fk = ordId_fk;
        this.prodId_fk = prodId_fk;
        this.detoCantidad = detoCantidad;
        this.detoPrecio = detoPrecio;
        this.detoDetalles = detoDetalles;
        this.detoSubTotal = detoSubTotal;
        this.detoPrecioDomicilio = detoPrecioDomicilio;
    }

    public DetallesOrdenVO() {
    }

    public String getDetoId() {
        return detoId;
    }

    public void setDetoId(String detoId) {
        this.detoId = detoId;
    }

    public String getOrdId_fk() {
        return ordId_fk;
    }

    public void setOrdId_fk(String ordId_fk) {
        this.ordId_fk = ordId_fk;
    }

    public String getProdId_fk() {
        return prodId_fk;
    }

    public void setProdId_fk(String prodId_fk) {
        this.prodId_fk = prodId_fk;
    }

    public String getDetoCantidad() {
        return detoCantidad;
    }

    public void setDetoCantidad(String detoCantidad) {
        this.detoCantidad = detoCantidad;
    }

    public String getDetoPrecio() {
        return detoPrecio;
    }

    public void setDetoPrecio(String detoPrecio) {
        this.detoPrecio = detoPrecio;
    }

    public String getDetoDetalles() {
        return detoDetalles;
    }

    public void setDetoDetalles(String detoDetalles) {
        this.detoDetalles = detoDetalles;
    }

    public String getDetoSubTotal() {
        return detoSubTotal;
    }

    public void setDetoSubTotal(String detoSubTotal) {
        this.detoSubTotal = detoSubTotal;
    }

    public String getDetoPrecioDomicilio() {
        return detoPrecioDomicilio;
    }

    public void setDetoPrecioDomicilio(String detoPrecioDomicilio) {
        this.detoPrecioDomicilio = detoPrecioDomicilio;
    }

    public DetallesOrdenVO(String detoId, String ordId_fk, String prodId_fk, String detoCantidad, String detoPrecio, String detoDetalles, String detoSubTotal, String detoPrecioDomicilio, String prodNombre) {
        this.detoId = detoId;
        this.ordId_fk = ordId_fk;
        this.prodId_fk = prodId_fk;
        this.detoCantidad = detoCantidad;
        this.detoPrecio = detoPrecio;
        this.detoDetalles = detoDetalles;
        this.detoSubTotal = detoSubTotal;
        this.detoPrecioDomicilio = detoPrecioDomicilio;
        this.prodNombre = prodNombre;
    }

    public String getProdNombre() {
        return prodNombre;
    }

    public void setProdNombre(String prodNombre) {
        this.prodNombre = prodNombre;
    }

    
}
