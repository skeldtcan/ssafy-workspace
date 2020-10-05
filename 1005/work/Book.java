package com.ssafy.work;

import java.util.Date;

public class Book {
    private String isbn;
    private String title;
    private String catalogue;
    private String nation;
    private Date pubdate;
    private String publisher;
    private String author;
    private int price;
    private String currency;
    private String desc;



    public Book(String isbn, String title, String catalogue, String nation, Date pubdate,
            String publisher, String author, int price, String currency, String desc) {
        super();
        this.isbn = isbn;
        this.title = title;
        this.catalogue = catalogue;
        this.nation = nation;
        this.pubdate = pubdate;
        this.publisher = publisher;
        this.author = author;
        this.price = price;
        this.currency = currency;
        this.desc = desc;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(String catalogue) {
        this.catalogue = catalogue;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Book [isbn=" + isbn + ", title=" + title + ", catalogue=" + catalogue + ", nation="
               + nation + ", pubdate=" + pubdate + ", publisher=" + publisher + ", author=" + author
               + ", price=" + price + ", currency=" + currency + ", desc=" + desc + "]";
    }



}
