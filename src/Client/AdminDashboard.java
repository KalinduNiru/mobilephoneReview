package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;
import java.rmi.Naming;
//import java.net.http.HttpClient;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import datamodels.MobileAnalytics;
import interfaces.TheInterface;

import java.awt.Color;
import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminDashboard {

	JFrame frame;
	private JTable table;
	
	Image chartImage = null;
	Image scaledImage = null;
	
	JLabel chartLabel = new JLabel("Loading Charts");
	JLabel lblTable = new JLabel("Loding Table");
	
	static TheInterface mainstub;
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void ShowAdminDashboard(TheInterface stub) {
		try {
			
			stub = (TheInterface)Naming.lookup("rmi://localhost/MainServer");
			stub.DatabaseConnect();
			mainstub = stub;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashboard window = new AdminDashboard();
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
	public AdminDashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 985, 586);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 13));
		tabbedPane.setBounds(10, 65, 949, 471);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel_0 = new JPanel();
		tabbedPane.addTab("Question Summery", null, panel_0, null);
		panel_0.setLayout(null);
		
		
		chartLabel.setHorizontalAlignment(SwingConstants.CENTER);
		chartLabel.setBounds(10, 58, 924, 370);
		panel_0.add(chartLabel);
		
		
		ArrayList<String> labelNames = new ArrayList<String>();
		ArrayList<Integer> chartValues = new ArrayList<Integer>();
		
		JButton btnNewButton_1 = new JButton("Question 01");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelNames.clear();
				chartValues.clear();
				
				labelNames.add("Yes");
				labelNames.add("No");
				labelNames.add("Maybe");
				try {
					SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){

						
						protected Void doInBackground() throws Exception {
							chartValues.add(mainstub.dataCount("use_type", "Yes"));
							chartValues.add(mainstub.dataCount("use_type", "No"));
							chartValues.add(mainstub.dataCount("use_type", "Maybe"));
							return null;
						}
						
						protected void done() {
							super.done();
							chartLoad(labelNames, chartValues, "Preffered Use Type", "bar");
							System.out.println("Chart Displayed");
						}
						
					};
					worker.execute();
				} catch (Exception e2) {
					System.out.println(e2.toString());
				}
				chartLabel.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 153, 255));
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnNewButton_1.setBounds(24, 24, 102, 23);
		panel_0.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Question 02");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelNames.clear();
				chartValues.clear();
				
				labelNames.add("As the primary phone");
				labelNames.add("As the backup phone");
				labelNames.add("Just for fun");
				labelNames.add("Need to put the second sim card");
				
				try {
					SwingWorker<Void, Void> worker1 = new SwingWorker<Void, Void>(){

						
						protected Void doInBackground() throws Exception {
							chartValues.add(mainstub.dataCount("type", "As the primary phone"));
							chartValues.add(mainstub.dataCount("type", "As the backup phone"));
							chartValues.add(mainstub.dataCount("type", "Just for fun"));
							chartValues.add(mainstub.dataCount("type", "Need to put the second sim card"));
							
							return null;
						}
						protected void done() {
							super.done();
							chartLoad(labelNames, chartValues, "Type of Phone", "bar");
							System.out.println("Chart Generated");
						}
						
					};
					worker1.execute();
				} catch (Exception e2) {
					System.out.println(e2.toString());
				}
				chartLabel.setVisible(true);
			}
		});
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnNewButton_1_1.setBackground(new Color(0, 153, 255));
		btnNewButton_1_1.setBounds(147, 24, 102, 23);
		panel_0.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Question 03");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelNames.clear();
				chartValues.clear();
				
				labelNames.add("Yes");
				labelNames.add("No");
				labelNames.add("Maybe");
			
				
				try {
					SwingWorker<Void, Void> worker1 = new SwingWorker<Void, Void>(){

						
						protected Void doInBackground() throws Exception {
							chartValues.add(mainstub.dataCount("where_to_buy", "Yes"));
							chartValues.add(mainstub.dataCount("where_to_buy", "No"));
							chartValues.add(mainstub.dataCount("where_to_buy", "Maybe"));
							
							
							return null;
						}
						protected void done() {
							super.done();
							chartLoad(labelNames, chartValues, "Prefer a reputed Shop? or not", "bar");
							System.out.println("Chart Generated");
						}
						
					};
					worker1.execute();
				} catch (Exception e2) {
					System.out.println(e2.toString());
				}
				chartLabel.setVisible(true);
			}
		});
		btnNewButton_1_2.setForeground(Color.WHITE);
		btnNewButton_1_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnNewButton_1_2.setBackground(new Color(0, 153, 255));
		btnNewButton_1_2.setBounds(272, 24, 102, 23);
		panel_0.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("Question 04");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelNames.clear();
				chartValues.clear();
				
				labelNames.add("Apple");
				labelNames.add("Samsung");
				labelNames.add("Huawei");
				labelNames.add("Xiaomi");
			
				
				try {
					SwingWorker<Void, Void> worker1 = new SwingWorker<Void, Void>(){

						
						protected Void doInBackground() throws Exception {
							chartValues.add(mainstub.dataCount("brand", "Apple"));
							chartValues.add(mainstub.dataCount("brand", "Samsung"));
							chartValues.add(mainstub.dataCount("brand", "Huawei"));
							chartValues.add(mainstub.dataCount("brand", "Xiaomi"));
							
							return null;
						}
						protected void done() {
							super.done();
							chartLoad(labelNames, chartValues, "Brand", "pie");
							System.out.println("Chart Generated");
						}
						
					};
					worker1.execute();
				} catch (Exception e2) {
					System.out.println(e2.toString());
				}
				chartLabel.setVisible(true);
			}
		});
		btnNewButton_1_3.setForeground(Color.WHITE);
		btnNewButton_1_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnNewButton_1_3.setBackground(new Color(0, 153, 255));
		btnNewButton_1_3.setBounds(401, 24, 102, 23);
		panel_0.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_4 = new JButton("Question 05");
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelNames.clear();
				chartValues.clear();
				
				labelNames.add("Below 10000LKR");
				labelNames.add("Between 10000-25000LKR");
				labelNames.add("Between 25000-35000LKR");
				labelNames.add("Above 40000LKR");
			
				
				try {
					SwingWorker<Void, Void> worker1 = new SwingWorker<Void, Void>(){

						
						protected Void doInBackground() throws Exception {
							chartValues.add(mainstub.dataCount("price", "Below 10000LKR"));
							chartValues.add(mainstub.dataCount("price", "Between 10000-25000LKR"));
							chartValues.add(mainstub.dataCount("price", "Between 25000-35000LKR"));
							chartValues.add(mainstub.dataCount("price", "Above 40000LKR"));
							
							return null;
						}
						protected void done() {
							super.done();
							chartLoad(labelNames, chartValues, "Price", "bar");
							System.out.println("Chart Generated");
						}
						
					};
					worker1.execute();
				} catch (Exception e2) {
					System.out.println(e2.toString());
				}
				chartLabel.setVisible(true);
			}
		});
		btnNewButton_1_4.setForeground(Color.WHITE);
		btnNewButton_1_4.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnNewButton_1_4.setBackground(new Color(0, 153, 255));
		btnNewButton_1_4.setBounds(534, 24, 102, 23);
		panel_0.add(btnNewButton_1_4);
		
		JButton btnNewButton_1_5 = new JButton("Question 06");
		btnNewButton_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelNames.clear();
				chartValues.clear();
				
				labelNames.add("Less than 3.5");
				labelNames.add("Between 3.5-4.5");
				labelNames.add("Between 4.5-6.0");
				labelNames.add("More than 6.0");
			
				
				try {
					SwingWorker<Void, Void> worker1 = new SwingWorker<Void, Void>(){

						
						protected Void doInBackground() throws Exception {
							chartValues.add(mainstub.dataCount("display", "Less than 3.5"));
							chartValues.add(mainstub.dataCount("display", "Between 3.5-4.5"));
							chartValues.add(mainstub.dataCount("display", "Between 4.5-6.0"));
							chartValues.add(mainstub.dataCount("display", "More than 6.0"));
							
							return null;
						}
						protected void done() {
							super.done();
							chartLoad(labelNames, chartValues, "Display Size", "bar");
							System.out.println("Chart Generated");
						}
						
					};
					worker1.execute();
				} catch (Exception e2) {
					System.out.println(e2.toString());
				}
				chartLabel.setVisible(true);
			}
		});
		btnNewButton_1_5.setForeground(Color.WHITE);
		btnNewButton_1_5.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnNewButton_1_5.setBackground(new Color(0, 153, 255));
		btnNewButton_1_5.setBounds(672, 24, 102, 23);
		panel_0.add(btnNewButton_1_5);
		
		JButton btnNewButton_1_5_1 = new JButton("Question 07");
		btnNewButton_1_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelNames.clear();
				chartValues.clear();
				
				labelNames.add("Full set with box");
				labelNames.add("Full set without box");
				labelNames.add("Charger and phone");
				labelNames.add("Just the phone");
			
				
				try {
					SwingWorker<Void, Void> worker1 = new SwingWorker<Void, Void>(){

						
						protected Void doInBackground() throws Exception {
							chartValues.add(mainstub.dataCount("box_type", "Full set with box"));
							chartValues.add(mainstub.dataCount("box_type", "Full set without box"));
							chartValues.add(mainstub.dataCount("box_type", "Charger and phone"));
							chartValues.add(mainstub.dataCount("box_type", "Just the phone"));
							
							return null;
						}
						protected void done() {
							super.done();
							chartLoad(labelNames, chartValues, "Box Type", "bar");
							System.out.println("Chart Generated");
						}
						
					};
					worker1.execute();
				} catch (Exception e2) {
					System.out.println(e2.toString());
				}
				chartLabel.setVisible(true);
			}
		});
		btnNewButton_1_5_1.setForeground(Color.WHITE);
		btnNewButton_1_5_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnNewButton_1_5_1.setBackground(new Color(0, 153, 255));
		btnNewButton_1_5_1.setBounds(812, 24, 102, 23);
		panel_0.add(btnNewButton_1_5_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Users", null, panel_1, null);
		panel_1.setLayout(null);
		lblTable.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		lblTable.setHorizontalAlignment(SwingConstants.CENTER);
		lblTable.setBounds(10, 63, 924, 365);
		panel_1.add(lblTable);
		
		JButton table_btn = new JButton("Show Table");
		table_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTable.setVisible(true);
				ShowTable();
			}
		});
		table_btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		table_btn.setBounds(415, 23, 125, 23);
		panel_1.add(table_btn);
		
	
		
		
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Analytics", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("According to Reviews Thease are the most Likeble Used Mobile Phones");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 11, 644, 24);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Kalindu\\Desktop\\ecipse\\PhoneReviewSystem\\img\\phone01.jpg"));
		lblNewLabel_2.setBounds(10, 61, 145, 199);
		panel_2.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("About ", null, panel, null);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Log Out");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(0, 153, 255));
		btnNewButton.setBounds(10, 223, 127, 37);
		panel.add(btnNewButton);
		
		JLabel lblUsedMobilePhone = new JLabel("Used Mobile Phone Review System - Admin Dashboard");
		lblUsedMobilePhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsedMobilePhone.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblUsedMobilePhone.setBounds(35, 11, 924, 43);
		frame.getContentPane().add(lblUsedMobilePhone);
	}
	
	private void chartLoad(ArrayList<String> labelNames, ArrayList<Integer> chartValues, String header, String chartType) {
		String chartURL = "";
		try {
			chartURL = mainstub.generateChartDetails(labelNames, chartValues, header, chartType);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		try {
			URL url = new URL(chartURL);
			chartImage = ImageIO.read(url); 
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		scaledImage = chartImage.getScaledInstance(chartLabel.getWidth(), chartLabel.getHeight(), Image.SCALE_SMOOTH);
		chartLabel.setIcon(new ImageIcon(scaledImage));
	}
	
	private void ShowTable() {
		String data[][]= {};
		String colunm[] = {"User ID","Name","use_type", "type", "where_to_buy", "brand", "price", "display", "box_type"};
		
		DefaultTableModel tableModel = new DefaultTableModel(data,colunm) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		table = new JTable(tableModel);
		table.setBounds(10, 51, 644, 213);
		final TableColumnModel columnModel = table.getColumnModel();
		for (int colunmTab = 0; colunmTab < table.getColumnCount(); colunmTab++) {
			int width = 100;
			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer render = table.getCellRenderer(row, colunmTab);
				Component component = table.prepareRenderer(render, row, colunmTab);
				width = Math.max(component.getPreferredSize().width + 10, width);
			}
			if(width > 300)
				width = 300;
			columnModel.getColumn(colunmTab).setPreferredWidth(width);
		}
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		lblTable.add(table);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 905, 512);
		lblTable.add(scrollPane);

		Object[] row = new Object[9];
		ArrayList<MobileAnalytics> list = new ArrayList<MobileAnalytics>();
		try {
			list = mainstub.getAnalytics();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		for(int i =0; i<list.size(); i++) {
			row[0]= list.get(i).getId();
			row[1]= list.get(i).getName();
			row[2]= list.get(i).getUse_type();
			row[3]= list.get(i).getType();
			row[4]= list.get(i).getWhere_to_buy();
			row[5]= list.get(i).getBrand();
			row[6]= list.get(i).getPrice();
			row[7]= list.get(i).getDisplay();
			row[8]= list.get(i).getBox_type();
		tableModel.addRow(row);
		}
	}
}
