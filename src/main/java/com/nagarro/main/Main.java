package com.nagarro.main;

import java.io.IOException;

import com.nagarro.dao.CSVDataDAO;
import com.nagarro.dao.UserDAO;
import com.nagarro.dao.impl.CSVDataDAOImpl;
import com.nagarro.dao.impl.UserDAOImpl;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		CSVDataDAO saveCSV = new CSVDataDAOImpl();
		saveCSV.saveCSVData();
		UserDAO saveUser = new UserDAOImpl();
		saveUser.saveUser();

	}

}
