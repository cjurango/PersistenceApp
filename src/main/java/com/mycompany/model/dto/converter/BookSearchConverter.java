/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.dto.converter;

import com.mycompany.model.dto.model.BookSearchDTO;
import com.mycompany.model.entity.BookSearchEntity;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.interfaces.IBookSearchConverter;

/**
 *
 * @author Carlos Urango
 */
public class BookSearchConverter implements IBookSearchConverter{

    public static IBookSearchConverter CONVERTER = new BookSearchConverter();

    public BookSearchConverter() {
    }

    @Override
    public BookSearchDTO entityToDto(BookSearchEntity entity) {
        BookSearchDTO dto = new BookSearchDTO();
        dto.setId(entity.getId());
        dto.setQuery(entity.getQuery());
        dto.setDatetime(entity.getDatetime());
        dto.setNumResults(entity.getNumResults());
        dto.setBooks(entity.getBooks());
        return dto;
    }

    @Override
    public BookSearchEntity dtoToEntity(BookSearchDTO dto) {
        BookSearchEntity entity = new BookSearchEntity();
        entity.setId(dto.getId());
        entity.setQuery(dto.getQuery());
        entity.setDatetime(dto.getDatetime());
        entity.setNumResults(dto.getNumResults());
        entity.setBooks(dto.getBooks());
        return entity;
    }

    @Override
    public List<BookSearchDTO> listEntitiesToListDTOs(List<BookSearchEntity> entities) {
        ArrayList<BookSearchDTO> dtos = new ArrayList<>();
        for (BookSearchEntity entity : entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }

    @Override
    public List<BookSearchEntity> listDTOsToListEntities(List<BookSearchDTO> dtos) {
        ArrayList<BookSearchEntity> entities = new ArrayList<>();
        for (BookSearchDTO dto : dtos) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }
    
}
