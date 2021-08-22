package com.nagarro.Validator;

import java.io.IOException;
import java.util.List;

import com.nagarro.dao.FlightDAO;
import com.nagarro.dao.impl.FlightDAOImpl;
import com.nagarro.dto.Flight;

public class Validator {
	public String isInputValid(String depLoc, String arrLoc) throws IOException {

		FlightDAO flightDAO = new FlightDAOImpl();
		List<Flight> flights = flightDAO.fetchFlights();
		int flag1 = 0;
		int flag2 = 0;
		for (Flight flight : flights) {
			if (flight.getArrLoc().equals(arrLoc)) { // to check whether input arrival location present in
														// data or not
				flag1 = 1;
			}
			if (flight.getDepLoc().equals(depLoc)) { // to check whether input departure location present in
														// data or not
				flag2 = 1;
			}
			if (flag1 == 1 && flag2 == 1) {
				return "Y";
			}
		}
		// if input departure or arrival location not present then
		// throwing an exception
		return "N";
	}
}
