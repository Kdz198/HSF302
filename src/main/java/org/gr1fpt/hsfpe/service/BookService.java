package org.gr1fpt.hsfpe.service;

import org.gr1fpt.hsfpe.model.Book;
import org.gr1fpt.hsfpe.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public java.util.List<Book> getAll()
    {
        return bookRepository.findAll();
    }

    public Book create(Book book)
    {
        return bookRepository.save(book);
    }

    public void delete(int id) {

        bookRepository.deleteById(id);
    }

    public Book update (Book book)
    {
        if (bookRepository.findById(book.getBookId()).isPresent())
        {
            bookRepository.save(book);
        }
        //throw new customException.....
        return null;
    }

    public java.util.List<Book> findByName(String name)
    {
        return bookRepository.findByBookNameContaining(name);
    }

}
