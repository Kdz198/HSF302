package org.gr1fpt.hsfpe.service;

import org.gr1fpt.hsfpe.model.BookCategory;
import org.gr1fpt.hsfpe.repository.BookCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookCategoryService {
    @Autowired
    BookCategoryRepository bookCategoryRepository;

    public java.util.List<BookCategory> getAll()
    {
        return bookCategoryRepository.findAll();
    }

}
