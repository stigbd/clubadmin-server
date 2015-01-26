/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stigbd.clubadmin.server.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import stigbd.clubadmin.domain.Member;
import stigbd.clubadmin.server.service.Service;

/**
 *
 * @author sbd
 */
@Path("member/")
public class MemberResource {

    private static final Service SERVICE = new Service();

    /**
     * Method processing HTTP GET requests, producing "text/turtle" MIME media
     * type.
     *
     * @return String that will be send back as a response of type
     * "text/turtle".
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMembersJSON() {

        return Response.ok(SERVICE.listMembers()).build();
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
