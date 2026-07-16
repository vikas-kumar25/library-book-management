package com.library.book_manager.bookService;

import com.library.book_manager.bookRepository.BookRepository;
import com.library.book_manager.dto.BookRequest;
import com.library.book_manager.dto.BookResponse;
import com.library.book_manager.entity.Book;
import com.library.book_manager.exception.BookNotFoundException;
import com.library.book_manager.transformer.BookTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**********************************************
 Developer Name: Vikas
 Created on: 15-07-2026 15:45
 Project Name: book-manager ${
 /**********************************************/
@Service
public class BookService
{
    @Autowired
    private BookRepository bookRepository;

    public BookResponse addBook(BookRequest bookRequest)
    {
        Book book = BookTransformer.bookRequestToBook(bookRequest);
        Book savedBook = bookRepository.save(book);
        BookResponse bookResponse = BookTransformer.bookToBookResponse(savedBook);
        return bookResponse;
    }

    public List<BookResponse> getAllBook()
    {
        List<Book> bookList = bookRepository.findAll();
        if (bookList.isEmpty())
        {
            throw new BookNotFoundException("Sorry, No Book exist!");
        }

        // Create an empty list to hold the responses
        List<BookResponse> responseList = new ArrayList<>();

        // Loop through each book and map it
        for (Book book : bookList)
        {
            BookResponse response = new BookResponse();
            response.setId(book.getId());
            response.setTitle(book.getTitle());
            response.setAuthor(book.getAuthor());
            response.setBookSold(book.getBookSold());

            responseList.add(response);
        }
        return responseList;
    }

    public BookResponse getBook(Long id)
    {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty())
        {
            throw new BookNotFoundException("Sorry, Book with id= " + id + " does not exist!");
        }
        Book bookFound = optionalBook.get();
        BookResponse bookResponse = BookTransformer.bookToBookResponse(bookFound);
        return bookResponse;
    }

    public BookResponse updateBook(BookRequest bookRequest, Long id)
    {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty())
        {
            throw new BookNotFoundException("Sorry, Book with id= " + id + " does not exist!");
        }
        Book bookFound = optionalBook.get();
        // --- Update the fields ---
        bookFound.setTitle(bookRequest.getTitle());
        bookFound.setAuthor(bookRequest.getAuthor());
        bookFound.setBookSold(bookRequest.getBookSold());

        Book updatedBook = bookRepository.save(bookFound);

        BookResponse bookResponse = BookTransformer.bookToBookResponse(updatedBook);
        return bookResponse;
    }

    public String deleteBook(Long id)
    {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty())
        {
            throw new BookNotFoundException("Sorry, Book with id= " + id + " does not exist!");
        }
        Book bookFound = optionalBook.get();
        bookRepository.delete(bookFound);
        return "BOOK WITH ID = " + id + " DELETED SUCCESSFULLY! ";
    }
}
