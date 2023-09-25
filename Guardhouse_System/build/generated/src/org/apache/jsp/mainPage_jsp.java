package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import GuardHouse.DBConnection;
import java.sql.Connection;

public final class mainPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Main Page</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>\n");
      out.write("        <link rel=\"stylesheet\" href=\"mainPage.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"sidebar\">\n");
      out.write("            <a class=\"active\" href=\"mainPage.jsp\">Search Visitor</a>\n");
      out.write("            <a href=\"RegisterPage.jsp\">Register New Visitor</a>\n");
      out.write("            <a href=\"VisitorTable.jsp\">Visitors</a>\n");
      out.write("            <a href=\"CheckoutTable.jsp\">Report</a>\n");
      out.write("        </div>\n");
      out.write("        <h1>SEARCH USER</h1>\n");
      out.write("        <form action=\"MainController\" method=\"get\">\n");
      out.write("            <div class=\"search-block\">\n");
      out.write("                <div class=\"search-block-h1\">Enter Credentials</div>\n");
      out.write("                <input type=\"text\" name=\"QueryValue\" placeholder=\"IC or Passport No or Permit No\" id=\"QueryValue\"/>\n");
      out.write("                <input type=\"hidden\" name=\"action\" value=\"search\">\n");
      out.write("                <button type=\"submit\">Search</button>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <h1 class=\"centerMargin\">CHECKED IN USERS</h1>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Full Name</th>\n");
      out.write("                <th>Check In Timestamp</th>\n");
      out.write("                <th>Company</th>\n");
      out.write("                <th>Checkout</th>\n");
      out.write("            </tr>\n");
      out.write("            ");

                Connection con = DBConnection.getConnection();
                Statement ps = con.createStatement();
                String str = "SELECT * FROM visitor INNER JOIN checkin ON visitor.Identification = checkin.Identification";
                ResultSet rs = ps.executeQuery(str);

                while (rs.next()) {

            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(rs.getString("FullName"));
      out.write("</td>\n");
      out.write("                <td>");
      out.print(rs.getString("CheckIn"));
      out.write("</td>\n");
      out.write("                <td>");
      out.print(rs.getString("Company"));
      out.write("</td>\n");
      out.write("                <td>\n");
      out.write("                    <form action=\"MainController\" method=\"get\">\n");
      out.write("                        <input type=\"hidden\" name=\"Identification\" value=\"");
      out.print(rs.getString("Identification"));
      out.write("\">\n");
      out.write("                        <input type=\"hidden\" name=\"CheckIn\" value=\"");
      out.print(rs.getString("CheckIn"));
      out.write("\">\n");
      out.write("                        <input type=\"hidden\" name=\"action\" value=\"checkout\">\n");
      out.write("                        <button type=\"submit\" class=\"checkout-block-button\">Checkout</button>\n");
      out.write("                    </form>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
