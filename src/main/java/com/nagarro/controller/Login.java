package com.nagarro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.dao.UserDAO;
import com.nagarro.dao.impl.UserDAOImpl;
import com.nagarro.dto.User;

@Controller
public class Login {

	@RequestMapping("/Login")
	public ModelAndView login(@RequestParam("uname") String username, @RequestParam("pass") String password,
			HttpServletRequest request, HttpServletResponse response) {

		User user = new User();

		UserDAO userDAO = new UserDAOImpl();

		user = userDAO.getUser(username);

		ModelAndView mv = new ModelAndView();

		if (user != null) {

			if (password.equals(user.getPassword())) {

				mv.setViewName("search.jsp");

				mv.addObject(user);

			}
		}
		return mv;
	}

}
