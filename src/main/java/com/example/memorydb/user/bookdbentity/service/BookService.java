package com.example.memorydb.user.bookdbentity.service;

import com.example.memorydb.user.bookdbentity.BookEntity;
import com.example.memorydb.user.bookdbentity.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;


    // create, update
    public BookEntity create(BookEntity book){
        return bookRepository.save(book);
    }

    // all
    public List<BookEntity> findAll(){
        return bookRepository.findAll();
    }

    //delete

    // find one

}
