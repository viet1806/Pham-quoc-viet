/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;

/**
 *
 * @author Toanne
 */
public class Book implements Serializable{
    private String BookID;
    private String BookName;
    private String Author;
    private String Price;

    public Book() {
    }

    public Book(String BookID, String BookName, String Author, String Price) {
        this.BookID = BookID;
        this.BookName = BookName;
        this.Author = Author;
        this.Price = Price;
    }

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String BookID) {
        this.BookID = BookID;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }
    
}