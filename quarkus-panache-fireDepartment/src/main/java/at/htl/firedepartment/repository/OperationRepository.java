package at.htl.firedepartment.repository;

import at.htl.firedepartment.model.Operation;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OperationRepository implements PanacheRepository<Operation> {
}
