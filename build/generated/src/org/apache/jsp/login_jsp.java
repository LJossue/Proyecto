package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"UTF-8\">\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("  <meta name=\"description\" content=\"Login de la Repostería y pastelería ubicada en Bogotá\">\n");
      out.write("<meta name=\"keywords\" content=\"Repostería Pastelería Bogotá\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/login.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("\n");
      out.write("  <link rel=\"icon\" href=\"img/logo.png\">\n");
      out.write("  <link rel=\"apple-touch-icon\" href=\"img/logo.png\">\n");
      out.write("  <title>Ingresar - Bocaditos</title>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("   <section id=\"header\">\n");
      out.write("    <a href=\"login.jsp\"><img src=\"img/logo.png\" class=\"logo\" alt=\"Logo de Bocaditos\"></a>\n");
      out.write("    <div>\n");
      out.write("      <ul id=\"navbar\">\n");
      out.write("\n");
      out.write("        <li><a class=\"active\" href=\"login.jsp\">Login</a></li>\n");
      out.write("      </ul>\n");
      out.write("    </div>\n");
      out.write("  </section>\n");
      out.write("\n");
      out.write("  <div class=\"container\">\n");
      out.write("    <div class=\"signin-signup\">\n");
      out.write("      <form method=\"post\" action=\"Usuario\" class=\"sign-in-form\">\n");
      out.write("        <h2 class=\"title\">Inicio de sesión</h2>\n");
      out.write("        <div class=\"input-field\">\n");
      out.write("          <i class=\"bi bi-envelope-at\"></i>\n");
      out.write("          <input type=\"text\" placeholder=\"Correo electronico\" name=\"usuCorreo\" required>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"input-field\">\n");
      out.write("          <i class=\"bi bi-key\"></i>\n");
      out.write("          <input type=\"password\" placeholder=\"Contraseña\" name=\"usuContrasena\" required>\n");
      out.write("        </div>\n");
      out.write("        <input type=\"submit\" class=\"btn\" value=\"Iniciar sesión\">\n");
      out.write("        <br>\n");
      out.write("        <a href=\"#\" class=\"lost-pass\">¿Olvidaste tu Contraseña?</a><br>\n");
      out.write("        <a href=\"#\" id=\"sign-up-btn2\" class=\"account-text\">¿No tienes una cuenta?</a>\n");
      out.write(" <input type=\"hidden\" name=\"opcion\" value=\"4\">\n");
      out.write("      </form>\n");

            if(request.getAttribute("mensajeError") != null){ 
      out.write("\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("            \n");
      out.write("            ");
} else { 
      out.write("\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeExito}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("            ");
 }
            
      out.write("\n");
      out.write("\n");
      out.write("        \n");
      out.write("      <form method=\"post\" action=\"Usuario\" class=\"sign-up-form\">\n");
      out.write("        <h2 class=\"title\">Registro</h2>\n");
      out.write("\n");
      out.write("        <div class=\"input-field\">\n");
      out.write("          <i class=\"bi bi-envelope-at\"></i>\n");
      out.write("          <input type=\"text\" placeholder=\"Correo electronico\" name=\"usuCorreo\" required>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"input-field\">\n");
      out.write("          <i class=\"bi bi-person\"></i>\n");
      out.write("          <input type=\"text\" placeholder=\"Nombre\" name=\"usuNombre\" required>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"input-field\">\n");
      out.write("          <i class=\"bi bi-person\"></i>\n");
      out.write("          <input type=\"text\" placeholder=\"Apellido\" name=\"usuApellido\" required>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"input-field\">\n");
      out.write("          <i class=\"bi bi-person-vcard\"></i>\n");
      out.write("          <input type=\"number\" placeholder=\"Numero de Documento\" name=\"usuDocumento\" required>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"input-field\">\n");
      out.write("          <i class=\"bi bi-telephone\"></i>\n");
      out.write("          <input type=\"number\" placeholder=\"Numero de Telefono\" name=\"usuTelefono\" required>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"input-field\">\n");
      out.write("          <i class=\"bi bi-geo-alt\"></i>\n");
      out.write("          <input type=\"text\" placeholder=\"Dirección\" name=\"usuDireccion\" required>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"input-field\">\n");
      out.write("          <i class=\"bi bi-key\"></i>\n");
      out.write("          <input type=\"password\" placeholder=\"Contraseña\" name=\"usuContrasena\" required>\n");
      out.write("        </div>\n");
      out.write("        <input type=\"submit\" class=\"btn\" value=\"Registrarse\"><br>\n");
      out.write("        <a href=\"#\" id=\"sign-in-btn2\" class=\"account-text\">¿Ya tienes una cuenta?</a>\n");
      out.write("         <input type=\"hidden\" name=\"opcion\" value=\"1\">\n");
      out.write("        </form>\n");
      out.write("        ");

            if(request.getAttribute("mensajeError") != null){ 
      out.write("\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("            \n");
      out.write("            ");
} else { 
      out.write("\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeExito}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("            ");
 }
            
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <div class=\"panel-container\">\n");
      out.write("      <div class=\"panel left-panel\">\n");
      out.write("        <div class=\"content \">\n");
      out.write("          <h3>¿Ya estas registrado?</h3>\n");
      out.write("          <p>Te extrañamos, sigue compartiendo con nosotros tus mejores momentos.</p>\n");
      out.write("          <button class=\"btn\" id=\"sign-in-btn\">Ingresa</button>\n");
      out.write("        </div>\n");
      out.write("        <img src=\"img/Mobile login-amico.png\" alt=\"inicio de sesión\" class=\"imagen-panel\">\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div class=\"panel right-panel\">\n");
      out.write("        <div class=\"content \">\n");
      out.write("          <h3>¿Aún no te registras?</h3>\n");
      out.write("          <p>Bienvenid@, Permitenos conocernos un poco más.</p>\n");
      out.write("          <button class=\"btn\" id=\"sign-up-btn\">Registrate</button>\n");
      out.write("        </div>\n");
      out.write("        <img src=\"img/Welcome-amico.png\" alt=\"inicio de sesión\" class=\"imagen-panel\">\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  \n");
      out.write("  <script src=\"js/script.js\"></script>\n");
      out.write("  <script src=\"js/login.js\"></script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
