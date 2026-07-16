package com.library.book_manager.exception;

/**********************************************
 Developer Name: Vikas
 Created on: 15-07-2026 16:18
 Project Name: book-manager ${
 /**********************************************/
public class BookNotFoundException extends RuntimeException
{
    public BookNotFoundException(String message)
    {
        super(message);
    }
}
