package com.iwec.rest.example.model;

import lombok.NonNull;

public class Book {
	  private Integer id;
	  
	  @NonNull
	  private String bookName;
	  
	  @NonNull
	  private String formatName;
	  
	  public Integer getId() {
	    return this.id;
	  }
	  
	  @NonNull
	  public String getBookName() {
	    return this.bookName;
	  }
	  
	  @NonNull
	  public String getFormatName() {
	    return this.formatName;
	  }
	  
	  public void setId(Integer id) {
	    this.id = id;
	  }
	  
	  public void setBookName(@NonNull String bookName) {
	    if (bookName == null)
	      throw new NullPointerException("bookName is marked non-null but is null"); 
	    this.bookName = bookName;
	  }
	  
	  public void setFormatName(@NonNull String formatName) {
	    if (formatName == null)
	      throw new NullPointerException("formatName is marked non-null but is null"); 
	    this.formatName = formatName;
	  }
	  
	  public boolean equals(Object o) {
	    if (o == this)
	      return true; 
	    if (!(o instanceof com.iwec.rest.example.model.Book))
	      return false; 
	    com.iwec.rest.example.model.Book other = (com.iwec.rest.example.model.Book)o;
	    if (!other.canEqual(this))
	      return false; 
	    Object this$id = getId(), other$id = other.getId();
	    if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id))
	      return false; 
	    Object this$bookName = getBookName(), other$bookName = other.getBookName();
	    if ((this$bookName == null) ? (other$bookName != null) : !this$bookName.equals(other$bookName))
	      return false; 
	    Object this$formatName = getFormatName(), other$formatName = other.getFormatName();
	    return !((this$formatName == null) ? (other$formatName != null) : !this$formatName.equals(other$formatName));
	  }
	  
	  protected boolean canEqual(Object other) {
	    return other instanceof com.iwec.rest.example.model.Book;
	  }
	  
	  public int hashCode() {
	    
	    int result = 1;
	    Object $id = getId();
	    result = result * 59 + (($id == null) ? 43 : $id.hashCode());
	    Object $bookName = getBookName();
	    result = result * 59 + (($bookName == null) ? 43 : $bookName.hashCode());
	    Object $formatName = getFormatName();
	    return result * 59 + (($formatName == null) ? 43 : $formatName.hashCode());
	  }
	  
	  public String toString() {
	    return "Book(id=" + getId() + ", bookName=" + getBookName() + ", formatName=" + getFormatName() + ")";
	  }
	  
	  public Book(@NonNull String bookName, @NonNull String formatName) {
	    if (bookName == null)
	      throw new NullPointerException("bookName is marked non-null but is null"); 
	    if (formatName == null)
	      throw new NullPointerException("formatName is marked non-null but is null"); 
	    this.bookName = bookName;
	    this.formatName = formatName;
	  }
	  
	  public Book() {}
	  
	  public Book(Integer id, @NonNull String bookName, @NonNull String formatName) {
	    if (bookName == null)
	      throw new NullPointerException("bookName is marked non-null but is null"); 
	    if (formatName == null)
	      throw new NullPointerException("formatName is marked non-null but is null"); 
	    this.id = id;
	    this.bookName = bookName;
	    this.formatName = formatName;
	  }
	}