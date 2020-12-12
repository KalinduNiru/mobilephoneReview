package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import datamodels.Users;
import interfaces.TheInterface;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.awt.event.ActionEvent;

public class RegisterUser {

	JFrame frame;
	private JTextField name_text;
	private JTextField age_text;
	private JTextField email_text;
	private JTextField phone_text;
	
	static TheInterface mainstub;
	private JTextField password_text;

	/**
	 * Launch the application.
	 */
	public static void ShowRegUser(TheInterface stub) {
		try {
			mainstub = stub;
			System.out.println("DataBase Connected");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterUser window = new RegisterUser();
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
	public RegisterUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 516, 428);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsedMobilePhone = new JLabel("Used Mobile Phone Review System - User Register");
		lblUsedMobilePhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsedMobilePhone.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblUsedMobilePhone.setBounds(10, 11, 480, 44);
		frame.getContentPane().add(lblUsedMobilePhone);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel.setBounds(72, 87, 44, 21);
		frame.getContentPane().add(lblNewLabel);
		
		name_text = new JTextField();
		name_text.setBounds(202, 83, 216, 31);
		frame.getContentPane().add(name_text);
		name_text.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblAge.setBounds(72, 132, 44, 21);
		frame.getContentPane().add(lblAge);
		
		age_text = new JTextField();
		age_text.setColumns(10);
		age_text.setBounds(202, 128, 216, 31);
		frame.getContentPane().add(age_text);
		
		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblEmailAddress.setBounds(72, 177, 87, 21);
		frame.getContentPane().add(lblEmailAddress);
		
		email_text = new JTextField();
		email_text.setColumns(10);
		email_text.setBounds(202, 173, 216, 31);
		frame.getContentPane().add(email_text);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblPhoneNumber.setBounds(72, 219, 105, 21);
		frame.getContentPane().add(lblPhoneNumber);
		
		phone_text = new JTextField();
		phone_text.setColumns(10);
		phone_text.setBounds(202, 215, 216, 31);
		frame.getContentPane().add(phone_text);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblPassword.setBounds(72, 262, 105, 21);
		frame.getContentPane().add(lblPassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean register = false;
				
				//Users user = new Users();
				String name = name_text.getText();
				String age = age_text.getText();
				String email = email_text.getText();
				String phone = phone_text.getText();
				String password = password_text.getText();
				
				try {
					System.out.println(name);
					register = mainstub.usersReg(name, age, email, phone, password);
				} catch (Exception e2) {
					System.out.println(e2.toString());
					System.out.println("RegUser Wrong");
				}
				
				if(register) {
					System.out.println("User Saved");
				}
				
			}
		});
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnRegister.setBackground(new Color(0, 153, 255));
		btnRegister.setBounds(159, 329, 174, 49);
		frame.getContentPane().add(btnRegister);
		
		password_text = new JTextField();
		password_text.setBounds(202, 263, 216, 31);
		frame.getContentPane().add(password_text);
		password_text.setColumns(10);
	}
}
