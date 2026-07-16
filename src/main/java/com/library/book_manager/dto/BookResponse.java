package com.library.book_manager.dto;

import lombok.*;

/**********************************************
 Developer Name: Vikas
 Created on: 15-07-2026 15:48
 Project Name: book-manager ${
 /**********************************************/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponse
{
    private Long id;

    private String title;

    private String author;

    private Integer bookSold;
}
