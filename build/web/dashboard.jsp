<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.OrdenDAO"%>
<%@page import="ModeloVO.OrdenVO"%>
<%@page import="ModeloDAO.ProductoDAO"%>
<%@page import="ModeloVO.ProductoVO"%>
<%@page import="ModeloDAO.ClienteDAO"%>
<%@page import="ModeloVO.ClienteVO"%>
<!DOCTYPE html>
<html lang="es">

<div class="head-title">
            <div class="left">
              <h1>Dashboard</h1>
              <ul class="breadcrumb">
                <li>
                  <a href="#">Dashboard</a>
                </li>
                <li><i class='bx bx-chevron-right'></i></li>
                <li>
                  <a class="active" href="#">Home</a>
                </li>
              </ul>
            </div>
            <a href="#" class="btn-download">
              <i class='bx bxs-cloud-download'></i>
              <span class="text">Download PDF</span>
            </a>
          </div>

          <ul class="box-info">
            <li>
              <i class='bx bxs-dollar-circle''></i>
          <span class="text">
            <h3>$10220</h3>
            <p>Ventas</p>
          </span>
        </li>
        <li>
          <i class=' bx bxs-dollar-circle'></i>
              <span class="text">
                <h3>$2834</h3>
                <p>Gastos</p>
              </span>
            </li>
            <li>
              <i class='bx bxs-dollar-circle'></i>
              <span class="text">
                <h3>$2543</h3>
                <p>Ganancias</p>
              </span>
            </li>

            <li>
              <i class='bx bxs-calendar-check'></i>
              <span class="text">
                <h3>1020</h3>
                <p>Ordenes</p>
              </span>
            </li>
             <%
                                    ClienteVO cliVO = new ClienteVO();
                                    ClienteDAO cliDAO = new ClienteDAO();
                                    int cantidadClientesActivos = cliDAO.obtenerCantidadClientesActivos();
                                %>
            <li>
              <i class='bx bxs-group'></i>
              <span class="text">
                <h3><%= cantidadClientesActivos %></h3>
                <p>Clientes Activos</p>
              </span>
            </li>
            <%
                                    ProductoVO proVO = new ProductoVO();
                                    ProductoDAO proDAO = new ProductoDAO();
                                    int cantidadProductosActivos = proDAO.obtenerCantidadProductosActivos();
                                %>
            <li>
              <i class='bx bxs-cake'></i>
              <span class="text">
                <h3><%= cantidadProductosActivos %></h3>
                <p>Productos Totales</p>
              </span>
            </li>
          </ul>

          <div class="table-data">
            <div class="order">
                <div class="head">
                    <h3>Ultimas Ordenes de Clientes</h3>
                    <a href="#" id="ver-mas-ordenes" >Ver más</a>
                <i class='bx bx-search'></i>
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
                                <%
                                    OrdenVO ordVO = new OrdenVO();
                                    OrdenDAO ordDAO = new OrdenDAO();

                                    ArrayList<OrdenVO> listaOrdenesDashboard = ordDAO.listarDashboard();
                                    for (int i = 0; i < listaOrdenesDashboard.size(); i++) {
                                        ordVO = listaOrdenesDashboard.get(i);
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

                          

                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
        </div>
          <div class="table-data">
            <div class="order">
              <div class="head">
                <h3>Mis ordenes a realizar</h3>
                <p>Ver más</p>
                <i class='bx bx-search'></i>
                <i class='bx bx-filter'></i>
              </div>
              <table>
                <thead>
                  <tr>
                    <th>Cliente</th>
                    <th>Documento</th>
                    <th>Fecha Orden</th>
                    <th>Fecha Entrega</th>
                    <th>Repostero</th>
                    <th>Estado</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>
                      John Doe
                    </td>
                    <td>CC 1232406440</td>
                    <td>01-10-2021</td>
                    <td>01-10-2021</td>
                    <td>Michael Torres</td>
                    <td><span class="status completed">Completed</span></td>
                    <td><i class='bx bx-dots-vertical-rounded'></i></td>
                  </tr>
                  <tr>
                    <td>
                      John Doe
                    </td>
                    <td>CC 1232406440</td>
                    <td>01-10-2021</td>
                    <td>01-10-2021</td>
                    <td>Michael Torres</td>
                    <td><span class="status pending">Pending</span></td>
                    <td><i class='bx bx-dots-vertical-rounded'></i></td>
                  </tr>
                  <tr>
                    <td>
                      John Doe
                    </td>
                    <td>CC 1232406440</td>
                    <td>01-10-2021</td>
                    <td>01-10-2021</td>
                    <td>Michael Torres</td>
                    <td><span class="status process">Process</span></td>
                    <td><i class='bx bx-dots-vertical-rounded'></i></td>
                  </tr>
                  <tr>
                    <td>
                      John Doe
                    </td>
                    <td>CC 1232406440</td>
                    <td>01-10-2021</td>
                    <td>01-10-2021</td>
                    <td>Michael Torres</td>
                    <td><span class="status pending">Pending</span></td>
                    <td><i class='bx bx-dots-vertical-rounded'></i></td>
                  </tr>
                  <tr>
                    <td>
                      John Doe
                    </td>
                    <td>CC 1232406440</td>
                    <td>01-10-2021</td>
                    <td>01-10-2021</td>
                    <td>Michael Torres</td>
                    <td><span class="status completed">Completed</span></td>
                    <td><i class='bx bx-dots-vertical-rounded'></i></td>
                  </tr>
                </tbody>
              </table>
            </div>
              