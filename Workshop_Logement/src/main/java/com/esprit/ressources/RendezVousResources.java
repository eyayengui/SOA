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
import com.esprit.entities.Logement;
import com.esprit.entities.RendezVous;

//classe ci dessous est un service web rest ou on a des methodes qui permettent de faire des operations sur les rendez vous
//consumes pour ajouter

@Path("rendezvous")
public class RendezVousResources {

	private static RendezVousBusiness RB = new RendezVousBusiness();
	public static LogementBusiness logementMetier = new LogementBusiness();
	RendezVous r = new RendezVous(1, "31-10-2015", "15:30",
			logementMetier.getLogementsByReference(4), "55214078");


	//format de sortie de get fait avec produces
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListRDV() {
		if (RB.getListeRendezVous().size() != 0)
			return Response.status(Status.OK).entity(RB.getListeRendezVous()).build();

		return Response.status(Status.NOT_FOUND).entity("La liste est vide").build();

	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRendezVousById(@PathParam("id") int id) {
		RendezVous rendezVous = RB.getRendezVousById(id);
		if (rendezVous != null) {
			return Response.status(Status.OK).entity(rendezVous).build();
		} else {
			return Response.status(Status.NOT_FOUND).entity("Rendez-vous not found").build();
		}
	}

	@GET
	@Path("search")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRendezVousByIdQuery(@QueryParam("id") int id) {
		RendezVous rendezVous = RB.getRendezVousById(id);
		if (rendezVous != null) {
			return Response.status(Status.OK).entity(rendezVous).build();
		} else {
			return Response.status(Status.NOT_FOUND).entity("Rendez-vous not found").build();

		}

	}
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)//yakra boody f postman
	public Response addRDV(RendezVous r) {
		if (RB.addRendezVous(r))
			return Response.status(Status.CREATED).entity("RendezVous ajouté").build();
		return Response.status(Status.NOT_ACCEPTABLE).entity("RendezVous non ajouté").build();
	}
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateRendezVous(@PathParam("id") int id, RendezVous updatedRendezVous) {
		boolean isUpdated = RB.updateRendezVous(id, updatedRendezVous);
		if (isUpdated) {
			return Response.status(Status.OK).entity("RendezVous updated successfully").build();
		} else {
			return Response.status(Status.NOT_FOUND).entity("RendezVous not found or update failed").build();
		}
	}
	@DELETE
	@Path("/delete/{id}")
	public Response deleteRDV(@PathParam("id") int id) {
		if (RB.deleteRendezVous(id))
			return Response.status(Status.OK).entity("RendezVous supprimé").build();
		return Response.status(Status.NOT_FOUND).entity("RendezVous  supprimé").build();
	}

}