package org.example.recursos;

import org.example.api.Estadios;
import org.example.api.Results;
import org.example.dao.EstadiosDao;

import javax.ws.rs.*;


@Path("trends")
@Produces({"application/json"})
@Consumes({"application/json"})
public class EstadiosRecursos {
    EstadiosDao dao;

    public EstadiosRecursos(EstadiosDao dao) {
        this.dao = dao;
    }

    @GET
    public Estadios getAllTrends() {
        return this.dao.getAllTrends();
    }

    @POST
    @Path("/create/{data}")
    public void createResult(@PathParam("data") String data) {
        this.dao.createResult(this.getResultFromString(data));
    }

    @PUT
    @Path("/update/{data}")
    public void updateResult(@PathParam("data") String data) {
        this.dao.updateResult(this.getResultFromString(data));
    }

    public Results getResultFromString(String data) {
        String[] cols = data.split(",");
        Results result = new Results();
        result.setDate(cols[0]);
        result.setValue(Double.parseDouble(cols[1]));
        return result;
    }
}
