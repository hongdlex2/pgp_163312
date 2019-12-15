package clm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JTextField;

public class Student {
	public static void main(String[] args) {
//		getConnection();
//		createStudent(234567, "김길동", "234567", "234567");
//		ArrayList<String> list = getStudents();
//		for(String item: list) {
//			System.out.println(item);
//		}
		
//		getLogin("163312","163312");
//		System.out.println(getLogin("163312","163312"));
//		System.out.println(getId("163312"));
//		System.out.println(checkEmpty("163399"));
//		checkEmpty("163399","10");
//		System.out.println(getRtn("163312"));
//		updateStudent("888888","test02","test02","test02","test001");
		System.out.println(rtnPass("163312"));
		System.out.println(rtnName("163312"));
		System.out.println(rtnStdnum("163312"));
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
			System.out.println("회원정보를 불러왔습니다.");
			return list;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static void createStudent(String stdnum, String name, String id, String password) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement(""
					+ "INSERT INTO student"
					+ "(stdnum, name, id, password)"
					+ "VALUE"
					+ "('"+stdnum+"','"+name+"','"+id+"','"+password+"')");
				insert.executeUpdate();
				System.out.println("회원정보가 등록되었습니다.");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void updateStudent(String stdnum, String name, String id, String password,     String checkId) {
		try {
			Connection con = getConnection();
			PreparedStatement updateStdnum = con.prepareStatement("UPDATE student SET stdnum = '"+stdnum+"' WHERE id='"+checkId+"'" );
			updateStdnum.executeUpdate();
			PreparedStatement updateName = con.prepareStatement("UPDATE student SET name = '"+name+"' WHERE id='"+checkId+"'" );
			updateName.executeUpdate();
			PreparedStatement updatePass = con.prepareStatement("UPDATE student SET password = '"+password+"' WHERE id='"+checkId+"'" );
			updatePass.executeUpdate();
			PreparedStatement updateId = con.prepareStatement("UPDATE student SET id = '"+id+"' WHERE id='"+checkId+"'" );
			updateId.executeUpdate();
			
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static int getLogin(String id, String password) {
		 
		try {
			Connection con = getConnection();
			PreparedStatement login = con.prepareStatement("SELECT * FROM student");
			ResultSet results = login.executeQuery();
			
			while (results.next()) {
				if(results.getString("id").equals(id)&&results.getString("password").equals(password)){
					System.out.println("로그인 성공");
					return 1;
				} else {
					System.out.println("매칭중");
				}

			}
				
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
		return 0;
	}
	
	public static String getId(String id, int num) {
		try {
			Connection con = getConnection();
			PreparedStatement login = con.prepareStatement("SELECT name FROM student WHERE id ='"+id+"'");
			ResultSet results = login.executeQuery();
			PreparedStatement insertBrwLockNum = con.prepareStatement("UPDATE student SET brwLockNum = '"+num+"' WHERE id='"+id+"'" );
			insertBrwLockNum.executeUpdate();
			
			while(results.next()) {
				String getID = results.getString("name");
				System.out.println(getID);
				return getID;
			}
	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String rtnPass(String id) {
		try {
			Connection con = getConnection();
			PreparedStatement login = con.prepareStatement("SELECT password FROM student WHERE id ='"+id+"'");
			ResultSet results = login.executeQuery();
			
			while(results.next()) {
				String getPass = results.getString("password");
				System.out.println(getPass);
				return getPass;
			}
	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String rtnName(String id) {
		try {
			Connection con = getConnection();
			PreparedStatement login = con.prepareStatement("SELECT name FROM student WHERE id ='"+id+"'");
			ResultSet results = login.executeQuery();
			
			while(results.next()) {
				String getPass = results.getString("name");
				System.out.println(getPass);
				return getPass;
			}
	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String rtnStdnum(String id) {
		try {
			Connection con = getConnection();
			PreparedStatement login = con.prepareStatement("SELECT stdnum FROM student WHERE id ='"+id+"'");
			ResultSet results = login.executeQuery();
			
			while(results.next()) {
				String getPass = results.getString("stdnum");
				System.out.println(getPass);
				return getPass;
			}
	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static int checkEmpty(String id) {
		String empty = "0";
		try {
			Connection con = getConnection();
			PreparedStatement check = con.prepareStatement("SELECT brwLockNum FROM student WHERE id ='"+id+"' ");
			ResultSet results = check.executeQuery();
			
			//로그인 할때 사용한 아이디를 받아서 그 아이디의 brwLockNum이  0이나 null값이 아니면 반납먼저(0리턴), 그렇지 않으면, 대여가능 1리턴
			
			while (results.next()) {
				if(!results.getString("brwLockNum").equals(empty)){
					System.out.println("이미 대여중인 사물함이 있습니다. 먼저 반납해주세요.");
					return 1;
				} else {
					System.out.println("탐색중...");
				}

			}
				
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
//		System.out.println("대여가능합니다.");
		return 0;
	}
	
	public static int getRtnS(String id) {
		String empty = "0";
		String backupLocknum = null;
		
		
		try {
			Connection con = getConnection();
			PreparedStatement check = con.prepareStatement("SELECT brwLockNum FROM student WHERE id ='"+id+"'");
			ResultSet results = check.executeQuery();
			
			while (results.next()) {
				if(!results.getString("brwLockNum").equals(empty)){
					backupLocknum = results.getString("brwLockNum");
					break;
				} else {
					System.out.println("탐색중...");
				}
			
			}
		
			int rtnNum = Integer.parseInt(backupLocknum);
			//업데이트
			PreparedStatement resetLocker = con.prepareStatement("UPDATE student SET brwLockNum = 0 WHERE id='"+id+"'" );
			resetLocker.executeUpdate();
			return rtnNum;
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
		return 0;
	}
	
	
	
	public static Connection getConnection() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/celockermanager?serverTimezone=Asia/Seoul";
			String user = "root";
			String pass = "tnghcjstk3";
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, pass);
			System.out.println("student class : 데이터베이스에 성공적으로 연결하였습니다.");
			return con;
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}

}
