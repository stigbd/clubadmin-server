/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stigbd.clubadmin.server.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import stigbd.clubadmin.server.service.Service;

/**
 *
 * @author sbd
 */
@Path("/")
public class RootResource {

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
    public Response getSlashJSON() {

        return Response.ok().
                link("http://localhost:8080/clubadmin/", "self" ).
                link("http://localhost:8080/clubadmin/member", "member" ).
                link("http://localhost:8080/clubadmin/event", "event").
                link("http://localhost:8080/clubadmin/admin", "admin").
                build();
    }

    @GET
    @Produces({MediaType.TEXT_HTML})
    public Response getSlashHTML() {

        return Response.ok().
                link("http://localhost:8080/clubadmin/", "self" ).
                link("http://localhost:8080/clubadmin/member", "member" ).
                link("http://localhost:8080/clubadmin/event", "event").
                link("http://localhost:8080/clubadmin/admin", "admin" ).
                build();
    }
}
