# JDBC_project

- DBMS : ORACLE DATABASE EXPRESS EDITION (XE) RELEASE 11.2.0.2.0 (11GR2)
- Java : jdk1.8.0
- Windows 10 Pro 64 bit
- JDBC : ojdbc6

---
### test code
```
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
```
#### test code result
![image](https://user-images.githubusercontent.com/84575041/211155648-10e45c3e-2f7d-4d1c-9dc3-2e7df5a80821.png)
