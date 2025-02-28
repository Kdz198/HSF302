package org.gr1fpt.hsfpe.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer BookId;
    @NotNull
    @Column(name = "BookName")
    String bookName;
    String Description;
    @PastOrPresent
    java.sql.Date PublicationDate;
    @Min(value = 1)
    float Price;
    @NotNull
    String Author;
    @ManyToOne
    @JoinColumn(name = "BookCategoryId", nullable = false)
    BookCategory bookCategory;

}
