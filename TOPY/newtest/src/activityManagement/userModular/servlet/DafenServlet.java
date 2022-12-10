package activityManagement.userModular.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.DBConnection;

/**
 * Servlet implementation class DafenServlet
 */
@WebServlet("/dafen")
public class DafenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DafenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println(123);
		String userid = request.getParameter("userid");
		String activity_id = request.getParameter("activity_id");
		String type = request.getParameter("type");
		String fenshu = request.getParameter("fenshu");
		String actname = request.getParameter("actname");
		String dafenren = request.getParameter("dafenren");
		System.out.println(userid);
		System.out.println(activity_id);
		System.out.println(type);
		System.out.println(fenshu);
		
		int isSuccess = 0 ;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = null;
			String sql = "insert into dafen(userid,activity_id,fenshu,type,actname,dafenren) value (?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			ps.setString(2, activity_id);
			ps.setString(3, fenshu);
			ps.setString(4, type);
			ps.setString(5, actname);
			ps.setString(6, dafenren);
			isSuccess = ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(isSuccess);
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("utf-8");
		if (isSuccess == 1) {
			out.print("<script language=\"javascript\" >alert('Success');" + " javascript:history.go(-1)</script>");
			out.flush();
			out.close();

		} else {
			out.print("<script language=\"javascript\" >alert('Evaluated points cannot be scored again');" + " javascript:history.go(-1)</script>");
			out.flush();
			out.close();
		}
		
		
	}

}
