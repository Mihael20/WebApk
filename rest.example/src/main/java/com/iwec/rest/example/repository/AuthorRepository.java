package com.iwec.rest.example.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.iwec.rest.example.model.Author;

@Component
public class AuthorRepository {
  private static final Map<Integer, Author> authors = new TreeMap<>();
  
  @PostConstruct
  public void initData() {
    Author author = new Author();
    author.setId(Integer.valueOf(1));
    author.setFirstName("Stiv");
    author.setLastName("Jobs");
    authors.put(author.getId(), author);
    author = new Author();
    author.setId(Integer.valueOf(2));
    author.setFirstName("Miguel");
    author.setLastName("Jonson");
    authors.put(author.getId(), author);
    author = new Author();
    author.setId(Integer.valueOf(3));
    author.setFirstName("Dino");
    author.setLastName("Dinev");
    authors.put(author.getId(), author);
    author = new Author();
    author.setId(Integer.valueOf(4));
    author.setFirstName("Petar");
    author.setLastName("Ognenovski");
    authors.put(author.getId(), author);
  }
  
  public Author findById(Integer id) {
    return (id == null) ? null : authors.get(id);
  }
  
  public List<Author> getAllAuthorsOrderedById() {
    List<Author> authorList = new ArrayList<>(authors.values());
    return authorList;
  }
  
  public Integer saveOrUpdate(Author author) {
    Integer key = Integer.valueOf((author == null || author.getId() == null) ? (
    		authors.size() + 1) : 
        	author.getId().intValue());
    author.setId(key);
    authors.put(key, author);
    return author.getId();
  }
  
  public boolean delete(Integer id) {
	  Author author = authors.remove(id);
    return (author != null);
  }
}