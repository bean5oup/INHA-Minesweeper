/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.65
 * Generated at: 2021-06-14 13:03:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/menu.jsp", Long.valueOf(1623673336584L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction init2(){\r\n");
      out.write("\t\tconsole.log(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(");\r\n");
      out.write("\t\tif(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" != '' )\r\n");
      out.write("\t\t\t$(\"#error\").show();\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<title>Sign In</title>\r\n");
      out.write("<link href=\"css/style.css?ver=1.3\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body bgcolor=\"gray\" onload=\"init(); init2();\">\r\n");
      out.write("\r\n");
      out.write("<link href=\"css/style.css?ver=1.7\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction init(){\r\n");
      out.write("\t\tif(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" != \"\"){\r\n");
      out.write("\t\t\tdocument.getElementById(\"menu_nickname\").innerText = \"[");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionNickname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("님]\";\r\n");
      out.write("\t\t\tdocument.getElementById(\"menu_login\").innerText = \"로그아웃\";\r\n");
      out.write("\t\t\tdocument.getElementById(\"menu_join\").innerText = \"회원수정\";\r\n");
      out.write("\t\t\tdocument.getElementById(\"menu_login\").setAttribute(\"onclick\", \"location.href='UserLogout'\");\r\n");
      out.write("\t\t\tdocument.getElementById(\"menu_join\").setAttribute(\"onclick\", \"location.href='update.jsp'\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse{\r\n");
      out.write("\t\t\tdocument.getElementById(\"menu_nickname\").innerText = \"\";\r\n");
      out.write("\t\t\tdocument.getElementById(\"menu_login\").innerText = \"로그인\";\r\n");
      out.write("\t\t\tdocument.getElementById(\"menu_join\").innerText = \"회원가입\";\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction logout(){\r\n");
      out.write("\t\t     location.href = \"UserLogout\";\r\n");
      out.write("\t\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<a href=\"./index.jsp\"><h1 class=\"title-return\" style=\"float: left; text-shadow: 1px 1px 1px #000;\">MineSweeper</h1><br></a>\r\n");
      out.write("\t<div style=\"text-align : right;\">\r\n");
      out.write("\t\t\t<div id=\"menu_nickname\" style=\"display: inline; font-size: large; text-align: center; color: #fff;\"></div>\r\n");
      out.write("\t\t \t<button id=\"menu_admin\" class=\"styled\" style=\"display: none;\" type=\"button\" onclick=\"location.href='ProcessAdmin'\">관리자페이지</button>\r\n");
      out.write("\t\t\t<button id=\"menu_login\" class=\"styled\" type=\"button\" onclick=\"location.href='login.jsp'\">로그인</button>\r\n");
      out.write("\t\t\t<button id=\"menu_join\" class=\"styled\" type=\"button\" onclick=\"location.href='join.jsp'\">회원가입</button>\r\n");
      out.write("\t</div><br><br><br>\r\n");
      out.write('\r');
      out.write('\n');
 
	try{
	if(session.getAttribute("sessionId").toString().equals("root")){ 
      out.write("\r\n");
      out.write("\t\t\t<script>$(\"#menu_admin\").show();\r\n");
      out.write("\t\t\t</script>\r\n");

		}
	} catch(Exception e){
	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<form action=\"UserLogin\" method=\"post\">\r\n");
      out.write("<div style=\"margin: auto; text-align: center; border: 1px solid rgb(143, 145, 250); width: 50%; height: 150%;\">\r\n");
      out.write("\t<div class='alert-danger' id=\"error\" style=\"display:none\" >\r\n");
      out.write("\t\t\t\t\"아이디와 비밀번호를 확인해 주세요\"\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<span>\r\n");
      out.write("\t\t<input class=\"id_pw\" type=\"text\" id=\"id\" name=\"id\" placeholder=\"아이디\" maxlength=\"20\">\r\n");
      out.write("\t</span><br>\r\n");
      out.write("\t<span>\r\n");
      out.write("\t\t<input class=\"id_pw\" type=\"password\" id=\"pw\" name=\"pw\" placeholder=\"비밀번호\" maxlength=\"20\">\r\n");
      out.write("\t</span><br>\r\n");
      out.write("\t<span>\r\n");
      out.write("\t\t<input class=\"id_pw_submit\" type=\"submit\" value=\"로그인\">\r\n");
      out.write("\t</span><br><br>\r\n");
      out.write("\t\r\n");
      out.write("\t<a href=\"\" style=\"color: white; text-decoration: none; display: none;\">아이디 찾기</a> | \r\n");
      out.write("\t<a href=\"\" style=\"color: white; text-decoration: none; display: none;\">비밀번호 찾기</a> |\r\n");
      out.write("\t<a href=\"join.jsp\" style=\"color: white; text-decoration: none;\">회원가입</a>\r\n");
      out.write("</div>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
