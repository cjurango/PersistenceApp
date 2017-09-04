/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.dto.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Urango
 */
@XmlRootElement
public class BookSearchDTO {

    private String id;

    private String query;

    private Date datetime;

    private int numResults;
    
    private List<String> books;

    public BookSearchDTO() {
        this.books = new ArrayList();
    }

    public BookSearchDTO(String id, String query, Date datetime, List<String> books, int numResults) {
        this.id = id;
        this.query = query;
        this.datetime = datetime;
        this.books = books;
        this.numResults = numResults;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public int getNumResults() {
        return numResults;
    }

    public void setNumResults(int numResults) {
        this.numResults = numResults;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }
    
    public void addBook(String id){
        this.books.add(id);
    }

}
