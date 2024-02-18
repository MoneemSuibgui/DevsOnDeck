package com.isport.moneem.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.isport.moneem.model.LoggedUser;
import com.isport.moneem.model.User;
import com.isport.moneem.service.UserService;

@Controller
public class UserController {

	// inject UserService
	@Autowired
	private UserService service;

	// login & register route passing tow empty object to jsp file
	@GetMapping("/")
	public String index(Model modelView) {
		modelView.addAttribute("newUser", new User());
		modelView.addAttribute("user", new LoggedUser());
		return "index.jsp";
	}

	// register route
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User user, BindingResult result, HttpSession session,
			Model modelView) {
		service.register(user, result);
		if (result.hasErrors()) {
			modelView.addAttribute("user", new LoggedUser());
			return "index.jsp";
		}
		User newUser = this.service.add(user);
		session.setAttribute("user_id", newUser.getId());

		return "redirect:/home";

	}

	// login route
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("user") LoggedUser logUser, BindingResult result, HttpSession session,
			Model modelView) {
		User user = service.login(logUser, result);
		if (result.hasErrors()) {
			modelView.addAttribute("newUser", new User());
			return "index.jsp";
		}
		session.setAttribute("user_id", user.getId());
		return "redirect:/home";

	}

	// home page route
	@GetMapping("/home")
	public String home(Model modelView, HttpSession session) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		User user = this.service.getById((Long) session.getAttribute("user_id"));
		modelView.addAttribute("user", user);
		
		  LocalDate today = LocalDate.now();
		  
		  DateTimeFormatter pattern=DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		  String formattedDate=today.format(pattern);
		  modelView.addAttribute("formattedDate", formattedDate);	  
		  modelView.addAttribute("today",today);
		return "home.jsp";
	}

	// logout route
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user_id");
		return "redirect:/";
	}

}
