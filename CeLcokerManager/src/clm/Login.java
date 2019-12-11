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
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class Login{

	private JFrame frmCelockermanager;
	private JTextField txtID;
	private JTextField pass;
	private JTextField id;
	private JTextField name;
	private JTextField stdnum;
	private JPasswordField txtPass;
	private JTable table;
	private JTable table_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
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
		Student student = new Student();
		Locker locker = new Locker();
		frmCelockermanager = new JFrame();
		frmCelockermanager.setTitle("CeLockerManager");
		frmCelockermanager.setResizable(false);
		frmCelockermanager.setBounds(100, 100, 1260, 791);
		frmCelockermanager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCelockermanager.getContentPane().setLayout(new CardLayout(0, 0));
		Date date = new Date();
		SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		SpinnerDateModel dm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		
		final JPanel panel_1 = new JPanel();
		frmCelockermanager.getContentPane().add(panel_1, "name_6662942471800");
		panel_1.setLayout(new CardLayout(0, 0));
		
		final JPanel loginPage = new JPanel();
		loginPage.setBackground(SystemColor.menu);
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
				signBtn.setBounds(395, 469, 202, 71);
				loginPage.add(signBtn);
				
	
				
				
				JButton logBtn = new JButton("\uB85C\uADF8\uC778");
				logBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						String id = "ghdals1997";
						String pass = "tnghcjstk3";
						
						if(id.equals(txtID.getText())&&pass.equals(txtPass.getText())) {
							txtID.setText("");
							txtPass.setText("");
							JOptionPane.showMessageDialog(null,"로그인 성공");
							CardLayout c=(CardLayout)(panel_1.getLayout());
							c.show(panel_1, "메인");
						} else {
							JOptionPane.showMessageDialog(null,"로그인 실패");
						}
						
						
//						CardLayout c=(CardLayout)(panel_1.getLayout());
//						c.show(panel_1, "메인");
					}
					
				});
				logBtn.setBounds(651, 469, 202, 71);
				loginPage.add(logBtn);
				
				txtID = new JTextField();
				txtID.setColumns(10);
				txtID.setBounds(523, 302, 328, 36);
				loginPage.add(txtID);
				
				JLabel lblId = new JLabel("ID");
				lblId.setBounds(407, 311, 90, 18);
				loginPage.add(lblId);
				
				JLabel lblPassword = new JLabel("PASSWORD");
				lblPassword.setBounds(407, 359, 102, 18);
				loginPage.add(lblPassword);
				
				txtPass = new JPasswordField();
				txtPass.setBounds(523, 356, 328, 36);
				loginPage.add(txtPass);
				
				JLabel label_11 = new JLabel("\uB85C\uADF8\uC778");
				label_11.setFont(new Font("굴림", Font.PLAIN, 30));
				label_11.setBounds(14, 12, 169, 35);
				loginPage.add(label_11);
				
				JLabel lblCeLockerManager = new JLabel("CE Locker Manager");
				lblCeLockerManager.setFont(new Font("굴림", Font.PLAIN, 45));
				lblCeLockerManager.setBounds(430, 134, 421, 99);
				loginPage.add(lblCeLockerManager);
		
		JPanel signupPage = new JPanel();
		panel_1.add(signupPage, "회원가입");
		signupPage.setLayout(null);

				
				JButton btnSignup = new JButton("\uD68C\uC6D0\uAC00\uC785");
				btnSignup.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String idTxt = id.getText();
						String passTxt = pass.getText();
						String nameTxt = name.getText();
						String stdnumTxt = stdnum.getText();
						
						Student.createStudent(stdnumTxt, nameTxt, idTxt, passTxt);
						JOptionPane.showMessageDialog(null, "회인가입이 완료되었습니다. ");
						
						id.setText("");
						pass.setText("");
						name.setText("");
						stdnum.setText("");
						
						CardLayout c=(CardLayout)(panel_1.getLayout());
						c.show(panel_1, "로그인");
					}
				});
				btnSignup.setBounds(399, 501, 202, 71);
				signupPage.add(btnSignup);
				
				JButton btnCancle = new JButton("\uCDE8\uC18C");
				btnCancle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CardLayout c=(CardLayout)(panel_1.getLayout());
						c.show(panel_1, "로그인");
					}
				});
				btnCancle.setBounds(655, 501, 202, 71);
				signupPage.add(btnCancle);
				
				pass = new JTextField();
				pass.setColumns(10);
				pass.setBounds(513, 283, 355, 36);
				signupPage.add(pass);
				
				id = new JTextField();
				id.setColumns(10);
				id.setBounds(513, 235, 355, 36);
				signupPage.add(id);
				
				JLabel label = new JLabel("ID");
				label.setBounds(385, 235, 90, 18);
				signupPage.add(label);
				
				JLabel label_1 = new JLabel("PASSWORD");
				label_1.setBounds(385, 283, 102, 18);
				signupPage.add(label_1);
				
				name = new JTextField();
				name.setColumns(10);
				name.setBounds(513, 331, 355, 36);
				signupPage.add(name);
				
				stdnum = new JTextField();
				stdnum.setColumns(10);
				stdnum.setBounds(513, 385, 355, 36);
				signupPage.add(stdnum);
				
				JLabel label_2 = new JLabel("\uC774\uB984");
				label_2.setBounds(385, 340, 102, 18);
				signupPage.add(label_2);
				
				JLabel label_3 = new JLabel("\uD559\uBC88");
				label_3.setBounds(385, 394, 102, 18);
				signupPage.add(label_3);
				
				JLabel label_12 = new JLabel("\uD68C\uC6D0\uAC00\uC785");
				label_12.setFont(new Font("굴림", Font.PLAIN, 30));
				label_12.setBounds(14, 12, 169, 35);
				signupPage.add(label_12);
		
		final JPanel mainPage = new JPanel();
		panel_1.add(mainPage, "메인");
		mainPage.setLayout(null);
		

		
		JLabel lblNewLabel = new JLabel("\uC0AC\uBB3C\uD568 \uD604\uD669");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblNewLabel.setBounds(14, 12, 232, 35);
		mainPage.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\uD68C\uC6D0\uC815\uBCF4\uC218\uC815");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c=(CardLayout)(panel_1.getLayout());
				c.show(panel_1, "회원정보수정");
			}
		});
		btnNewButton.setBounds(944, 12, 141, 35);
		mainPage.add(btnNewButton);
		
		JButton btnLogout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c=(CardLayout)(panel_1.getLayout());
				c.show(panel_1, "로그인");
			}
		});
		
		
		btnLogout.setBounds(1099, 12, 141, 35);
		mainPage.add(btnLogout);
		
		JButton button_3 = new JButton("\uB300\uC5EC\uD558\uAE30");
		button_3.setBounds(944, 418, 296, 203);
		mainPage.add(button_3);
		
		JButton button_4 = new JButton("\uBC18\uB0A9\uD558\uAE30");
		button_4.setBounds(944, 673, 296, 68);
		mainPage.add(button_4);
		
		JLabel label_5 = new JLabel("\uB0B4 \uC0AC\uBB3C\uD568 \uC815\uBCF4");
		label_5.setFont(new Font("나눔고딕", Font.BOLD, 20));
		label_5.setBounds(14, 634, 185, 27);
		mainPage.add(label_5);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(14, 59, 916, 347);
		mainPage.add(panel);
		panel.setLayout(null);
		
		JToggleButton lockerOne = new JToggleButton("0");
		lockerOne.setEnabled(false);
		lockerOne.setToolTipText("01");
		lockerOne.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		});
		lockerOne.setBounds(14, 59, 35, 42);
		panel.add(lockerOne);
		
		JToggleButton toggleButton = new JToggleButton("0");
		toggleButton.setEnabled(false);
		toggleButton.setToolTipText("01");
		toggleButton.setBounds(49, 59, 35, 42);
		panel.add(toggleButton);
		
		JToggleButton toggleButton_1 = new JToggleButton("0");
		toggleButton_1.setEnabled(false);
		toggleButton_1.setToolTipText("01");
		toggleButton_1.setBounds(85, 59, 35, 42);
		panel.add(toggleButton_1);
		
		JToggleButton toggleButton_2 = new JToggleButton("0");
		toggleButton_2.setEnabled(false);
		toggleButton_2.setToolTipText("01");
		toggleButton_2.setBounds(121, 59, 35, 42);
		panel.add(toggleButton_2);
		
		JToggleButton toggleButton_3 = new JToggleButton("0");
		toggleButton_3.setEnabled(false);
		toggleButton_3.setToolTipText("01");
		toggleButton_3.setBounds(157, 59, 35, 42);
		panel.add(toggleButton_3);
		
		JToggleButton toggleButton_4 = new JToggleButton("0");
		toggleButton_4.setEnabled(false);
		toggleButton_4.setToolTipText("01");
		toggleButton_4.setBounds(14, 101, 35, 42);
		panel.add(toggleButton_4);
		
		JToggleButton toggleButton_5 = new JToggleButton("0");
		toggleButton_5.setEnabled(false);
		toggleButton_5.setToolTipText("01");
		toggleButton_5.setBounds(49, 101, 35, 42);
		panel.add(toggleButton_5);
		
		JToggleButton toggleButton_6 = new JToggleButton("0");
		toggleButton_6.setEnabled(false);
		toggleButton_6.setToolTipText("01");
		toggleButton_6.setBounds(85, 101, 35, 42);
		panel.add(toggleButton_6);
		
		JToggleButton toggleButton_7 = new JToggleButton("0");
		toggleButton_7.setEnabled(false);
		toggleButton_7.setToolTipText("01");
		toggleButton_7.setBounds(121, 101, 35, 42);
		panel.add(toggleButton_7);
		
		JToggleButton toggleButton_8 = new JToggleButton("0");
		toggleButton_8.setEnabled(false);
		toggleButton_8.setToolTipText("01");
		toggleButton_8.setBounds(157, 101, 35, 42);
		panel.add(toggleButton_8);
		
		JToggleButton toggleButton_9 = new JToggleButton("0");
		toggleButton_9.setEnabled(false);
		toggleButton_9.setBackground(Color.YELLOW);
		toggleButton_9.setToolTipText("01");
		toggleButton_9.setBounds(14, 143, 35, 42);
		panel.add(toggleButton_9);
		
		JToggleButton toggleButton_10 = new JToggleButton("0");
		toggleButton_10.setEnabled(false);
		toggleButton_10.setToolTipText("01");
		toggleButton_10.setBounds(49, 143, 35, 42);
		panel.add(toggleButton_10);
		
		JToggleButton toggleButton_11 = new JToggleButton("0");
		toggleButton_11.setEnabled(false);
		toggleButton_11.setToolTipText("01");
		toggleButton_11.setBounds(85, 143, 35, 42);
		panel.add(toggleButton_11);
		
		JToggleButton toggleButton_12 = new JToggleButton("0");
		toggleButton_12.setEnabled(false);
		toggleButton_12.setToolTipText("01");
		toggleButton_12.setBounds(121, 143, 35, 42);
		panel.add(toggleButton_12);
		
		JToggleButton toggleButton_13 = new JToggleButton("0");
		toggleButton_13.setBackground(Color.ORANGE);
		toggleButton_13.setEnabled(false);
		toggleButton_13.setToolTipText("01");
		toggleButton_13.setBounds(157, 143, 35, 42);
		panel.add(toggleButton_13);
		
		JLabel label_13 = new JLabel("01~05");
		label_13.setBounds(206, 71, 62, 18);
		panel.add(label_13);
		
		JLabel label_14 = new JLabel("21~25");
		label_14.setBounds(206, 113, 62, 18);
		panel.add(label_14);
		
		JLabel label_15 = new JLabel("41~45");
		label_15.setBounds(206, 155, 62, 18);
		panel.add(label_15);
		
		JLabel label_16 = new JLabel("06~20");
		label_16.setBounds(840, 71, 62, 18);
		panel.add(label_16);
		
		JLabel label_18 = new JLabel("45~60");
		label_18.setBounds(840, 155, 62, 18);
		panel.add(label_18);
		
		JLabel label_17 = new JLabel("26~40");
		label_17.setBounds(840, 113, 62, 18);
		panel.add(label_17);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(0, 0, 190, 47);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_19 = new JLabel("308");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setBounds(0, 0, 190, 47);
		panel_2.add(label_19);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(191, 0, 144, 47);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblIcsLab = new JLabel("ICS LAB");
		lblIcsLab.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcsLab.setBounds(0, 0, 144, 47);
		panel_3.add(lblIcsLab);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(336, 0, 580, 47);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblAsioLab = new JLabel("ASIO LAB");
		lblAsioLab.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsioLab.setBounds(0, 0, 580, 47);
		panel_4.add(lblAsioLab);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBounds(0, 300, 190, 47);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("307");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 190, 47);
		panel_5.add(lblNewLabel_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.LIGHT_GRAY);
		panel_6.setBounds(191, 300, 144, 47);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("MOS LAB");
		lblNewLabel_2.setBounds(39, 5, 66, 42);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblNewLabel_2);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.LIGHT_GRAY);
		panel_7.setBounds(336, 300, 580, 47);
		panel.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("305");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 0, 580, 47);
		panel_7.add(lblNewLabel_3);
		
		JToggleButton toggleButton_14 = new JToggleButton("0");
		toggleButton_14.setToolTipText("01");
		toggleButton_14.setEnabled(false);
		toggleButton_14.setBounds(267, 59, 35, 42);
		panel.add(toggleButton_14);
		
		JToggleButton toggleButton_15 = new JToggleButton("0");
		toggleButton_15.setToolTipText("01");
		toggleButton_15.setEnabled(false);
		toggleButton_15.setBounds(267, 101, 35, 42);
		panel.add(toggleButton_15);
		
		JToggleButton toggleButton_16 = new JToggleButton("0");
		toggleButton_16.setToolTipText("01");
		toggleButton_16.setEnabled(false);
		toggleButton_16.setBackground(Color.YELLOW);
		toggleButton_16.setBounds(267, 143, 35, 42);
		panel.add(toggleButton_16);
		
		JToggleButton toggleButton_17 = new JToggleButton("0");
		toggleButton_17.setToolTipText("01");
		toggleButton_17.setEnabled(false);
		toggleButton_17.setBounds(302, 143, 35, 42);
		panel.add(toggleButton_17);
		
		JToggleButton toggleButton_18 = new JToggleButton("0");
		toggleButton_18.setToolTipText("01");
		toggleButton_18.setEnabled(false);
		toggleButton_18.setBounds(302, 101, 35, 42);
		panel.add(toggleButton_18);
		
		JToggleButton toggleButton_19 = new JToggleButton("0");
		toggleButton_19.setToolTipText("01");
		toggleButton_19.setEnabled(false);
		toggleButton_19.setBounds(302, 59, 35, 42);
		panel.add(toggleButton_19);
		
		JToggleButton toggleButton_20 = new JToggleButton("0");
		toggleButton_20.setToolTipText("01");
		toggleButton_20.setEnabled(false);
		toggleButton_20.setBounds(338, 59, 35, 42);
		panel.add(toggleButton_20);
		
		JToggleButton toggleButton_21 = new JToggleButton("0");
		toggleButton_21.setToolTipText("01");
		toggleButton_21.setEnabled(false);
		toggleButton_21.setBounds(338, 101, 35, 42);
		panel.add(toggleButton_21);
		
		JToggleButton toggleButton_22 = new JToggleButton("0");
		toggleButton_22.setToolTipText("01");
		toggleButton_22.setEnabled(false);
		toggleButton_22.setBounds(338, 143, 35, 42);
		panel.add(toggleButton_22);
		
		JToggleButton toggleButton_23 = new JToggleButton("0");
		toggleButton_23.setToolTipText("01");
		toggleButton_23.setEnabled(false);
		toggleButton_23.setBounds(374, 143, 35, 42);
		panel.add(toggleButton_23);
		
		JToggleButton toggleButton_24 = new JToggleButton("0");
		toggleButton_24.setToolTipText("01");
		toggleButton_24.setEnabled(false);
		toggleButton_24.setBounds(374, 101, 35, 42);
		panel.add(toggleButton_24);
		
		JToggleButton toggleButton_25 = new JToggleButton("0");
		toggleButton_25.setToolTipText("01");
		toggleButton_25.setEnabled(false);
		toggleButton_25.setBounds(374, 59, 35, 42);
		panel.add(toggleButton_25);
		
		JToggleButton toggleButton_26 = new JToggleButton("0");
		toggleButton_26.setToolTipText("01");
		toggleButton_26.setEnabled(false);
		toggleButton_26.setBounds(410, 59, 35, 42);
		panel.add(toggleButton_26);
		
		JToggleButton toggleButton_27 = new JToggleButton("0");
		toggleButton_27.setToolTipText("01");
		toggleButton_27.setEnabled(false);
		toggleButton_27.setBounds(410, 101, 35, 42);
		panel.add(toggleButton_27);
		
		JToggleButton toggleButton_28 = new JToggleButton("0");
		toggleButton_28.setToolTipText("01");
		toggleButton_28.setEnabled(false);
		toggleButton_28.setBackground(Color.ORANGE);
		toggleButton_28.setBounds(410, 143, 35, 42);
		panel.add(toggleButton_28);
		
		JToggleButton toggleButton_29 = new JToggleButton("0");
		toggleButton_29.setToolTipText("01");
		toggleButton_29.setEnabled(false);
		toggleButton_29.setBounds(459, 59, 35, 42);
		panel.add(toggleButton_29);
		
		JToggleButton toggleButton_30 = new JToggleButton("0");
		toggleButton_30.setToolTipText("01");
		toggleButton_30.setEnabled(false);
		toggleButton_30.setBounds(459, 101, 35, 42);
		panel.add(toggleButton_30);
		
		JToggleButton toggleButton_31 = new JToggleButton("0");
		toggleButton_31.setToolTipText("01");
		toggleButton_31.setEnabled(false);
		toggleButton_31.setBackground(Color.YELLOW);
		toggleButton_31.setBounds(459, 143, 35, 42);
		panel.add(toggleButton_31);
		
		JToggleButton toggleButton_32 = new JToggleButton("0");
		toggleButton_32.setToolTipText("01");
		toggleButton_32.setEnabled(false);
		toggleButton_32.setBounds(494, 143, 35, 42);
		panel.add(toggleButton_32);
		
		JToggleButton toggleButton_33 = new JToggleButton("0");
		toggleButton_33.setToolTipText("01");
		toggleButton_33.setEnabled(false);
		toggleButton_33.setBounds(494, 101, 35, 42);
		panel.add(toggleButton_33);
		
		JToggleButton toggleButton_34 = new JToggleButton("0");
		toggleButton_34.setToolTipText("01");
		toggleButton_34.setEnabled(false);
		toggleButton_34.setBounds(494, 59, 35, 42);
		panel.add(toggleButton_34);
		
		JToggleButton toggleButton_35 = new JToggleButton("0");
		toggleButton_35.setToolTipText("01");
		toggleButton_35.setEnabled(false);
		toggleButton_35.setBounds(530, 59, 35, 42);
		panel.add(toggleButton_35);
		
		JToggleButton toggleButton_36 = new JToggleButton("0");
		toggleButton_36.setToolTipText("01");
		toggleButton_36.setEnabled(false);
		toggleButton_36.setBounds(530, 101, 35, 42);
		panel.add(toggleButton_36);
		
		JToggleButton toggleButton_37 = new JToggleButton("0");
		toggleButton_37.setToolTipText("01");
		toggleButton_37.setEnabled(false);
		toggleButton_37.setBounds(530, 143, 35, 42);
		panel.add(toggleButton_37);
		
		JToggleButton toggleButton_38 = new JToggleButton("0");
		toggleButton_38.setToolTipText("01");
		toggleButton_38.setEnabled(false);
		toggleButton_38.setBounds(566, 143, 35, 42);
		panel.add(toggleButton_38);
		
		JToggleButton toggleButton_39 = new JToggleButton("0");
		toggleButton_39.setToolTipText("01");
		toggleButton_39.setEnabled(false);
		toggleButton_39.setBounds(566, 101, 35, 42);
		panel.add(toggleButton_39);
		
		JToggleButton toggleButton_40 = new JToggleButton("0");
		toggleButton_40.setToolTipText("01");
		toggleButton_40.setEnabled(false);
		toggleButton_40.setBounds(566, 59, 35, 42);
		panel.add(toggleButton_40);
		
		JToggleButton toggleButton_41 = new JToggleButton("0");
		toggleButton_41.setToolTipText("01");
		toggleButton_41.setEnabled(false);
		toggleButton_41.setBounds(602, 59, 35, 42);
		panel.add(toggleButton_41);
		
		JToggleButton toggleButton_42 = new JToggleButton("0");
		toggleButton_42.setToolTipText("01");
		toggleButton_42.setEnabled(false);
		toggleButton_42.setBounds(602, 101, 35, 42);
		panel.add(toggleButton_42);
		
		JToggleButton toggleButton_43 = new JToggleButton("0");
		toggleButton_43.setToolTipText("01");
		toggleButton_43.setEnabled(false);
		toggleButton_43.setBackground(Color.ORANGE);
		toggleButton_43.setBounds(602, 143, 35, 42);
		panel.add(toggleButton_43);
		
		JToggleButton toggleButton_44 = new JToggleButton("0");
		toggleButton_44.setToolTipText("01");
		toggleButton_44.setEnabled(false);
		toggleButton_44.setBounds(648, 59, 35, 42);
		panel.add(toggleButton_44);
		
		JToggleButton toggleButton_45 = new JToggleButton("0");
		toggleButton_45.setToolTipText("01");
		toggleButton_45.setEnabled(false);
		toggleButton_45.setBounds(648, 101, 35, 42);
		panel.add(toggleButton_45);
		
		JToggleButton toggleButton_46 = new JToggleButton("0");
		toggleButton_46.setToolTipText("01");
		toggleButton_46.setEnabled(false);
		toggleButton_46.setBackground(Color.YELLOW);
		toggleButton_46.setBounds(648, 143, 35, 42);
		panel.add(toggleButton_46);
		
		JToggleButton toggleButton_47 = new JToggleButton("0");
		toggleButton_47.setToolTipText("01");
		toggleButton_47.setEnabled(false);
		toggleButton_47.setBounds(683, 143, 35, 42);
		panel.add(toggleButton_47);
		
		JToggleButton toggleButton_48 = new JToggleButton("0");
		toggleButton_48.setToolTipText("01");
		toggleButton_48.setEnabled(false);
		toggleButton_48.setBounds(683, 101, 35, 42);
		panel.add(toggleButton_48);
		
		JToggleButton toggleButton_49 = new JToggleButton("0");
		toggleButton_49.setToolTipText("01");
		toggleButton_49.setEnabled(false);
		toggleButton_49.setBounds(683, 59, 35, 42);
		panel.add(toggleButton_49);
		
		JToggleButton toggleButton_50 = new JToggleButton("0");
		toggleButton_50.setToolTipText("01");
		toggleButton_50.setEnabled(false);
		toggleButton_50.setBounds(719, 59, 35, 42);
		panel.add(toggleButton_50);
		
		JToggleButton toggleButton_51 = new JToggleButton("0");
		toggleButton_51.setToolTipText("01");
		toggleButton_51.setEnabled(false);
		toggleButton_51.setBounds(719, 101, 35, 42);
		panel.add(toggleButton_51);
		
		JToggleButton toggleButton_52 = new JToggleButton("0");
		toggleButton_52.setToolTipText("01");
		toggleButton_52.setEnabled(false);
		toggleButton_52.setBounds(719, 143, 35, 42);
		panel.add(toggleButton_52);
		
		JToggleButton toggleButton_53 = new JToggleButton("0");
		toggleButton_53.setToolTipText("01");
		toggleButton_53.setEnabled(false);
		toggleButton_53.setBounds(755, 143, 35, 42);
		panel.add(toggleButton_53);
		
		JToggleButton toggleButton_54 = new JToggleButton("0");
		toggleButton_54.setToolTipText("01");
		toggleButton_54.setEnabled(false);
		toggleButton_54.setBounds(755, 101, 35, 42);
		panel.add(toggleButton_54);
		
		JToggleButton toggleButton_55 = new JToggleButton("0");
		toggleButton_55.setToolTipText("01");
		toggleButton_55.setEnabled(false);
		toggleButton_55.setBounds(755, 59, 35, 42);
		panel.add(toggleButton_55);
		
		JToggleButton toggleButton_56 = new JToggleButton("0");
		toggleButton_56.setToolTipText("01");
		toggleButton_56.setEnabled(false);
		toggleButton_56.setBounds(791, 59, 35, 42);
		panel.add(toggleButton_56);
		
		JToggleButton toggleButton_57 = new JToggleButton("0");
		toggleButton_57.setToolTipText("01");
		toggleButton_57.setEnabled(false);
		toggleButton_57.setBounds(791, 101, 35, 42);
		panel.add(toggleButton_57);
		
		JToggleButton toggleButton_58 = new JToggleButton("0");
		toggleButton_58.setToolTipText("01");
		toggleButton_58.setEnabled(false);
		toggleButton_58.setBackground(Color.ORANGE);
		toggleButton_58.setBounds(791, 143, 35, 42);
		panel.add(toggleButton_58);
		

		
		String[][] data = locker.getLockers();
		String[] headers = new String[] {"사물함 번호", "대여상태","대여자","대여 시작일","대여 종료일"};
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(14, 418, 916, 202);
		mainPage.add(scrollPane_1);
		table = new JTable(data, headers);
		scrollPane_1.setViewportView(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 673, 916, 68);
		mainPage.add(scrollPane);
		
		table_1 = new JTable(data,headers);
		scrollPane.setViewportView(table_1);
		
		JLabel label_6 = new JLabel("\uC0AC\uBB3C\uD568 \uC120\uD0DD");
		label_6.setFont(new Font("나눔고딕", Font.BOLD, 20));
		label_6.setBounds(944, 71, 120, 18);
		mainPage.add(label_6);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(944, 200, 296, 35);
		mainPage.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(944, 324, 296, 35);
		mainPage.add(dateChooser_1);
		JSpinner spinner = new JSpinner(sm);					// 기존 j스피너 () 안에 sm 추가 후 위 아래 코드 추가함.
		JSpinner.DateEditor de = new JSpinner.DateEditor(spinner, "HH:mm");
		spinner.setEditor(de);
		
		spinner.setBounds(944, 247, 296, 35);
		mainPage.add(spinner);
		JSpinner spinner_1 = new JSpinner(dm);
		JSpinner.DateEditor ge = new JSpinner.DateEditor(spinner_1, "HH:mm");
		spinner_1.setEditor(ge);
		
		
		spinner_1.setBounds(944, 371, 296, 35);
		mainPage.add(spinner_1);
		
		String[] s = Locker.getLockerNum();

 		
		JComboBox comboBox = new JComboBox(s);
		comboBox.setBounds(944, 99, 296, 35);
		mainPage.add(comboBox);
		
		JLabel label_4 = new JLabel("\uB300\uC5EC \uC2DC\uC791\uC77C");
		label_4.setFont(new Font("나눔고딕", Font.BOLD, 20));
		label_4.setBounds(944, 157, 120, 41);
		mainPage.add(label_4);
		
		JLabel label_7 = new JLabel("\uB300\uC5EC \uC885\uB8CC\uC77C");
		label_7.setFont(new Font("나눔고딕", Font.BOLD, 20));
		label_7.setBounds(944, 286, 120, 35);
		mainPage.add(label_7);
		
		JButton button_2 = new JButton("\uC0C8\uB85C\uACE0\uCE68");
		button_2.setBounds(789, 12, 141, 35);
		mainPage.add(button_2);
		
		JPanel changeInfo = new JPanel();
		changeInfo.setLayout(null);
		panel_1.add(changeInfo, "회원정보수정");
		
		JButton button = new JButton("\uC218\uC815\uD558\uAE30");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c=(CardLayout)(panel_1.getLayout());
				c.show(panel_1, "메인");
			}
		});
		button.setBounds(390, 510, 202, 71);
		changeInfo.add(button);
		
		JButton button_1 = new JButton("\uCDE8\uC18C");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c=(CardLayout)(panel_1.getLayout());
				c.show(panel_1, "메인");
			}
		});
		button_1.setBounds(646, 510, 202, 71);
		changeInfo.add(button_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(517, 284, 355, 36);
		changeInfo.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(517, 236, 355, 36);
		changeInfo.add(textField_2);
		
		JLabel label_20 = new JLabel("ID");
		label_20.setBounds(389, 236, 90, 18);
		changeInfo.add(label_20);
		
		JLabel label_21 = new JLabel("PASSWORD");
		label_21.setBounds(389, 284, 102, 18);
		changeInfo.add(label_21);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(517, 332, 355, 36);
		changeInfo.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(517, 386, 355, 36);
		changeInfo.add(textField_4);
		
		JLabel label_22 = new JLabel("\uC774\uB984");
		label_22.setBounds(389, 341, 102, 18);
		changeInfo.add(label_22);
		
		JLabel label_23 = new JLabel("\uD559\uBC88");
		label_23.setBounds(389, 395, 102, 18);
		changeInfo.add(label_23);
		
		JLabel label_24 = new JLabel("\uD68C\uC6D0\uC815\uBCF4\uC218\uC815");
		label_24.setFont(new Font("굴림", Font.PLAIN, 30));
		label_24.setBounds(14, 12, 283, 35);
		changeInfo.add(label_24);
//		comboBox.addItem();
		
		

	}
}
