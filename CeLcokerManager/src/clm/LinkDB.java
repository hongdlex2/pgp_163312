package clm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class LinkDB {
	private static Connection con;
	private static Statement st;
	private ResultSet rs;
/*	public LinkDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://localhost:3306/celockermanager?serverTimezone=Asia/Seoul";
        con = DriverManager.getConnection(url,"root","tnghcjstk3");
        
        System.out.println("�����ͺ��̽��� ���������� �����Ͽ����ϴ�.");
        st = con.createStatement();	
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
        
	}
	*/
	public static Connection DBconnect() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://localhost:3306/celockermanager?serverTimezone=Asia/Seoul";
        con = DriverManager.getConnection(url,"root","tnghcjstk3");
        
        System.out.println("�����ͺ��̽��� ���������� �����Ͽ����ϴ�.");
        st = con.createStatement();	
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	
}
