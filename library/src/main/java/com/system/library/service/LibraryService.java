package com.system.library.service;

import com.system.library.entity.Book;

import java.util.List;

public interface LibraryService {

    List<Book> findAll();

    Book findBy(int id);

    Book save(Book theBook);

    void deleteByID(int id);

}
