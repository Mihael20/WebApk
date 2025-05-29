package com.iwec.rest.example.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iwec.rest.example.model.Book;
import com.iwec.rest.example.repository.BookRepository;

@CrossOrigin({"*"})
@RestController
@RequestMapping({"v1/rest/books/"})
public class BookController {
  @Autowired
  private BookRepository bookrepository;
  
  @RequestMapping(method = {RequestMethod.GET}, produces = {"application/json"})
  @ResponseBody
  public List<Book> getAllBooksOrderedById() {
    return this.bookrepository.getAllBooksOrderedById();
  }
  
  @RequestMapping(value = {"/{id}"}, method = {RequestMethod.GET})
  public ResponseEntity<Book> getById(@PathVariable("id") Integer id) {
    Book book = this.bookrepository.findById(id);
    HttpStatus status = (book != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return new ResponseEntity<Book>(book, status);
  }
  
  @RequestMapping(method = {RequestMethod.POST}, consumes = {"application/json"})
  @ResponseStatus(HttpStatus.CREATED)
  public Integer insert(@RequestBody Book book) {
    return this.bookrepository.saveOrUpdate(book);
  }
  
  @RequestMapping(method = {RequestMethod.PUT}, consumes = {"application/json"})
  @ResponseStatus(HttpStatus.OK)
  public Integer update(@RequestBody Book book) {
    return this.bookrepository.saveOrUpdate(book);
  }
  
  @RequestMapping(value = {"/{id}"}, method = {RequestMethod.DELETE})
  public HttpStatus delete(@PathVariable("id") Integer id) {
    boolean isDeleted = this.bookrepository.delete(id);
    System.err.println("######" + isDeleted);
    return isDeleted ? HttpStatus.OK : HttpStatus.NOT_FOUND;
  }
}

