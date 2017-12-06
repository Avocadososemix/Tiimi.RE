package ohtu.domain;

import java.sql.Date;
import java.time.LocalDate;
//import java.time.LocalDate;

public class Book {

    private int id;
    private String title;
    private String author;
    private String ISBN;
    private String tags;
    private boolean seen;
    private Date time;

    public Book(String title, String author, String isbn, String tags, boolean seen) {
        this.author = author;
        this.title = title;
        this.ISBN = isbn;
        this.tags = tags;
        this.seen = seen;
        this.time = Date.valueOf(LocalDate.now());
    }

    public Book(int id, String title, String author, String ISBN, String tags, boolean seen) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.tags = tags;
        this.seen = seen;
    }

    public Book(Integer id, String title, String author, String ISBN, String tags, boolean seen, Date time) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.tags = tags;
        this.seen = seen;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public Date getTime() {
        return time;
    }

    public String getTags() {
        return tags;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public boolean getSeen() {
        return seen;
    }

    public void setSeen(int seen) {
        this.id = seen;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}
