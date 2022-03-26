package dev.highright96.springstudy.transaction;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService self;

    public void addBooks(List<String> bookNames) {
        bookNames.forEach(self::addBook);
    }

    @Transactional
    public void addBook(String bookName) {
        Book book = new Book(bookName);
        bookRepository.save(book);
        book.setFlag(true);
    }
}
