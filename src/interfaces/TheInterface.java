package interfaces;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datamodels.MobileAnalytics;
import datamodels.Questions;
import datamodels.Users;

public interface TheInterface extends Remote {
	
	 public void DatabaseConnect() throws RemoteException, ClassNotFoundException;
	
	 public boolean userLogin(String username, String password) throws RemoteException, SQLException;
	 
	 public boolean adminLogin(String username, String password) throws RemoteException, SQLException;
	 
	 public boolean usersReg(String name, String age, String email, String phone, String password) throws RemoteException, SQLException;
	  
	 public List<Questions> getQuestions() throws RemoteException, SQLException;
	 
	 public String saveAnswer(ArrayList<String> answers) throws RemoteException;
	 
	 public ArrayList<MobileAnalytics> getAnalytics() throws RemoteException, SQLException;
	 
	 public ArrayList<String> selectedAnswer(int id) throws RemoteException, SQLException;
	 
	 public String generateChartDetails(ArrayList<String> labelNames, ArrayList<Integer> values, String heading, String chartType) throws RemoteException, IOException, InterruptedException;
	 
	 public int dataCount(String column, String ansItem) throws RemoteException, SQLException;
	 
}
