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
public class OrdenVO {
    
    private String ordId, ordEstado, ordFechaPedido, ordFechaEntrega, ordTotal, ordIdRepostero_fk, cliId_fk, repostero,cliente, documento;

    public OrdenVO(String ordId, String ordEstado, String ordFechaPedido, String ordFechaEntrega, String ordTotal, String ordIdRepostero_fk, String cliId_fk) {
        this.ordId = ordId;
        this.ordEstado = ordEstado;
        this.ordFechaPedido = ordFechaPedido;
        this.ordFechaEntrega = ordFechaEntrega;
        this.ordTotal = ordTotal;
        this.ordIdRepostero_fk = ordIdRepostero_fk;
        this.cliId_fk = cliId_fk;
    }

    public OrdenVO() {
    }

    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public String getOrdEstado() {
        return ordEstado;
    }

    public void setOrdEstado(String ordEstado) {
        this.ordEstado = ordEstado;
    }

    public String getOrdFechaPedido() {
        return ordFechaPedido;
    }

    public void setOrdFechaPedido(String ordFechaPedido) {
        this.ordFechaPedido = ordFechaPedido;
    }

    public String getOrdFechaEntrega() {
        return ordFechaEntrega;
    }

    public void setOrdFechaEntrega(String ordFechaEntrega) {
        this.ordFechaEntrega = ordFechaEntrega;
    }

    public String getOrdTotal() {
        return ordTotal;
    }

    public void setOrdTotal(String ordTotal) {
        this.ordTotal = ordTotal;
    }

    public String getOrdIdRepostero_fk() {
        return ordIdRepostero_fk;
    }

    public void setOrdIdRepostero_fk(String ordIdRepostero_fk) {
        this.ordIdRepostero_fk = ordIdRepostero_fk;
    }

    public String getCliId_fk() {
        return cliId_fk;
    }

    public void setCliId_fk(String cliId_fk) {
        this.cliId_fk = cliId_fk;
    }

    public OrdenVO(String ordId, String ordEstado, String ordFechaPedido, String ordFechaEntrega, String ordTotal, String repostero, String cliente,String documento) {
        this.ordId = ordId;
        this.ordEstado = ordEstado;
        this.ordFechaPedido = ordFechaPedido;
        this.ordFechaEntrega = ordFechaEntrega;
        this.ordTotal = ordTotal;
        this.repostero = repostero;
        this.cliente = cliente;
        this.documento = documento;
    }

    public String getRepostero() {
        return repostero;
    }

    public void setRepostero(String repostero) {
        this.repostero = repostero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

   

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
