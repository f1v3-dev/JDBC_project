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
																
																
			System.out.println("���������ηε��Ǿ���");
			Statement stmt = conn.createStatement(); // Statement ����
			ResultSet rset = stmt.executeQuery("select * from cafe order by code"); // ����������
																				// System.out.println("��ǰ�ڵ�\t��ǰ\t����\t���");
			while (rset.next()) // ������������
			{
				for (int i = 1; i < 5; i++)
					System.out.print(rset.getString(i) + "\t");
				System.out.println();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("�ش����̹���ã���������ϴ�.\n" + e);
		} catch (SQLException e) {
			System.out.println("�ش����̹���ã���������ϴ�.\n" + e);
		}
	}

	public static void main(String[] args) {
		new Main().connect();
	}
}

