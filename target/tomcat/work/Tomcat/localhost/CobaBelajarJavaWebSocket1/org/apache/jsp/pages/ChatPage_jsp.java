/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-10-14 05:55:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ChatPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Title</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h4>Chat Page</h4>\n");
      out.write("    <div id=\"chatbox\">\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <table>\n");
      out.write("        <tr>\n");
      out.write("            <td>Message</td>\n");
      out.write("            <td><input type=\"text\" id=\"message\" placeholder=\"Your Message\"/></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td><input type=\"submit\" value=\"Submit pesan\" onclick=\"return kirim()\"/></td>\n");
      out.write("        </tr>\n");
      out.write("    </table>\n");
      out.write("    <div id=\"response\"></div>\n");
      out.write("    <a href=\"");
      out.print(request.getContextPath());
      out.write("\">Home Page</a>\n");
      out.write("</body>\n");
      out.write("    <script>\n");
      out.write("        var ws = new WebSocket('ws://192.168.1.100:8080/CobaBelajarJavaWebSocket1/web-socket');\n");
      out.write("\n");
      out.write("\n");
      out.write("        ws.onerror = function (event) {\n");
      out.write("          console.log(event);\n");
      out.write("        };\n");
      out.write("\n");
      out.write("\n");
      out.write("        ws.onopen = function (event) {\n");
      out.write("           document.getElementById('response').innerHTML = \"Connected to websocket server and ready to communicate\";\n");
      out.write("        };\n");
      out.write("\n");
      out.write("        function kirim(){\n");
      out.write("            if(ws.readyState === WebSocket.OPEN){\n");
      out.write("                var textPesan = document.getElementById('message').value;\n");
      out.write("                ws.send(textPesan);\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        ws.onmessage = function (p1) {\n");
      out.write("            var p = document.createElement('p');\n");
      out.write("            p.innerHTML = p1.data;\n");
      out.write("\n");
      out.write("            document.getElementById('chatbox').appendChild(p);\n");
      out.write("            console.log(p1.data);\n");
      out.write("        };\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
