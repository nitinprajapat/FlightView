package com.nagarro.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nagarro.dao.FlightDAO;
import com.nagarro.dto.Flight;
import com.nagarro.dto.Input;
import com.nagarro.util.SessionBuilder;

public class FlightDAOImpl implements FlightDAO {

	public List<Flight> fetchFlights() {
		// TODO Auto-generated method stub
		Session session = SessionBuilder.buildSession();
		String query = "from Flight";
		Query q = session.createQuery(query);
		List<Flight> flights = q.getResultList();
		return flights;
	}

	public List<Flight> searchResults(Input input) {
		// TODO Auto-generated method stub
		String query;

		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-mm-dd").parse(input.getDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (input.getOutPref().equals("fare")) {
			query = "from Flight where depLoc=:dep and arrLoc=:arr and validTillDate>=:date and flightClass=:inputClass order by fare";
		} else {
			query = "from Flight where depLoc=:dep and arrLoc=:arr and validTillDate>=:date and flightClass=:inputClass and seatAvailability='Y' order by flightDuration";
		}

		Session session = SessionBuilder.buildSession();
		session.beginTransaction();

		Query q = session.createQuery(query);
		q.setParameter("date", date);
		q.setParameter("inputClass", input.getFlightClass());
		q.setParameter("dep", input.getDepLoc());
		q.setParameter("arr", input.getArrLoc());
		List<Flight> flights = q.getResultList();
		return flights;
	}

}
