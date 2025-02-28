package org.gr1fpt.hsfpe.repository;

import org.gr1fpt.hsfpe.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

   List<Book> findByBookNameContaining(String name);
}
