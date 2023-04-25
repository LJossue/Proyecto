
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Login de la Repostería y pastelería ubicada en Bogotá">
<meta name="keywords" content="Repostería Pastelería Bogotá">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@10.16.3/dist/sweetalert2.min.css">
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.min.js"></script>
  <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="style.css">
  <link rel="icon" href="img/logo.png">
  <link rel="apple-touch-icon" href="img/logo.png">

  <title>Ingresar - Bocaditos</title>
</head>

<body>
     <% String mensajeExito = request.getParameter("mensajeExito");
if (request.getParameter("mensajeExito") != null) {
    request.setAttribute("mensajeExito", mensajeExito.replace("+", " "));
} %>
<% String mensajeError = request.getParameter("mensajeError");
if (request.getParameter("mensajeError") != null) {
    request.setAttribute("mensajeError", mensajeError.replace("+", " "));
} %>
<% if (request.getAttribute("mensajeError") != null) { %>
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
            title: '<%= request.getAttribute("mensajeError") %>'
        })
     </script>
<% } else if(request.getAttribute("mensajeExito") != null) { %>
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
            title: '<%= request.getAttribute("mensajeExito") %>'
        })
     </script>
<% } %>
   <section id="header">
    <a href="login.jsp"><img src="img/logo.png" class="logo" alt="Logo de Bocaditos"></a>
    <div>
        
      <ul id="navbar">

        <li><a class="active" href="login.jsp">Login</a></li>
      </ul>
    </div>
  </section>

  <div class="container">
    <div class="signin-signup">
      <form method="post" action="Usuario" class="sign-in-form">
        <h2 class="title">Inicio de sesión</h2>
        <div class="input-field">
          <i class="bi bi-envelope-at"></i>
          <input type="text" placeholder="Correo electronico" name="usuCorreo" required>
        </div>
        <div class="input-field">
          <i class="bi bi-key"></i>
          <input type="password" placeholder="Contraseña" name="usuContrasena" required>
        </div>
        <input type="submit" class="btn" value="Iniciar sesión">
        <br>
        <a href="#" class="lost-pass">¿Olvidaste tu Contraseña?</a><br>
        <a href="#" id="sign-up-btn2" class="account-text">¿No tienes una cuenta?</a>
 <input type="hidden" name="opcion" value="4">
      </form>

        
      <form method="post" action="Usuario" class="sign-up-form">
        <h2 class="title">Registro</h2>

        <div class="input-field">
          <i class="bi bi-envelope-at"></i>
          <input type="text" placeholder="Correo electronico" name="usuCorreo" required>
        </div>

        <div class="input-field">
          <i class="bi bi-person"></i>
          <input type="text" placeholder="Nombre" name="usuNombre" required>
        </div>

        <div class="input-field">
          <i class="bi bi-person"></i>
          <input type="text" placeholder="Apellido" name="usuApellido" required>
        </div>

        <div class="input-field">
            
          <i class="bi bi-person-vcard"></i>
          <select name="usuTipoDocumento" id="select" required><option value="CC">CC</option>
          <option value="CE">CE</option></select>
          <input type="number" placeholder="Numero de Documento" name="usuDocumento" required>
        </div>
        <div class="input-field">
          <i class="bi bi-telephone"></i>
          <input type="number" placeholder="Numero de Telefono" name="usuTelefono" required>
        </div>
        <div class="input-field">
          <i class="bi bi-geo-alt"></i>
          <input type="text" placeholder="Dirección" name="usuDireccion" required>
        </div>
        <div class="input-field">
          <i class="bi bi-key"></i>
          <input type="password" placeholder="Contraseña" name="usuContrasena" required>
        </div>
        <input type="submit" class="btn" value="Registrarse"><br>
        <a href="#" id="sign-in-btn2" class="account-text">¿Ya tienes una cuenta?</a>
         <input type="hidden" name="opcion" value="1">
        </form>

    </div>
    <div class="panel-container">
      <div class="panel left-panel">
        <div class="content ">
          <h3>¿Ya estas registrado?</h3>
          <p>Te extrañamos, sigue compartiendo con nosotros tus mejores momentos.</p>
          <button class="btn" id="sign-in-btn">Ingresa</button>
        </div>
        <img src="img/Mobile login-amico.png" alt="inicio de sesión" class="imagen-panel">
      </div>

      <div class="panel right-panel">
        <div class="content ">
          <h3>¿Aún no te registras?</h3>
          <p>Bienvenid@, Permitenos conocernos un poco más.</p>
          <button class="btn" id="sign-up-btn">Registrate</button>
        </div>
        <img src="img/Welcome-amico.png" alt="inicio de sesión" class="imagen-panel">
      </div>
    </div>

  </div>

  
  <script src="js/script.js"></script>
  <script src="js/login.js"></script>
</body>

</html>