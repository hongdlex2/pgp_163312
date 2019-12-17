package clm;
//
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Locker {
	public static void main(String[] args) {
//		getConnection();
		
//		ArrayList<String> list = getLockers();
//		for(String item: list) {
//			System.out.println(item);
//		}
//		getLockerNum();
		

//		System.out.println(getLockerState(9));
//		getLent(5);
//		getRtnL(10);
		
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
	
	
	public static void getLent(int lockernum, String name ,String startdate, String enddate) {
		try {
			Connection con = getConnection();
			PreparedStatement insertState = con.prepareStatement("UPDATE locker SET state = '대여중' WHERE lockernum='"+lockernum+"'" );
			PreparedStatement insertBorrower = con.prepareStatement("UPDATE locker SET borrower = '"+name+"' WHERE lockernum='"+lockernum+"'" );
			PreparedStatement insertStart = con.prepareStatement("UPDATE locker SET startdate = '"+startdate+"' WHERE lockernum='"+lockernum+"'" );
			PreparedStatement insertEnd = con.prepareStatement("UPDATE locker SET enddate = '"+enddate+"' WHERE lockernum='"+lockernum+"'" );
				insertState.executeUpdate();
				insertBorrower.executeUpdate();
				insertStart.executeUpdate();
				insertEnd.executeUpdate();
//				System.out.println("회원정보가 등록되었습니다.");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		
		}
	}
	
	public static void getRtnL(int num) {
		try {
			Connection con = getConnection();
			PreparedStatement resetState = con.prepareStatement("UPDATE locker SET state = '대여가능' WHERE lockernum='"+num+"'" );
			PreparedStatement resetBorrower = con.prepareStatement("UPDATE locker SET borrower = null WHERE lockernum='"+num+"'" );
			PreparedStatement resetStartdate = con.prepareStatement("UPDATE locker SET startdate = null WHERE lockernum='"+num+"'" );
			PreparedStatement resetEnddate = con.prepareStatement("UPDATE locker SET enddate = null WHERE lockernum='"+num+"'" );
			
			
			resetBorrower.executeUpdate();
			resetState.executeUpdate();
			resetStartdate.executeUpdate();
			resetEnddate.executeUpdate();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
		
	}
	
	
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
			System.out.println("사물함 정보를 불러왔습니다.");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static String[][] getMyLocker(String name){
		try {
			System.out.println(name);
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("Select lockernum, state, borrower, startdate, enddate FROM locker WHERE borrower ='"+name+"'");
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
				
			}
			System.out.println("내 사물함 정보를 불러왔습니다.");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static int getLockerState(int num) {
		String lent = "대여중";
		int numb = 0;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("Select state From locker Where lockernum="+num);
			ResultSet results = statement.executeQuery();
			
			while(results.first()) {
				String lockerState = results.getString("state");
	//			System.out.println(lockerState);

					if(lockerState.equals(lent)) {
//						System.out.println(lockerState);
//						System.out.println("리턴 1을 합니다.");
//						return 1;
						numb = 1;
						break;		
					} else {
//						System.out.println(lockerState);
//						System.out.println("리턴 0을 합니다.");
//						return 0;
						numb = 0;
						break;
					}		
			}
			con.close();
			statement.close();
			results.close();
			return numb;
		} catch (Exception e) {
			
			e.printStackTrace();

		}
		return 2;
	}
	
	
	public static String[] getLockerNum() {
		int cnt =0;
		String[] rtn = new String[60];
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("Select lockernum From locker");
			ResultSet results = statement.executeQuery();
			
			while(results.next()) {
				String lockerNumber = results.getString("lockernum");
				rtn[cnt] = lockerNumber;
				cnt = cnt+1;
//				System.out.println(lockerNumber);
			}
			return rtn;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rtn;
		
	}
	
	
	public static Connection getConnection() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/celockermanager?serverTimezone=Asia/Seoul";
			String user = "root";
			String pass = "tnghcjstk3";
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, pass);
//			System.out.println("Locker class : 데이터베이스에 성공적으로 연결하였습니다.");
			return con;
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}

}
