/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.65
 * Generated at: 2021-06-14 13:03:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import com.bean3oup.setting.SettingBoard;

public final class game_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.bean3oup.setting.SettingBoard");
    _jspx_imports_classes.add("java.util.ArrayList");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<title>MineSweeper</title>\r\n");
      out.write("<link href=\"css/style.css?ver=1.2\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script src=\"js/game.js?ver=1.2\"></script>\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body bgcolor=\"gray\" oncontextmenu='return false' onload=\"init()\">\r\n");
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

	int level = Integer.parseInt(request.getParameter("level"));
	int row, col, mine;
	if(level == 1){
		row = 9; col = 9;
		mine = 10;
	}
	else if(level == 2){
		row = 16; col = 16;	
		mine = 40;
	}
	else if(level == 3){
		row = 16; col = 30;	
		mine = 99;
	}
	else{
		row = 55; col = 55;
		mine = 100;
		
		if(request.getParameter("row") != null)
			row = Integer.parseInt(request.getParameter("row"));
		if(request.getParameter("col") != null)
			col = Integer.parseInt(request.getParameter("col"));
		if(request.getParameter("mine") != null){
			mine = Integer.parseInt(request.getParameter("mine"));
			if(mine > row * col)
				mine = row * col;
		}
		
      out.write("\r\n");
      out.write("\t\t<form action=\"game.jsp\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"level\" value=");
      out.print( level );
      out.write(">\r\n");
      out.write("\t\t\t<input class=\"styled\" type=\"number\" name=\"col\" min=\"1\" max=\"55\" placeholder=\"가로");
      out.print( col );
      out.write("\" required=\"required\">\r\n");
      out.write("\t\t\t<input class=\"styled\" type=\"number\" name=\"row\" min=\"1\" max=\"100\" placeholder=\"세로");
      out.print( row );
      out.write("\" required=\"required\">\r\n");
      out.write("\t\t\t<input class=\"styled\" type=\"number\" name=\"mine\" min=\"1\" max=\"5500\" placeholder=\"지뢰");
      out.print( mine );
      out.write("\" required=\"required\">\r\n");
      out.write("\t\t\t<button class=\"styled\" type=\"submit\">업데이트</button>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t");

	}	
	SettingBoard set = new SettingBoard();
	
	String board = set.setBoard(row, col);
	ArrayList<Integer> minepos = set.setMine(mine, col * row);

      out.write('\r');
      out.write('\n');

	int navi_width = 34 * col;
	if(navi_width < 34 * 3)
		navi_width = 34 * 3;

      out.write("\r\n");
      out.write("<div style=\"text-align: center;\">\r\n");
      out.write("<div style=\"display: inline-block; text-align: center; width: ");
      out.print( navi_width );
      out.write("px; height: 68px; border: 1px solid rgb(143, 145, 250);\">\r\n");
      out.write("\t<div style=\"display: inline-block; float: left; margin: 3px;\">\r\n");
      out.write("\t\t<input class=\"styled\" style=\"width: 90px; height: 64px; float: left;\" id=\"leftmine\" type=\"submit\" value=");
      out.print( mine );
      out.write(">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div style=\"display: inline-block; margin: 3px;\">\r\n");
      out.write("\t\t<form action=\"game.jsp\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"level\" value=");
      out.print( level );
      out.write(">\r\n");
      out.write("\t\t\t<input class=\"styled\" style=\"height: 64px\" type=\"submit\" value=\"초기화\">\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div style=\"display: inline-block; float: right; margin: 3px;\">\r\n");
      out.write("\t\t<input class=\"styled\" style=\"width: 90px; height: 64px; float: right;\" id=\"time\" type=\"submit\" value=0 name=0>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.print( board );
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<script>\r\n");
      out.write("\tsetMineAtBoard(");
      out.print( minepos);
      out.write(");\r\n");
      out.write("\ttableEvent();\r\n");
      out.write("</script>\r\n");
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
