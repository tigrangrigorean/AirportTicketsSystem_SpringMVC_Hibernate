package com.tickets.validation;

import java.time.DateTimeException;

import org.springframework.stereotype.Component;

import com.tickets.model.Ticket;

import jakarta.persistence.EntityNotFoundException;

@Component
public class Validator {

	  public boolean checkId(long id) {
	        if (id <= 0) {
	            throw new IllegalArgumentException("Id is wrong");
	        }
	        return true;
	    }
	  
	  public boolean checkPassengers(int passengers) {
		  if(passengers <= 0) {
			  throw new IllegalArgumentException("Passengers count < or = 0");
		  }
		  return true;
	  }
	  
	  public boolean checkDate(String date) {
		  String regex = "^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])/\\d{4}$";
		  if(!date.matches(regex)) {
			  throw new DateTimeException("Entered Date is wrong format");
		  }
		  return true;
	  }
	  
	  public boolean checkTime(String time) {
		  String regex = "^(?:[01]\\d|2[0-3]):[0-5]\\d$";
		  if(!time.matches(regex)) {
			  throw new DateTimeException("Entered Time is wrong format");
		  }
		  return true;
	  }

	    public boolean checkEntity(Ticket ticket) {
	        if (ticket == null) {
	            throw new EntityNotFoundException("Address not found");
	        }
	        
	        checkName(ticket.getTitle());
	        checkPassengers(ticket.getPassangers());
	        checkDate(ticket.getDate());
	        checkTime(ticket.getTime());
	        checkName(ticket.getSendAirport());
	        checkName(ticket.getReceiveAirport());
	        checkPrice(Double.parseDouble(ticket.getPrice()));
	        return true;
	    }
	    
	    public boolean checkPrice(double price) {
	        if (price < 0.1) {
	            throw new IllegalArgumentException("Entered price is invalid");
	        }
	        return true;
	    }
	    
	    public boolean checkName(String name) {
	        String regex = "^[A-Z][a-z]*$";
	        if (!name.matches(regex)) {
	            throw new IllegalArgumentException("Name is incorrect. Right format: Yerevan");
	        }
	        return true;
	    }

}
