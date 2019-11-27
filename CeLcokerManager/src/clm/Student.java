package clm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Student {
	public static void main(String[] args) {
		getConnection();
//		createStudent(234567, "��浿", "234567", "234567");
		ArrayList<String> list = getStudents();
		for(String item: list) {
			System.out.println(item);
		}
		
	}
	
	public static ArrayList<String> getStudents(){
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("Select stdnum, name, id, password FROM student");
			ResultSet results = statement.executeQuery();
			ArrayList<String> list = new ArrayList<String>();
			while(results.next()) {
				list.add("stdnum : " + results.getString("stdnum") + 
						" name " + results.getString("name") + 
						" id " + results.getString("id") + 
						" password " + results.getString("password"));
			}
			System.out.println("ȸ�������� �ҷ��Խ��ϴ�.");
			return list;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static void createStudent(int stdnum, String name, String id, String password) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement(""
					+ "INSERT INTO student"
					+ "(stdnum, name, id, password)"
					+ "VALUE"
					+ "('"+stdnum+"','"+name+"','"+id+"','"+password+"')");
				insert.executeUpdate();
				System.out.println("ȸ�������� ��ϵǾ����ϴ�.");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public static void createTable() {
		try {
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Connection getConnection() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/celockermanager?serverTimezone=Asia/Seoul";
			String user = "root";
			String pass = "tnghcjstk3";
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, pass);
			System.out.println("student class : �����ͺ��̽��� ���������� �����Ͽ����ϴ�.");
			return con;
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}

}
