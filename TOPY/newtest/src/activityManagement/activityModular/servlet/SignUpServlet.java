package activityManagement.activityModular.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import activityManagement.activityModular.dao.ActivityDao;
import activityManagement.activityModular.entity.Activity;

public class SignUpServlet extends HttpServlet {
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
		String actId = req.getParameter("actId");

		if (userId == null || "".equals(userId) || actId == null || "".equals(actId)) {
			out.print("<script language=\"javascript\" >alert('Fail to edit');" + " javascript:history.go(-1)</script>");
			out.flush();
			out.close();
		}
		ActivityDao activityDao = new ActivityDao();

		Date now = new Date();
		Activity act = null;
		act = activityDao.queryById(Integer.parseInt(actId));
		Date head = act.getSignUpStartDate();
		Date tail = act.getSignUpEndDate();
		if (now.getTime() < head.getTime()) {
			System.out.println(" Register has not started yet");
			out.print("<script language=\"javascript\" >alert('Register has not started yet');" + " javascript:history.go(-1)</script>");
			out.flush();
			out.close();
		} else if (now.getTime() > tail.getTime()) {
			System.out.println("Register is already over");
			out.print("<script language=\"javascript\" >alert('Register is already over');" + " javascript:history.go(-1)</script>");
			out.flush();
			out.close();
		} else {

			Boolean isSuccess = activityDao.signUp(Integer.parseInt(userId), Integer.parseInt(actId));
			if (isSuccess) {
				resp.sendRedirect("./activityDetail.jsp?id=" + actId);
			} else {
				out.print("<script language=\"javascript\" >alert('Fail to edit');" + " javascript:history.go(-1)</script>");
				out.flush();
				out.close();
			}
		}
	}
}
