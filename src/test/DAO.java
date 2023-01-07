package test;

import java.sql.*;
import java.util.ArrayList;

// DB 연결 및 제어 담당 클래스
public class DAO {

	Connection conn = null;
	ResultSet rs = null;
	Statement st = null;
	PreparedStatement ps = null;

	public DAO() {
		try {
			// DB 연결
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "seungjo", "1234");
			// conn.setAutoCommit(false);
			// state.setText("성공적연결");
		} catch (Exception e) {

			e.printStackTrace();
			// state.setText("DB 연결실패" + e.toString());

		}
	}

	// insert
	public void insertData(Data data) {
		try {
			conn.setAutoCommit(false);
			String sql = "insert into cafe values(?, ?, ?, ?)";

			ps = conn.prepareStatement(sql);
			ps.setString(1, data.code);
			ps.setString(2, data.name);
			ps.setInt(3, data.price);
			ps.setInt(4, data.count);

			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}

	// select
	public ArrayList<Data> readData() {
		ArrayList<Data> row = new ArrayList<Data>();
		System.out.println(row);
		try {
			conn.setAutoCommit(false);
			conn.commit();
			st = conn.createStatement();
			rs = st.executeQuery("select * from cafe order by code asc");
			while (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt(3));
				System.out.println(rs.getInt(4));
				// row 값읽기
				row.add(new Data(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));

			}

			System.out.println();
			// JTable에출력
			// model.addRow(row);
		} catch (Exception err) {
			err.printStackTrace();
		} finally {
			dbClose();
		}
		return row;
	}

	// Update
	public boolean updateData(Data data) {
		try {
//			String sql = "update cafe set price = ? where code=?;";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, data.price);
//			ps.setString(2, data.code);
//			ps.executeUpdate();
//			

			String sql = "update cafe set price = " + data.price + "where code = " + data.code; 
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			if (rs.next()) {
				st.executeUpdate(sql);
				System.out.println("수정 성공");
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		} return false;
	}

	// Delete
	public boolean deleteData(String code) {
		try {

			String sql = "delete from cafe where code = " + code;

			st = conn.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				st.executeUpdate(sql);
				System.out.println("삭제 성공");
				return true;

			} else {
				return false;
			}

		} catch (

		SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return false;
	}

	public void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (ps != null)
				ps.close();
		} catch (Exception e) {
			System.out.println(e + "=> dbClose fail");
		}
	}
}
