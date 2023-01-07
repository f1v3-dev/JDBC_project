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

---

# 
## 조회 버튼 실행 결과 (Select)
![image](https://user-images.githubusercontent.com/84575041/211155783-8f5496f8-bbb4-4487-9d29-87e8c1141ddb.png)


## 삽입 버튼 (insert) - 데이터 1개 삽입
![image](https://user-images.githubusercontent.com/84575041/211155799-7d9c9203-d656-4a10-884e-d765cda630fa.png)

## 데이터 삽입 후 조회 (select)
![image](https://user-images.githubusercontent.com/84575041/211155795-fc93a838-c5ac-41f3-9e59-6b18f5298f8e.png)

## 삭제 버튼 (delete) - 데이터 1개 삭제
![image](https://user-images.githubusercontent.com/84575041/211155805-1a30a88f-2636-4675-b6c5-dcbc63b6917e.png)

## 데이터 삭제 후 조회 (select)
![image](https://user-images.githubusercontent.com/84575041/211155810-f2fe7ed6-765a-437c-b62d-57a2d83aebe1.png)

## 수정 버튼 (update) - 데이터 1개 수정
![image](https://user-images.githubusercontent.com/84575041/211155814-58a01587-54f6-41fd-bc7f-5635a67969a1.png)

## 데이터 수정 후 조회 (select)
![image](https://user-images.githubusercontent.com/84575041/211155817-6fe97b67-aabd-4db6-80d4-98973a9cee27.png)
