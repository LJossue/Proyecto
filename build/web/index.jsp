<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Boxicons -->
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
  
        <link rel="icon" href="img/logo.png">
        <link rel="apple-touch-icon" href="img/logo.png">
        <!-- JQUERY -->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> 
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@10.16.3/dist/sweetalert2.min.css">
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.min.js"></script>

                <!-- My CSS -->
        <link rel="stylesheet" href="style.css"> 
        <title>Bocaditos - Sistema de Informaci�n</title>
        
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

        <!-- SIDEBAR -->
        <section id="sidebar">
            <a href="index.jsp" class="brand">
                <img src="img/LOGO CUPCAKE.png" alt="Logo Bocaditos" >
                <span class="text">Bocaditos</span>
            </a>
            <ul class="side-menu top">
                <li class="active">
                    <a href="#" id="dashboard">
                        <i class='bx bxs-dashboard'></i>
                        <span class="text">Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class='bx bxs-receipt'></i>
                        <span class="text">Mis Ordenes</span>
                    </a>
                </li>
                <li>
                    <a href="#" id="usuario">
                        <i class='bx bxs-group'></i>
                        <span class="text">Equipo</span>
                    </a>
                </li>


            </ul>
            <ul class="side-menu top">
                <li>
                    <a href="#" id="producto">
                        <i class='bx bxs-cake'></i>
                        <span class="text">Producto</span>
                    </a>
                </li>
                <li>
                    <a href="#" id="cliente">
                        <i class='bx bxs-group'></i>
                        <span class="text">Cliente</span>
                    </a>
                </li>
                <li>
                    <a href="#" id="orden">
                        <i class='bx bxs-receipt'></i>
                        <span class="text">Orden</span>
                    </a>
                </li>
                <li>
                    <a href="#" id="categoria">
                        <i class='bx bxs-food-menu'></i>
                        <span class="text">Categor�a</span>
                    </a>
                </li>
                <li>
                    <a href="#" id="materia">
                        <i class='bx bxs-package'></i>
                        <span class="text">Mater�a Prima</span>
                    </a>
                </li>
                <li>
                    <a href="#" id="pedido">
                        <i class='bx bxs-truck'></i>
                        <span class="text">Pedido</span>
                    </a>
                </li>
                <li>
                    <a href="#" id="proveedor">
                        <i class='bx bxs-store' ></i>
                        <span class="text">Proveedor</span>
                    </a>
                </li>
                <li>
                    <a href="#" id="rol">
                        <i class='bx bxs-user-circle'></i>
                        <span class="text">Rol</span>
                    </a>
                </li>


            </ul>
            <ul class="side-menu">

                <li>
                    <a href="#" class="logout">
                        <i class='bx bxs-log-out-circle'></i>
                        <span class="text">Logout</span>
                    </a>
                </li>
            </ul>
        </section>
        <!-- SIDEBAR -->



        <!-- CONTENT -->
        <section id="content">
            <!-- NAVBAR -->
            <nav>
                <i class='bx bx-menu'></i>
                <form action="#">
                    <div class="form-input">

                    </div>
                </form>
                <input type="checkbox" id="switch-mode" hidden>
                <label for="switch-mode" class="switch-mode"></label>
                <a href="#" class="notification">
                    <i class='bx bxs-bell'></i>
                    <span class="num">8</span>
                </a>
                <a href="#" class="profile">
                    <img src="img/people.png">
                </a>
            </nav>
            <!-- NAVBAR -->

            <!-- MAIN -->
            <main id="main-content">

            </main>

            <!-- MAIN -->
        </section>
        <!-- CONTENT -->



        <script src="script.js"></script>
    </body>

</html>