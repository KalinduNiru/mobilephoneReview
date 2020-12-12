package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;


import interfaces.TheInterface;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class AdminLogin extends JFrame{

	JFrame frame;
	private JTextField username_text;
	static TheInterface mainstub;
	private JTextField passwordField;

	/**
	 * Launch the application.
	 */
	public static void ShowAdminLogin(TheInterface stub) {
		try {
			mainstub = stub;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 549, 341);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Used Mobile Phone Review System - Admin Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 513, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Admin Username");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(276, 78, 99, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Admin Password");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(276, 160, 99, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		username_text = new JTextField();
		username_text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		username_text.setBounds(276, 103, 182, 36);
		frame.getContentPane().add(username_text);
		username_text.setColumns(10);
		
		
		passwordField = new JTextField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		passwordField.setBounds(276, 185, 182, 36);
		frame.getContentPane().add(passwordField);
		passwordField.setColumns(10);
		/*passwordField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});*/
		
		JButton btnNewButton = new JButton("Admin Login");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(0, 153, 255));
		btnNewButton.setBounds(276, 244, 113, 36);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
	         repaint();
				Boolean login = false;
				
				
				try {
					login = mainstub.adminLogin(username_text.getText(), passwordField.getText());
				} catch (NullPointerException e2) {
					System.out.println(e2.toString());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(login) {
					
					AdminDashboard.ShowAdminDashboard(mainstub);
					System.out.println("Logged");
				}else {
					JOptionPane.showMessageDialog(null, "Wring PW of User");
				}
				
			}
			
		});
		
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Kalindu\\Desktop\\ecipse\\PhoneReviewSystem\\img\\admin-settings-male.png"));
		lblNewLabel_2.setBounds(20, 63, 229, 217);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton login = new JButton("New button");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminDashboard.ShowAdminDashboard(mainstub);
				
			}
		});
		login.setBounds(407, 252, 89, 23);
		frame.getContentPane().add(login);
		
		
	}
}


