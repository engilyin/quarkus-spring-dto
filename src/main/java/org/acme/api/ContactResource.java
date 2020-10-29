package org.acme.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.entities.Contact;
import org.acme.services.ContactService;

import lombok.AllArgsConstructor;

@Path("/api")
@AllArgsConstructor
public class ContactResource {

    private final ContactService contactService;

    @GET
    @Path("/contact/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Contact searchContact(@PathParam("username") String username) {
        return contactService.find(username);
    }
    
    @GET
    @Path("/contact")
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Contact> listAll(String username) {
        return contactService.findAll();
    }
}