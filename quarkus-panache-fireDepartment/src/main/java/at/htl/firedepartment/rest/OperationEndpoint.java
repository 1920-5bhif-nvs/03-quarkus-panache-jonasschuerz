package at.htl.firedepartment.rest;

import at.htl.firedepartment.model.Operation;
import at.htl.firedepartment.repository.OperationRepository;

import javax.inject.Inject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("operation")
public class OperationEndpoint {
    @Inject
    OperationRepository operationRepository;

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Operation> operations = operationRepository.listAll();
        return Response.ok().entity(operations).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") long id) {
        Operation operation = operationRepository.findById(id);
        if (operation == null) {
            return Response.status(404).build();
        }
        return Response.ok().entity(operation).build();
    }

    @DELETE
    @Path("/deleteOperation/{id}")
    public Response deleteById(@PathParam("id") long id) {
        Operation operation = operationRepository.findById(id);
        if (operation == null) {
            return Response.status(404).build();
        }
        operationRepository.delete(operation);
        return Response.noContent().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Operation operation){
        operationRepository.persist(operation);
        return Response.ok().entity(operation).build();
    }

}
