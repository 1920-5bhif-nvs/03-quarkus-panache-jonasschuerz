package at.htl.firedepartment.rest;

import at.htl.firedepartment.model.Member;
import at.htl.firedepartment.repository.MemberRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("member")
public class MemberEndpoint {
    @Inject
    MemberRepository memberRepository;

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Member> members = memberRepository.listAll();
        if(members != null && !members.isEmpty())
            return Response.ok(members).build();
        else
            return Response.noContent().build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response findById(@PathParam("id") long id) {
        Member member = memberRepository.findById(id);
        if (member == null) {
            return Response.status(404).build();
        }
        return Response.ok().entity(member).build();
    }

    @DELETE
    @Path("/deleteMember/{id}")
    @Transactional
    public Response deleteById(@PathParam("id") long id) {
        Member member = memberRepository.findById(id);
        if (member == null) {
            return Response.status(404).build();
        }
        memberRepository.delete(member);
        return Response.noContent().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Member member){
        memberRepository.persist(member);
        return Response.ok().entity(member).build();
    }

}
