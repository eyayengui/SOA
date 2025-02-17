package com.esprit.ressources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.esprit.busniss.LogementBusiness;
import com.esprit.busniss.RendezVousBusiness;
import com.esprit.entities.RendezVous;




@Path("rendezvous")
public class RendezVousResources {
	
	private static RendezVousBusiness RB=new RendezVousBusiness();
	public static LogementBusiness logementMetier=new LogementBusiness();
RendezVous r= new RendezVous(1, "31-10-2015","15:30", 
		logementMetier.getLogementsByReference(4), "55214078");

	

@GET
@Produces(MediaType.APPLICATION_JSON)
public   Response     getListRDV()
{
if(RB.getListeRendezVous().size()!=0)
return Response.status(Status.OK).entity(RB.getListeRendezVous()).build();

return Response.status(Status.NOT_FOUND).entity("La liste est vide").build();

	}


}

