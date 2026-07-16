package com.library.book_manager.dto;

/**********************************************
 Developer Name: Vikas
 Created on: 15-07-2026 15:48
 Project Name: book-manager ${
 /**********************************************/

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest
{
    private String title;

    private String author;

    private Integer bookSold;
}
