package com.iwec.rest.example.repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;


import com.iwec.rest.example.model.Book;

@Component
public class BookRepository {
  private static final Map<Integer, Book> books = new TreeMap<>();
  
  @PostConstruct
  public void initData() {
    Book book = new Book();
    book.setId(Integer.valueOf(1));
    book.setBookName("Kasni Porasni");
    book.setFormatName("Html");
    books.put(book.getId(), book);
    book = new Book();
    book.setId(Integer.valueOf(2));
    book.setBookName("Robinson Kruso");
    book.setFormatName("mobi");
    books.put(book.getId(), book);
    book = new Book();
    book.setId(Integer.valueOf(3));
    book.setBookName("Goce Delcev");
    book.setFormatName("Java");
    books.put(book.getId(), book);
    book = new Book();
    book.setId(Integer.valueOf(4));
    book.setBookName("Hamnet");
    book.setFormatName("Pdf");
    books.put(book.getId(), book);
  }
  
  public Book findById(Integer id) {
    return (id == null) ? null : books.get(id);
  }
  
  public List<Book> getAllBooksOrderedById() {
    List<Book> bookList = new ArrayList<>(books.values());
    return bookList;
  }
  
  public Integer saveOrUpdate(Book book) {
    Integer key = Integer.valueOf((book == null || book.getId() == null) ? (
    		books.size() + 1) : 
        	book.getId().intValue());
    book.setId(key);
    books.put(key, book);
    return book.getId();
  }
  
  public boolean delete(Integer id) {
	  Book author = books.remove(id);
    return (author != null);
  }
}
