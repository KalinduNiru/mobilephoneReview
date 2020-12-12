package datamodels;

import java.util.ArrayList;

public class Questions implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5374777387872326286L;
	private ArrayList<String> Question = new ArrayList<String>();
	private ArrayList<String> Answers_01 = new ArrayList<String>();
	private ArrayList<String> Answers_02 = new ArrayList<String>();
	private ArrayList<String> Answers_03 = new ArrayList<String>();
	private ArrayList<String> Answers_04 = new ArrayList<String>();
	
	public ArrayList<String> getQuestion() {
		return Question;
	}
	public void setQuestion(ArrayList<String> question) {
		Question = question;
	}
	public ArrayList<String> getAnswers_01() {
		return Answers_01;
	}
	public void setAnswers_01(ArrayList<String> answers_01) {
		Answers_01 = answers_01;
	}
	public ArrayList<String> getAnswers_02() {
		return Answers_02;
	}
	public void setAnswers_02(ArrayList<String> answers_02) {
		Answers_02 = answers_02;
	}
	public ArrayList<String> getAnswers_03() {
		return Answers_03;
	}
	public void setAnswers_03(ArrayList<String> answers_03) {
		Answers_03 = answers_03;
	}
	public ArrayList<String> getAnswers_04() {
		return Answers_04;
	}
	public void setAnswers_04(ArrayList<String> answers_04) {
		Answers_04 = answers_04;
	}
}
