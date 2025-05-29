package com.iwec.rest.example.controller.rest;

import com.iwec.rest.example.model.Author;
import com.iwec.rest.example.repository.AuthorRepository;

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

@CrossOrigin({"*"})
@RestController
@RequestMapping({"v1/rest/authors/"})
public class AuthorController {
  @Autowired
  private AuthorRepository repository;
  
  @RequestMapping(method = {RequestMethod.GET}, produces = {"application/json"})
  @ResponseBody
  public List<Author> getAllAuthorsOrderedById() {
    return this.repository.getAllAuthorsOrderedById();
  }
  
  @RequestMapping(value = {"/{id}"}, method = {RequestMethod.GET})
  public ResponseEntity<Author> getById(@PathVariable("id") Integer id) {
    Author author = this.repository.findById(id);
    HttpStatus status = (author != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return new ResponseEntity<Author>(author, status);
  }
  
  @RequestMapping(method = {RequestMethod.POST}, consumes = {"application/json"})
  @ResponseStatus(HttpStatus.CREATED)
  public Integer insert(@RequestBody Author author) {
    return this.repository.saveOrUpdate(author);
  }
  
  @RequestMapping(method = {RequestMethod.PUT}, consumes = {"application/json"})
  @ResponseStatus(HttpStatus.OK)
  public Integer update(@RequestBody Author author) {
    return this.repository.saveOrUpdate(author);
  }
  
  @RequestMapping(value = {"/{id}"}, method = {RequestMethod.DELETE})
  public HttpStatus delete(@PathVariable("id") Integer id) {
    boolean isDeleted = this.repository.delete(id);
    System.err.println("######" + isDeleted);
    return isDeleted ? HttpStatus.OK : HttpStatus.NOT_FOUND;
  }
}
