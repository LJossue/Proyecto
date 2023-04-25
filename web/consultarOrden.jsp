
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.OrdenDAO"%>
<%@page import="ModeloVO.OrdenVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <center>


        <table>
            <tr>
                <th>
                    <h2><b>Consultar Orden</b></h2>
                    <div >

                        <div class="buscar">
                            <input type="search" class="buscador" id="buscador" placeholder="Search...">
                            <i class='search-btn bx bx-search'></i>
                        </div>

                        <br>
                        <a href="registrarOrden.jsp" class="btn-buscar">Añadir Registro<i class='bx bxs-plus-square'></i></a>

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
                    <h3>Ordenes de Clientes</h3>
                    <i class='bx bx-filter'></i>
                </div>
                <table>
                    <thead>
                        <tr>
                            <th style="padding-right: 10px">Id</th>
                            <th>Fecha Pedido</th>
                            <th>Fecha Entrega</th>                   
                            <th>Repostero</th>
                            <th>Cliente</th>
                            <th>Documento</th>
                            <th>Total</th>             
                            <th>Estado</th>
                            <th>Opciones</th>
                                <%
                                    OrdenVO ordVO = new OrdenVO();
                                    OrdenDAO ordDAO = new OrdenDAO();

                                    ArrayList<OrdenVO> listaOrdenes = ordDAO.listar();
                                    for (int i = 0; i < listaOrdenes.size(); i++) {
                                        ordVO = listaOrdenes.get(i);
                                %>
                        </tr>
                    </thead>
                    <tbody>
                        <tr class="registro">
                            <td ><%=ordVO.getOrdId()%></td>
                            <td ><%=ordVO.getOrdFechaPedido()%></td>
                            <td ><%=ordVO.getOrdFechaEntrega()%></td>
                            <td><%=ordVO.getRepostero()%></td>
                            <td class="dato" ><%=ordVO.getCliente()%></td>
                            <td><%=ordVO.getDocumento()%></td>
                            <td><%=ordVO.getOrdTotal()%></td>
                                                          <td>
  <% String estado = "" + ordVO.getOrdEstado();%>
    <span<% if (estado.equals("Realizada")) {%> class='status realizado' <%} else if(estado.equals("Pagada")) {%> class='status pagado' <%} else if(estado.equals("En camino")) {%> class='status enCamino'<%} else if(estado.equals("Entregada")) {%> class='status entregado'<%} else if(estado.equals("Cancelada")) {%> class='status cancelado'<%}%>>
                                    <%=ordVO.getOrdEstado()%>

                                </span>
                            </td>

                            <td>
                                <form method="post" action="Orden" style="display: inline">
                                    <button class="btn-table" type="submit"><i class='bx bxs-edit'></i></button>
                                    <input type="hidden" name="ordId" value=<%=ordVO.getOrdId()%>>
                                    <input type="hidden" name="opcion" value="4">
                                </form>
                                <form method="post" action="Orden" style="display: inline">
                                    <button class="btn-table" onclick="return confirm('¿Está seguro que desea eliminar este dato?')" type="submit"><i
                                            class=' bx bxs-trash'></i></button>
                                    <input type="hidden" name="ordId" value=<%=ordVO.getOrdId()%>>
                                    <input type="hidden" name="opcion" value="3">
                                </form>
                                <a href="consultarDetallesOrden.jsp"><button class="btn-table" type="submit"><i class='bx bxs-detail'></i></button></a>  
                            </td>

                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
        </div>