package stigbd.clubmemberservice.rest;

import stigbd.clubmemberservice.domain.Member;
import stigbd.clubmemberservice.service.Service;
import stigbd.clubmemberservice.service.ServiceDefault;

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
@Path("/")
public class MemberResource {

    private static final Service SERVICE_DEFAULT = new ServiceDefault();


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMembers() {

        List<Member> members = SERVICE_DEFAULT.listMembers();
        GenericEntity<List<Member>> list = new GenericEntity<List<Member>>(members) {
        };
        return Response.ok(list).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMember(Member member) {

        String id = SERVICE_DEFAULT.createMember(member);
        URI uri = URI.create(id);

        return Response.created(uri).build();
    }

    @Path("/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMemberById(@PathParam("id") String id) {

        Member member = SERVICE_DEFAULT.retrieveMember(id);
        if (member != null) {
            return Response.ok(member).build();
        }
        return Response
                .status(Response.Status.NOT_FOUND)
                .build();
    }

    @Path("/{id}")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    public Response putMemberById(@PathParam("id") String id, Member member) {

        String updatedId = SERVICE_DEFAULT.changeMember(id, member);
        if (updatedId != null) {
            return Response.noContent().build();
        }
        return Response
                .status(Response.Status.NOT_FOUND)
                .build();
    }

    @Path("/{id}")
    @DELETE
    public Response deleteMemberById(@PathParam("id") String id) {

        String deletedId = SERVICE_DEFAULT.removeMember(id);
        if (deletedId != null) {
            return Response.noContent().build();
        }
        return Response
                .status(Response.Status.NOT_FOUND)
                .build();
    }

}
