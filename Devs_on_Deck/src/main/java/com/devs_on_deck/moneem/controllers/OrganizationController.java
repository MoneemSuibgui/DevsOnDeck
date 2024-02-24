package com.devs_on_deck.moneem.controllers;


import java.util.ArrayList;
import java.util.List;

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

import com.devs_on_deck.moneem.models.LoginOrg;
import com.devs_on_deck.moneem.models.Organization;
import com.devs_on_deck.moneem.models.Position;
import com.devs_on_deck.moneem.models.User;
import com.devs_on_deck.moneem.services.OrgService;
import com.devs_on_deck.moneem.services.PositionService;
import com.devs_on_deck.moneem.services.UserService;

@Controller
public class OrganizationController {
	
	@Autowired
	private OrgService service;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PositionService positionService;
	
	private static ArrayList<User> availableDev=new ArrayList<User>();
	
	// Display route : Organization form
	@GetMapping("/orgs/register")
	public String orgForm(@ModelAttribute("organization")Organization org) {
		return "orgRegister.jsp";
	}
	
	// Action route : Register Organization
	@PostMapping("/orgs/register")
	public String register(@Valid @ModelAttribute("organization")Organization org,BindingResult result,HttpSession session) {
		
		this.service.register(org, result);
		if(result.hasErrors()) {
			return "orgRegister.jsp";
		}
		Organization organization=this.service.create(org);
		session.setAttribute("orgId", organization.getId());
		
		return "redirect:/orgs/dashboard";
	}
	
	
	// Display route login form organization
	@GetMapping("/orgs/login")
	public String loginForm(@ModelAttribute("org") Organization org) {
		return "orgLogin.jsp"; 
	}
	// Action route login organization
	@PostMapping("/orgs/login")
	public String login(@Valid @ModelAttribute("org") LoginOrg org,BindingResult result,HttpSession session) {
		Organization loginOrg=this.service.login(org, result);
		if(result.hasErrors()) {
			return "orgLogin.jsp";
		}
		session.setAttribute("orgId", loginOrg.getId());
		return "redirect:/orgs/dashboard";
	}
	
	// Display route :render dashboard page
	@GetMapping("/orgs/dashboard")
	public String dashboard(Model model,HttpSession session) {
		if(session.getAttribute("orgId")!=null) {
		model.addAttribute("org",this.service.oneOrg((Long)session.getAttribute("orgId")));
		List<User> developers=userService.all();
		model.addAttribute("developers", developers);
		model.addAttribute("jobOffers", positionService.all());
		
		return "dashboard.jsp";
		}return "redirect:/orgs/register";
	}
	
	// Display route : position form
	@GetMapping("/orgs/jobs/new")
	public String newPosition(@ModelAttribute("position") Position position,HttpSession session) {
		if(session.getAttribute("orgId")!=null) {
			return "newPosition.jsp";
		}
		return "redirect:/orgs/register";		
	}
	
	// Action Route save the position to database
	@PostMapping("/orgs/jobs/new")
	public String savePosition(@Valid @ModelAttribute("position") Position position,BindingResult result,Model model,HttpSession session) {
		if(result.hasErrors()) {
			return "newPosition.jsp";
		}
		Long orgId=(Long)session.getAttribute("orgId");
		Organization org=this.service.oneOrg(orgId);
		position.setOrganization(org);
		positionService.add(position);
		return "redirect:/orgs/dashboard";	
		
	}
	@GetMapping("/offers/jobs/{offerId}")
	public String chooseDevelopers(@PathVariable("offerId") Long offerId,Model model,HttpSession session) {
		model.addAttribute("org", this.service.oneOrg((Long)session.getAttribute("orgId")));
		model.addAttribute("position",positionService.getById(offerId));
		List<Position> positions=positionService.all();
		List<User> developers=userService.all();
		
		
		for(User developer:developers) {
			//System.out.println(developer.getFirstName());
			//System.out.println(developer.getProfile().getFrameworks());
			//System.out.println(developer.getProfile().getLanguages());
			for(Position position:positions) {
				//System.out.println("*********");
				//System.out.println(position);
				
				Boolean isDevs=getAvailableDevelopers(developer.getProfile().getLanguages(),
													   developer.getProfile().getFrameworks(),
													   position.getSkills());
				if(isDevs) {
					System.out.println(developers);
					model.addAttribute("developers", developers);
				}
				
			}
			
		}
		
		return "specificDeveolpers.jsp";
	}
	


	@SuppressWarnings("unused")
	private Boolean getAvailableDevelopers(ArrayList<String> languages, ArrayList<String> frameworks,
			ArrayList<String> skills) {
		Boolean isExist = false;
			for(int i=0;i<languages.size();i++) {
				for(int j=0; j<frameworks.size();j++) {
					if(skills.contains(languages.get(i)) || skills.contains(frameworks.get(j))) {
						return  true;
					}return true;
				}
		}
		System.out.println(isExist);
		return isExist;
	}

	// route for Organization logout
	@GetMapping("/orgs/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("orgId");
		return "redirect:/orgs/register";
	}
	
	

}
