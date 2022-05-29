package com.cmcglobal.ebshop.dto;

import com.cmcglobal.ebshop.entity.Author;
import com.cmcglobal.ebshop.entity.OrderDetail;
import com.cmcglobal.ebshop.entity.Publisher;
import lombok.Data;

import java.util.Date;

@Data
public class EbookDTO {
    private String title;
    private String isbn;
    private String description;
    private Long authorId;
    private Long publisherId;
    private Date publisherDate;
    private Integer pages;
    private Long price;
    private Integer quantity;
    private Boolean deleted = false;
    private Long orderDetailId;

}
