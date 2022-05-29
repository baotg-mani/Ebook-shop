package com.cmcglobal.ebshop.dto.mapper;

import com.cmcglobal.ebshop.dto.PublisherDTO;
import com.cmcglobal.ebshop.entity.Publisher;
import org.springframework.stereotype.Component;

@Component
public class PublisherMapper {
    public PublisherDTO toDto(Publisher publisher) {
        PublisherDTO publisherDTO = new PublisherDTO();
        publisherDTO.setAddress(publisher.getAddress());
        publisherDTO.setFounder(publisher.getFounder());
        publisherDTO.setFoundedYear(publisher.getFoundedYear());
        publisherDTO.setName(publisher.getName());
        publisherDTO.setWebsite(publisher.getWebsite());
        publisherDTO.setEbooks(publisher.getEbooks());
        return publisherDTO;
    }

    public Publisher toPublisher(PublisherDTO publisherDTO) {
        Publisher publisher = new Publisher();
        publisher.setFounder(publisherDTO.getFounder());
        publisher.setAddress(publisherDTO.getAddress());
        publisher.setFoundedYear(publisherDTO.getFoundedYear());
        publisher.setName(publisherDTO.getName());
        publisher.setWebsite(publisherDTO.getWebsite());
        publisher.setEbooks(publisherDTO.getEbooks());
        return publisher;
    }
}
