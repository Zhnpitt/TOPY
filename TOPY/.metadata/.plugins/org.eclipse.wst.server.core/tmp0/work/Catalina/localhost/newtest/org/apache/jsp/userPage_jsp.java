/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.69
 * Generated at: 2022-11-28 00:50:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import activityManagement.userModular.entity.User;
import activityManagement.activityModular.dao.ActivityDao;
import activityManagement.activityModular.entity.Defen;
import activityManagement.userModular.dao.UserDao;
import activityManagement.activityModular.entity.Activity;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import activityManagement.activityModular.dao.DefenDao;

public final class userPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("activityManagement.activityModular.entity.Defen");
    _jspx_imports_classes.add("activityManagement.activityModular.dao.DefenDao");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("activityManagement.activityModular.entity.Activity");
    _jspx_imports_classes.add("activityManagement.activityModular.dao.ActivityDao");
    _jspx_imports_classes.add("activityManagement.userModular.entity.User");
    _jspx_imports_classes.add("java.text.DateFormat");
    _jspx_imports_classes.add("activityManagement.userModular.dao.UserDao");
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"zh-CN\">\n");
      out.write("<head>\n");
      out.write("<title>TOPY for Parents & Pet owners</title>\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"layui/css/layui.css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("</head>\n");

	User loginUser = (User) session.getAttribute("loginUser");
	ActivityDao activityDao = new ActivityDao();
	List<Activity> actList = activityDao.queryAllList();
	ActivityDao activityDao1 = new ActivityDao();
	List<Activity> actList1 = activityDao1.querySignUpList(loginUser.getId());
	
	
	DateFormat df = new SimpleDateFormat("yyyy / MM / dd ");

      out.write("\n");
      out.write("<body>\n");
      out.write("	<script src=\"layui/layui.js\"></script>\n");
      out.write("	<div class=\"layui-tab\">\n");
      out.write("		<ul class=\"layui-tab-title\">\n");
      out.write("			<li class=\"layui-this\">Event HomePage</li>\n");
      out.write("			<li>Registered event</li>\n");
      out.write("			<li>Personal Information</li>\n");
      out.write("			<li>My wish List</li>\n");
      out.write("			<li>Rating List</li>\n");
      out.write("			<li class=\"layui-nav-item layui-layout-right\"><a\n");
      out.write("				href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/logout\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginUser.userName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("-The user logs out</a></li>\n");
      out.write("				\n");
      out.write("		</ul>\n");
      out.write("		<div class=\"layui-tab-content\">\n");
      out.write("			<div class=\"layui-tab-item layui-show\">\n");
      out.write("\n");
      out.write("				<table>\n");
      out.write("					\n");
      out.write("							");

									for (int i = 0; i < actList.size(); i++) {
											Activity act = actList.get(i);
								
      out.write("\n");
      out.write("						\n");
      out.write("					<tr>\n");
      out.write("						<td><img src=\"\" width=\"0\">&nbsp;&nbsp;</td>\n");
      out.write("						<td>");
      out.print(act.getActName());
      out.write("<br /> Organizer：");
      out.print(act.getSponsor());
      out.write("<br />\n");
      out.write("							Event participants ：");
      out.print(act.getCoOrganizer());
      out.write("<br /> Registration Time ： ");
      out.print(act.getSignUpStartDate() == null ? "" : df.format(act.getSignUpStartDate()));
      out.write("&nbsp;—&nbsp;\n");
      out.write("							");
      out.print(act.getSignUpEndDate() == null ? "" : df.format(act.getSignUpEndDate()));
      out.write("<br />\n");
      out.write("							Event Time ： ");
      out.print(act.getActStartDate() == null ? "" : df.format(act.getActStartDate()));
      out.write("&nbsp;—&nbsp;\n");
      out.write("							");
      out.print(act.getActEndDate() == null ? "" : df.format(act.getActEndDate()));
      out.write("<br />\n");
      out.write("							<br /> <a\n");
      out.write("							href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/activityDetail.jsp?id=");
      out.print(act.getId());
      out.write("\"\n");
      out.write("							class=\"layui-btn layui-btn-sm layui-btn-radius\">Event details</a><br />\n");
      out.write("						<br /></td>\n");
      out.write("					</tr>\n");
      out.write("					<tr>\n");
      out.write("						<td colspan=\"2\"></td>\n");
      out.write("					</tr>\n");
      out.write("					");

									}
								
      out.write("\n");
      out.write("					\n");
      out.write("				</table>\n");
      out.write("\n");
      out.write("			</div>\n");
      out.write("			<div class=\"layui-tab-item\">\n");
      out.write("\n");
      out.write("				<table class=\"layui-table\">\n");
      out.write("					<colgroup>\n");
      out.write("						<col width=\"150\">\n");
      out.write("						<col width=\"200\">\n");
      out.write("						<col>\n");
      out.write("					</colgroup>\n");
      out.write("					<thead>\n");
      out.write("						<tr>\n");
      out.write("							<th>serial number</th>\n");
      out.write("							<th>Activity name</th>\n");
      out.write("							<th>The event start time</th>\n");
      out.write("							<th>The event end time</th>\n");
      out.write("							<th>Details</th>\n");
      out.write("							<th>Cancellation</th>\n");
      out.write("						</tr>\n");
      out.write("					</thead>\n");
      out.write("					<tbody>\n");
      out.write("						");

						for (int i = 0; i < actList1.size(); i++) {
							Activity act = actList1.get(i);
					
      out.write("<tr>\n");
      out.write("							<td>");
      out.print(i + 1);
      out.write("</td>\n");
      out.write("							<td>");
      out.print(act.getActName());
      out.write("</td>\n");
      out.write("							<td>");
      out.print(act.getActStartDate() == null ? "" : df.format(act.getActStartDate()));
      out.write("\n");
      out.write("							</td>\n");
      out.write("							<td>");
      out.print(act.getActEndDate() == null ? "" : df.format(act.getActEndDate()));
      out.write("\n");
      out.write("							</td>\n");
      out.write("							<td><a\n");
      out.write("								href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/activityDetail.jsp?id=");
      out.print(act.getId());
      out.write("\"\n");
      out.write("								class=\"layui-btn layui-btn-sm layui-btn-radius\">Event details</a>\n");
      out.write("							<td><a\n");
      out.write("								href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/cancelSign?userId=");
      out.print(loginUser.getId());
      out.write("&actId=");
      out.print(act.getId());
      out.write("\"\n");
      out.write("								class=\"layui-btn layui-btn-sm layui-btn-radius\">Cancel your registration</a></td>\n");
      out.write("							</td>\n");
      out.write("						</tr>\n");
      out.write("						");

}

      out.write("\n");
      out.write("					</tbody>\n");
      out.write("				</table>\n");
      out.write("				");


UserDao userDao = new UserDao();
User user = userDao.queryByUserId(loginUser.getId());
								
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("			</div>\n");
      out.write("			<div class=\"layui-tab-item\">\n");
      out.write("\n");
      out.write("				<form class=\"layui-form\"\n");
      out.write("					action=\"");
      out.print(request.getContextPath());
      out.write("/userEdit\" method=\"post\">\n");
      out.write("					<input type=\"hidden\" id=\"userId\" name=\"userId\"\n");
      out.write("						value=\"");
      out.print(user.getId());
      out.write("\" />\n");
      out.write("					<div class=\"layui-form-item\">\n");
      out.write("						<label class=\"layui-form-label\">User name</label>\n");
      out.write("						<div class=\"layui-input-inline\">\n");
      out.write("							<input type=\"text\" name=\"userName\" id=\"userName\" required\n");
      out.write("								lay-verify=\"required\" placeholder=\"User name\" autocomplete=\"off\"\n");
      out.write("								class=\"layui-input\" value=\"");
      out.print(user.getUserName());
      out.write("\">\n");
      out.write("						</div>\n");
      out.write("					</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("					<div class=\"layui-form-item\">\n");
      out.write("						<label class=\"layui-form-label\">Password</label>\n");
      out.write("						<div class=\"layui-input-inline\">\n");
      out.write("							<input type=\"password\" name=\"password\" id=\"password\" required\n");
      out.write("								lay-verify=\"required\" placeholder=\"password\" autocomplete=\"off\"\n");
      out.write("								class=\"layui-input\" value=\"");
      out.print(user.getPassword());
      out.write("\">\n");
      out.write("						</div>\n");
      out.write("					</div>\n");
      out.write("\n");
      out.write("					<div class=\"layui-form-item\">\n");
      out.write("						<label class=\"layui-form-label\">User type</label>\n");
      out.write("						<div class=\"layui-input-inline\">\n");
      out.write("							<input type=\"text\" name=\"name\" id=\"name\" required\n");
      out.write("								lay-verify=\"required\" placeholder=\"name\" autocomplete=\"off\"\n");
      out.write("								class=\"layui-input\" value=\"");
      out.print(user.getNickname());
      out.write("\">\n");
      out.write("						</div>\n");
      out.write("					</div>\n");
      out.write("\n");
      out.write("					<div class=\"layui-form-item\">\n");
      out.write("						<label class=\"layui-form-label\">Sex</label>\n");
      out.write("						<div class=\"layui-input-block\">\n");
      out.write("							<input type=\"radio\" name=\"sex\" id=\"sex\" value=\"M\" title=\"M\"\n");
      out.write("								");
if (user.getSex() != null && user.getSex().equals("M")) {
      out.write("\n");
      out.write("								checked ");
}
      out.write("> <input type=\"radio\" name=\"sex\"\n");
      out.write("								id=\"sex\" value=\"F\" title=\"F\"\n");
      out.write("								");
if (user.getSex() != null && user.getSex().equals("F")) {
      out.write("\n");
      out.write("								checked ");
}
      out.write(">\n");
      out.write("						</div>\n");
      out.write("					</div>\n");
      out.write("\n");
      out.write("					<div class=\"layui-form-item\">\n");
      out.write("						<label class=\"layui-form-label\">phone number</label>\n");
      out.write("						<div class=\"layui-input-inline\">\n");
      out.write("							<input type=\"number\" name=\"phoneNum\" id=\"phoneNum\" required\n");
      out.write("								lay-verify=\"required\" placeholder=\"phone number\" autocomplete=\"off\"\n");
      out.write("								class=\"layui-input\" value=\"");
      out.print(user.getPhoneNum());
      out.write("\">\n");
      out.write("						</div>\n");
      out.write("						<div class=\"layui-form-mid layui-word-aux\"></div>\n");
      out.write("					</div>\n");
      out.write("\n");
      out.write("					<div class=\"layui-form-item\">\n");
      out.write("						<div class=\"layui-input-block\">\n");
      out.write("							<button class=\"layui-btn\" lay-submit lay-filter=\"formDemo\"\n");
      out.write("								type=\"submit\">revise</button>\n");
      out.write("						</div>\n");
      out.write("					</div>\n");
      out.write("				</form>\n");
      out.write("\n");
      out.write("			</div>\n");
      out.write("			\n");
      out.write("			<!-- aspiration -->\n");
      out.write("			<div class=\"layui-tab-item\">\n");
      out.write("\n");
      out.write("				<form class=\"layui-form\"\n");
      out.write("					action=\"");
      out.print(request.getContextPath());
      out.write("/yuanwangadd\" method=\"post\">\n");
      out.write("					<input type=\"hidden\" id=\"userId\" name=\"userId\"\n");
      out.write("						value=\"");
      out.print(user.getId());
      out.write("\" />\n");
      out.write("					<div class=\"layui-form-item\">\n");
      out.write("						<label class=\"layui-form-label\">WishBox</label>\n");
      out.write("						<div class=\"layui-input-inline\">\n");
      out.write("							<textarea rows=\"10\" cols=\"60\" name=\"content\" ></textarea>\n");
      out.write("							\n");
      out.write("						</div>\n");
      out.write("					</div>\n");
      out.write("\n");
      out.write("					<div class=\"layui-form-item\">\n");
      out.write("						<label class=\"layui-form-label\">User type</label>\n");
      out.write("						<div class=\"layui-input-inline\">\n");
      out.write("							<input type=\"text\" name=\"leixing\" id=\"leixing\" required\n");
      out.write("								lay-verify=\"required\"  \n");
      out.write("								class=\"layui-input\" value=\"");
      out.print(user.getNickname());
      out.write("\">\n");
      out.write("						</div>\n");
      out.write("					</div>\n");
      out.write("					<div class=\"layui-form-item\">\n");
      out.write("						<label class=\"layui-form-label\">User name</label>\n");
      out.write("						<div class=\"layui-input-inline\">\n");
      out.write("							<input type=\"text\" name=\"name\" id=\"name\" required\n");
      out.write("								lay-verify=\"required\" \n");
      out.write("								class=\"layui-input\" value=\"");
      out.print(user.getUserName());
      out.write("\">\n");
      out.write("						</div>\n");
      out.write("					</div>\n");
      out.write("					\n");
      out.write("\n");
      out.write("					<div class=\"layui-form-item\">\n");
      out.write("						<div class=\"layui-input-block\">\n");
      out.write("							<button class=\"layui-btn\" lay-submit lay-filter=\"formDemo\"\n");
      out.write("								type=\"submit\">Submit</button>\n");
      out.write("						</div>\n");
      out.write("					</div>\n");
      out.write("				</form>\n");
      out.write("\n");
      out.write("			</div>\n");
      out.write("			<div class=\"layui-tab-item\">\n");
      out.write("\n");
      out.write("				<table class=\"layui-table\">\n");
      out.write("					<colgroup>\n");
      out.write("						<col width=\"150\">\n");
      out.write("						<col width=\"200\">\n");
      out.write("						<col>\n");
      out.write("					</colgroup>\n");
      out.write("					<thead>\n");
      out.write("						<tr>\n");
      out.write("							<th>Senior name</th>\n");
      out.write("							<th>Activity name</th>\n");
      out.write("							<th>Seniors score</th>\n");
      out.write("							<th>Activity rating</th>\n");
      out.write("							<th>Evaluator</th>\n");
      out.write("						</tr>\n");
      out.write("					</thead>\n");
      out.write("					<tbody>\n");
      out.write("						");

						DefenDao dao1 = new DefenDao();
						List<Defen> deList = dao1.queryAllList();
						for (int i = 0; i < deList.size(); i++) {
							Defen act = deList.get(i);
					
      out.write("<tr>\n");
      out.write("							<td>");
      out.print(act.getUserid());
      out.write("</td>\n");
      out.write("							<td>");
      out.print(act.getActname());
      out.write("</td>\n");
      out.write("							<td>");
      out.print(act.getFenshu());
      out.write("</td>\n");
      out.write("							<td>");
      out.print(act.getType());
      out.write("</td>\n");
      out.write("							<td>");
      out.print(act.getDafenren());
      out.write("</td>\n");
      out.write("						</tr>\n");
      out.write("						");

}

      out.write("\n");
      out.write("					</tbody>\n");
      out.write("				</table>\n");
      out.write("\n");
      out.write("			</div>\n");
      out.write("			\n");
      out.write("			\n");
      out.write("		</div>\n");
      out.write("	</div>\n");
      out.write("\n");
      out.write("	<script>\n");
      out.write("//注意：选项卡 依赖 element 模块，否则无法进行功能性操作\n");
      out.write("layui.use('element', function(){\n");
      out.write("  var element = layui.element;\n");
      out.write("  \n");
      out.write("  //…\n");
      out.write("});\n");
      out.write("layui.use('form', function() {\n");
      out.write("	var form = layui.form;\n");
      out.write("\n");
      out.write("	\n");
      out.write("});\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
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
