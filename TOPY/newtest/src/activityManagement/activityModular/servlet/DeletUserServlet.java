package activityManagement.activityModular.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import activityManagement.activityModular.dao.ActivityDao;

public class DeletUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String userId = req.getParameter("userId");

		if (userId == null || "".equals(userId)) {
			out.print("<script language=\"javascript\" >alert('Fail to edit');" + " javascript:history.go(-1)</script>");
			out.flush();
			out.close();
		}
		ActivityDao activityDao = new ActivityDao();

		Boolean isSuccess = activityDao.deletUser(Integer.parseInt(userId));
		if (isSuccess) {
			// 签到取消
			Boolean inSuccess = activityDao.deletUser(Integer.parseInt(userId));
			out.print("<script language=\"javascript\" >alert('successfully Delete');"
					+ " location.href = './adminPage.jsp'</script>");
			out.flush();
			out.close();
		} else {
			out.print("<script language=\"javascript\" >alert('Fail to edit');" + " javascript:history.go(-1)</script>");
			out.flush();
			out.close();
		}
	}

}
