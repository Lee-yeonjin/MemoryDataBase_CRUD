package com.example.memorydb.user.bookdbentity.repository;

import com.example.memorydb.db.SimpleDataRepository;
import com.example.memorydb.user.bookdbentity.BookEntity;
import org.springframework.stereotype.Service;


@Service
public class BookRepository extends SimpleDataRepository<BookEntity, Long> {

}
