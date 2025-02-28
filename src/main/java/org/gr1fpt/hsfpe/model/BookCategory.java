package org.gr1fpt.hsfpe.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int BookCategoryId;
    String BookGenreType;
    String Description;
}
