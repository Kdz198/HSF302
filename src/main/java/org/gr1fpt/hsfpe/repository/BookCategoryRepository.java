package org.gr1fpt.hsfpe.repository;

import org.gr1fpt.hsfpe.model.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory,Integer> {
}
