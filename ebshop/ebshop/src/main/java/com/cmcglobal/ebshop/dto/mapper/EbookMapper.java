package com.cmcglobal.ebshop.dto.mapper;

import com.cmcglobal.ebshop.dto.EbookDTO;
import com.cmcglobal.ebshop.entity.Ebook;
import com.cmcglobal.ebshop.repository.AuthorRepository;
import com.cmcglobal.ebshop.repository.OrderDetailRepository;
import com.cmcglobal.ebshop.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EbookMapper {
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    public EbookMapper (AuthorRepository authorRepository,
                        PublisherRepository publisherRepository,
                        OrderDetailRepository orderDetailRepository) {
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    public EbookDTO toDto(Ebook ebook) {
        EbookDTO ebookDTO = new EbookDTO();
        ebookDTO.setDescription(ebook.getDescription());
        ebookDTO.setAuthorId(ebook.getAuthor().getId());
        ebookDTO.setDeleted(ebook.getDeleted());
        ebookDTO.setIsbn(ebook.getIsbn());
        ebookDTO.setPages(ebook.getPages());
        ebookDTO.setPrice(ebook.getPrice());
        ebookDTO.setOrderDetailId(ebook.getOrderDetail().getId());
        ebookDTO.setPublisherId(ebook.getPublisher().getId());
        ebookDTO.setQuantity(ebook.getQuantity());
        ebookDTO.setTitle(ebook.getTitle());
        ebookDTO.setPublisherDate(ebook.getPublisherDate());
        return ebookDTO;
    }

    public Ebook toEbook(EbookDTO ebookDTO) {
        Ebook ebook = new Ebook();
        ebook.setAuthor(authorRepository
                .findById(ebookDTO.getAuthorId())
                .get());
        ebook.setPublisher(publisherRepository
                .findById(ebookDTO.getPublisherId())
                .get());
        ebook.setOrderDetail(orderDetailRepository
                .findById(ebookDTO.getOrderDetailId())
                .get());
        ebook.setDeleted(ebookDTO.getDeleted());
        ebook.setDescription(ebookDTO.getDescription());
        ebook.setIsbn(ebookDTO.getIsbn());
        ebook.setPages(ebookDTO.getPages());
        ebook.setPrice(ebookDTO.getPrice());
        ebook.setQuantity(ebookDTO.getQuantity());
        ebook.setPublisherDate(ebookDTO.getPublisherDate());
        ebook.setTitle(ebookDTO.getTitle());
        return ebook;
    }
}
