package com.tickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tickets.model.Ticket;
import com.tickets.repository.TicketRepository;
import com.tickets.validation.Validator;

@Service
public class TicketServiceImpl implements TicketService {
	
	private final TicketRepository ticketRepository;
	private final Validator validator;
	
	@Autowired
	public TicketServiceImpl(TicketRepository ticketRepository, Validator validator) {
		this.ticketRepository = ticketRepository;
		this.validator = validator;
	}

	
	@Override
	public Ticket getById(long id) {
		Ticket ticket = ticketRepository.getById(id);
		validator.checkEntity(ticket);
		return ticket;
	}
	
	@Override
	public List<Ticket> getAll() {
		return ticketRepository.getAll();
	}

	@Override
	public void save(Ticket ticket) {
		validator.checkEntity(ticket);
		ticket.setPrice(ticket.getPrice() + "$");
		ticketRepository.save(ticket);
	}

	@Override
	public void update(Ticket ticket) {
		validator.checkEntity(ticket);
		ticket.setPrice(ticket.getPrice() + "$");
		ticketRepository.update(ticket);
	}

	@Override
	public void delete(long id) {
		validator.checkId(id);
		validator.checkEntity(ticketRepository.getById(id));
		ticketRepository.delete(id);
	}


}
