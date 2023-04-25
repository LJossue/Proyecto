
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.MateriaDAO"%>
<%@page import="ModeloVO.MateriaVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
 <section class="modal modal_registrar_materia">
        <div class="modal_container">
            <h2 class="modal_title">Registrar Matería Prima</h2>
            <form method="post" action="Materia">
                           <div class="inputs">
                                    <div>
                                        <label class="modal_paragraph">Nombre:<span class="asterisco"> *</span></label>
                                        <input class="modal_input" type="text" placeholder="Nombre" name="matNombre" required >            
                                    </div>
                               <div>
                        
                        <label class="modal_paragraph">Unidad de Medida:<span class="asterisco"> *</span></label>
                                        <select class="modal_input"  name="matUnidadDeMedida" required >            
                                            <option value="">Seleccione...</option> 
            <option value="Kg">Kg</option> 
            <option value="L">L</option> 
            <option value="Unidad">Unidad</option> 
                                        
                                        </select>         
                                    </div>
                                 <div>
                                        <label class="modal_paragraph">Cantidad:<span class="asterisco"> *</span></label>
                                        <input class="modal_input" type="number" placeholder="Cantidad" name="matCantidad" required >            
                                    </div>
                               </div>
                <div class="swal2-actions">
                    <a href="#" class="modal_close_registrar_materia swal2-styled swal2-cancel">Cerrar</a>
                    <button class="swal2-styled swal2-confirm" type="submit">Registrar</button>
                    
                </div>
                         <input type="hidden" name="opcion" value="1">       
                                
                            
                        </form>

        </div>
        
    </section>
 <section class="modal modal_actualizar_materia">
        <div class="modal_container">
            <h2 class="modal_title">Actualizar Matería Prima</h2>
            <form method="post" action="Materia">
                           
                <div class="inputs">
                    <div>
                           <label class="modal_paragraph" >Id:<span class="asterisco"> *</span></label>
                                         <input class="modal_input" type="number" placeholder="Id" name="matId" required readonly id="mat_id">    
                    </div>
                    <div>
                           <label class="modal_paragraph" >Nombre:<span class="asterisco"> *</span></label>
                                         <input class="modal_input" type="text" placeholder="Nombre" name="matNombre" required  id="mat_nom">    
                    </div>
                    <div>
                        
                        <label class="modal_paragraph">Unidad de Medida:<span class="asterisco"> *</span></label>
                                        <select class="modal_input"  name="matUnidadDeMedida" required  id="mat_uni">            
                                            <option value="">Seleccione...</option> 
            <option value="Kg">Kg</option> 
            <option value="L">L</option> 
            <option value="Unidad">Unidad</option> 
                                        
                                        </select>         
                                    </div>
                                       <div>
                                        <label class="modal_paragraph">Cantidad:<span class="asterisco"> *</span></label>
                                        <input class="modal_input" type="number" placeholder="Cantidad" name="matCantidad" required id="mat_can">            
                                    </div>
                                                
                                    </div>
                <div class="swal2-actions">
                    <a href="#" class="modal_close_actualizar_materia swal2-styled swal2-cancel">Cerrar</a>
                    <button class="swal2-styled swal2-confirm" type="submit">Actualizar</button>
                </div>
                         <input type="hidden" name="opcion" value="2">              
                        </form>
        </div>
        
    </section>
    <center>


        <table>
            <tr>
                <th>
                    <h2><b>Consultar Matería Prima</b></h2>
                    <div >

                        <div class="buscar">
                            <input type="search" class="buscador" id="buscador" placeholder="Search...">
                            <i class='search-btn bx bx-search'></i>
                        </div>

                        <br>
                         <a href="#" class="registrar_materia btn-buscar">Añadir Registro<i class='bx bxs-plus-square'></i></a>

                    </div>


                </th>
            </tr>
        </table><br>




        <div class="table-data">
            <div class="order">
                <div class="head">
                    <h3>Matería Prima</h3>
                    <i class='bx bx-filter'></i>
                </div>
                <table>
                    <thead>
                        <tr>
                            <th style="padding-right: 10px">Id</th>
                            <th>Nombre</th>
                            <th>Cantidad</th>
                            <th>UM</th>
                            <th>Estado</th>
                            <th>Opciones</th>
                                <%
                                    MateriaVO matVO = new MateriaVO();
                                    MateriaDAO matDAO = new MateriaDAO();

                                    ArrayList<MateriaVO> listaMateriaPrima = matDAO.listar();
                                    for (int i = 0; i < listaMateriaPrima.size(); i++) {
                                        matVO = listaMateriaPrima.get(i);
                                %>
                        </tr>
                    </thead>
                    <tbody>
                        <tr class="registro">
                            <td ><%=matVO.getMatId()%></td>
                            
                            <td class="dato" >
                                <%=matVO.getMatNombre()%>
                            </td>
                            <td >
                                <%=matVO.getMatCantidad()%>
                            </td>
                            <td>
                                <%=matVO.getMatUnidadDeMedida()%>
                            </td>
                                                         <td>
  <% String estado = "" + matVO.getMatEstado();%>
    <span<% if (estado.equals("Activo")) {%> class='status activo' <%} else {%> class='status inactivo' <%}%>>
                                    <%=matVO.getMatEstado()%>

                                </span>
                            </td>
                           
                            <td>
                                 <button class="actualizar_materia btn-table" type="button" name="matId" data-id-materia="<%=matVO.getMatId()%>" data-unidad-materia="<%=matVO.getMatUnidadDeMedida()%>" data-nombre-materia="<%=matVO.getMatNombre()%>" data-cantidad-materia="<%=matVO.getMatCantidad()%>"><i class='bx bxs-edit'></i></button>
                                   
                                  
                               
<button class="btn-table" onclick="mostrarSweetAlert('<%=estado%>', <%=matVO.getMatId()%>)"  type="button">
  <%if (estado.equals("Activo")){%>
    <i class='bx bxs-hide'></i>
  <%}else{%>
    <i class='bx bxs-show'></i>
  <%}%>
</button>
<input type="hidden" name="matEstado" value="<%= estado.equals("Activo") ? "Inactivo" : "Activo" %>">
<input type="hidden" name="matId" value="<%= matVO.getMatId() %>">
<input type="hidden" name="opcion" value="3">

<script>
function mostrarSweetAlert(estado, matId) {
  let mensaje, nuevoEstado;
  if (estado === "Activo") {
    mensaje = "¿Está seguro que desea Inactivar este dato?";
    nuevoEstado = "Inactivo";
  } else {
    mensaje = "¿Está seguro que desea Activar este dato?";
    nuevoEstado = "Activo";
  }

  Swal.fire({
    title: mensaje,
    icon: 'warning',
    showCancelButton: true,
    confirmButtonText: 'Sí, estoy seguro'
  }).then((result) => {
    if (result.isConfirmed) {
      // Envía el formulario
      const form = document.createElement('form');
      form.method = 'POST';
      form.action = 'Materia';
      form.style.display = 'none';
      const matEstadoInput = document.createElement('input');
      matEstadoInput.type = 'hidden';
      matEstadoInput.name = 'matEstado';
      matEstadoInput.value = nuevoEstado;
      form.appendChild(matEstadoInput);
      const matIdInput = document.createElement('input');
      matIdInput.type = 'hidden';
      matIdInput.name = 'matId';
      matIdInput.value = matId;
      form.appendChild(matIdInput);
      const opcionInput = document.createElement('input');
      opcionInput.type = 'hidden';
      opcionInput.name = 'opcion';
      opcionInput.value = '3';
      form.appendChild(opcionInput);
      document.body.appendChild(form);
      form.submit();
    }
  })
}

</script>
                            </td>

                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
        </div>
                    <script>
var ejecutado = false;

$(document).ready(function() {
   if (!ejecutado) {
      // Código a ejecutar solo la primera vez
      //MODALES
//registrar materia
const openModal_registrar_materia = document.querySelector('.registrar_materia');
const modal_registrar_materia = document.querySelector('.modal_registrar_materia');
const closeModal_registrar_materia = document.querySelector('.modal_close_registrar_materia')

openModal_registrar_materia.addEventListener('click',(e)=>{
    e.preventDefault();
    modal_registrar_materia.classList.add('modal--show');
});
closeModal_registrar_materia.addEventListener('click',(e)=>{
    e.preventDefault();
    modal_registrar_materia.classList.remove('modal--show');
});


//actualizar materia
const openModal_actualizar_materia = document.querySelectorAll('.actualizar_materia');
const modal_actualizar_materia = document.querySelector('.modal_actualizar_materia');
const closeModal_actualizar_materia = document.querySelector('.modal_close_actualizar_materia')

openModal_actualizar_materia.forEach((btn) => {
  btn.addEventListener('click', (e) => {
    e.preventDefault();
    const idmateria = btn.getAttribute('data-id-materia'); // Obtener el id de materia del botón actualizado
    const modal_actualizar_materia = document.querySelector('.modal_actualizar_materia');
    const matIdInput = modal_actualizar_materia.querySelector('#mat_id');
    matIdInput.value = idmateria; // Asignar el id de materia al input correspondiente en la ventana modal
         // Obtener el valor de data-descripcion del botón y asignarlo al input correspondiente en la ventana modal
    const uniMateria = btn.getAttribute('data-unidad-materia');
    const  matUnidadMedidaInput = modal_actualizar_materia.querySelector('#mat_uni');
    matUnidadMedidaInput.value = uniMateria;
    
    const canMateria = btn.getAttribute('data-cantidad-materia');
    const  matCantidadInput = modal_actualizar_materia.querySelector('#mat_can');
    matCantidadInput.value = canMateria;
    
     const catNombre = btn.getAttribute('data-nombre-materia');
    const  matNombreInput = modal_actualizar_materia.querySelector('#mat_nom');
    matNombreInput.value = catNombre;
    modal_actualizar_materia.classList.add('modal--show');

  });
});
closeModal_actualizar_materia.addEventListener('click',(e)=>{
    e.preventDefault();
    modal_actualizar_materia.classList.remove('modal--show');
});

      ejecutado = true;
   }
   // Resto del código
});
                    </script>