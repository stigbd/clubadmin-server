package stigbd.clubmemberservice.rest;

import stigbd.clubmemberservice.domain.Member;
import stigbd.clubmemberservice.representation.MemberFactory;
import stigbd.clubmemberservice.representation.MemberIdRepresentation;
import stigbd.clubmemberservice.representation.MemberRepresentation;
import stigbd.clubmemberservice.service.Service;
import stigbd.clubmemberservice.service.ServiceDefault;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sbd
 */
@Path("member/")
public class MemberResource {

    private static final Service SERVICE_DEFAULT = new ServiceDefault();
    final Logger logger = Logger.getLogger(MemberFactory.class.getName());


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMembers() {

        List<Member> members = SERVICE_DEFAULT.listMembers();
        List<MemberRepresentation> memberRepresentationList = new ArrayList<>();
        for (Member m: members) {
            memberRepresentationList.add(new MemberRepresentation(m));
        }
        GenericEntity<List<MemberRepresentation>> list = new GenericEntity<List<MemberRepresentation>>(memberRepresentationList) {
        };
        return Response
                .ok(list)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMember(MemberRepresentation memberRepresentation,  @Context UriInfo uriInfo) {

        Member m = MemberFactory.createMember(memberRepresentation);
        if (m != null) {
            String id = SERVICE_DEFAULT.createMember(m);
            URI uri = uriInfo.getAbsolutePathBuilder().path(id).build();
            return Response
                    .created(uri)
                    .build();
        }
        return Response
                .status(422)
                .build();
    }

    @Path("/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMemberById(@PathParam("id") String id) {

        Member member = SERVICE_DEFAULT.retrieveMember(id);
        if (member != null) {
            MemberRepresentation memberRepresentation = new MemberRepresentation(member);
            return Response
                    .ok(memberRepresentation)
                    .build();
        }
        return Response
                .status(Response.Status.NOT_FOUND)
                .build();
    }

    @Path("/{id}")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    public Response putMemberById(@PathParam("id") String id, MemberRepresentation memberRepresentation) {

        Member m = MemberFactory.createMember(memberRepresentation);
        if (m != null) {
            String updatedId = SERVICE_DEFAULT.changeMember(id, m);
            if (updatedId != null) {
                return Response
                        .noContent()
                        .build();
            }
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        } else {
            return Response
                    .status(422)
                    .build();
        }
    }

    @Path("/{id}")
    @DELETE
    public Response deleteMemberById(@PathParam("id") String id) {

        String deletedId = SERVICE_DEFAULT.removeMember(id);
        if (deletedId != null) {
            return Response.
                    noContent()
                    .build();
        }
        return Response
                .status(Response.Status.NOT_FOUND)
                .build();
    }

    @Path("{id}/mainMember/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMainMemberRelation(@PathParam("id") String memberId, MemberIdRepresentation mainMemberIdRepresentation, @Context UriInfo uriInfo) {

        logger.log(Level.INFO, "memberId/mainMemberId ->" + memberId + "/" + mainMemberIdRepresentation.getId());

        String id = SERVICE_DEFAULT.createMainMemberRelation(memberId, mainMemberIdRepresentation.getId());
        if (id != null) {
            URI uri = uriInfo.getAbsolutePathBuilder().path(id).build();

            return Response
                    .created(uri)
                    .build();
        } else {
            return Response
                    .status(400)
                    .build();
        }
    }


    @Path("{id}/familyMember/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createFamilyMemberRelation(@PathParam("id") String memberId, MemberIdRepresentation familyMemberIdRepresentation, @Context UriInfo uriInfo) {

        logger.log(Level.INFO, "memberId/mainMemberId ->" + memberId + "/" + familyMemberIdRepresentation.getId());

        String id = SERVICE_DEFAULT.createMainMemberRelation(familyMemberIdRepresentation.getId(), memberId);
        if (id != null) {
            URI uri = uriInfo.getAbsolutePathBuilder().path(id).build();

            return Response
                    .created(uri)
                    .build();
        } else {
            return Response
                    .status(400)
                    .build();
        }
    }
}
