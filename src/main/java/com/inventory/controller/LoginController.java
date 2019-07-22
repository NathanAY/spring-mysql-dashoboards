package com.inventory.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inventory.model.MstBarang;
import com.inventory.model.Notes;
import com.inventory.model.User;
import com.inventory.repository.BarangRepo;
import com.inventory.repository.NotesRepository;
import com.inventory.service.EmailService;
import com.inventory.service.SecurityService;
import com.inventory.service.UserService;
import com.inventory.validator.UserValidator;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	@Autowired
	private NotesRepository notesRepo;
	
	@Autowired
	private BarangRepo barangRepo;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new User());

		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
		userValidator.validate(userForm, bindingResult);

		System.out.println(userForm.getUsername());
		// System.out.println(bindingResult);

		// if (bindingResult.hasErrors()) {
		// return "/registration";
		// }

		userService.save(userForm);

		securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

		// emailService.sendSimpleEmail(userForm.getEmail(), "Test Email",
		// "This is the test email template for your email");
		return "redirect:/dashboard";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {

		System.out.println("login");
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
	public String welcome(Model model) {
		return "welcome";
	}

	@RequestMapping(value = { "/", "/dashboard" }, method = RequestMethod.GET)
	public String dashboard(Model model) {
		return "dashboard";
	}

	@RequestMapping(value = { "/icons" }, method = RequestMethod.GET)
	public String icons(Model model) {
		return "icons";
	}
	
	@RequestMapping(value = "/dashboard/save")
	public String dashboardBave(Model model, @ModelAttribute MstBarang barang, HttpServletRequest request) {
		if (barang != null) {
			barangRepo.save(barang);
		}
		return "dashboard";
	}

	@RequestMapping(value = "/welcome/save")
	public String save(Model model, @ModelAttribute Notes note, HttpServletRequest request) {
		if (note != null) {
			notesRepo.save(note);
		}
		return "welcome";
	}

	@RequestMapping(value = "/welcome/save", method = RequestMethod.GET)
	public String save(Model model) {
		return "welcome";
	}
}
