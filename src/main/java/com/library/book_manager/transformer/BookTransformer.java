package com.library.book_manager.transformer;

import com.library.book_manager.dto.BookRequest;
import com.library.book_manager.dto.BookResponse;
import com.library.book_manager.entity.Book;

/**********************************************
 Developer Name: Vikas
 Created on: 15-07-2026 16:00
 Project Name: book-manager ${
 /**********************************************/
public class BookTransformer
{
    public static Book bookRequestToBook(BookRequest bookRequest)
    {
        return Book.builder()
                .title(bookRequest.getTitle())
                .author(bookRequest.getAuthor())
                .bookSold(bookRequest.getBookSold())
                .build();
    }

    public static BookResponse bookToBookResponse(Book savedBook)
    {
        return BookResponse.builder()
                .id(savedBook.getId())
                .author(savedBook.getAuthor())
                .title(savedBook.getTitle())
                .bookSold(savedBook.getBookSold())
                .build();
    }
}
