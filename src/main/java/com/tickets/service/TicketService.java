package com.tickets.service;

import java.util.List;


import com.tickets.model.Ticket;

public interface TicketService {
	
	 List<Ticket> getAll();
	 void save(Ticket ticket);
	 void update(Ticket ticket);
	 void delete(long id);
}
