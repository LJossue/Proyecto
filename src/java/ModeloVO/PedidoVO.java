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
public class PedidoVO {
    String pedId, pedFechaPedido, pedFechaEntrega, PedEstado, prvId_fk, pedTotal, prvNombre;
    

    public PedidoVO() {
    }

    public PedidoVO(String pedId, String pedFechaPedido, String pedFechaEntrega, String PedEstado, String prvId_fk,String pedTotal) {
        this.pedId = pedId;
        this.pedFechaPedido = pedFechaPedido;
        this.pedFechaEntrega = pedFechaEntrega;
        this.PedEstado = PedEstado;     
        this.prvId_fk = prvId_fk;
        this.pedTotal = pedTotal;
    }

    public PedidoVO(String pedId, String pedFechaPedido, String pedFechaEntrega, String PedEstado, String prvId_fk, String pedTotal, String prvNombre) {
        this.pedId = pedId;
        this.pedFechaPedido = pedFechaPedido;
        this.pedFechaEntrega = pedFechaEntrega;
        this.PedEstado = PedEstado;
        this.prvId_fk = prvId_fk;
        this.pedTotal = pedTotal;
        this.prvNombre = prvNombre;
                
    }

    public String getPedId() {
        return pedId;
    }

    public void setPedId(String pedId) {
        this.pedId = pedId;
    }

    public String getPedFechaPedido() {
        return pedFechaPedido;
    }

    public void setPedFechaPedido(String pedFechaPedido) {
        this.pedFechaPedido = pedFechaPedido;
    }

    public String getPedFechaEntrega() {
        return pedFechaEntrega;
    }

    public void setPedFechaEntrega(String pedFechaEntrega) {
        this.pedFechaEntrega = pedFechaEntrega;
    }


    public String getPrvId_fk() {
        return prvId_fk;
    }

    public void setPrvId_fk(String prvId_fk) {
        this.prvId_fk = prvId_fk;
    }

    public String getPedTotal() {
        return pedTotal;
    }

    public void setPedTotal(String pedTotal) {
        this.pedTotal = pedTotal;
    }

    public String getPrvNombre() {
        return prvNombre;
    }

    public void setPrvNombre(String prvNombre) {
        this.prvNombre = prvNombre;
    }

        public String getPedEstado() {
        return PedEstado;
    }

    public void setPedEstado(String PedEstado) {
        this.PedEstado = PedEstado;
    }  
    
}
