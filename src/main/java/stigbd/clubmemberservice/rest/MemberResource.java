package stigbd.clubmemberservice.rest;

import stigbd.clubmemberservice.domain.Member;
import stigbd.clubmemberservice.repository.RepositoryDefault;
import stigbd.clubmemberservice.service.Service;

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

    private static final Service SERVICE = new Service();

    static {
        Service.setREPOSITORY(new RepositoryDefault());
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMembers() {

        List<Member> members = SERVICE.listMembers();
        GenericEntity<List<Member>> list = new GenericEntity<List<Member>>(members) {
        };
        return Response.ok(list).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMember(Member member) {

        String id = SERVICE.createMember(member);
        URI uri = URI.create(id);

        return Response.created(uri).build();
    }

    @Path("/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMemberById(@PathParam("id") String id) {

        Member member = SERVICE.retrieveMember(id);
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

        Member m = SERVICE.changeMember(id, member);
        if (m != null) {
            return Response.noContent().build();
        }
        return Response
                .status(Response.Status.NOT_FOUND)
                .build();
    }

    @Path("/{id}")
    @DELETE
    public Response deleteMemberById(@PathParam("id") String id) {

        String deletedId = SERVICE.removeMember(id);
        if (deletedId != null) {
            return Response.noContent().build();
        }
        return Response
                .status(Response.Status.NOT_FOUND)
                .build();
    }

}
