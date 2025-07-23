package com.example.memorydb.user.bookdbentity.controller;

import com.example.memorydb.user.bookdbentity.BookEntity;
import com.example.memorydb.user.bookdbentity.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookApiController {

    private final BookService bookService;

    @PostMapping("")
    public BookEntity create(
            @RequestBody BookEntity bookEntity
    ){
        return bookService.create(bookEntity);
    }

    @GetMapping ("/all")
    public List<BookEntity> findAll(){
        return bookService.findAll();
    }
}
