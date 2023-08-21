package com.tickets.repository;

import java.util.List;

import jakarta.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.tickets.config.HibernateConfig;
import com.tickets.model.Ticket;

@Repository
public class TicketRepositoryImpl implements TicketRepository {
	
	private Configuration config = HibernateConfig.getConfiguration();
	private SessionFactory sessionFactory = config.buildSessionFactory();
	

	@Override
	public List<Ticket> getAll() {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = (Query) session.createQuery("FROM Ticket");
		List<Ticket> tickets = ((org.hibernate.query.Query) query).list();
		session.getTransaction().commit();
		session.close();
		return tickets;
	}

	@Override
	public void save(Ticket ticket) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(ticket);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void update(Ticket ticket) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(ticket);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(session.get(Ticket.class, id));
		session.getTransaction().commit();
		session.close();
	}

}
