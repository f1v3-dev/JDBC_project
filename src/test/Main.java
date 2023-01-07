package test;

import java.io.*;
import java.lang.*;
import java.sql.*;

public class Main {
	private Connection conn = null;

	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "seungjo", "1234");
																
																
			System.out.println("성공적으로로딩되었음");
			Statement stmt = conn.createStatement(); // Statement 생성
			ResultSet rset = stmt.executeQuery("select * from cafe order by code"); // 쿼리문수행
																				// System.out.println("상품코드\t상품\t가격\t재고");
			while (rset.next()) // 쿼리문결과출력
			{
				for (int i = 1; i < 5; i++)
					System.out.print(rset.getString(i) + "\t");
				System.out.println();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("해당드라이버를찾을수없습니다.\n" + e);
		} catch (SQLException e) {
			System.out.println("해당드라이버를찾을수없습니다.\n" + e);
		}
	}

	public static void main(String[] args) {
		new Main().connect();
	}
}

