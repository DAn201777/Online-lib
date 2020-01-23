/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isu.librarysystem;

import java.io.*;
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 *
 * @author 349150325
 */
public class Lib {
    
     public Scanner input(File file) {
        try {
            return new Scanner(file);
        } catch (FileNotFoundException err) {
            err.printStackTrace();
            return null;
        }
        
    }
     public PrintWriter output(File file){
         try{
             return new PrintWriter(file);
         }
         catch (Exception err){
             err.printStackTrace();
             return null;
         }
     }
      public void addBook(Book book) {
        //reads bookinfo file
        File file = new File("lib.txt");
        Scanner reader = input(file);
        ArrayList <String> store= new ArrayList();
        while(reader.hasNext()){
            store.add(reader.nextLine());
        }
        store.add(book.getTitle()+"||"+book.getUrl()+"||"+book.getCover()+"||"+book.getAuthor()+"||"+book.getDescription()+"||"+book.getId());
        PrintWriter write = output(file);
        for(String a:store){
            write.println(a);
        }
        write.close();
       
    }
      public Book checkBook(String Id){
          Book book;
          File file = new File("lib.txt");
          Scanner reader= input(file);
          int counter=0;
         
          while(reader.hasNext()){
              String []store=reader.nextLine().split("||");
              if(store[index]=Id){
                  book= new Book (store[],store[],store[],store[],store[]);
                   return book;
              }
             else
                  return null;
         
      }
      public Book getDescription (String link){
           File file = new File("lib.txt");
             Book book;
        //stores html for book info page
        Document info = null;
        try {
            //Jsoup is used to parse html
           info = Jsoup.connect(link).get();
        } catch (IOException e) {
            System.out.println(e);
        }
        //gets barcode and formats it
        String Id = doc.getElementById("details-standardno").tagName("td").text().replaceFirst("ISBN: ", "");
        barcode = barcode.substring(0, barcode.indexOf(" "));
        //checks if book exists already in bookinfo.txt
        if (!checkBook(Id).equals(null)) {
            book = checkBook(Id);
            return book;
        } else {
            //gets title,author,publisher
            String title = info.getElementsByClass("title").get(0).text();
            String author = info.getElementsByAttributeValue("title", "Search for more by this author").get(0).text();
        
         
           
            //gets and formats genres
       
            String cover = "https:" + info.getElementsByClass("cover").get(0).attr("src");
            String summ = info.getElementsByClass("abstracttxt").text();
            if (summ == "") {
                summ = "Not Available";
            }
            //initializes Book class and adds it to bookinfo.txt
            book= new Book(title, url,cover,author,des, Id);
            addBook(book);
        }
            return book;
       
      }
      public Book[] searchLib(String title){
       
      String link="https://openlibrary.org/search?q="+title+"&mode=ebooks&m=edit&has_fulltext=true";
           
  org.jsoup.nodes.Document info=null;
         try {
             
             info = Jsoup.connect(link).get();
             
         } catch (IOException e) {
             System.out.println(e);
         }
        //WebDriver is used to interact with WorldCat website
        WebDriver transmitter = new HtmlUnitDriver();
        //turn off htmlunit warnings
        java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
        transmitter.get(link);
        //stores items from search results
        List<WebElement> bookList= new ArrayList();
        for(int i=1;i<=5;i++){
           String path="html/body/div/div/div/div/div/ul/li["+i+"]/span[2]/span/h3/a";
      //  String path="//*a[@class='restuls']";
        //max 6 results as WorldCat can only store that many on one page
       // for (int i = 1; i <= 6; i++) {
         try {
                bookList.add(transmitter.findElement(By.xpath(path)));
        //      System.out.println((transmitter.findElement(By.xpath("//a[@href]")).getAttribute()).getText());
              //<a href="/works/OL8124417W"><img itemprop="image" src="/images/icons/avatar_book-sm.png" alt="Cover of: White Tiger" title="Cover of: White Tiger"></a>
                //"/body/div/div/div/div/div/ul/li/span/a"
            } catch (org.openqa.selenium.NoSuchElementException e) {
              // i=7;
               System.out.println(e);
            }}
        Book []search= new Book[5];

        for(int i=0;i<5;i++){
           search[i]=new Book(bookList.get(i).getText(),bookList.get(i).getAttribute("href"));
        }
      
              return search;
          }
         
      }

