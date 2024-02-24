package com.devs_on_deck.moneem.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.devs_on_deck.moneem.models.LoginUser;
import com.devs_on_deck.moneem.models.Profile;
import com.devs_on_deck.moneem.models.User;
import com.devs_on_deck.moneem.services.SkillsService;
import com.devs_on_deck.moneem.services.UserService;

@Controller
public class UserController {
	
	// inject UserService
	@Autowired
	private UserService service;
	
	// inject SkillsService
	@Autowired
	private SkillsService skillService;
		
	private static String uploaded_path="src/main/resources/static/pictures/";

	
	@GetMapping("/")
	public String home() {
		return "redirect:/devs/register";
	}
	
	// Display route  developer register from
	@GetMapping("/devs/register")
	public String developerForm(@ModelAttribute("user") User user) {
		return "registerUser.jsp";
	}
	
	// Action route register developer :add developer
	@PostMapping("/create/developer")
	public String register(@Valid @ModelAttribute("user") User user,BindingResult result
							,HttpSession session,@RequestParam("picture") MultipartFile file ,RedirectAttributes redirectAttr) {
		this.service.register(user, result);
		if(result.hasErrors()) {
			return "registerUser.jsp";
		}
		// validation for picture of developer
		if(file.isEmpty() && (file.getOriginalFilename() !=".jpg" || file.getOriginalFilename() !=".png")) {
			redirectAttr.addFlashAttribute("error", "* Picture cannot be empty, must be jpg or png extension");
			return "redirect:/devs/register";
		}
		try {
			byte [] bytes=file.getBytes();
			Path path=Paths.get(uploaded_path+file.getOriginalFilename());
			Files.write(path, bytes);
			// get the URL of the file we just uploaded and set to image_url of user belongs to it
			String url="/pictures/"+file.getOriginalFilename();
			user.setImage_url(url);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		service.add(user);
		
		session.setAttribute("userId", user.getId());
		return "redirect:/devs/skills/languages";

	}
	
	// Display route Login page
	@GetMapping("/devs/login")
	public String loginForm(@ModelAttribute("user") User user) {
		return "loginUser.jsp";
	}
	
	// Action route login
	@PostMapping("/devs/login")
	public String login(@Valid @ModelAttribute("user")LoginUser user,BindingResult result,HttpSession session) {
		User LogedUser=this.service.login(user, result);
		if(result.hasErrors()) {
			return "loginUser.jsp";
		}
		session.setAttribute("userId", LogedUser.getId());
		return "redirect:/devs/skills/languages";
	}
	
	@GetMapping("/dashboardJob")
	public String dashboardJob(Model model,HttpSession session) {
		
		User user=this.service.oneUser((Long)session.getAttribute("userId"));

		if(session.getAttribute("userId")!=null ) {
			model.addAttribute("LGuser", user);
			return "dashboardJobs.jsp";
		}
		return "redirect:/devs/register";
	}
	
	
	@GetMapping("/devs/skills/languages")
	public String languages(Model model,HttpSession session) {

		if(session.getAttribute("userId")!= null ) {
			User user=this.service.oneUser((Long)session.getAttribute("userId"));
			if(user.getProfile()!= null) {
				return "redirect:/developer/details";
			}
			model.addAttribute("LGuser", user);
		return "languageSkills.jsp";
		}return"redirect:/devs/register";
	}
	
	// Action route : save developer skills => languages
	@PostMapping("/devs/skills/languages")
	public String saveLanguages(@RequestParam(name="languages") ArrayList<String> lang,
								@RequestParam(name="biography") String bio,
								HttpSession session,RedirectAttributes redirectAttribute) {
		
		User user=this.service.oneUser((Long)session.getAttribute("userId"));
		if(lang.size()<5 || lang.size()>5) {
			redirectAttribute.addFlashAttribute("errorMessage", "* Languages list must be 5 languages");
			return "redirect:/devs/skills/languages";
		}
		Profile profile=new Profile();
		profile.setDeveloper(user);
		profile.setBiography(bio);
		profile.setLanguages(lang);
		skillService.add(profile);
		
		
		this.service.update(user);
		return "redirect:/devs/skills/frameworks";
	}
	
	@GetMapping("/devs/skills/frameworks")
	public String frameworks(Model model,HttpSession session) {
		if(session.getAttribute("userId")!=null) {
		User user=this.service.oneUser((Long)session.getAttribute("userId"));
		model.addAttribute("LGuser", user);
		return "frameworks.jsp";
		}return"redirect:/devs/register";
	}
	
	// Action route : save developer skills => frameworks
		@PostMapping("/devs/skills/frameworks")
		public String saveFrameworks(
				@RequestParam(value="frameworks") ArrayList<String> frameworks,
				@RequestParam(value="profession") String profession,
				@RequestParam(value="experience") Integer experience,
				HttpSession session,RedirectAttributes redirectAttribute) {
			User user=this.service.oneUser((Long)session.getAttribute("userId"));
			if(frameworks.size()<5 || frameworks.size()>5) {
				redirectAttribute.addFlashAttribute("errorMessage", "* Languages list must be 5 languages");
				return "redirect:/devs/skills/languages";
			}
			if(experience.toString()== null) {
				redirectAttribute.addFlashAttribute("errorExperience", "* Experience is required !!");
				return "redirect:/devs/skills/languages";
			}
			Profile profile=skillService.getOne(user.getProfile().getId());
			profile.setFrameworks(frameworks);
			profile.setProfession(profession);
			profile.setExperience(experience);
			profile.setDeveloper(user);
			
			skillService.update(profile);
			return "redirect:/developer/details";
		}
		
	// show all developer details
		@GetMapping("/developer/details")
		public String developerInfo(Model model,HttpSession session) {
			if(session.getAttribute("userId") == null) {
				return "redirect:/devs/register";
			}
			User user=this.service.oneUser((Long)session.getAttribute("userId"));
			model.addAttribute("user", user);
			System.out.println(user);
			return "developerDetails.jsp";
			
		}
	
	
	// logout route
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userId");
		return "redirect:/devs/register";
	}
	
	
	
	
	
	
}


