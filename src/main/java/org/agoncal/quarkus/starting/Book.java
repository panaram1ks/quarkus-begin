package org.agoncal.quarkus.starting;

public class Book {

    public int id;
    public String author;
    public String title;
    public int yearOfPublication;
    public String genre;

    public Book(int id, String author, String title, int yearOfPublication, String genre) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.genre = genre;
    }
}
