/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.69
 * Generated at: 2022-11-28 00:27:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import activityManagement.activityModular.dao.ActivityDao;
import activityManagement.activityModular.entity.Activity;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class activityEdit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("activityManagement.activityModular.entity.Activity");
    _jspx_imports_classes.add("activityManagement.activityModular.dao.ActivityDao");
    _jspx_imports_classes.add("java.text.DateFormat");
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

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP 只允许 GET、POST 或 HEAD。Jasper 还允许 OPTIONS");
        return;
      }
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Event updated</title>\n");
      out.write("<link rel=\"stylesheet\" href=\"layui/css/layui.css\">\n");
      out.write("</head>\n");
      out.write("<body style=\"height: 80%\">\n");
      out.write("	<script src=\"layui/layui.js\"></script>\n");
      out.write("	");

		String actId = request.getParameter("id");
		Activity act = null;
		if (actId == null) {
			act = new Activity();
		} else {
			ActivityDao activityDao = new ActivityDao();
			act = activityDao.queryById(Integer.parseInt(actId));
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
      out.write("\n");
      out.write("	<form class=\"layui-form\" id=\"actForm\"\n");
      out.write("		action=\"");
      out.print(request.getContextPath());
      out.write("/activityEdit\" method=\"post\"\n");
      out.write("		enctype=\"multipart/form-data\">\n");
      out.write("		<input type=\"hidden\" id=\"actId\" name=\"actId\"\n");
      out.write("			value=\"");
      out.print(act.getId() != null ? act.getId() : "");
      out.write("\" />\n");
      out.write("		<div class=\"layui-form-item\">\n");
      out.write("			<label class=\"layui-form-label\"></label>\n");
      out.write("			<td>\n");
      out.write("				");

								if (act.getActPicture() != null && !"".equals(act.getActPicture())) {
							
      out.write(" <img alt=\"\" src=\"");
      out.print(act.getActPicture());
      out.write("\" width=\"100\">\n");
      out.write("				");

								}
							
      out.write("\n");
      out.write("			</td>\n");
      out.write("		</div>\n");
      out.write("\n");
      out.write("		<div class=\"layui-form-item\">\n");
      out.write("			<label class=\"layui-form-label\">Activity name</label>\n");
      out.write("			<div class=\"layui-input-inline\">\n");
      out.write("				<input type=\"text\"\n");
      out.write("					value=\"");
      out.print(act.getActName() != null ? act.getActName() : "");
      out.write("\"\n");
      out.write("					name=\"actName\" id=\"actName\" required lay-verify=\"required\"\n");
      out.write("					placeholder=\"The name of activity\" autocomplete=\"off\" class=\"layui-input\">\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("\n");
      out.write("		<div class=\"layui-form-item\">\n");
      out.write("			<label class=\"layui-form-label\">Organizer</label>\n");
      out.write("			<div class=\"layui-input-inline\">\n");
      out.write("				<input type=\"text\"\n");
      out.write("					value=\"");
      out.print(act.getSponsor() != null ? act.getSponsor() : "");
      out.write("\"\n");
      out.write("					name=\"sponsor\" id=\"sponsor\" required lay-verify=\"required\"\n");
      out.write("					placeholder=\"Organizer\" autocomplete=\"off\" class=\"layui-input\">\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("\n");
      out.write("		<div class=\"layui-form-item\">\n");
      out.write("			<label class=\"layui-form-label\">Event participant</label>\n");
      out.write("			<div class=\"layui-input-inline\">\n");
      out.write("				<input type=\"text\"\n");
      out.write("					value=\"");
      out.print(act.getCoOrganizer() != null ? act.getCoOrganizer() : "");
      out.write("\"\n");
      out.write("					name=\"coOrganizer\" id=\"coOrganizer\" required lay-verify=\"required\"\n");
      out.write("					placeholder=\"Event participants\" autocomplete=\"off\" class=\"layui-input\">\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("		<div class=\"layui-form-item\">\n");
      out.write("			<label class=\"layui-form-label\">Registration start time</label>\n");
      out.write("			<div class=\"layui-input-inline\">\n");
      out.write("				<input type=\"date\"\n");
      out.write("					value=\"");
      out.print(act.getSignUpStartDate() != null ? df.format(act.getSignUpStartDate()) : "");
      out.write("\"\n");
      out.write("					name=\"signUpStart\" id=\"signUpStart\" required lay-verify=\"required\"\n");
      out.write("					autocomplete=\"off\" class=\"layui-input\">\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("\n");
      out.write("		<div class=\"layui-form-item\">\n");
      out.write("			<label class=\"layui-form-label\">Registration close time</label>\n");
      out.write("			<div class=\"layui-input-inline\">\n");
      out.write("				<input type=\"date\"\n");
      out.write("					value=\"");
      out.print(act.getSignUpEndDate() != null ? df.format(act.getSignUpEndDate()) : "");
      out.write("\"\n");
      out.write("					name=\"signUpEnd\" id=\"signUpEnd\" required lay-verify=\"required\"\n");
      out.write("					autocomplete=\"off\" class=\"layui-input\">\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("\n");
      out.write("		<div class=\"layui-form-item\">\n");
      out.write("			<label class=\"layui-form-label\">The event start time</label>\n");
      out.write("			<div class=\"layui-input-inline\">\n");
      out.write("				<input type=\"date\"\n");
      out.write("					value=\"");
      out.print(act.getActStartDate() != null ? df.format(act.getActStartDate()) : "");
      out.write("\"\n");
      out.write("					name=\"actStart\" id=\"actStart\" required lay-verify=\"required\"\n");
      out.write("					autocomplete=\"off\" class=\"layui-input\">\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("\n");
      out.write("		<div class=\"layui-form-item\">\n");
      out.write("			<label class=\"layui-form-label\">The event end time</label>\n");
      out.write("			<div class=\"layui-input-inline\">\n");
      out.write("				<input type=\"date\"\n");
      out.write("					value=\"");
      out.print(act.getActEndDate() != null ? df.format(act.getActEndDate()) : "");
      out.write("\"\n");
      out.write("					name=\"actEnd\" id=\"actEnd\" required lay-verify=\"required\"\n");
      out.write("					autocomplete=\"off\" class=\"layui-input\">\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("\n");
      out.write("		<div class=\"layui-form-item layui-form-text\">\n");
      out.write("			<label class=\"layui-form-label\">Event content</label>\n");
      out.write("			<div class=\"layui-input-block\">\n");
      out.write("				<textarea placeholder=\"Content\" class=\"layui-textarea\" rows=\"5\"\n");
      out.write("					form=\"actForm\" name=\"actContent\" id=\"actContent\">");
      out.print(act.getActContent() != null ? act.getActContent() : "");
      out.write("</textarea>\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("		<div class=\"layui-form-item\">\n");
      out.write("			<div class=\"layui-input-block\">\n");
      out.write("				<button class=\"layui-btn\" lay-submit lay-filter=\"formDemo\">Submit</button>\n");
      out.write("				<button type=\"reset\" class=\"layui-btn layui-btn-primary\"\n");
      out.write("					onclick=\"javascript:history.go(-1);\">return</button>\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("	</form>\n");
      out.write("\n");
      out.write("	<script>\n");
      out.write("					//Demo\n");
      out.write("					layui.use('form', function() {\n");
      out.write("						var form = layui.form;\n");
      out.write("\n");
      out.write("						//监听提交\n");
      out.write("						form.on('submit(formDemo)', function(data) {\n");
      out.write("							return;\n");
      out.write("						});\n");
      out.write("					});\n");
      out.write("				</script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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