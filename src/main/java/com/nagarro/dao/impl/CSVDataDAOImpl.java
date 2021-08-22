package com.nagarro.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nagarro.dao.CSVDataDAO;
import com.nagarro.dto.Flight;
import com.nagarro.util.SessionBuilder;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class CSVDataDAOImpl implements CSVDataDAO {

	public void saveCSVData() {
		// ArrayList<Flight> flights = new ArrayList<Flight>(); // Array list to store
		// flights data
		File folder = new File("C:/Users/nitin03/Documents/Airline_data"); // creating file object with the folder that
																			// contains all the files
		File[] listOfFiles = folder.listFiles(); // storing all files in array

		Session session = SessionBuilder.buildSession();
		for (File file : listOfFiles) {
			FileReader filereader = null;
			try {
				filereader = new FileReader(file);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			CSVParser parser = new CSVParserBuilder().withSeparator('|').build(); // parsing each file
			CSVReader csvReader = new CSVReaderBuilder(filereader).withCSVParser(parser).withSkipLines(1).build();
			List<String[]> allData = null;
			try {
				allData = csvReader.readAll();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			/**
			 * traversing file data and storing it into flights array list
			 */
			for (String[] temp : allData) {
				Flight flight = new Flight();
				flight.setFlightNo(temp[0]);
				flight.setDepLoc(temp[1]);
				flight.setArrLoc(temp[2]);
				try {
					flight.setValidTillDate(new SimpleDateFormat("dd-MM-yyyy").parse(temp[3]));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				flight.setFlightTime(Integer.parseInt(temp[4]));
				flight.setFlightDuration(Double.parseDouble(temp[5]));
				flight.setFare(Double.parseDouble(temp[6]));
				flight.setSeatAvailability(temp[7]);
				flight.setFlightClass(temp[8]);
				// flights.add(flight);
				Transaction tx = session.beginTransaction();
				session.save(flight);
				tx.commit();
			}

		}
	}

}
