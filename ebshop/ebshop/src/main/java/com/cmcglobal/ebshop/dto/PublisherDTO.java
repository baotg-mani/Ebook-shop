package com.cmcglobal.ebshop.dto;

import com.cmcglobal.ebshop.entity.Ebook;
import lombok.Data;

import java.util.List;

@Data
public class PublisherDTO {
    private String name;
    private String website;
    private String founder;
    private Integer foundedYear;
    private String Address;
    private List<Ebook> ebooks;

    private Integer numOfTitles;
    private List<Ebook> top5TitleBestSeller;

}
