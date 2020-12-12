package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import interfaces.TheInterface;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class Questions {

	JFrame frame;
	
	static TheInterface mainStub;
	
	final JLabel QLabel = new JLabel("");
	final JButton nextButton = new JButton("Next");
	int index = 0;
	boolean finish = false;
	static datamodels.Questions questions;
	static ArrayList<String> questionDisplay = new ArrayList<String>();
	static ArrayList<String> Answers_01 = new ArrayList<String>();
	static ArrayList<String> Answers_02 = new ArrayList<String>();
	static ArrayList<String> Answers_03 = new ArrayList<String>();
	static ArrayList<String> Answers_04 = new ArrayList<String>();
	static ArrayList<String> selectAnswers = new ArrayList<String>();
	
	ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton option_1 = new JRadioButton("");
	JRadioButton option_2 = new JRadioButton("");
	JRadioButton option_3 = new JRadioButton("");
	JRadioButton option_4 = new JRadioButton("");
	
	
	
	/**
	 * Launch the application.
	 */
	public static void ShowQuestions(String name, TheInterface stub) {
		try {
			mainStub = stub;
			List<datamodels.Questions> list = (List) mainStub.getQuestions();
			for(datamodels.Questions q : list) {
				questionDisplay = q.getQuestion();
				Answers_01 = q.getAnswers_01();
				Answers_02 = q.getAnswers_02();
				Answers_03 = q.getAnswers_03();
				Answers_04 = q.getAnswers_04();
				
			}
			selectAnswers.add(name);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Questions window = new Questions();
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
	public Questions() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 662, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 65, 626, 200);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel1 = new JPanel();
		layeredPane.add(panel1, "name_4280998404500");
		panel1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Question 01");
		lblNewLabel_1.setBounds(10, 11, 100, 20);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		panel1.add(lblNewLabel_1);
		
		
		QLabel.setBounds(10, 42, 586, 33);
		QLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		QLabel.setVerticalAlignment(SwingConstants.TOP);
		QLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel1.add(QLabel);
		
		
		buttonGroup.add(option_1);
		option_1.setBounds(45, 82, 240, 23);
		option_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		option_1.setActionCommand("opt01");
		panel1.add(option_1);
		
		
		buttonGroup.add(option_2);
		option_2.setBounds(322, 82, 186, 23);
		option_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		option_2.setActionCommand("opt02");
		panel1.add(option_2);
		
		
		buttonGroup.add(option_3);
		option_3.setBounds(45, 136, 240, 23);
		option_3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		option_3.setActionCommand("opt03");
		panel1.add(option_3);
		
		
		buttonGroup.add(option_4);
		option_4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		option_4.setBounds(322, 136, 186, 23);
		option_4.setActionCommand("opt04");
		panel1.add(option_4);
		
		JLabel lblNewLabel = new JLabel("Used Mobile Phone Review System - Questionnaire");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 11, 626, 43);
		frame.getContentPane().add(lblNewLabel);
		
		
		QLabel.setText(questionDisplay.get(0));
		option_1.setText(Answers_01.get(0));
		option_2.setText(Answers_02.get(0));
		option_3.setText(Answers_03.get(0));
		option_4.setText(Answers_04.get(0));

		
		nextButton.setBounds(494, 291, 125, 33);
		frame.getContentPane().add(nextButton);
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(nextButton)) {
					if(buttonGroup.getSelection() != null) {
						getAnswers(buttonGroup);
						nextQuestion(nextButton);
						
					}
				}
			}
		});
		nextButton.setForeground(new Color(255, 255, 255));
		nextButton.setBackground(new Color(0, 153, 255));
		nextButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
	}
	
	private void nextQuestion(JButton btn) {
		try {
			if(finish) {
				
				saveAnswers();
				System.out.println("Answers Saved...");
			}
			if(btn == nextButton) {
				if(index < 7) {
					index++;
					QLabel.setText(index +1 + ". " + questionDisplay.get(index));
					option_1.setText(Answers_01.get(index));
					option_2.setText(Answers_02.get(index));
					option_3.setText(Answers_03.get(index));
					option_4.setText(Answers_04.get(index));
					
					if(index +1 == questionDisplay.size()) {
						nextButton.setText("Finish");
						finish = true;
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}


	private void getAnswers(ButtonGroup btnGroup) {
		String answer = btnGroup.getSelection().getActionCommand();
		/*switch (answer) {
		case "opt1":
			selectAnswers.add(Answers_01.get(index));
			break;
		case "opt2":
			selectAnswers.add(Answers_02.get(index));
			break;
		case "opt3":
			selectAnswers.add(Answers_03.get(index));
			break;
		case "opt4":
			selectAnswers.add(Answers_04.get(index));
			break;*/
		if(answer == "opt01") {
			selectAnswers.add(Answers_01.get(index));
		}else if(answer == "opt02"){
			selectAnswers.add(Answers_02.get(index));
		}else if(answer == "opt03"){
			selectAnswers.add(Answers_03.get(index));
		}else if(answer == "opt04"){
			selectAnswers.add(Answers_04.get(index));
		}
		btnGroup.clearSelection();
	}

	private void saveAnswers() {
	 try {
		String results =  (String) mainStub.saveAnswer(selectAnswers);
		System.out.println(results);
	} catch (Exception e) {
		System.out.println(e.toString());
		System.out.println("Wrong");
	}
		
	}
}
