package clm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Locker {
/*	public static void main(String[] args) {
		getConnection();
		
		ArrayList<String> list = getLockers();
		for(String item: list) {
			System.out.println(item);
		}
		
	}
*/	
	public static String[][] getLockers(){
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("Select lockernum, state, borrower, startdate, enddate FROM locker");
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()) {
				list.add(new String[]{
					results.getString("lockernum"),
					results.getString("state"),
					results.getString("borrower"),
					results.getString("startdate"),
					results.getString("enddate")
				});
				
				
/*				list.add("lockernum : " + results.getString("lockernum") + 
						" state " + results.getString("state") + 
						" borrower " + results.getString("borrower") + 
						" startdate " + results.getString("startdate") + 
						" enddate " + results.getString("enddate") 
						);
*/	
			}
			System.out.println("�繰�� ������ �ҷ��Խ��ϴ�.");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
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
			System.out.println("Locker class : �����ͺ��̽��� ���������� �����Ͽ����ϴ�.");
			return con;
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}

}
