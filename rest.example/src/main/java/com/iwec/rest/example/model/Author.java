package com.iwec.rest.example.model;

import lombok.NonNull;

public class Author {
  private Integer id;
  
  @NonNull
  private String firstName;
  
  @NonNull
  private String lastName;
  
  public Integer getId() {
    return this.id;
  }
  
  @NonNull
  public String getFirstName() {
    return this.firstName;
  }
  
  @NonNull
  public String getLastName() {
    return this.lastName;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public void setFirstName(@NonNull String firstName) {
    if (firstName == null)
      throw new NullPointerException("firstName is marked non-null but is null"); 
    this.firstName = firstName;
  }
  
  public void setLastName(@NonNull String lastName) {
    if (lastName == null)
      throw new NullPointerException("lastName is marked non-null but is null"); 
    this.lastName = lastName;
  }
  
  public boolean equals(Object o) {
    if (o == this)
      return true; 
    if (!(o instanceof com.iwec.rest.example.model.Author))
      return false; 
    com.iwec.rest.example.model.Author other = (com.iwec.rest.example.model.Author)o;
    if (!other.canEqual(this))
      return false; 
    Object this$id = getId(), other$id = other.getId();
    if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id))
      return false; 
    Object this$firstName = getFirstName(), other$firstName = other.getFirstName();
    if ((this$firstName == null) ? (other$firstName != null) : !this$firstName.equals(other$firstName))
      return false; 
    Object this$lastName = getLastName(), other$lastName = other.getLastName();
    return !((this$lastName == null) ? (other$lastName != null) : !this$lastName.equals(other$lastName));
  }
  
  protected boolean canEqual(Object other) {
    return other instanceof com.iwec.rest.example.model.Author;
  }
  
  public int hashCode() {
    
    int result = 1;
    Object $id = getId();
    result = result * 59 + (($id == null) ? 43 : $id.hashCode());
    Object $firstName = getFirstName();
    result = result * 59 + (($firstName == null) ? 43 : $firstName.hashCode());
    Object $lastName = getLastName();
    return result * 59 + (($lastName == null) ? 43 : $lastName.hashCode());
  }
  
  public String toString() {
    return "Author(id=" + getId() + ", firstName=" + getFirstName() + ", lastName=" + getLastName() + ")";
  }
  
  public Author(@NonNull String firstName, @NonNull String lastName) {
    if (firstName == null)
      throw new NullPointerException("firstName is marked non-null but is null"); 
    if (lastName == null)
      throw new NullPointerException("lastName is marked non-null but is null"); 
    this.firstName = firstName;
    this.lastName = lastName;
  }
  
  public Author() {}
  
  public Author(Integer id, @NonNull String firstName, @NonNull String lastName) {
    if (firstName == null)
      throw new NullPointerException("firstName is marked non-null but is null"); 
    if (lastName == null)
      throw new NullPointerException("lastName is marked non-null but is null"); 
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
