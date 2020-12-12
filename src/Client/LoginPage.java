package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import interfaces.TheInterface;

public class LoginPage {

	private JFrame frame;
	private JTextField username_text;
	private JTextField password_text;
	static TheInterface stub;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			stub = (TheInterface)Naming.lookup("rmi://localhost/MainServer");
			stub.DatabaseConnect();
			System.out.println("DataBase Connected");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
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
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 526, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Used Mobile Phone Review System");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 490, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Login as User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean login = false;
				String name = username_text.getText();
				try {
					login = stub.userLogin(username_text.getText(), password_text.getText());
				} catch (Exception e2) {
					System.out.println(e2.toString());
				}
				if(login) {
					Questions.ShowQuestions(name, stub);
				}else {
					JOptionPane.showConfirmDialog(null,"Invalid UserName or Password","Query",JOptionPane.OK_OPTION);
				}
				
			}
			
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 153, 255));
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton.setBounds(168, 173, 177, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnRegisterAsUser = new JButton("Register as User");
		btnRegisterAsUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterUser.ShowRegUser(stub);
				
			}
		});
		btnRegisterAsUser.setForeground(Color.WHITE);
		btnRegisterAsUser.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnRegisterAsUser.setBackground(new Color(0, 153, 255));
		btnRegisterAsUser.setBounds(168, 217, 177, 33);
		frame.getContentPane().add(btnRegisterAsUser);
		
		username_text = new JTextField();
		username_text.setBounds(168, 74, 177, 33);
		frame.getContentPane().add(username_text);
		username_text.setColumns(10);
		
		password_text = new JTextField();
		password_text.setColumns(10);
		password_text.setBounds(168, 118, 177, 33);
		frame.getContentPane().add(password_text);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(72, 83, 75, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(72, 127, 75, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnLoginAsAdmin = new JButton("Login As Admin");
		btnLoginAsAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin adminlogin = new AdminLogin();
				adminlogin.frame.setVisible(true);
			}
		});
		btnLoginAsAdmin.setForeground(new Color(0, 153, 255));
		btnLoginAsAdmin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnLoginAsAdmin.setBackground(new Color(255, 255, 255));
		btnLoginAsAdmin.setBounds(168, 261, 177, 33);
		frame.getContentPane().add(btnLoginAsAdmin);
	}
}
