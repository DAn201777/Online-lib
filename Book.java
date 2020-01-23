/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isu.librarysystem;
  
import java.util.ArrayList;


/**
 *
 * @author 349150325
 */
public class Book {  
    private String title; //the variable for the book title
    private String author; //the variable for the book's author
    private String description; //the variable for the book's description
    private String publisher; //the variable for the book's publisher
    private String cover; //the variable for the book's cover
    private Review review; //the variable used to access the Review Class
    private String url; //The link of the book on the online data base
    private String ID;
    
    public Book(String title, String url,String cover,String author,String des, String Id) {
    this.title= title;
    this.url=url;
    this.cover=cover;
    description =des;
    this.cover=cover; 
    this.author=author; 
    review=new Review(Id);
    ID=Id;
    
}
    public Book (String title, String link){
        this.title=title;
         url=link;
    }
    public void setId(String bar){
        this.ID=bar;
    }
    public String getId(){
       return ID;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getTitle(){
       return title;
    }
    public void setUrl(String url){
        this.url=url;
    }
    public String getUrl(){
        return url;
    }
   public void setAuthor(String name){
        this.author=name;
    }
    public String getAuthor(){
       return author;
    }
    
    public void setDescription(String des){
        this.description=des;
    }
    public String getDescription(){
        return description;
    }
    public void setCover(String cover){
        this.cover=cover;
        
    }
    public String getCover(){
        return cover;
    }
    public void setReview(Review r){
        review=r;
    }
   
    public Review getReview(){
        return review;
    }
    public void comment(String star, String text, String account){
        getReview().addComment(star, text, account);
    }
    public ArrayList<String> fetch(){
      return  getReview().getComments();
    }
}

