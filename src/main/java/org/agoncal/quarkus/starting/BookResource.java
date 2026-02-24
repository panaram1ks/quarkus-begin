package org.agoncal.quarkus.starting;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Optional;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @GET
    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "Me","Title1", 2025, "IT"),
                new Book(2, "Him","Title2", 2023, "IT"),
                new Book(3, "She","Title3", 2019, "IT")
        );
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks(){
        return getAllBooks().size();
    }

    @GET
    @Path("{id}")
    public Optional<Book> getBook(@PathParam("id") int id){
       return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }

}
