package com.julieandco.bookservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.UUID;
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue
    private UUID id;
    @Column
    private String title;
    @Column
    private String author;
    @Column
    private long year;
    @Column
    private double rating;
    @Column
    @Enumerated(EnumType.STRING)
    private Genre genre=Genre.Thriller;
    @Column
    private boolean available;
    @Column
    private boolean needRepair;
    //@JsonManagedReference(value = "bookorder") //////////
    @OneToOne(mappedBy="book")
    private Bookorder bookorder;
    //@JsonBackReference(value = "boxId") ///////////////
    //@JsonManagedReference(value = "boxId")//////after higher
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Box boxId;

    public Book() {
        /*title="";
        author="";
        year=0;
        rating=0;
        available=true;
        needRepair=false;*/
    }

    public Book(String title, String author, long year, double rating, Genre genre){
        this.title=title;
        this.author=author;
        this.year=year;
        this.rating=rating;
        this.genre=genre;
        this.available=true;
        this.needRepair=false;
    }

    public Box getBox() {
        return boxId;
    }

    public Bookorder getBookorder() {
        return bookorder;
    }

    public void setBookorder(Bookorder bookorder) {
        this.bookorder = bookorder;
    }

    public void setBox(Box box) {
        this.boxId = box;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setNeedRepair(boolean needRepair) {
        this.needRepair = needRepair;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public Genre getGenre(){
        return genre;
    }

    public double getRating(){
        return rating;
    }

    public long getYear(){
        return year;
    }

    public boolean getAvailability(){
        return available;
    }

    public boolean getRepair(){
        return needRepair;
    }

    public UUID getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String toString(){
        String bookString = "Book: " + title;
        String authorString = "\r\n Author: " + author;
        String genreString = "\r\n Genre: " + genre;
        String yearString = "\r\n Year: " + year;
        String ratingString = "\r\n Rating: " + rating;

        return  bookString + authorString + genreString + yearString + ratingString;
    }

}
