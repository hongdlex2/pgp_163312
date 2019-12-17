package clm;
//
import java.awt.EventQueue;
import java.sql.*;
import java.text.DateFormat;

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
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import javax.swing.SwingConstants;
//
public class Login{

	private JFrame frmCelockermanager;
	private JTextField txtID;
	private JTextField pass;
	private JTextField id;
	private JTextField name;
	private JTextField stdnum;
	private JPasswordField txtPass;
	private JTable allStateTable;
	private JTable myStateTable;
	private JTextField chPass;
	private JTextField chId;
	private JTextField chName;
	private JTextField chStdnum;
	private String idd;
	private String[][] data;
	private String[][] data2;
	private String[] headers;
	private DefaultTableModel model;
	private DefaultTableModel model2;
	private String mylocker;
	private String startDate;
	private String endDate;
	private String startDate2;
	private String endDate2;
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
		final Student student = new Student();
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

						
						
						idd = txtID.getText();
						String pass = txtPass.getText();
						
						int checkNum = Student.getLogin(idd, pass);
						
						if(checkNum ==1 ) {
							JOptionPane.showMessageDialog(null,"로그인 성공");
							txtID.setText("");
							txtPass.setText("");
							

							
							CardLayout c=(CardLayout)(panel_1.getLayout());
							c.show(panel_1, "메인");
						} else {
							JOptionPane.showMessageDialog(null,"로그인 실패");
							txtID.setText("");
							txtPass.setText("");
						}
						
						

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
				String one = Student.rtnPass(idd);
				String two = Student.rtnName(idd);
				String three = Student.rtnStdnum(idd);
				
				
				chId.setText(idd);
				chPass.setText(one);
				chName.setText(two);
				chStdnum.setText(three);
				
				CardLayout c=(CardLayout)(panel_1.getLayout());
				c.show(panel_1, "회원정보수정");
			}
		});
		btnNewButton.setBounds(944, 12, 141, 35);
		mainPage.add(btnNewButton);
		
		JButton btnLogout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "성공적으로 로그아웃하였습니다.");
				CardLayout c=(CardLayout)(panel_1.getLayout());
				c.show(panel_1, "로그인");
			}
		});
		
		
		btnLogout.setBounds(1099, 12, 141, 35);
		mainPage.add(btnLogout);
		
		JLabel label_5 = new JLabel("\uB0B4 \uC0AC\uBB3C\uD568 \uC815\uBCF4");
		label_5.setFont(new Font("나눔고딕", Font.BOLD, 20));
		label_5.setBounds(14, 634, 185, 27);
		mainPage.add(label_5);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(14, 59, 916, 347);
		mainPage.add(panel);
		panel.setLayout(null);
		
		final JToggleButton locker1 = new JToggleButton("0");
		locker1.setEnabled(false);
		locker1.setToolTipText("1");
		locker1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		});
		locker1.setBounds(14, 59, 35, 42);
		panel.add(locker1);
		
		final JToggleButton locker2 = new JToggleButton("0");
		locker2.setEnabled(false);
		locker2.setToolTipText("2");
		locker2.setBounds(49, 59, 35, 42);
		panel.add(locker2);
		
		final JToggleButton locker3 = new JToggleButton("0");
		locker3.setEnabled(false);
		locker3.setToolTipText("3");
		locker3.setBounds(85, 59, 35, 42);
		panel.add(locker3);
		
		final JToggleButton locker4 = new JToggleButton("0");
		locker4.setEnabled(false);
		locker4.setToolTipText("4");
		locker4.setBounds(121, 59, 35, 42);
		panel.add(locker4);
		
		final JToggleButton locker5 = new JToggleButton("0");
		locker5.setEnabled(false);
		locker5.setToolTipText("5");
		locker5.setBounds(157, 59, 35, 42);
		panel.add(locker5);
		
		final JToggleButton locker21 = new JToggleButton("0");
		locker21.setEnabled(false);
		locker21.setToolTipText("21");
		locker21.setBounds(14, 101, 35, 42);
		panel.add(locker21);
		
		final JToggleButton locker22 = new JToggleButton("0");
		locker22.setEnabled(false);
		locker22.setToolTipText("22");
		locker22.setBounds(49, 101, 35, 42);
		panel.add(locker22);
		
		final JToggleButton locker23 = new JToggleButton("0");
		locker23.setEnabled(false);
		locker23.setToolTipText("23");
		locker23.setBounds(85, 101, 35, 42);
		panel.add(locker23);
		
		final JToggleButton locker24 = new JToggleButton("0");
		locker24.setEnabled(false);
		locker24.setToolTipText("24");
		locker24.setBounds(121, 101, 35, 42);
		panel.add(locker24);
		
		final JToggleButton locker25 = new JToggleButton("0");
		locker25.setEnabled(false);
		locker25.setToolTipText("25");
		locker25.setBounds(157, 101, 35, 42);
		panel.add(locker25);
		
		final JToggleButton locker41 = new JToggleButton("0");
		locker41.setEnabled(false);
		locker41.setToolTipText("41");
		locker41.setBounds(14, 143, 35, 42);
		panel.add(locker41);
		
		final JToggleButton locker42 = new JToggleButton("0");
		locker42.setEnabled(false);
		locker42.setToolTipText("42");
		locker42.setBounds(49, 143, 35, 42);
		panel.add(locker42);
		
		final JToggleButton locker43 = new JToggleButton("0");
		locker43.setEnabled(false);
		locker43.setToolTipText("43");
		locker43.setBounds(85, 143, 35, 42);
		panel.add(locker43);
		
		final JToggleButton locker44 = new JToggleButton("0");
		locker44.setEnabled(false);
		locker44.setToolTipText("44");
		locker44.setBounds(121, 143, 35, 42);
		panel.add(locker44);
		
		final JToggleButton locker45 = new JToggleButton("0");
		locker45.setEnabled(false);
		locker45.setToolTipText("45");
		locker45.setBounds(157, 143, 35, 42);
		panel.add(locker45);
		
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
		
		final JToggleButton locker6 = new JToggleButton("0");
		locker6.setToolTipText("6");
		locker6.setEnabled(false);
		locker6.setBounds(267, 59, 35, 42);
		panel.add(locker6);
		
		final JToggleButton locker26 = new JToggleButton("0");
		locker26.setToolTipText("26");
		locker26.setEnabled(false);
		locker26.setBounds(267, 101, 35, 42);
		panel.add(locker26);
		
		final JToggleButton locker46 = new JToggleButton("0");
		locker46.setToolTipText("46");
		locker46.setEnabled(false);
		locker46.setBounds(267, 143, 35, 42);
		panel.add(locker46);
		
		final JToggleButton locker47 = new JToggleButton("0");
		locker47.setToolTipText("47");
		locker47.setEnabled(false);
		locker47.setBounds(302, 143, 35, 42);
		panel.add(locker47);
		
		final JToggleButton locker27 = new JToggleButton("0");
		locker27.setToolTipText("27");
		locker27.setEnabled(false);
		locker27.setBounds(302, 101, 35, 42);
		panel.add(locker27);
		
		final JToggleButton locker7 = new JToggleButton("0");
		locker7.setToolTipText("7");
		locker7.setEnabled(false);
		locker7.setBounds(302, 59, 35, 42);
		panel.add(locker7);
		
		final JToggleButton locker8 = new JToggleButton("0");
		locker8.setToolTipText("8");
		locker8.setEnabled(false);
		locker8.setBounds(338, 59, 35, 42);
		panel.add(locker8);
		
		final JToggleButton locker28 = new JToggleButton("0");
		locker28.setToolTipText("28");
		locker28.setEnabled(false);
		locker28.setBounds(338, 101, 35, 42);
		panel.add(locker28);
		
		final JToggleButton locker48 = new JToggleButton("0");
		locker48.setToolTipText("48");
		locker48.setEnabled(false);
		locker48.setBounds(338, 143, 35, 42);
		panel.add(locker48);
		
		final JToggleButton locker49 = new JToggleButton("0");
		locker49.setToolTipText("49");
		locker49.setEnabled(false);
		locker49.setBounds(374, 143, 35, 42);
		panel.add(locker49);
		
		final JToggleButton locker29 = new JToggleButton("0");
		locker29.setToolTipText("29");
		locker29.setEnabled(false);
		locker29.setBounds(374, 101, 35, 42);
		panel.add(locker29);
		
		final JToggleButton locker9 = new JToggleButton("0");
		locker9.setToolTipText("9");
		locker9.setEnabled(false);
		locker9.setBounds(374, 59, 35, 42);
		panel.add(locker9);
		
		final JToggleButton locker10 = new JToggleButton("0");
		locker10.setToolTipText("10");
		locker10.setEnabled(false);
		locker10.setBounds(410, 59, 35, 42);
		panel.add(locker10);
		
		final JToggleButton locker30 = new JToggleButton("0");
		locker30.setToolTipText("30");
		locker30.setEnabled(false);
		locker30.setBounds(410, 101, 35, 42);
		panel.add(locker30);
		
		final JToggleButton locker50 = new JToggleButton("0");
		locker50.setToolTipText("50");
		locker50.setEnabled(false);
		locker50.setBounds(410, 143, 35, 42);
		panel.add(locker50);
		
		final JToggleButton locker11 = new JToggleButton("0");
		locker11.setToolTipText("11");
		locker11.setEnabled(false);
		locker11.setBounds(459, 59, 35, 42);
		panel.add(locker11);
		
		final JToggleButton locker31 = new JToggleButton("0");
		locker31.setToolTipText("31");
		locker31.setEnabled(false);
		locker31.setBounds(459, 101, 35, 42);
		panel.add(locker31);
		
		final JToggleButton locker51 = new JToggleButton("0");
		locker51.setToolTipText("51");
		locker51.setEnabled(false);
		locker51.setBounds(459, 143, 35, 42);
		panel.add(locker51);
		
		final JToggleButton locker52 = new JToggleButton("0");
		locker52.setToolTipText("52");
		locker52.setEnabled(false);
		locker52.setBounds(494, 143, 35, 42);
		panel.add(locker52);
		
		final JToggleButton locker32 = new JToggleButton("0");
		locker32.setToolTipText("32");
		locker32.setEnabled(false);
		locker32.setBounds(494, 101, 35, 42);
		panel.add(locker32);
		
		final JToggleButton locker12 = new JToggleButton("0");
		locker12.setToolTipText("12");
		locker12.setEnabled(false);
		locker12.setBounds(494, 59, 35, 42);
		panel.add(locker12);
		
		final JToggleButton locker13 = new JToggleButton("0");
		locker13.setToolTipText("13");
		locker13.setEnabled(false);
		locker13.setBounds(530, 59, 35, 42);
		panel.add(locker13);
		
		final JToggleButton locker33 = new JToggleButton("0");
		locker33.setToolTipText("33");
		locker33.setEnabled(false);
		locker33.setBounds(530, 101, 35, 42);
		panel.add(locker33);
		
		final JToggleButton locker53 = new JToggleButton("0");
		locker53.setToolTipText("53");
		locker53.setEnabled(false);
		locker53.setBounds(530, 143, 35, 42);
		panel.add(locker53);
		
		final JToggleButton locker54 = new JToggleButton("0");
		locker54.setToolTipText("54");
		locker54.setEnabled(false);
		locker54.setBounds(566, 143, 35, 42);
		panel.add(locker54);
		
		final JToggleButton locker34 = new JToggleButton("0");
		locker34.setToolTipText("34");
		locker34.setEnabled(false);
		locker34.setBounds(566, 101, 35, 42);
		panel.add(locker34);
		
		final JToggleButton locker14 = new JToggleButton("0");
		locker14.setToolTipText("14");
		locker14.setEnabled(false);
		locker14.setBounds(566, 59, 35, 42);
		panel.add(locker14);
		
		final JToggleButton locker15 = new JToggleButton("0");
		locker15.setToolTipText("15");
		locker15.setEnabled(false);
		locker15.setBounds(602, 59, 35, 42);
		panel.add(locker15);
		
		final JToggleButton locker35 = new JToggleButton("0");
		locker35.setToolTipText("35");
		locker35.setEnabled(false);
		locker35.setBounds(602, 101, 35, 42);
		panel.add(locker35);
		
		final JToggleButton locker55 = new JToggleButton("0");
		locker55.setToolTipText("55");
		locker55.setEnabled(false);
		locker55.setBounds(602, 143, 35, 42);
		panel.add(locker55);
		
		final JToggleButton locker16 = new JToggleButton("0");
		locker16.setToolTipText("16");
		locker16.setEnabled(false);
		locker16.setBounds(648, 59, 35, 42);
		panel.add(locker16);
		
		final JToggleButton locker36 = new JToggleButton("0");
		locker36.setToolTipText("36");
		locker36.setEnabled(false);
		locker36.setBounds(648, 101, 35, 42);
		panel.add(locker36);
		
		final JToggleButton locker56 = new JToggleButton("0");
		locker56.setToolTipText("56");
		locker56.setEnabled(false);
		locker56.setBounds(648, 143, 35, 42);
		panel.add(locker56);
		
		final JToggleButton locker57 = new JToggleButton("0");
		locker57.setToolTipText("57");
		locker57.setEnabled(false);
		locker57.setBounds(683, 143, 35, 42);
		panel.add(locker57);
		
		final JToggleButton locker37 = new JToggleButton("0");
		locker37.setToolTipText("37");
		locker37.setEnabled(false);
		locker37.setBounds(683, 101, 35, 42);
		panel.add(locker37);
		
		final JToggleButton locker17 = new JToggleButton("0");
		locker17.setToolTipText("17");
		locker17.setEnabled(false);
		locker17.setBounds(683, 59, 35, 42);
		panel.add(locker17);
		
		final JToggleButton locker18 = new JToggleButton("0");
		locker18.setToolTipText("18");
		locker18.setEnabled(false);
		locker18.setBounds(719, 59, 35, 42);
		panel.add(locker18);
		
		final JToggleButton locker38 = new JToggleButton("0");
		locker38.setToolTipText("38");
		locker38.setEnabled(false);
		locker38.setBounds(719, 101, 35, 42);
		panel.add(locker38);
		
		final JToggleButton locker58 = new JToggleButton("0");
		locker58.setToolTipText("58");
		locker58.setEnabled(false);
		locker58.setBounds(719, 143, 35, 42);
		panel.add(locker58);
		
		final JToggleButton locker59 = new JToggleButton("0");
		locker59.setToolTipText("59");
		locker59.setEnabled(false);
		locker59.setBounds(755, 143, 35, 42);
		panel.add(locker59);
		
		final JToggleButton locker39 = new JToggleButton("0");
		locker39.setToolTipText("39");
		locker39.setEnabled(false);
		locker39.setBounds(755, 101, 35, 42);
		panel.add(locker39);
		
		final JToggleButton locker19 = new JToggleButton("0");
		locker19.setToolTipText("19");
		locker19.setEnabled(false);
		locker19.setBounds(755, 59, 35, 42);
		panel.add(locker19);
		
		final JToggleButton locker20 = new JToggleButton("0");
		locker20.setToolTipText("20");
		locker20.setEnabled(false);
		locker20.setBounds(791, 59, 35, 42);
		panel.add(locker20);
		
		final JToggleButton locker40 = new JToggleButton("0");
		locker40.setToolTipText("40");
		locker40.setEnabled(false);
		locker40.setBounds(791, 101, 35, 42);
		panel.add(locker40);
		
		final JToggleButton locker60 = new JToggleButton("0");
		locker60.setToolTipText("60");
		locker60.setEnabled(false);

		locker60.setBounds(791, 143, 35, 42);
		panel.add(locker60);
		
		JToggleButton toggleButton = new JToggleButton("0");
		toggleButton.setBackground(Color.GREEN);
		toggleButton.setToolTipText("01");
		toggleButton.setEnabled(false);
		toggleButton.setBounds(697, 246, 35, 42);
		panel.add(toggleButton);
		
		JToggleButton toggleButton_1 = new JToggleButton("0");
		toggleButton_1.setBackground(Color.RED);
		toggleButton_1.setToolTipText("01");
		toggleButton_1.setEnabled(false);
		toggleButton_1.setBounds(804, 246, 35, 42);
		panel.add(toggleButton_1);
		
		JLabel label_8 = new JLabel("\uB300\uC5EC\uC911");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(840, 258, 62, 18);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("\uB300\uC5EC\uAC00\uB2A5");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(732, 258, 62, 18);
		panel.add(label_9);
		

		
		
		
		JLabel label_6 = new JLabel("\uC0AC\uBB3C\uD568 \uC120\uD0DD");
		label_6.setFont(new Font("나눔고딕", Font.BOLD, 20));
		label_6.setBounds(944, 71, 120, 18);
		mainPage.add(label_6);
		
		final JDateChooser dateChooser = new JDateChooser(); 
		dateChooser.setBounds(944, 200, 296, 35);
		mainPage.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(944, 324, 296, 35);
		mainPage.add(dateChooser_1);
		final JSpinner startSpin = new JSpinner(sm);					// 기존 j스피너 () 안에 sm 추가 후 위 아래 코드 추가함.
		JSpinner.DateEditor de_startSpin = new JSpinner.DateEditor(startSpin, "HH:mm");
		startSpin.setEditor(de_startSpin);
		
		startSpin.setBounds(944, 247, 296, 35);
		mainPage.add(startSpin);
		JSpinner endSpin = new JSpinner(dm);
		JSpinner.DateEditor de_endSpin = new JSpinner.DateEditor(endSpin, "HH:mm");
		endSpin.setEditor(de_endSpin);
		
		
		endSpin.setBounds(944, 371, 296, 35);
		mainPage.add(endSpin);
		
		String[] s = Locker.getLockerNum();

 		
		final JComboBox comboBox = new JComboBox(s);
		comboBox.setBounds(944, 99, 296, 35);
		mainPage.add(comboBox);
		
		JButton button_3 = new JButton("\uB300\uC5EC\uD558\uAE30");
		button_3.setFont(new Font("나눔고딕", Font.BOLD, 20));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				startDate  = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
				System.out.println(startDate);
				endDate  = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
				System.out.println(endDate);
				
				String locknum = comboBox.getSelectedItem().toString();
				int stringToint = Integer.parseInt(locknum);
				
				
				if(startDate.equals("")&&endDate.equals("")) {
					JOptionPane.showMessageDialog(null, "대여날짜를 먼저 선택해주세요.");
					
				} else {
					if(Locker.getLockerState(stringToint) == 1) {
					JOptionPane.showMessageDialog(null, "선택한 사물함은 이미 대여중입니다.");
				} else if(Locker.getLockerState(stringToint) != 1){
					if(student.checkEmpty(idd) == 1) {
						JOptionPane.showMessageDialog(null, "이미 대여중인 사물함이 있습니다.\n 먼저 반납해주세요.");
					}
					if(student.checkEmpty(idd) == 0) {
						Locker.getLent(stringToint, student.getId(idd,stringToint), startDate, endDate);
						JOptionPane.showMessageDialog(null, "사물함을 대여하였습니다.");
						
						startDate = "";
						endDate = "";
						data = Locker.getLockers();
						model = new DefaultTableModel(data,headers);
						
						
						
						mylocker = student.rtnName(idd);
						
						data2 = Locker.getMyLocker(mylocker);
						
						model2 = new DefaultTableModel(data2,headers);
						
						allStateTable.repaint();
						allStateTable.revalidate();
						model.fireTableDataChanged();
						allStateTable.setModel(model);
						
						myStateTable.repaint();
						myStateTable.revalidate();
						model2.fireTableDataChanged();
						myStateTable.setModel(model2);
					}
					
				}
				
				
				
				
					
				}


				
				allStateTable.repaint();
				allStateTable.revalidate();
				model.fireTableDataChanged();
				allStateTable.setModel(model);
				
				myStateTable.repaint();
				myStateTable.revalidate();
				model2.fireTableDataChanged();
				myStateTable.setModel(model2);

				

				if(Locker.getLockerState(1)==1) {
					locker1.setBackground(Color.red);
				} else {
					locker1.setBackground(Color.green);
				}

				if(Locker.getLockerState(2)==1) {
					locker2.setBackground(Color.red);
				} else {
					locker2.setBackground(Color.green);
				}

				if(Locker.getLockerState(3)==1) {
					locker3.setBackground(Color.red);
				} else {
					locker3.setBackground(Color.green);
				}

				if(Locker.getLockerState(4)==1) {
					locker4.setBackground(Color.red);
				} else {
					locker4.setBackground(Color.green);
				}

				if(Locker.getLockerState(5)==1) {
					locker5.setBackground(Color.red);
				} else {
					locker5.setBackground(Color.green);
				}

				if(Locker.getLockerState(6)==1) {
					locker6.setBackground(Color.red);
				} else {
					locker6.setBackground(Color.green);
				}

				if(Locker.getLockerState(7)==1) {
					locker7.setBackground(Color.red);
				} else {
					locker7.setBackground(Color.green);
				}

				if(Locker.getLockerState(8)==1) {
					locker8.setBackground(Color.red);
				} else {
					locker8.setBackground(Color.green);
				}

				if(Locker.getLockerState(9)==1) {
					locker9.setBackground(Color.red);
				} else {
					locker9.setBackground(Color.green);
				}

				if(Locker.getLockerState(10)==1) {
					locker10.setBackground(Color.red);
				} else {
					locker10.setBackground(Color.green);
				}

				if(Locker.getLockerState(11)==1) {
					locker11.setBackground(Color.red);
				} else {
					locker11.setBackground(Color.green);
				}

				if(Locker.getLockerState(12)==1) {
					locker12.setBackground(Color.red);
				} else {
					locker12.setBackground(Color.green);
				}

				if(Locker.getLockerState(13)==1) {
					locker13.setBackground(Color.red);
				} else {
					locker13.setBackground(Color.green);
				}

				if(Locker.getLockerState(14)==1) {
					locker14.setBackground(Color.red);
				} else {
					locker14.setBackground(Color.green);
				}

				if(Locker.getLockerState(15)==1) {
					locker15.setBackground(Color.red);
				} else {
					locker15.setBackground(Color.green);
				}

				if(Locker.getLockerState(16)==1) {
					locker16.setBackground(Color.red);
				} else {
					locker16.setBackground(Color.green);
				}

				if(Locker.getLockerState(17)==1) {
					locker17.setBackground(Color.red);
				} else {
					locker17.setBackground(Color.green);
				}

				if(Locker.getLockerState(18)==1) {
					locker18.setBackground(Color.red);
				} else {
					locker18.setBackground(Color.green);
				}

				if(Locker.getLockerState(19)==1) {
					locker19.setBackground(Color.red);
				} else {
					locker19.setBackground(Color.green);
				}

				if(Locker.getLockerState(20)==1) {
					locker20.setBackground(Color.red);
				} else {
					locker20.setBackground(Color.green);
				}
				
				if(Locker.getLockerState(21)==1) {
					locker21.setBackground(Color.red);
				} else {
					locker21.setBackground(Color.green);
				}

				if(Locker.getLockerState(22)==1) {
					locker22.setBackground(Color.red);
				} else {
					locker22.setBackground(Color.green);
				}

				if(Locker.getLockerState(23)==1) {
					locker23.setBackground(Color.red);
				} else {
					locker23.setBackground(Color.green);
				}

				if(Locker.getLockerState(24)==1) {
					locker24.setBackground(Color.red);
				} else {
					locker24.setBackground(Color.green);
				}

				if(Locker.getLockerState(25)==1) {
					locker25.setBackground(Color.red);
				} else {
					locker25.setBackground(Color.green);
				}

				if(Locker.getLockerState(26)==1) {
					locker26.setBackground(Color.red);
				} else {
					locker26.setBackground(Color.green);
				}

				if(Locker.getLockerState(27)==1) {
					locker27.setBackground(Color.red);
				} else {
					locker27.setBackground(Color.green);
				}

				if(Locker.getLockerState(28)==1) {
					locker28.setBackground(Color.red);
				} else {
					locker28.setBackground(Color.green);
				}

				if(Locker.getLockerState(29)==1) {
					locker29.setBackground(Color.red);
				} else {
					locker29.setBackground(Color.green);
				}

				if(Locker.getLockerState(30)==1) {
					locker30.setBackground(Color.red);
				} else {
					locker30.setBackground(Color.green);
				}

				if(Locker.getLockerState(31)==1) {
					locker31.setBackground(Color.red);
				} else {
					locker31.setBackground(Color.green);
				}

				if(Locker.getLockerState(32)==1) {
					locker32.setBackground(Color.red);
				} else {
					locker32.setBackground(Color.green);
				}

				if(Locker.getLockerState(33)==1) {
					locker33.setBackground(Color.red);
				} else {
					locker33.setBackground(Color.green);
				}

				if(Locker.getLockerState(34)==1) {
					locker34.setBackground(Color.red);
				} else {
					locker34.setBackground(Color.green);
				}

				if(Locker.getLockerState(35)==1) {
					locker35.setBackground(Color.red);
				} else {
					locker35.setBackground(Color.green);
				}

				if(Locker.getLockerState(36)==1) {
					locker36.setBackground(Color.red);
				} else {
					locker36.setBackground(Color.green);
				}

				if(Locker.getLockerState(37)==1) {
					locker37.setBackground(Color.red);
				} else {
					locker37.setBackground(Color.green);
				}

				if(Locker.getLockerState(38)==1) {
					locker38.setBackground(Color.red);
				} else {
					locker38.setBackground(Color.green);
				}

				if(Locker.getLockerState(39)==1) {
					locker39.setBackground(Color.red);
				} else {
					locker39.setBackground(Color.green);
				}

				if(Locker.getLockerState(40)==1) {
					locker40.setBackground(Color.red);
				} else {
					locker40.setBackground(Color.green);
				}
				
				if(Locker.getLockerState(41)==1) {
					locker41.setBackground(Color.red);
				} else {
					locker41.setBackground(Color.green);
				}

				if(Locker.getLockerState(42)==1) {
					locker42.setBackground(Color.red);
				} else {
					locker42.setBackground(Color.green);
				}

				if(Locker.getLockerState(43)==1) {
					locker43.setBackground(Color.red);
				} else {
					locker43.setBackground(Color.green);
				}

				if(Locker.getLockerState(44)==1) {
					locker44.setBackground(Color.red);
				} else {
					locker44.setBackground(Color.green);
				}

				if(Locker.getLockerState(45)==1) {
					locker45.setBackground(Color.red);
				} else {
					locker45.setBackground(Color.green);
				}

				if(Locker.getLockerState(46)==1) {
					locker46.setBackground(Color.red);
				} else {
					locker46.setBackground(Color.green);
				}

				if(Locker.getLockerState(47)==1) {
					locker47.setBackground(Color.red);
				} else {
					locker47.setBackground(Color.green);
				}

				if(Locker.getLockerState(48)==1) {
					locker48.setBackground(Color.red);
				} else {
					locker48.setBackground(Color.green);
				}

				if(Locker.getLockerState(49)==1) {
					locker49.setBackground(Color.red);
				} else {
					locker49.setBackground(Color.green);
				}

				if(Locker.getLockerState(50)==1) {
					locker50.setBackground(Color.red);
				} else {
					locker50.setBackground(Color.green);
				}
				
				if(Locker.getLockerState(51)==1) {
					locker51.setBackground(Color.red);
				} else {
					locker51.setBackground(Color.green);
				}

				if(Locker.getLockerState(52)==1) {
					locker52.setBackground(Color.red);
				} else {
					locker52.setBackground(Color.green);
				}

				if(Locker.getLockerState(53)==1) {
					locker53.setBackground(Color.red);
				} else {
					locker53.setBackground(Color.green);
				}

				if(Locker.getLockerState(54)==1) {
					locker54.setBackground(Color.red);
				} else {
					locker54.setBackground(Color.green);
				}

				if(Locker.getLockerState(55)==1) {
					locker55.setBackground(Color.red);
				} else {
					locker55.setBackground(Color.green);
				}

				if(Locker.getLockerState(56)==1) {
					locker56.setBackground(Color.red);
				} else {
					locker56.setBackground(Color.green);
				}

				if(Locker.getLockerState(57)==1) {
					locker57.setBackground(Color.red);
				} else {
					locker57.setBackground(Color.green);
				}

				if(Locker.getLockerState(58)==1) {
					locker58.setBackground(Color.red);
				} else {
					locker58.setBackground(Color.green);
				}

				if(Locker.getLockerState(59)==1) {
					locker59.setBackground(Color.red);
				} else {
					locker59.setBackground(Color.green);
				}

				if(Locker.getLockerState(60)==1) {
					locker60.setBackground(Color.red);
				} else {
					locker60.setBackground(Color.green);
				}


			}
		});
		button_3.setBounds(944, 418, 296, 203);
		mainPage.add(button_3);
		
		JButton button_4 = new JButton("\uBC18\uB0A9\uD558\uAE30");
		button_4.setFont(new Font("나눔고딕", Font.BOLD, 20));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(student.checkEmpty(idd) == 0) {
					JOptionPane.showMessageDialog(null, "반납할 사물함이 없습니다.");
					
				}
				if(student.checkEmpty(idd) == 1) {
					Locker.getRtnL(student.getRtnS(idd));
					JOptionPane.showMessageDialog(null, "사물함을 반납하였습니다.");
					
					mylocker = student.rtnName(idd);
					data = Locker.getLockers();
					
					data2 = Locker.getMyLocker(mylocker);
					model = new DefaultTableModel(data,headers);
					model2 = new DefaultTableModel(data2,headers);
					
					allStateTable.repaint();
					allStateTable.revalidate();

					model.fireTableDataChanged();
					allStateTable.setModel(model);
					
					myStateTable.repaint();
					myStateTable.revalidate();

					model2.fireTableDataChanged();
					myStateTable.setModel(model2);
					
				}
				
				if(Locker.getLockerState(1)==1) {
					locker1.setBackground(Color.red);
				} else {
					locker1.setBackground(Color.green);
				}

				if(Locker.getLockerState(2)==1) {
					locker2.setBackground(Color.red);
				} else {
					locker2.setBackground(Color.green);
				}

				if(Locker.getLockerState(3)==1) {
					locker3.setBackground(Color.red);
				} else {
					locker3.setBackground(Color.green);
				}

				if(Locker.getLockerState(4)==1) {
					locker4.setBackground(Color.red);
				} else {
					locker4.setBackground(Color.green);
				}

				if(Locker.getLockerState(5)==1) {
					locker5.setBackground(Color.red);
				} else {
					locker5.setBackground(Color.green);
				}

				if(Locker.getLockerState(6)==1) {
					locker6.setBackground(Color.red);
				} else {
					locker6.setBackground(Color.green);
				}

				if(Locker.getLockerState(7)==1) {
					locker7.setBackground(Color.red);
				} else {
					locker7.setBackground(Color.green);
				}

				if(Locker.getLockerState(8)==1) {
					locker8.setBackground(Color.red);
				} else {
					locker8.setBackground(Color.green);
				}

				if(Locker.getLockerState(9)==1) {
					locker9.setBackground(Color.red);
				} else {
					locker9.setBackground(Color.green);
				}

				if(Locker.getLockerState(10)==1) {
					locker10.setBackground(Color.red);
				} else {
					locker10.setBackground(Color.green);
				}

				if(Locker.getLockerState(11)==1) {
					locker11.setBackground(Color.red);
				} else {
					locker11.setBackground(Color.green);
				}

				if(Locker.getLockerState(12)==1) {
					locker12.setBackground(Color.red);
				} else {
					locker12.setBackground(Color.green);
				}

				if(Locker.getLockerState(13)==1) {
					locker13.setBackground(Color.red);
				} else {
					locker13.setBackground(Color.green);
				}

				if(Locker.getLockerState(14)==1) {
					locker14.setBackground(Color.red);
				} else {
					locker14.setBackground(Color.green);
				}

				if(Locker.getLockerState(15)==1) {
					locker15.setBackground(Color.red);
				} else {
					locker15.setBackground(Color.green);
				}

				if(Locker.getLockerState(16)==1) {
					locker16.setBackground(Color.red);
				} else {
					locker16.setBackground(Color.green);
				}

				if(Locker.getLockerState(17)==1) {
					locker17.setBackground(Color.red);
				} else {
					locker17.setBackground(Color.green);
				}

				if(Locker.getLockerState(18)==1) {
					locker18.setBackground(Color.red);
				} else {
					locker18.setBackground(Color.green);
				}

				if(Locker.getLockerState(19)==1) {
					locker19.setBackground(Color.red);
				} else {
					locker19.setBackground(Color.green);
				}

				if(Locker.getLockerState(20)==1) {
					locker20.setBackground(Color.red);
				} else {
					locker20.setBackground(Color.green);
				}
				
				if(Locker.getLockerState(21)==1) {
					locker21.setBackground(Color.red);
				} else {
					locker21.setBackground(Color.green);
				}

				if(Locker.getLockerState(22)==1) {
					locker22.setBackground(Color.red);
				} else {
					locker22.setBackground(Color.green);
				}

				if(Locker.getLockerState(23)==1) {
					locker23.setBackground(Color.red);
				} else {
					locker23.setBackground(Color.green);
				}

				if(Locker.getLockerState(24)==1) {
					locker24.setBackground(Color.red);
				} else {
					locker24.setBackground(Color.green);
				}

				if(Locker.getLockerState(25)==1) {
					locker25.setBackground(Color.red);
				} else {
					locker25.setBackground(Color.green);
				}

				if(Locker.getLockerState(26)==1) {
					locker26.setBackground(Color.red);
				} else {
					locker26.setBackground(Color.green);
				}

				if(Locker.getLockerState(27)==1) {
					locker27.setBackground(Color.red);
				} else {
					locker27.setBackground(Color.green);
				}

				if(Locker.getLockerState(28)==1) {
					locker28.setBackground(Color.red);
				} else {
					locker28.setBackground(Color.green);
				}

				if(Locker.getLockerState(29)==1) {
					locker29.setBackground(Color.red);
				} else {
					locker29.setBackground(Color.green);
				}

				if(Locker.getLockerState(30)==1) {
					locker30.setBackground(Color.red);
				} else {
					locker30.setBackground(Color.green);
				}

				if(Locker.getLockerState(31)==1) {
					locker31.setBackground(Color.red);
				} else {
					locker31.setBackground(Color.green);
				}

				if(Locker.getLockerState(32)==1) {
					locker32.setBackground(Color.red);
				} else {
					locker32.setBackground(Color.green);
				}

				if(Locker.getLockerState(33)==1) {
					locker33.setBackground(Color.red);
				} else {
					locker33.setBackground(Color.green);
				}

				if(Locker.getLockerState(34)==1) {
					locker34.setBackground(Color.red);
				} else {
					locker34.setBackground(Color.green);
				}

				if(Locker.getLockerState(35)==1) {
					locker35.setBackground(Color.red);
				} else {
					locker35.setBackground(Color.green);
				}

				if(Locker.getLockerState(36)==1) {
					locker36.setBackground(Color.red);
				} else {
					locker36.setBackground(Color.green);
				}

				if(Locker.getLockerState(37)==1) {
					locker37.setBackground(Color.red);
				} else {
					locker37.setBackground(Color.green);
				}

				if(Locker.getLockerState(38)==1) {
					locker38.setBackground(Color.red);
				} else {
					locker38.setBackground(Color.green);
				}

				if(Locker.getLockerState(39)==1) {
					locker39.setBackground(Color.red);
				} else {
					locker39.setBackground(Color.green);
				}

				if(Locker.getLockerState(40)==1) {
					locker40.setBackground(Color.red);
				} else {
					locker40.setBackground(Color.green);
				}
				
				if(Locker.getLockerState(41)==1) {
					locker41.setBackground(Color.red);
				} else {
					locker41.setBackground(Color.green);
				}

				if(Locker.getLockerState(42)==1) {
					locker42.setBackground(Color.red);
				} else {
					locker42.setBackground(Color.green);
				}

				if(Locker.getLockerState(43)==1) {
					locker43.setBackground(Color.red);
				} else {
					locker43.setBackground(Color.green);
				}

				if(Locker.getLockerState(44)==1) {
					locker44.setBackground(Color.red);
				} else {
					locker44.setBackground(Color.green);
				}

				if(Locker.getLockerState(45)==1) {
					locker45.setBackground(Color.red);
				} else {
					locker45.setBackground(Color.green);
				}

				if(Locker.getLockerState(46)==1) {
					locker46.setBackground(Color.red);
				} else {
					locker46.setBackground(Color.green);
				}

				if(Locker.getLockerState(47)==1) {
					locker47.setBackground(Color.red);
				} else {
					locker47.setBackground(Color.green);
				}

				if(Locker.getLockerState(48)==1) {
					locker48.setBackground(Color.red);
				} else {
					locker48.setBackground(Color.green);
				}

				if(Locker.getLockerState(49)==1) {
					locker49.setBackground(Color.red);
				} else {
					locker49.setBackground(Color.green);
				}

				if(Locker.getLockerState(50)==1) {
					locker50.setBackground(Color.red);
				} else {
					locker50.setBackground(Color.green);
				}
				
				if(Locker.getLockerState(51)==1) {
					locker51.setBackground(Color.red);
				} else {
					locker51.setBackground(Color.green);
				}

				if(Locker.getLockerState(52)==1) {
					locker52.setBackground(Color.red);
				} else {
					locker52.setBackground(Color.green);
				}

				if(Locker.getLockerState(53)==1) {
					locker53.setBackground(Color.red);
				} else {
					locker53.setBackground(Color.green);
				}

				if(Locker.getLockerState(54)==1) {
					locker54.setBackground(Color.red);
				} else {
					locker54.setBackground(Color.green);
				}

				if(Locker.getLockerState(55)==1) {
					locker55.setBackground(Color.red);
				} else {
					locker55.setBackground(Color.green);
				}

				if(Locker.getLockerState(56)==1) {
					locker56.setBackground(Color.red);
				} else {
					locker56.setBackground(Color.green);
				}

				if(Locker.getLockerState(57)==1) {
					locker57.setBackground(Color.red);
				} else {
					locker57.setBackground(Color.green);
				}

				if(Locker.getLockerState(58)==1) {
					locker58.setBackground(Color.red);
				} else {
					locker58.setBackground(Color.green);
				}

				if(Locker.getLockerState(59)==1) {
					locker59.setBackground(Color.red);
				} else {
					locker59.setBackground(Color.green);
				}

				if(Locker.getLockerState(60)==1) {
					locker60.setBackground(Color.red);
				} else {
					locker60.setBackground(Color.green);
				}
				
				
				
			}
		});
		
		button_4.setBounds(944, 673, 296, 68);
		mainPage.add(button_4);
		
		JButton refreshBtn = new JButton("\uC0C8\uB85C\uACE0\uCE68");
		refreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//				startDate2 = startSpin.getValue().toString();

//				startDate2 = (String)startSpin.getSelectedItem();
				
//				System.out.println(startDate2);
//				endDate2 = (String)startSpin.getValue();
//				System.out.println(endDate2);
				
				
				data = Locker.getLockers();
				model = new DefaultTableModel(data,headers);
				
				
				
				mylocker = student.rtnName(idd);
				
				data2 = Locker.getMyLocker(mylocker);
				
				model2 = new DefaultTableModel(data2,headers);
				
				allStateTable.repaint();
				allStateTable.revalidate();
				model.fireTableDataChanged();
				allStateTable.setModel(model);
				
				myStateTable.repaint();
				myStateTable.revalidate();
				model2.fireTableDataChanged();
				myStateTable.setModel(model2);
				
				
				if(Locker.getLockerState(1)==1) {
					locker1.setBackground(Color.red);
				} else {
					locker1.setBackground(Color.green);
				}

				if(Locker.getLockerState(2)==1) {
					locker2.setBackground(Color.red);
				} else {
					locker2.setBackground(Color.green);
				}

				if(Locker.getLockerState(3)==1) {
					locker3.setBackground(Color.red);
				} else {
					locker3.setBackground(Color.green);
				}

				if(Locker.getLockerState(4)==1) {
					locker4.setBackground(Color.red);
				} else {
					locker4.setBackground(Color.green);
				}

				if(Locker.getLockerState(5)==1) {
					locker5.setBackground(Color.red);
				} else {
					locker5.setBackground(Color.green);
				}

				if(Locker.getLockerState(6)==1) {
					locker6.setBackground(Color.red);
				} else {
					locker6.setBackground(Color.green);
				}

				if(Locker.getLockerState(7)==1) {
					locker7.setBackground(Color.red);
				} else {
					locker7.setBackground(Color.green);
				}

				if(Locker.getLockerState(8)==1) {
					locker8.setBackground(Color.red);
				} else {
					locker8.setBackground(Color.green);
				}

				if(Locker.getLockerState(9)==1) {
					locker9.setBackground(Color.red);
				} else {
					locker9.setBackground(Color.green);
				}

				if(Locker.getLockerState(10)==1) {
					locker10.setBackground(Color.red);
				} else {
					locker10.setBackground(Color.green);
				}

				if(Locker.getLockerState(11)==1) {
					locker11.setBackground(Color.red);
				} else {
					locker11.setBackground(Color.green);
				}

				if(Locker.getLockerState(12)==1) {
					locker12.setBackground(Color.red);
				} else {
					locker12.setBackground(Color.green);
				}

				if(Locker.getLockerState(13)==1) {
					locker13.setBackground(Color.red);
				} else {
					locker13.setBackground(Color.green);
				}

				if(Locker.getLockerState(14)==1) {
					locker14.setBackground(Color.red);
				} else {
					locker14.setBackground(Color.green);
				}

				if(Locker.getLockerState(15)==1) {
					locker15.setBackground(Color.red);
				} else {
					locker15.setBackground(Color.green);
				}

				if(Locker.getLockerState(16)==1) {
					locker16.setBackground(Color.red);
				} else {
					locker16.setBackground(Color.green);
				}

				if(Locker.getLockerState(17)==1) {
					locker17.setBackground(Color.red);
				} else {
					locker17.setBackground(Color.green);
				}

				if(Locker.getLockerState(18)==1) {
					locker18.setBackground(Color.red);
				} else {
					locker18.setBackground(Color.green);
				}

				if(Locker.getLockerState(19)==1) {
					locker19.setBackground(Color.red);
				} else {
					locker19.setBackground(Color.green);
				}

				if(Locker.getLockerState(20)==1) {
					locker20.setBackground(Color.red);
				} else {
					locker20.setBackground(Color.green);
				}
				
				if(Locker.getLockerState(21)==1) {
					locker21.setBackground(Color.red);
				} else {
					locker21.setBackground(Color.green);
				}

				if(Locker.getLockerState(22)==1) {
					locker22.setBackground(Color.red);
				} else {
					locker22.setBackground(Color.green);
				}

				if(Locker.getLockerState(23)==1) {
					locker23.setBackground(Color.red);
				} else {
					locker23.setBackground(Color.green);
				}

				if(Locker.getLockerState(24)==1) {
					locker24.setBackground(Color.red);
				} else {
					locker24.setBackground(Color.green);
				}

				if(Locker.getLockerState(25)==1) {
					locker25.setBackground(Color.red);
				} else {
					locker25.setBackground(Color.green);
				}

				if(Locker.getLockerState(26)==1) {
					locker26.setBackground(Color.red);
				} else {
					locker26.setBackground(Color.green);
				}

				if(Locker.getLockerState(27)==1) {
					locker27.setBackground(Color.red);
				} else {
					locker27.setBackground(Color.green);
				}

				if(Locker.getLockerState(28)==1) {
					locker28.setBackground(Color.red);
				} else {
					locker28.setBackground(Color.green);
				}

				if(Locker.getLockerState(29)==1) {
					locker29.setBackground(Color.red);
				} else {
					locker29.setBackground(Color.green);
				}

				if(Locker.getLockerState(30)==1) {
					locker30.setBackground(Color.red);
				} else {
					locker30.setBackground(Color.green);
				}

				if(Locker.getLockerState(31)==1) {
					locker31.setBackground(Color.red);
				} else {
					locker31.setBackground(Color.green);
				}

				if(Locker.getLockerState(32)==1) {
					locker32.setBackground(Color.red);
				} else {
					locker32.setBackground(Color.green);
				}

				if(Locker.getLockerState(33)==1) {
					locker33.setBackground(Color.red);
				} else {
					locker33.setBackground(Color.green);
				}

				if(Locker.getLockerState(34)==1) {
					locker34.setBackground(Color.red);
				} else {
					locker34.setBackground(Color.green);
				}

				if(Locker.getLockerState(35)==1) {
					locker35.setBackground(Color.red);
				} else {
					locker35.setBackground(Color.green);
				}

				if(Locker.getLockerState(36)==1) {
					locker36.setBackground(Color.red);
				} else {
					locker36.setBackground(Color.green);
				}

				if(Locker.getLockerState(37)==1) {
					locker37.setBackground(Color.red);
				} else {
					locker37.setBackground(Color.green);
				}

				if(Locker.getLockerState(38)==1) {
					locker38.setBackground(Color.red);
				} else {
					locker38.setBackground(Color.green);
				}

				if(Locker.getLockerState(39)==1) {
					locker39.setBackground(Color.red);
				} else {
					locker39.setBackground(Color.green);
				}

				if(Locker.getLockerState(40)==1) {
					locker40.setBackground(Color.red);
				} else {
					locker40.setBackground(Color.green);
				}
				
				if(Locker.getLockerState(41)==1) {
					locker41.setBackground(Color.red);
				} else {
					locker41.setBackground(Color.green);
				}

				if(Locker.getLockerState(42)==1) {
					locker42.setBackground(Color.red);
				} else {
					locker42.setBackground(Color.green);
				}

				if(Locker.getLockerState(43)==1) {
					locker43.setBackground(Color.red);
				} else {
					locker43.setBackground(Color.green);
				}

				if(Locker.getLockerState(44)==1) {
					locker44.setBackground(Color.red);
				} else {
					locker44.setBackground(Color.green);
				}

				if(Locker.getLockerState(45)==1) {
					locker45.setBackground(Color.red);
				} else {
					locker45.setBackground(Color.green);
				}

				if(Locker.getLockerState(46)==1) {
					locker46.setBackground(Color.red);
				} else {
					locker46.setBackground(Color.green);
				}

				if(Locker.getLockerState(47)==1) {
					locker47.setBackground(Color.red);
				} else {
					locker47.setBackground(Color.green);
				}

				if(Locker.getLockerState(48)==1) {
					locker48.setBackground(Color.red);
				} else {
					locker48.setBackground(Color.green);
				}

				if(Locker.getLockerState(49)==1) {
					locker49.setBackground(Color.red);
				} else {
					locker49.setBackground(Color.green);
				}

				if(Locker.getLockerState(50)==1) {
					locker50.setBackground(Color.red);
				} else {
					locker50.setBackground(Color.green);
				}
				
				if(Locker.getLockerState(51)==1) {
					locker51.setBackground(Color.red);
				} else {
					locker51.setBackground(Color.green);
				}

				if(Locker.getLockerState(52)==1) {
					locker52.setBackground(Color.red);
				} else {
					locker52.setBackground(Color.green);
				}

				if(Locker.getLockerState(53)==1) {
					locker53.setBackground(Color.red);
				} else {
					locker53.setBackground(Color.green);
				}

				if(Locker.getLockerState(54)==1) {
					locker54.setBackground(Color.red);
				} else {
					locker54.setBackground(Color.green);
				}

				if(Locker.getLockerState(55)==1) {
					locker55.setBackground(Color.red);
				} else {
					locker55.setBackground(Color.green);
				}

				if(Locker.getLockerState(56)==1) {
					locker56.setBackground(Color.red);
				} else {
					locker56.setBackground(Color.green);
				}

				if(Locker.getLockerState(57)==1) {
					locker57.setBackground(Color.red);
				} else {
					locker57.setBackground(Color.green);
				}

				if(Locker.getLockerState(58)==1) {
					locker58.setBackground(Color.red);
				} else {
					locker58.setBackground(Color.green);
				}

				if(Locker.getLockerState(59)==1) {
					locker59.setBackground(Color.red);
				} else {
					locker59.setBackground(Color.green);
				}

				if(Locker.getLockerState(60)==1) {
					locker60.setBackground(Color.red);
				} else {
					locker60.setBackground(Color.green);
				}
			}
		});
		
		mylocker = student.rtnName(idd);
		System.out.println(idd);
		System.out.println(mylocker);
		data = locker.getLockers();
		data2 = locker.getMyLocker(mylocker);
		headers = new String[] {"사물함 번호", "대여상태","대여자","대여 시작일","대여 종료일"};
		
		
		model = new DefaultTableModel(data,headers);
		model2 = new DefaultTableModel(data2,headers);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(14, 418, 916, 202);
		mainPage.add(scrollPane_1);
//		allStateTable = new JTable(data, headers);
		allStateTable = new JTable(model);
		scrollPane_1.setViewportView(allStateTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 673, 916, 68);
		mainPage.add(scrollPane);
		
		myStateTable = new JTable(model2);
		scrollPane.setViewportView(myStateTable);
		refreshBtn.setBounds(789, 12, 141, 35);
		mainPage.add(refreshBtn);
		
		JLabel label_4 = new JLabel("\uB300\uC5EC \uC2DC\uC791\uC77C");
		label_4.setFont(new Font("나눔고딕", Font.BOLD, 20));
		label_4.setBounds(944, 157, 120, 41);
		mainPage.add(label_4);
		
		JLabel label_7 = new JLabel("\uB300\uC5EC \uC885\uB8CC\uC77C");
		label_7.setFont(new Font("나눔고딕", Font.BOLD, 20));
		label_7.setBounds(944, 286, 120, 35);
		mainPage.add(label_7);
		
		JPanel changeInfo = new JPanel();
		changeInfo.setLayout(null);
		panel_1.add(changeInfo, "회원정보수정");
		
		JButton button = new JButton("\uC218\uC815\uD558\uAE30");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String idTxt = null;
				String passTxt = null;
				String nameTxt = null;
				String stdnumTxt = null;
				
				
				
				
				idTxt = chId.getText();
				passTxt = chPass.getText();
				nameTxt = chName.getText();
				stdnumTxt = chStdnum.getText();
				
				Student.updateStudent(stdnumTxt, nameTxt, idTxt, passTxt,idd);
				JOptionPane.showMessageDialog(null, "회원정보가 수정되었습니다.");
				
				chId.setText("");
				chPass.setText("");
				chName.setText("");
				chStdnum.setText("");
				
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
		
		chPass = new JTextField();
		chPass.setColumns(10);
		chPass.setBounds(517, 284, 355, 36);
		changeInfo.add(chPass);
		
		chId = new JTextField();
		chId.setColumns(10);
		chId.setBounds(517, 236, 355, 36);
		changeInfo.add(chId);
		
		JLabel label_20 = new JLabel("ID");
		label_20.setBounds(389, 236, 90, 18);
		changeInfo.add(label_20);
		
		JLabel label_21 = new JLabel("PASSWORD");
		label_21.setBounds(389, 284, 102, 18);
		changeInfo.add(label_21);
		
		chName = new JTextField();
		chName.setColumns(10);
		chName.setBounds(517, 332, 355, 36);
		changeInfo.add(chName);
		
		chStdnum = new JTextField();
		chStdnum.setColumns(10);
		chStdnum.setBounds(517, 386, 355, 36);
		changeInfo.add(chStdnum);
		
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

		
		

	}
}
