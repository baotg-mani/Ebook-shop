package com.cmcglobal.ebshop.dto;

import com.cmcglobal.ebshop.entity.Ebook;
import lombok.Data;

import java.util.List;

@Data
public class AuthorDTO {
    private String firstname;
    private String lastname;
    private Integer yearOfBirth;
    private String description;
    private String website;
    private String organization;
    private List<Ebook> ebooks;

    private Integer numOfTitles;
    private List<String> listTop3Titles;
}
