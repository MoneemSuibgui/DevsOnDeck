package com.isport.moneem.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.isport.moneem.model.Event;
import com.isport.moneem.model.User;
import com.isport.moneem.service.EventService;
import com.isport.moneem.service.PictureService;
import com.isport.moneem.service.UserService;

@Controller
public class EventController {

	// inject EventService
	@Autowired
	private EventService eventService;

	// inject UserService
	@Autowired
	private UserService userService;

	// inject UserService
	@Autowired
	private PictureService pictureService;

	// path folder event_pictures
	public static String images_path = "src/main/resources/static/event_pictures/";

	// Event from route
	@GetMapping("/new/event")
	public String addEvent(@ModelAttribute("newEvent") Event event, HttpSession session) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		return "newEvent.jsp";
	}

	@PostMapping("/new/event")
	public String addForm(@Valid @ModelAttribute("newEvent") Event event, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "newEvent.jsp";
		}
		User creator = userService.getById((Long) session.getAttribute("user_id"));
		event.setCreator(creator);
		eventService.addEvent(event);
		return "redirect:/home";
	}

	@GetMapping("/search")
	public String search(Model modelView, HttpSession session) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		User loggedUser = userService.getById((Long) session.getAttribute("user_id"));
		// passing today into the jsp file to compare the tow Local dates
		modelView.addAttribute("now", LocalDate.now());

		modelView.addAttribute("user", loggedUser);
		modelView.addAttribute("events", eventService.getAll());
		return "search.jsp";
	}

	@GetMapping("/join/{event_id}")
	public String joinEvent(@PathVariable("event_id") Long eventId, HttpSession session) {

		User loggedUser = userService.getById((Long) session.getAttribute("user_id"));
		Event event = eventService.getEvent(eventId);
		event.getUsers().add(loggedUser);
		eventService.updateEvent(event);
		return "redirect:/search";
	}

	@GetMapping("/users/{id}")
	public String userInfo(@PathVariable("id") Long id, HttpSession session, Model modelView) {
		if (session.getAttribute("user_id") != null) {
			User user = userService.getById(id);
			modelView.addAttribute("user", user);
			modelView.addAttribute("loggedUser",this.userService.getById((Long)session.getAttribute("user_id")));
			modelView.addAttribute("pass", user.getPassword().hashCode());
			modelView.addAttribute("today", LocalDate.now());
			return "userInfo.jsp";
		}
		return "redirect:/";
	}

	@PostMapping("/upload/picture/{user_id}")
	public String uploadPicture(@RequestParam("image") MultipartFile file,@PathVariable("user_id")Long id,HttpSession session,RedirectAttributes redirect) {
		User loggedUser = this.userService.getById((Long) session.getAttribute("user_id"));
		if(file.isEmpty()) {
			redirect.addFlashAttribute("errorMessage", " * Please Entre image to upload");
			return "redirect:/users/"+id;
		}
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(images_path, file.getOriginalFilename());
			Files.write(path, bytes);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		String pictue_url = "/event_pictures/" + file.getOriginalFilename();
		pictureService.savePicture(pictue_url, loggedUser);
		return "redirect:/users/"+loggedUser.getId();

	}

}
