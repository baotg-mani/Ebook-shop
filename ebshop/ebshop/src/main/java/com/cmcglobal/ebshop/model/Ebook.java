package com.cmcglobal.ebshop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ebooks")
public class Ebook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    private String isbn;

    @Column
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    @JsonIgnoreProperties(value = "ebooks")
    private Author author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    @JsonIgnoreProperties(value = "ebooks")
    private Publisher publisher;

    @Column
    private Date publisherDate;

    @Column
    private Integer pages;

    @Column
    private Long price;

    @Column
    private Integer quantity;

    @Column
    private Boolean deleted;

    public Ebook(Long id, String title, String isbn, String description, Author author, Publisher publisher, Date publisherDate, Integer pages, Long price, Integer quantity, Boolean deleted) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.description = description;
        this.author = author;
        this.publisher = publisher;
        this.publisherDate = publisherDate;
        this.pages = pages;
        this.price = price;
        this.quantity = quantity;
        this.deleted = deleted;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void setPublisherDate(Date publisherDate) {
        this.publisherDate = publisherDate;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDescription() {
        return description;
    }

    public Author getAuthor() {
        return author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public Date getPublisherDate() {
        return publisherDate;
    }

    public Integer getPages() {
        return pages;
    }

    public Long getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Boolean getDeleted() {
        return deleted;
    }
}
