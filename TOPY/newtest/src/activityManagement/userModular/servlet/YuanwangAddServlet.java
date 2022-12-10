package activityManagement.userModular.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import activityManagement.userModular.entity.User;
import connection.DBConnection;

/**
 * Servlet implementation class YuanwangAddServlet
 */
@WebServlet("/yuanwangadd")
public class YuanwangAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YuanwangAddServlet() {
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
		
		String content = request.getParameter("content");
		String name = request.getParameter("name");
		String leixing = request.getParameter("leixing");
		
		
		int isSuccess = 0 ;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = null;
			String sql = "insert into yuanwang(content,name,leixing) value (?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, content);
			ps.setString(2, leixing);
			ps.setString(3, name);
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
		if (isSuccess == 1) {
			out.print("<script language=\"javascript\" >alert('Success');" + " javascript:history.go(-1)</script>");
			out.flush();
			out.close();

		} else {
			out.print("<script language=\"javascript\" >alert('Fail');" + " javascript:history.go(-1)</script>");
			out.flush();
			out.close();
		}
	}

}
