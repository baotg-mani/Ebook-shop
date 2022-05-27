package com.cmcglobal.ebshop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String website;

    @Column
    private String founder;

    @Column
    private Integer foundedYear;

    @Column
    private String Address;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties(value = "publisher")
    private List<Ebook> ebooks;

    public Publisher(Long id, String name, String website, String founder, Integer foundedYear, String address) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.founder = founder;
        this.foundedYear = foundedYear;
        Address = address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public void setFoundedYear(Integer foundedYear) {
        this.foundedYear = foundedYear;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWebsite() {
        return website;
    }

    public String getFounder() {
        return founder;
    }

    public Integer getFoundedYear() {
        return foundedYear;
    }

    public String getAddress() {
        return Address;
    }
}
