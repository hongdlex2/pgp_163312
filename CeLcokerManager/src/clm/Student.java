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
//		createStudent(234567, "��浿", "234567", "234567");
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
			System.out.println("ȸ�������� �ҷ��Խ��ϴ�.");
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
				System.out.println("ȸ�������� ��ϵǾ����ϴ�.");
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
					System.out.println("�α��� ����");
					return 1;
				} else {
					System.out.println("��Ī��");
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
			
			//�α��� �Ҷ� ����� ���̵� �޾Ƽ� �� ���̵��� brwLockNum��  0�̳� null���� �ƴϸ� �ݳ�����(0����), �׷��� ������, �뿩���� 1����
			
			while (results.next()) {
				if(!results.getString("brwLockNum").equals(empty)){
					System.out.println("�̹� �뿩���� �繰���� �ֽ��ϴ�. ���� �ݳ����ּ���.");
					return 1;
				} else {
					System.out.println("Ž����...");
				}

			}
				
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
//		System.out.println("�뿩�����մϴ�.");
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
					System.out.println("Ž����...");
				}
			
			}
		
			int rtnNum = Integer.parseInt(backupLocknum);
			//������Ʈ
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
			System.out.println("student class : �����ͺ��̽��� ���������� �����Ͽ����ϴ�.");
			return con;
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}

}
