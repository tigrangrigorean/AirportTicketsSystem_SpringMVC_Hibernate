package com.tickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tickets.model.Ticket;
import com.tickets.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {
	
	private final TicketRepository ticketRepository;
	
	@Autowired
	public TicketServiceImpl(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	@Override
	public List<Ticket> getAll() {
		// TODO Auto-generated method stub
		return ticketRepository.getAll();
	}

	@Override
	public void save(Ticket ticket) {
		ticketRepository.save(ticket);
	}

	@Override
	public void update(Ticket ticket) {
		ticketRepository.update(ticket);
		
	}

	@Override
	public void delete(long id) {
		ticketRepository.delete(id);
	}

}
