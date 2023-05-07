package com.module;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.payload.pojo.Booking;
import com.payload.pojo.Bookingdates;



	public class PayloadModule {

	    // Set the values on the payload
	    ObjectMapper objectMapper;

	    public String createPayload() throws JsonProcessingException {
	        objectMapper = new ObjectMapper();
	        Booking booking = new Booking();
	        booking.setFirstname("Pramod");
	        booking.setLastname("Dutta");
	        booking.setTotalprice(200.00);
	        booking.setDepositpaid(true);
	        booking.setAdditionalneeds("Lunch");
	        Bookingdates bookingdates = new Bookingdates();
	        bookingdates.setCheckin("2022-10-01");
	        bookingdates.setCheckout("2022-10-01");
	        booking.setBookingdates(bookingdates);
	        // Java Object -> Json String ->
	        String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
	        return payload;
	    }


	}



