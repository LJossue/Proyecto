
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.PedidoDAO"%>
<%@page import="ModeloVO.PedidoVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

 
    <center>


        <table>
            <tr>
                <th>
                    <h2><b>Consultar Pedido</b></h2>
                    <div >

                        <div class="buscar">
                            <input type="search" class="buscador" id="buscador" placeholder="Search...">
                            <i class='search-btn bx bx-search'></i>
                        </div>

                        <br>
                        <a href="registrarPedido.jsp" class="btn-buscar">Añadir Registro<i class='bx bxs-plus-square'></i></a>

                    </div>


                </th>
            </tr>
        </table><br>



        <% if (request.getAttribute("mensajeError") != null) {%>
        ${mensajeError}
        <%} else { %>
        ${mensajeExito}

        <% } %>

        <div class="table-data">
            <div class="order">
                <div class="head">
                    <h3>Pedidos a Proveedores</h3>
                    <i class='bx bx-filter'></i>
                </div>
                <table>
                    <thead>
                        <tr>
                            <th style="padding-right: 10px">Id</th>
                            <th>Fecha Pedido</th>
                            <th>Fecha Entrega</th>
                            <th>Proveedor</th>
                            <th>Total</th>
                            <th>Estado</th>   
                            <th>Opciones</th>
                                <%
                                    PedidoVO pedVO = new PedidoVO();
                                    PedidoDAO pedDAO = new PedidoDAO();

                                    ArrayList<PedidoVO> listaPedidos = pedDAO.listar();
                                    for (int i = 0; i < listaPedidos.size(); i++) {
                                        pedVO = listaPedidos.get(i);
                                %>
                        </tr>
                    </thead>
                    <tbody>
                        <tr class="registro">
                            <td ><%=pedVO.getPedId()%></td>
                            
                            <td >
                                <%=pedVO.getPedFechaPedido()%>
                            </td>
                            <td >
                                <%=pedVO.getPedFechaEntrega()%>
                            </td>
                            
                             <td class="dato" >
                                <%=pedVO.getPrvNombre()%>
                            </td>
                             <td>
                                <%=pedVO.getPedTotal()%>
                            </td>
                            <td>
  <% String estado = "" + pedVO.getPedEstado();%>
    <span<% if (estado.equals("Realizado")) {%> class='status realizado' <%} else if(estado.equals("Pagado")) {%> class='status pagado' <%} else if(estado.equals("En camino")) {%> class='status enCamino'<%} else if(estado.equals("Recibido")) {%> class='status entregado'<%} else if(estado.equals("Cancelado")) {%> class='status cancelado'<%}%>>
                                    <%=pedVO.getPedEstado()%>

                                </span>
                            </td>
                            
                            <td>
                                <form method="post" action="Pedido" style="display: inline">
                                    <button class="btn-table" type="submit"><i class='bx bxs-edit'></i></button>
                                    <input type="hidden" name="pedId" value=<%=pedVO.getPedId()%>>
                                    <input type="hidden" name="opcion" value="4">
                                </form>
                                <form method="post" action="Pedido" style="display: inline">
                                    <button class="btn-table" onclick="return confirm('¿Está seguro que desea eliminar este dato?')" type="submit"><i
                                            class=' bx bxs-trash'></i></button>
                                    <input type="hidden" name="pedId" value=<%=pedVO.getPedId()%>>
                                    <input type="hidden" name="opcion" value="3">
                                </form>
<a href="consultarDetallesPedido.jsp"><button class="btn-table" type="submit"><i class='bx bxs-detail'></i></button></a>  
                            </td>

                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
        </div>