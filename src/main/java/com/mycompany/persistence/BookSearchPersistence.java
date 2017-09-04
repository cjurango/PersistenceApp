/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.persistence;

import com.mycompany.model.entity.BookSearchEntity;

/**
 *
 * @author Carlos Urango
 */
public class BookSearchPersistence extends Persistencer<BookSearchEntity, String>{

    public BookSearchPersistence(){
        this.entityClass = BookSearchEntity.class;
    }

}
