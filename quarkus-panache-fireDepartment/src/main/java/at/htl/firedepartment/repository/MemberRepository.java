package at.htl.firedepartment.repository;

import at.htl.firedepartment.model.Member;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MemberRepository implements PanacheRepository<Member> {


}
