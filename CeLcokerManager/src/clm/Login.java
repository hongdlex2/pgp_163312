package clm;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import java.awt.Choice;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.JToggleButton;
import javax.swing.SpinnerDateModel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DateEditor;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JScrollPane;

public class Login{

	private JFrame frmCelockermanager;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPasswordField passwordField;
	private JTable table;
	private JTable table_1;
	
/*	static Connection con;
	   @SuppressWarnings("deprecation")
	   public Login(String id, String pass) {
	   
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	         String url = "jdbc:mysql://localhost:3306/celockermanager?serverTimezone=Asia/Seoul";
	         con = DriverManager.getConnection(url, id, pass);
	         System.out.println("데이터베이스에 성공적으로 연결하였습니다.");
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	   }
	   
	   public static void getData() {
		   String sql = "select lockernum, state, borrower, startdate, enddate from locker ";
		   
		   try {
			   	PreparedStatement stmt = con.prepareStatement(sql);
			   	ResultSet rs = stmt.executeQuery();
			   	while(rs.next()) { 
			   		String lockernum = rs.getString(1);
			   		String state = rs.getString(2);
			   		String borrower = rs.getString(3);
			   		String startdate = rs.getString(4);
			   		String enddate = rs.getString(5);
			   		
			   		System.out.println(lockernum + " \t| " + state + " \t| " + borrower + " \t| " + startdate + " \t| " + enddate);
			   	}
			   	rs.close();
			   	stmt.close();
		   } catch(Exception e) {
			   e.printStackTrace();
		   }
	   }
	   
	   public static void close() {
		   try {
			   con.close();
		   } catch (Exception e) {
		   }
	   }
*/
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		Login dt = new Login("root", "tnghcjstk3");
		   
//	    Login.getData();
//	    Login.close();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmCelockermanager.setVisible(true);
					
					
					
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	
	
	
	
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCelockermanager = new JFrame();
		frmCelockermanager.setTitle("CeLockerManager");
		frmCelockermanager.setResizable(false);
		frmCelockermanager.setBounds(100, 100, 1093, 788);
		frmCelockermanager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCelockermanager.getContentPane().setLayout(new CardLayout(0, 0));
		Date date = new Date();
		SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		SpinnerDateModel dm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		
		final JPanel panel_1 = new JPanel();
		frmCelockermanager.getContentPane().add(panel_1, "name_6662942471800");
		panel_1.setLayout(new CardLayout(0, 0));
		
		final JPanel loginPage = new JPanel();
		panel_1.add(loginPage, "로그인");
		loginPage.setLayout(null);
		//		loginPage.setVisible(true);
				
				JButton signBtn = new JButton("\uD68C\uC6D0\uAC00\uC785");
				signBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						CardLayout c=(CardLayout)(panel_1.getLayout());
						c.show(panel_1, "회원가입");
					}
				});
				signBtn.setBounds(303, 510, 202, 71);
				loginPage.add(signBtn);
				
	
				
				
				JButton logBtn = new JButton("\uB85C\uADF8\uC778");
				logBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						CardLayout c=(CardLayout)(panel_1.getLayout());
						c.show(panel_1, "메인");
					}
					
				});
				logBtn.setBounds(559, 510, 202, 71);
				loginPage.add(logBtn);
				
				textField = new JTextField();
				textField.setColumns(10);
				textField.setBounds(442, 303, 328, 36);
				loginPage.add(textField);
				
				JLabel lblId = new JLabel("ID");
				lblId.setBounds(326, 312, 90, 18);
				loginPage.add(lblId);
				
				JLabel lblPassword = new JLabel("PASSWORD");
				lblPassword.setBounds(326, 360, 102, 18);
				loginPage.add(lblPassword);
				
				passwordField = new JPasswordField();
				passwordField.setBounds(442, 357, 328, 36);
				loginPage.add(passwordField);
				
				JLabel label_11 = new JLabel("\uB85C\uADF8\uC778");
				label_11.setFont(new Font("굴림", Font.PLAIN, 30));
				label_11.setBounds(14, 12, 169, 35);
				loginPage.add(label_11);
				
				JLabel lblCeLockerManager = new JLabel("CE Locker Manager");
				lblCeLockerManager.setFont(new Font("굴림", Font.PLAIN, 45));
				lblCeLockerManager.setBounds(351, 135, 424, 99);
				loginPage.add(lblCeLockerManager);
		
		JPanel signupPage = new JPanel();
		panel_1.add(signupPage, "회원가입");
		signupPage.setLayout(null);

				
				JButton btnSignup = new JButton("\uD68C\uC6D0\uAC00\uC785");
				btnSignup.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CardLayout c=(CardLayout)(panel_1.getLayout());
						c.show(panel_1, "로그인");
					}
				});
				btnSignup.setBounds(303, 510, 202, 71);
				signupPage.add(btnSignup);
				
				JButton btnCancle = new JButton("\uCDE8\uC18C");
				btnCancle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CardLayout c=(CardLayout)(panel_1.getLayout());
						c.show(panel_1, "로그인");
					}
				});
				btnCancle.setBounds(559, 510, 202, 71);
				signupPage.add(btnCancle);
				
				textField_2 = new JTextField();
				textField_2.setColumns(10);
				textField_2.setBounds(431, 283, 355, 36);
				signupPage.add(textField_2);
				
				textField_3 = new JTextField();
				textField_3.setColumns(10);
				textField_3.setBounds(431, 235, 355, 36);
				signupPage.add(textField_3);
				
				JLabel label = new JLabel("ID");
				label.setBounds(303, 235, 90, 18);
				signupPage.add(label);
				
				JLabel label_1 = new JLabel("PASSWORD");
				label_1.setBounds(303, 283, 102, 18);
				signupPage.add(label_1);
				
				textField_4 = new JTextField();
				textField_4.setColumns(10);
				textField_4.setBounds(431, 331, 355, 36);
				signupPage.add(textField_4);
				
				textField_5 = new JTextField();
				textField_5.setColumns(10);
				textField_5.setBounds(431, 385, 355, 36);
				signupPage.add(textField_5);
				
				JLabel label_2 = new JLabel("\uC774\uB984");
				label_2.setBounds(303, 340, 102, 18);
				signupPage.add(label_2);
				
				JLabel label_3 = new JLabel("\uD559\uBC88");
				label_3.setBounds(303, 394, 102, 18);
				signupPage.add(label_3);
				
				JLabel label_12 = new JLabel("\uD68C\uC6D0\uAC00\uC785");
				label_12.setFont(new Font("굴림", Font.PLAIN, 30));
				label_12.setBounds(14, 12, 169, 35);
				signupPage.add(label_12);
		
		final JPanel mainPage = new JPanel();
		panel_1.add(mainPage, "메인");
		mainPage.setLayout(null);
		

		
		JLabel lblNewLabel = new JLabel("\uC0AC\uBB3C\uD568 \uD604\uD669");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel.setBounds(14, 12, 169, 35);
		mainPage.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\uD68C\uC6D0\uC815\uBCF4\uC218\uC815");
		btnNewButton.setBounds(777, 12, 141, 27);
		mainPage.add(btnNewButton);
		
		JButton btnLogout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c=(CardLayout)(panel_1.getLayout());
				c.show(panel_1, "로그인");
			}
		});
		
		
		btnLogout.setBounds(932, 12, 141, 27);
		mainPage.add(btnLogout);
		
		JButton button_3 = new JButton("\uB300\uC5EC\uD558\uAE30");
		button_3.setBounds(777, 562, 296, 68);
		mainPage.add(button_3);
		
		JButton button_4 = new JButton("\uBC18\uB0A9\uD558\uAE30");
		button_4.setBounds(777, 673, 296, 68);
		mainPage.add(button_4);
		
		JLabel label_4 = new JLabel("\uC120\uD0DD\uD55C \uC0AC\uBB3C\uD568 \uC815\uBCF4");
		label_4.setBounds(14, 532, 185, 18);
		mainPage.add(label_4);
		
		JLabel label_5 = new JLabel("\uB0B4 \uC0AC\uBB3C\uD568 \uC815\uBCF4");
		label_5.setBounds(14, 643, 185, 18);
		mainPage.add(label_5);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(14, 61, 747, 457);
		mainPage.add(panel);
		panel.setLayout(null);
		
		JToggleButton lockerOne = new JToggleButton("0");
		lockerOne.setToolTipText("01");
		lockerOne.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		});
		lockerOne.setBounds(14, 12, 35, 42);
		panel.add(lockerOne);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setToolTipText("Click this button to make something happen.");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(61, 107, 105, 27);
		panel.add(btnNewButton_1);
		
//		Connection conn = null;
		
		String[][] data = new String[][] {{"1","2","3","4","3"},{"5","6","7","8","1"},{"9","1","2","3","1"},{"4","5","6","7","2"}};
		String[] headers = new String[] {"lockernum", "state","borrower","startdate","enddate"};
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(14, 562, 749, 68);
		mainPage.add(scrollPane_1);
		table = new JTable(data, headers);
		scrollPane_1.setViewportView(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 673, 749, 68);
		mainPage.add(scrollPane);
		
		table_1 = new JTable(data,headers);
		scrollPane.setViewportView(table_1);
		
		Choice choice = new Choice();
		choice.setBounds(777, 85, 296, 24);
		mainPage.add(choice);
		
		JLabel label_6 = new JLabel("\uC0AC\uBB3C\uD568 \uC120\uD0DD");
		label_6.setBounds(777, 61, 120, 18);
		mainPage.add(label_6);
		
		JLabel label_7 = new JLabel("\uB300\uC5EC \uC2DC\uC791\uC77C");
		label_7.setBounds(777, 115, 120, 18);
		mainPage.add(label_7);
		
		JLabel label_8 = new JLabel("\uB300\uC5EC \uC885\uB8CC\uC77C");
		label_8.setBounds(777, 223, 120, 18);
		mainPage.add(label_8);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(777, 145, 240, 27);
		mainPage.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(777, 253, 240, 27);
		mainPage.add(dateChooser_1);
		
		JLabel label_10 = new JLabel("\uBD80\uD130");
		label_10.setBounds(1031, 184, 39, 27);
		mainPage.add(label_10);
		
		JLabel label_9 = new JLabel("\uAE4C\uC9C0");
		label_9.setBounds(1031, 292, 39, 27);
		mainPage.add(label_9);
		JSpinner spinner = new JSpinner(sm);					// 기존 j스피너 () 안에 sm 추가 후 위 아래 코드 추가함.
		JSpinner.DateEditor de = new JSpinner.DateEditor(spinner, "HH:mm");
		spinner.setEditor(de);
		
		spinner.setBounds(777, 184, 240, 27);
		mainPage.add(spinner);
		JSpinner spinner_1 = new JSpinner(dm);
		JSpinner.DateEditor ge = new JSpinner.DateEditor(spinner_1, "HH:mm");
		spinner_1.setEditor(ge);
		
		
		spinner_1.setBounds(777, 292, 240, 27);
		mainPage.add(spinner_1);
		
		

	}
}
