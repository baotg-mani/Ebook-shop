package com.cmcglobal.ebshop.dto;

import com.cmcglobal.ebshop.entity.Ebook;
import com.cmcglobal.ebshop.entity.Order;
import lombok.Data;

@Data
public class OrderDetailDTO {
    private Long orderId;
    private Integer quantity;
    private Long ebookId;

}
