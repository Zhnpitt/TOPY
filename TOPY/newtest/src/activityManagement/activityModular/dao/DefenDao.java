package activityManagement.activityModular.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import activityManagement.activityModular.entity.Activity;
import activityManagement.activityModular.entity.Defen;
import connection.DBConnection;

public class DefenDao {
	public List<Defen> queryAllList() {
			Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from dafen";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
	
			Defen temp = null;
			List<Defen> actList = new ArrayList<Defen>();
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
	
	private Defen resultSet2Activity(ResultSet rs) {
		Defen act = new Defen();
		try {
			act.setUserid(rs.getString("userid"));
			act.setActivity_id(rs.getString("activity_id"));
			act.setFenshu(rs.getString("fenshu"));
			act.setType(rs.getString("type"));
			act.setActname(rs.getString("actname"));
			act.setDafenren(rs.getString("dafenren"));
			return act;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
