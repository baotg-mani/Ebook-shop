package com.cmcglobal.ebshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "ebooks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ebook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String title;

    @Column
    @NotNull
    private String isbn;

    @Column
    @NotNull
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
    @NotBlank
    private Date publisherDate;

    @Column
    @NotBlank
    private Integer pages;

    @Column
    @NotBlank
    private Long price;

    @Column
    @NotBlank
    @DecimalMin(value = "0", inclusive = true)
    private Integer quantity;

    @Column
    @NotBlank
    private Boolean deleted = false;

    @OneToOne(mappedBy = "ebook", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "ebook")
    private OrderDetail orderDetail;

    @ManyToMany(mappedBy = "ebooks")
    private Set<Order> orders;

}
