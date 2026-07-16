package com.library.book_manager.bookRepository;

import com.library.book_manager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**********************************************
 Developer Name: Vikas
 Created on: 15-07-2026 15:46
 Project Name: book-manager ${
 /**********************************************/
@Repository
public interface BookRepository extends JpaRepository<Book, Long>
{

}
