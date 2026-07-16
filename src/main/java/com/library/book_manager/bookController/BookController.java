package com.library.book_manager.bookController;

import com.library.book_manager.bookService.BookService;
import com.library.book_manager.dto.BookRequest;
import com.library.book_manager.dto.BookResponse;
import com.library.book_manager.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**********************************************
 Developer Name: Vikas
 Created on: 15-07-2026 15:45
 Project Name: book-manager ${
 /**********************************************/
@RestController
@RequestMapping("/book")
public class BookController
{
    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<BookResponse> addBook(@RequestBody BookRequest bookRequest)
    {
        BookResponse bookResponse = bookService.addBook(bookRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookResponse);
    }

    @GetMapping("/get-all-books")
    public ResponseEntity<List<BookResponse>> getAllBook()
    {
        List<BookResponse> bookResponseList = bookService.getAllBook();
        return ResponseEntity.status(HttpStatus.OK).body(bookResponseList);
    }

    @GetMapping("/get-by-id")
    public ResponseEntity<BookResponse> getBook(@RequestParam("id") Long id)
    {
        BookResponse bookResponse = bookService.getBook(id);
        return ResponseEntity.status(HttpStatus.OK).body(bookResponse);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BookResponse> updateBook(@RequestBody BookRequest bookRequest, @PathVariable("id") Long id)
    {
        BookResponse bookResponse = bookService.updateBook(bookRequest, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookResponse);
    }

    @DeleteMapping("/delete-book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
        String message = bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

}
