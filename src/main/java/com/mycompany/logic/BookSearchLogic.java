/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.logic;

import com.mycompany.model.dto.model.BookSearchDTO;
import java.util.List;
import static com.mycompany.model.dto.converter.BookSearchConverter.CONVERTER;
import com.mycompany.persistence.BookSearchPersistence;
import java.util.UUID;
import com.mycompany.interfaces.IBookSearchLogic;

/**
 *
 * @author Carlos Urango
 */
public class BookSearchLogic implements IBookSearchLogic {

    private final BookSearchPersistence persistence;

    public BookSearchLogic() {
        this.persistence = new BookSearchPersistence();
    }

    @Override
    public BookSearchDTO add(BookSearchDTO dto) {
        if (dto.getId() == null) {
            dto.setId(UUID.randomUUID().toString());
        }
        BookSearchDTO result = CONVERTER.entityToDto(persistence.add(CONVERTER.dtoToEntity(dto)));
        return result;
    }

    @Override
    public BookSearchDTO update(BookSearchDTO dto) {
        BookSearchDTO result = CONVERTER.entityToDto(persistence.update(CONVERTER.dtoToEntity(dto)));
        return result;
    }

    @Override
    public List<BookSearchDTO> all() {
        return CONVERTER.listEntitiesToListDTOs(persistence.all());
    }

}
