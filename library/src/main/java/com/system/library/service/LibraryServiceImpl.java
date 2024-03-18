package com.system.library.service;

import com.system.library.dao.BookRepository;
import com.system.library.entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService{

    @Autowired
    private BookRepository repository;

    @Override
    public List<Book> findAll() {

        return repository.findAll();
    }

    @Override
    public Book findBy(int id) {

        Optional<Book> result = repository.findById(id);
        Book theBook = null;

        if (result.isPresent()) {
            theBook = result.get();
        }
        else {
            throw new RuntimeException("Did not find book id - " + id);
        }
        return theBook;

    }

    @Transactional
    @Override
    public Book save(Book theBook) {

        return repository.save(theBook);
    }

    @Transactional
    @Override
    public void deleteByID(int id) {

        repository.deleteById(id);


    }
}
