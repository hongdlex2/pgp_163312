package clm;

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
		

//		System.out.println(getLockerState(1));
		
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
	
	public static int getLockerState(int num) {
		String lent = "대여중";
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("Select state From locker Where lockernum="+num);
			ResultSet results = statement.executeQuery();
			
			while(results.first()) {
				String lockerState = results.getString("state");
				System.out.println(lockerState);

					if(lockerState.equals(lent)) {
						System.out.println(lockerState);
						System.out.println("리턴 1을 합니다.");
						return 1;
					} else {
						System.out.println(lockerState);
						System.out.println("리턴 0을 합니다.");
						return 0;
					}
			}
				
			
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
				System.out.println(lockerNumber);
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
			System.out.println("Locker class : 데이터베이스에 성공적으로 연결하였습니다.");
			return con;
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}

}
