package com.nagarro.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.Validator.Validator;
import com.nagarro.dao.FlightDAO;
import com.nagarro.dao.impl.FlightDAOImpl;
import com.nagarro.dto.Flight;
import com.nagarro.dto.Input;

@Controller
public class Search {

	@RequestMapping("/Search")
	public ModelAndView Search(HttpServletRequest request, HttpServletResponse response) throws ParseException {

		Input input = new Input();
		input.setDepLoc(request.getParameter("depLoc"));
		input.setArrLoc(request.getParameter("arrLoc"));
		input.setDate(request.getParameter("date"));
		input.setOutPref(request.getParameter("outPref"));
		input.setFlightClass(request.getParameter("Class"));
		Validator validate = new Validator();
		String isValid = null;
		try {
			isValid = validate.isInputValid(input.getDepLoc(), input.getArrLoc());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView();
		if (isValid.equals("N")) {
			mv.setViewName("search.jsp");
			return mv;
		}
		FlightDAO flightDAO = new FlightDAOImpl();
		List<Flight> flights = flightDAO.searchResults(input);
		mv.setViewName("display.jsp");

		mv.addObject("flights", flights);

		return mv;

	}

}
