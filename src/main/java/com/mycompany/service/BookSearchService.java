/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.logic.BookSearchLogic;
import com.mycompany.model.dto.model.BookSearchDTO;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.mycompany.interfaces.IBookSearchLogic;
import javax.ws.rs.core.Response;

/**
 *
 * @author Carlos Urango
 */
@Path("/booksearch")
@Produces(MediaType.APPLICATION_JSON)
public class BookSearchService {

    private final IBookSearchLogic bookSearchLogic;
    
    public BookSearchService(){
        this.bookSearchLogic = new BookSearchLogic();
    }

    @POST
    public BookSearchDTO add(BookSearchDTO dto) {
        return bookSearchLogic.add(dto);
    }

    @PUT
    public BookSearchDTO update(BookSearchDTO dto) {
        return bookSearchLogic.update(dto);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response all() {
        Response response = Response.status(200).header("Access-Control-Allow-Origin", "*").entity(bookSearchLogic.all()).build();
        return response;
    }

}

