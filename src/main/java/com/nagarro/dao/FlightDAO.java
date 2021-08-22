package com.nagarro.dao;

import java.util.List;

import com.nagarro.dto.Flight;
import com.nagarro.dto.Input;

public interface FlightDAO {

	public List<Flight> fetchFlights();

	public List<Flight> searchResults(Input input);

}
