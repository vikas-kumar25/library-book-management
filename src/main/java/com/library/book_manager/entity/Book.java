package com.library.book_manager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

/**********************************************
 Developer Name: Vikas
 Created on: 15-07-2026 15:42
 Project Name: book-manager ${
 /**********************************************/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity // Tells JPA to map this class to a database table
@Builder
public class Book
{
        @Id // Marks this field as the primary key
        @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increments the ID
        private Long id;

        private String title;

        private String author;

        private Integer bookSold;
}
