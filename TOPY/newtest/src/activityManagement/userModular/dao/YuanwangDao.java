package activityManagement.userModular.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import activityManagement.activityModular.entity.Yuanwang;
import connection.DBConnection;

public class YuanwangDao {
	public List<Yuanwang> queryAllList() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from yuanwang";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			Yuanwang temp = null;
			List<Yuanwang> actList = new ArrayList<Yuanwang>();
			while (rs.next()) {
				
				temp = resultSet2Activity(rs);
				actList.add(temp);
			}
			return actList;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	private Yuanwang resultSet2Activity(ResultSet rs) {
		Yuanwang act = new Yuanwang();
		try {
			act.setSn(rs.getInt("sn"));
			act.setContent(rs.getString("content"));
			act.setLeixing(rs.getString("leixing"));
			act.setName(rs.getString("name"));
			
			return act;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
