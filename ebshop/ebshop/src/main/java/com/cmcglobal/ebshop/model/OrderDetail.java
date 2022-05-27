package com.cmcglobal.ebshop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column
    private Integer quantity;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties(value = "orderDetail")
    @JoinColumn(name = "ebook_id")
    private Ebook ebook;

    public OrderDetail(Long id, Order order, Ebook ebook, Integer quantity) {
        this.id = id;
        this.order = order;
        this.ebook = ebook;
        this.quantity = quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setEbook(Ebook ebook) {
        this.ebook = ebook;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public Ebook getEbook() {
        return ebook;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
