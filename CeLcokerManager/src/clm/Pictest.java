package clm;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
 
//"C:\\SPB_Data\\git\\pgp_163312\\CeLcokerManager\\image"
public class Pictest {

	private JFrame frame;
	ImageIcon icon;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pictest window = new Pictest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the application.
	 */
	public Pictest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 589, 415);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTextArea txtrTesting = new JTextArea();
		txtrTesting.setText("testing");
		txtrTesting.setBounds(150, 150, 325, 58);
		panel.add(txtrTesting);
	}
}
