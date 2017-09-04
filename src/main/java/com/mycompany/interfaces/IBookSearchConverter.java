/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.model.dto.model.BookSearchDTO;
import com.mycompany.model.entity.BookSearchEntity;
import java.util.List;

/**
 *
 * @author Carlos Urango
 */
public interface IBookSearchConverter {
    
    public BookSearchDTO entityToDto(BookSearchEntity entity);
    public BookSearchEntity dtoToEntity(BookSearchDTO dto);
    public List<BookSearchDTO> listEntitiesToListDTOs(List<BookSearchEntity> entities);
    public List<BookSearchEntity> listDTOsToListEntities(List<BookSearchDTO> dtos);
    
}
