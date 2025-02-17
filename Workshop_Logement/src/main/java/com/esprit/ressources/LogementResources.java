package com.esprit.ressources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.esprit.busniss.LogementBusiness;
import com.esprit.entities.Logement;




@Path("logements")
public class LogementResources {

	private static LogementBusiness LB = new LogementBusiness();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllLogements() {
		if (LB.getLogements() != null && !LB.getLogements().isEmpty()) {
			return Response.status(Status.OK).entity(LB.getLogements()).build();
		} else {
			return Response.status(Status.NOT_FOUND).entity("La liste est vide").build();
		}
	}


	@GET
	@Path("/get/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response  GetByType(@PathParam("type") Logement.Type type)
	{
		if(LB.getLogementsByType(type)!=null)
			return Response.status(Status.OK).entity(LB.getLogementsByType(type)).build();
		else
			return Response.status(Status.NOT_FOUND).entity("liste vide" ).build();
	}

	
	
}
