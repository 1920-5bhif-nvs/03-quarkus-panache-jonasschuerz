package at.htl.firedepartment.rest;

import at.htl.firedepartment.model.Vehicle;
import at.htl.firedepartment.repository.VehicleRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("vehicle")
public class VehicleEndpoint {
    @Inject
    VehicleRepository vehicleRepository;

    @Path("/findAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response findAll() {
        List<Vehicle> vehicles =  vehicleRepository.listAll();
        return Response.ok().entity(vehicles).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response findById(@PathParam("id") long id) {
        Vehicle vehicle = vehicleRepository.findById(id);
        if (vehicle == null) {
            return Response.status(404).build();
        }
        return Response.ok().entity(vehicle).build();
    }

    @DELETE
    @Path("/deleteVehicle/{id}")
    @Transactional
    public Response deleteById(@PathParam("id") long id) {
        Vehicle vehicle = vehicleRepository.findById(id);
        if (vehicle == null) {
            return Response.status(404).build();
        }
        vehicleRepository.delete(vehicle);
        return Response.noContent().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Vehicle vehicle){
        vehicleRepository.persist(vehicle);
        return Response.ok().entity(vehicle).build();
    }

}
