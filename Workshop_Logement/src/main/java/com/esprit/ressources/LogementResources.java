package com.esprit.ressources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.esprit.busniss.LogementBusiness;
import com.esprit.entities.Logement;



public class LogementResources {

	public static LogementBusiness LB=new LogementBusiness();
	

	
	
	public Response  GetAll()
	{
		
		if(LB.getLogements()!=null)
			return Response.status(Status.OK).entity(LB.getLogements()).build();
		
		else 
			
			return Response.status(Status.NOT_FOUND).entity("liste vide" ).build();	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
