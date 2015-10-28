/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stigbd.clubadmin.server.rest;

import stigbd.clubadmin.server.domain.Member;
import stigbd.clubadmin.server.service.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

/**
 *
 * @author sbd
 */
@Path("member/")
public class MemberResource {

    private static final Service SERVICE = new Service();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMembersJSON() {

        List<Member> members = SERVICE.listMembers();
        GenericEntity<List<Member>> list = new GenericEntity<List<Member>>(members) {
        };
        return Response.ok(list).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMember(Member member) {

        Long id = SERVICE.createMember(member);
        URI uri = URI.create("member/" + id);

        return Response.created(uri).build();
    }



    @Path("/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMemberById(@PathParam("id") Long id) {

        Member member = SERVICE.retrieveMember(id);
        if (member != null) {
            return Response.ok(member).build();
        }
        return Response
                .status(Response.Status.NOT_FOUND)
                .build();
    }

}
