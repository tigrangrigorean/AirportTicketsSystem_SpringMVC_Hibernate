package com.tickets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tickets.service.TicketService;



@Controller
@RequestMapping("/")
public class UserPageController {
	
	
	private final TicketService ticketService;
	
	@Autowired
	public UserPageController(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	@GetMapping("/get/{id}")
	public String getById(@PathVariable long id, Model model) {
		model.addAttribute("tickets", ticketService.getById(id));
		return "oneticket";
	}

	
	@GetMapping()
	public String getAll(Model model) {
		model.addAttribute("tickets", ticketService.getAll());
		return "index";
		
	}
	

}
