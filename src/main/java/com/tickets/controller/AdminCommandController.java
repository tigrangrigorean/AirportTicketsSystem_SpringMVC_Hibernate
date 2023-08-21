package com.tickets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tickets.model.Ticket;
import com.tickets.service.TicketService;

@Controller
@RequestMapping("/admin")
public class AdminCommandController {
	
	private final TicketService ticketService;

	public AdminCommandController(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	
	
	@GetMapping()
	public String adminPanel(Model model) {
		model.addAttribute("tickets", ticketService.getAll());
		return "admin";
	}
	
	@PostMapping("/register")
	public String registerTicket(@ModelAttribute Ticket ticket, Model model) {
			ticketService.save(ticket);
			return "redirect:/admin";
	}
	
	@DeleteMapping("/delete")
	public String deleteTicket(@ModelAttribute Ticket ticket) {
		ticketService.delete(ticket.getId());
		return "redirect:/admin";
		
	}
	
	@PutMapping("update")
	public String update(@ModelAttribute Ticket ticket) {
		ticketService.update(ticket);
		return "redirect:/admin";
	}
	
	
	@GetMapping("/newticket")
	public String newTicket() {
		return "newticket";
	}
	
	
	
	@GetMapping("/removeticket")
	public String removeTicket() {
		return "removeticket";
	}
	

	
	@GetMapping("/updateticket")
	public String updateTicket() {
		return "updateticket";
	}

}
