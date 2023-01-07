package test;

/*
  
 SQL> desc cafe;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 CODE                                      NOT NULL CHAR(6)
 NAME                                               VARCHAR2(20)
 PRICE                                     NOT NULL NUMBER
 COUNT                                              NUMBER

 */

// 데이터 담당 클래스

public class Data {
	String code;
	String name;
	int price;
	int count;
	
	public Data() {
		
	}
	
	public Data(int price, String code) {
		this.code = code;
		this.price = price;
	}
	
	public Data(String code, String name, int price, int count) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.count = count;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	

}
