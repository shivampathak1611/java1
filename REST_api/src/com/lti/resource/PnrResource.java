package com.lti.resource;
//http://localhost:8181/REST_api/api/pnr?pnrNo=12563

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.lti.resource.Passenger.Gender;
import com.lti.resource.Passenger.Status;

//assume you are working for IRCTC and you are responsible for developing PNR API
@Path("/pnr")
public class PnrResource {
	
	@GET
	//can be written like this for json or second one //@Produces("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Pnr check(@QueryParam("pnrNo") int pnrNo, @Context HttpServletResponse response)//returning object of a class will be sent in the form of json not object
	{
		//enabling cors
		response.setHeader("Access-Control-Allow-Origin","http://localhost:4200");
		//response.setHeader("Access-Control-Allow-Origin","*");//for all
		Pnr pnr = new Pnr();
		pnr.setPnrNo(pnrNo);
		pnr.setTrainNo(12345);
		pnr.setTravelDate(LocalDate.of(2020, 12, 25));
		
		List<Passenger> passengers = new ArrayList<Passenger>();
		passengers.add(new Passenger("Majrul", Gender.MALE, Status.RAC));
		passengers.add(new Passenger("Dinesh", Gender.MALE, Status.RAC));
		passengers.add(new Passenger("Soumya", Gender.FEMALE, Status.CONFIRMED));
		pnr.setPassengers(passengers);
		
		return pnr;
	}
}
