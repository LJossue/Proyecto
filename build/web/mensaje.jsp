<%-- 
    Document   : mensaje
    Created on : 14/04/2023, 12:05:49 PM
    Author     : leand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><body>
<%-- Muestra el mensaje de éxito o error si existe --%>
<%
String mensajeExito = (String) session.getAttribute("mensajeExito");
String mensajeError = (String) session.getAttribute("mensajeError");
if (mensajeExito != null) {
%>
<script> 
const Toast = Swal.mixin({
  toast: true,
  position: 'top-end',
  showConfirmButton: false,
  timer: 3000,
  timerProgressBar: true,
  didOpen: (toast) => {
    toast.addEventListener('mouseenter', Swal.stopTimer)
    toast.addEventListener('mouseleave', Swal.resumeTimer)
  }
})

Toast.fire({
  icon: 'success',
  title: '<%= mensajeExito %>'
})</script>
<%
    session.removeAttribute("mensajeExito");
} else if (mensajeError != null) {
%>
<script> 
const Toast = Swal.mixin({
  toast: true,
  position: 'top-end',
  showConfirmButton: false,
  timer: 3000,
  timerProgressBar: true,
  didOpen: (toast) => {
    toast.addEventListener('mouseenter', Swal.stopTimer)
    toast.addEventListener('mouseleave', Swal.resumeTimer)
  }
})

Toast.fire({
  icon: 'error',
  title: '<%= mensajeError %>'
})</script>
<%
    session.removeAttribute("mensajeError");
        }
%>
</body>

