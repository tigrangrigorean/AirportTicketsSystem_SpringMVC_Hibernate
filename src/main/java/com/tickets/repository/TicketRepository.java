package com.tickets.repository;

import java.util.List;

import com.tickets.model.Ticket;

public interface TicketRepository {
	
	 Ticket getById(long id);
	 List<Ticket> getAll();
	 void save(Ticket ticket);
	 void update(Ticket ticket);
	 void delete(long id);

}
