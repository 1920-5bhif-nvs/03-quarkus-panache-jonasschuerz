package at.htl.firedepartment.repository;

import at.htl.firedepartment.model.Vehicle;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VehicleRepository implements PanacheRepository<Vehicle> {
}
